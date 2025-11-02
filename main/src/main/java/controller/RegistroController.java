/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Facade.PedidoFacade;
import view.RegistrarPedidoView;

/**
 *
 * @author diana
 */
public class RegistroController {
    RegistrarPedidoView vistaRegistro;
    
    public RegistroController(RegistrarPedidoView vistaRegistro){
        this.vistaRegistro = vistaRegistro;
        configurarEventos();
    }
    
    public void configurarEventos(){
        this.vistaRegistro.getBotonCancelar().addActionListener(e -> cerrarVentana());
    }
    
    public void cerrarVentana(){
        this.vistaRegistro.dispose();
    }
    
}
