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
public class UsuarioNoti implements SuscriptorComprobante {

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("[USUARIO] Se genero comprobante para: " + pedido.getNombreCliente());  
    }

}
