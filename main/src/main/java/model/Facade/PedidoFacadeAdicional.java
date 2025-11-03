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
public class PedidoFacadeAdicional {
    AdapterFactura factura;
    Pedido pedido;
    
    public PedidoFacadeAdicional(AdapterFactura factura) {
        this.factura = factura;
    }
    public void generarComprobantedePago(Pedido pedido){
        factura.emitirFactura(pedido);
    }
    
}
