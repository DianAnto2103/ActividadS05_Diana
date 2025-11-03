/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.*;


/**
 *
 * @author diana
 */
public class HomeController {
    RegistrarPedidoView vistaRegistrarPedido = new RegistrarPedidoView();
    RegistroController controllerRegistroController = new RegistroController(vistaRegistrarPedido);
    
    {
        vistaRegistrarPedido.setVisible(true);
    }
    
}
