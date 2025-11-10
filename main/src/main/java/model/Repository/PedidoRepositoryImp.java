/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Repository;

import java.util.ArrayList;
import java.util.List;
import model.Pedido;

/**
 *
 * @author diana
 */
public class PedidoRepositoryImp implements PedidoRepository{
    private List<Pedido> pedidos = new ArrayList<>();
    private int nextId = 1;
    private final String ARCHIVO = "pedidos.txt";
    
    @Override
    public Pedido buscarporID(int ID){
        return pedidos.stream()
                .filter(pedido -> pedido.getID() == ID)
                .findFirst()
                .orElse(null);
    }
}
