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
    private RegistrarPedidoView vistaRegistrarPedido;
    private RegistroController controllerRegistrarPedido;

    public HomeController() {
        inicializarComponentes();
        mostrarVentanaPrincipal();
    }
    
    public void inicializarComponentes(){
        this.vistaRegistrarPedido = new RegistrarPedidoView();
        this.controllerRegistrarPedido = new RegistroController(vistaRegistrarPedido);
    }
    
    public void mostrarVentanaPrincipal(){ 
        vistaRegistrarPedido.setVisible(true);
    }
    
}
