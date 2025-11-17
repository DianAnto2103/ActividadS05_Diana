/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import java.util.List;
import model.Pedido;
import Repository.PedidoRepositoryImp;
import model.Observer.*;

/**
 *
 * @author diana
 */
public class PedidoFacade {
    private CalculoDeImpuestos calculadora;
    private ValidacionDeStock validadora;
    private GeneraciondeComprobante comprobante;
    private PedidoRepositoryImp repositorio;
    private NotificadorPedidos notificador;
    
    public PedidoFacade(){
        this.calculadora = new CalculoDeImpuestos();
        this.validadora = new ValidacionDeStock();
        this.comprobante = new GeneraciondeComprobante();
        this.repositorio = new PedidoRepositoryImp();
        this.notificador = new NotificadorPedidos();
        
        
        notificador.suscribir(new InventarioNoti());
        notificador.suscribir(new UsuarioNoti());
        notificador.suscribir(new LogEventoNoti());
    }

    public String procesarPedido(Pedido pedido, boolean confirmacion,String tipoCalculo){
        if (pedido.getCantidad() <= 0) {
            return "CANTIDAD_INVALIDA";
        }
         //Se valida el stock
        if(!validadora.validarStock(pedido)){
             return "STOCK_INSUFICIENTE";
        }
        
        //Se calcula el total (sub-total, IGV, total)
        calculadora.seleccionarEstrategia(tipoCalculo); 
        calculadora.calcular(pedido);
        
        if(confirmacion){
            
            Thread hiloGenerarComprobantedePago = new Thread(() ->
            {
                comprobante.generarComprobante(pedido);
            });
            
            Thread hiloGurdarPedido = new Thread(() -> 
            {
                repositorio.guardar(pedido);
            });
            
            Thread hiloNotificacion = new Thread(() ->
            {
                notificador.notificarPedidoProcesado(pedido);
            });
            
            hiloGenerarComprobantedePago.start();
            hiloGurdarPedido.start();
            hiloNotificacion.start();
            
            //para matener el orden
          
        }
        return "VALIDO";
    }   
    
    public List<Pedido> obtenerTodosPedidos() {
        return repositorio.buscarTodos();
    }
}
