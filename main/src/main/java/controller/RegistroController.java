/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;
import model.Facade.PedidoFacade;
import model.*;
import view.RegistrarPedidoView;
/**
 *
 * @author diana
 */
public final class RegistroController {
    RegistrarPedidoView vistaRegistro;
    PedidoFacade pedidoFacade;
    
    public RegistroController(RegistrarPedidoView vistaRegistro){
        this.vistaRegistro = vistaRegistro;
        this.pedidoFacade = new PedidoFacade();
        
        configurarEventos();
    }
    
    public void configurarEventos(){
        this.vistaRegistro.getBotonCancelar().addActionListener(e -> cerrarVentana());
        this.vistaRegistro.getBotonAceptar().addActionListener(e -> registrar());
    }
    
    public void cerrarVentana(){
        this.vistaRegistro.dispose();
    }  
    
    
    public void registrar()
    {
        try
        {
            String nombreProducto = vistaRegistro.getProducto();
            Producto producto = crearProducto(nombreProducto);
            Pedido pedido = new Pedido(vistaRegistro.getNombreCliente(),producto,vistaRegistro.getCantidadProducto());
        
            boolean exito = pedidoFacade.procesarPedido(pedido);
        
            if(exito)
            {
                this.vistaRegistro.setTotal(pedido.getTotal());
                this.vistaRegistro.setIGV(pedido.getIGV());
                this.vistaRegistro.setSubTotalProducto(pedido.getSubtotal());
            }
            else{
                JOptionPane.showMessageDialog(vistaRegistro, "Stock insuficiente para:" + nombreProducto, "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(vistaRegistro, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
    private Producto crearProducto(String nombre) 
    {
        switch (nombre) 
        {
            case "Sillon":
                return new Producto("Sillón", 70, 20);
            case "Cama":
                return new Producto("Cama", 50, 20);
            case "Mesa":
                return new Producto("Mesa", 10, 20);
            case "Silla":
                return new Producto("Silla", 30, 20);
            default:
                return new Producto(nombre, 20, 20);
        }
    }
   
}
