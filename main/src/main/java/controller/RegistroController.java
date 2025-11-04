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
    private RegistrarPedidoView vistaRegistro;
    private PedidoFacade pedidoFacade;
    private Pedido pedidoGuardado;
    
    public RegistroController(RegistrarPedidoView vistaRegistro){
        this.vistaRegistro = vistaRegistro;
        this.pedidoFacade = new PedidoFacade();
        configurarEventos();
    }
    
    public void configurarEventos(){
        this.vistaRegistro.getBotonCancelar().addActionListener(e -> cerrarVentana());
        this.vistaRegistro.getBotonAceptar().addActionListener(e -> visualizarPedido());
        this.vistaRegistro.getGenerarComprobante().addActionListener(e -> confirmarPedido());
    }
    
    public void cerrarVentana(){
        this.vistaRegistro.dispose();
    }  
    
    /**
     *
     */
    public void visualizarPedido()
    {
        try
        {
            String nombreProducto = vistaRegistro.getProducto();
            Producto producto = crearProducto(nombreProducto);
            Pedido pedido = new Pedido(vistaRegistro.getNombreCliente(),producto,vistaRegistro.getCantidadProducto());
        
            String resultado = pedidoFacade.procesarPedido(pedido, false);
         
        
            if("VALIDO".equals(resultado))
            {
                this.pedidoGuardado = pedido;
              
                this.vistaRegistro.setTotal(pedido.getTotal());
                this.vistaRegistro.setIGV(pedido.getIGV());
                this.vistaRegistro.setSubTotalProducto(pedido.getSubtotal());
                
                JOptionPane.showMessageDialog(vistaRegistro, "Confirmar, por favor", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                String mensajeError = " ";
                if("CANTIDAD_INVALIDA".equals(resultado))
                {
                    mensajeError = "Cantidad invalida, debe ser mayor a 0";
                }
                else if("STOCK_INSUFICIENTE".equals(resultado))
                {
                    mensajeError = "Stock insuficiente para: " + nombreProducto;
                }
                    JOptionPane.showMessageDialog(vistaRegistro, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(vistaRegistro, "Ingrese datos completos" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void confirmarPedido()
    {
        if(pedidoGuardado == null)
        {
            JOptionPane.showMessageDialog(vistaRegistro, "Primero calcule el pedido", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try
        {
            String resultado = pedidoFacade.procesarPedido(pedidoGuardado, true);
            if("VALIDO".equals(resultado))
            {
                JOptionPane.showMessageDialog(vistaRegistro, 
                    "¡Pedido confirmado! Factura generada en sistema legacy", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                this.pedidoGuardado = null; //es para limpiar pedido guardado
            }
            else 
            {
              JOptionPane.showMessageDialog(vistaRegistro, "Error al confirmar el pedido", "Error", 
                    JOptionPane.ERROR_MESSAGE);  
            }
        }catch(Exception e){
           JOptionPane.showMessageDialog(vistaRegistro, "Error al confirmar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
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
