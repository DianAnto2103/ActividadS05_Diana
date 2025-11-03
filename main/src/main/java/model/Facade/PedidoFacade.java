/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

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
    
    public PedidoFacade(){
        this.calculadora = new CalculoDeImpuestos();
        this.registradora = new RegistroDePedidos();
        this.validadora = new ValidacionDeStock();
        this.comprobante = new GeneraciondeComprobante();
    }

    public String procesarPedido(Pedido pedido, boolean confirmacion){
        if (pedido.getCantidad() <= 0) {
            return "CANTIDAD_INVALIDA";
        }
         //Se valida el stock
        if(!validadora.validarStock(pedido)){
             return "STOCK_INSUFICIENTE";
        }
        
        //Se calcula el total (sub-total, IGV, total)
        calculadora.calcular(pedido);
        
        if(confirmacion){
            if(!registradora.registrar(pedido)){
                return "ERROR_REGISTRO";
            }
            comprobante.generarComprobante(pedido);
        }
        return "VALIDO";
    }   
}
