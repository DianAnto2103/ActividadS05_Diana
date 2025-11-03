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

    public boolean procesarPedido(Pedido pedido){
        if(!validadora.validarStock(pedido)){
            return false;
        }
        
        calculadora.calcular(pedido);
        
        if(!registradora.registrar(pedido)){
            return false;
        }
        
        return true;
    }   
}
