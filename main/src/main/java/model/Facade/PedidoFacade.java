/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import model.Pedido;
import model.Repository.PedidoRepositoryImp;

/**
 *
 * @author diana
 */
public class PedidoFacade {
    private CalculoDeImpuestos calculadora;
    private ValidacionDeStock validadora;
    private GeneraciondeComprobante comprobante;
    private PedidoRepositoryImp repositorio;
    
    public PedidoFacade(){
        this.calculadora = new CalculoDeImpuestos();
        this.validadora = new ValidacionDeStock();
        this.comprobante = new GeneraciondeComprobante();
        this.repositorio = new PedidoRepositoryImp();
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
            comprobante.generarComprobante(pedido);
            repositorio.guardar(pedido);
        }
        return "VALIDO";
    }   
}
