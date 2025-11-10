/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import model.Pedido;
import model.Strategy.*;


/**
 *
 * @author diana
 */
public class CalculoDeImpuestos {
    private Context_Strategy contexto;
    private String tipodeCalculo;
    
    public void calcular(Pedido pedido){
        double subtotal = calcularSubTotal(pedido);
        
        seleccionarEstrategia(tipodeCalculo);
        
        double IGV = contexto.executeStrategy(subtotal);
        double total = subtotal + IGV;
        
        pedido.setSubtotal(subtotal);
        pedido.setIGV(IGV);
        pedido.setTotal(total); 
    }
    
    public void seleccionarEstrategia(String tipoCalculo)
    {
        if("Con IGV".equals(tipoCalculo))
        {
            contexto.setEstrategia(new IGV18Strategy());
        } else if("Exonerado".equals(tipoCalculo)){
            contexto.setEstrategia(new ExoneradoStrategy());
        }
        this.tipodeCalculo = tipoCalculo;
    }
    
    public double calcularSubTotal(Pedido pedido)
    {
        return pedido.getCantidad()* pedido.getProducto().getPrecio();
    }

}
