/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import java.util.ArrayList;
import java.util.List;
import model.Observer.SuscriptorComprobante;
import model.Pedido;

/**
 *
 * @author diana
 */
public class NotificadorPedidos {
    private List<SuscriptorComprobante> suscriptores = new ArrayList<>();
    
    public void suscribir(SuscriptorComprobante suscriptor){
        suscriptores.add(suscriptor);
    }
    
    public void desuscribir(SuscriptorComprobante suscriptor){
        suscriptores.remove(suscriptor);
    }
    
    public void notificarPedidoProcesado(Pedido pedido){
        System.out.println("=====================================");
        System.out.println("Notificando pedido procesado ID: N-" + pedido.getID());
        notificarTodos(pedido);  
    }
    
    private void notificarTodos(Pedido pedido){
        for(SuscriptorComprobante suscriptor: suscriptores){
            suscriptor.actualizar(pedido);
        }
    } 
}
