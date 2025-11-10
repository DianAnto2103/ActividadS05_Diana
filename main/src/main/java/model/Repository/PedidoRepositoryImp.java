/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Producto;

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
    
    @Override
    public List<Pedido> buscarTodos(){
        return pedidos;
    }
    
    
    @Override
    public void guardar(Pedido pedido){
        pedidos.add(pedido);
    }
    
    @Override
    public void actualizar(Pedido pedido){
        int index = pedidos.indexOf(pedido);
        if(index >= 0){
            pedidos.set(index, pedido);
        }
    }
    
    @Override
    public void eliminar(Pedido pedido){
        pedidos.remove(pedido);
    }
    
    private void guardarEnArchivo() {
        try {
            FileWriter writer = new FileWriter(ARCHIVO);
            for (Pedido pedido : pedidos) {
                writer.write(pedido.getID() + "," + pedido.getNombreCliente() + "," +
                           pedido.getProducto().getNombre() + "," + pedido.getCantidad() + "," +
                           pedido.getTotal() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error guardando: " + e.getMessage());
        }
    }
}
