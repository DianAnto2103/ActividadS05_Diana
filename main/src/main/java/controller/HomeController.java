/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.*;
import view.*;


/**
 *
 * @author diana
 */
public class HomeController {
    RegistrarPedidoView vistaRegistrarPedido;
    FacturaView vistaFactura;
    RegistroController controllerRegistroController;

    public HomeController() {
        inicializarComponentes();
        mostrarVentanaPrincipal();
    }
    
    public void inicializarComponentes(){
        this.vistaRegistrarPedido = new RegistrarPedidoView();
        this.vistaFactura = new FacturaView();
        this.controllerRegistroController = new RegistroController(vistaRegistrarPedido, vistaFactura);
    }
    
    public void mostrarVentanaPrincipal(){ 
        vistaRegistrarPedido.setVisible(true);
    }
    
}
