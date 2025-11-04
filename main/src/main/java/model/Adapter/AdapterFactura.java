/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Adapter;

import model.Pedido;

/**
 *
 * @author diana
 */
public class AdapterFactura implements FacturaServicio{
    private LegacyBillingSystem adaptee;
    
    public AdapterFactura(LegacyBillingSystem adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void emitirFactura(Pedido pedido) {
       int clientId = generarIdCliente(pedido.getNombreCliente());
       String nombreCliente = pedido.getNombreCliente();
       String productCode = convertirNombreACodigo(pedido.getProducto().getNombre());
       double precioUnitario = pedido.getProducto().getPrecio();
       int cantidadTotal = pedido.getCantidad();
       
       
       adaptee.createInvoice(clientId, nombreCliente, productCode, precioUnitario, cantidadTotal);
    }
    
    private int generarIdCliente(String nombreCliente) {
        return Math.abs(nombreCliente.hashCode() % 1000);
    }
    
    private String convertirNombreACodigo(String nombreProducto) {
        switch(nombreProducto) {
            case "Sillón": return "SILLON-001";
            case "Cama": return "CAMA-002";
            case "Mesa": return "MESA-003";
            case "Silla": return "SILLA-004";
            default: return "PROD-000";
        }
    }  
    
    
}
