/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import model.Adapter.AdapterFactura;
import model.Pedido;

/**
 *
 * @author diana
 */
public class PedidoFacade {
    private CalculoDeImpuestos calculadora;
    private RegistroDePedidos registradora;
    private ValidacionDeStock validadora;
    private GeneraciondeComprobante comprobante;
    private AdapterFactura comprobantedePago;
    
    public PedidoFacade(){
        this.calculadora = new CalculoDeImpuestos();
        this.registradora = new RegistroDePedidos();
        this.validadora = new ValidacionDeStock();
        this.comprobante = new GeneraciondeComprobante();
    }

    public boolean procesarPedido(Pedido pedido, boolean confirmacion){
        //Se valida el stock
        if(!validadora.validarStock(pedido)){
            return false;
        }
        
        //Se calcula el total (sub-total, IGV, total)
        calculadora.calcular(pedido);
        
        if(confirmacion){
            if(!registradora.registrar(pedido)){
                return false;
            }
            comprobantedePago.emitirFactura(pedido);
        }
        return true;
    }   
}
