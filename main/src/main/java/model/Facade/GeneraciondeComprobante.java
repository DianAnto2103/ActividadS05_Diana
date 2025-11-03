/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import model.Adapter.AdapterFactura;
import model.Adapter.FacturaServicio;
import model.Adapter.LegacyBillingSystem;
import model.Pedido;

/**
 *
 * @author diana
 */
public class GeneraciondeComprobante {
    private FacturaServicio factura;
    
    public GeneraciondeComprobante() {
        LegacyBillingSystem legacy = new LegacyBillingSystem();
        this.factura = new AdapterFactura(legacy);
    }
    
    public void generarComprobante(Pedido pedido){
        factura.emitirFactura(pedido);
    }
}
