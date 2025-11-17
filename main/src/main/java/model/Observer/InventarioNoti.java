/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Observer;

import model.Pedido;

/**
 *
 * @author diana
 */
public class InventarioNoti implements SuscriptorComprobante {
    
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("[INVENTARIO] Procesando actualizacion de stock");
        System.out.println("    Producto: " + pedido.getProducto().getNombre());
        System.out.println("    Stock pre-compra: " + pedido.getProducto().getCantidadStock());
        System.out.println("    Cantidad vendida: " + pedido.getCantidad());
        System.out.println("    Stock restante: " + (pedido.getProducto().getCantidadStock() - pedido.getCantidad()));
    }
}
