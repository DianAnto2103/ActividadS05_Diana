/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JFrame;
import model.Pedido;
import view.FacturaView;

/**
 *
 * @author diana
 */
public class FacturaController {
    private FacturaView vistaFactura;
    private JFrame frameFactura;
    
    public FacturaController(FacturaView vistaFactura){
        this.vistaFactura = vistaFactura;
        
        this.frameFactura = new JFrame("Comprobante de Pago");
        this.frameFactura.setContentPane(vistaFactura);
        this.frameFactura.pack();
        this.frameFactura.setLocationRelativeTo(null);
        this.frameFactura.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
    public void mostrarComprobante(Pedido pedido){
        this.vistaFactura.setNombreCliente(pedido.getNombreCliente());
        this.vistaFactura.setNombreProducto(pedido.getProducto().getNombre());
        this.vistaFactura.setCantidadProducto(String.valueOf((pedido.getCantidad())));
        this.vistaFactura.setTotalProducto(String.valueOf((pedido.getTotal())));
        
        this.frameFactura.setVisible(true);
    }
    
    
    
}
