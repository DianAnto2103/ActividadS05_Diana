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
public class CalcularMontoTotal {
    
    public CalcularMontoTotal() {
        
    }
    
    public void calcular(Pedido pedido){
        double subtotal = calcularSubTotal(pedido);
        double IGV = 0.18;
        double total = subtotal + IGV;
        
        pedido.setSubtotal(subtotal);
        pedido.setIGV(IGV);
        pedido.setTotal(total); 
    }
    
    public double calcularSubTotal(Pedido pedido){
        return pedido.getCantidad()* pedido.getProducto().getPrecio();
    }
}
