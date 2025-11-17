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
public class LogEventoNoti implements SuscriptorComprobante {
    
    @Override
    public void actualizar(Pedido pedido){
        
        String timestamp = java.time.LocalDateTime.now().format
        (java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        System.out.println("[LOG] [" + timestamp + "] [INFO] Pedido procesado exitosamente");
        System.out.println("   ID: N-" + pedido.getID()); 
        System.out.println("   Cliente: " + pedido.getNombreCliente());
        System.out.println("   Producto: " + pedido.getProducto().getNombre());
    }    
}
