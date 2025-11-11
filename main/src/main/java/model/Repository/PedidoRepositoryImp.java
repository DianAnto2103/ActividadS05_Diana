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
    
    public PedidoRepositoryImp(){
        cargarDesdeArchivo();
    }
    
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
        pedido.setID(nextId++);
        pedidos.add(pedido);
        guardarEnArchivo();
    }
    
    @Override
    public void actualizar(Pedido pedido){
        for(int i = 0; i < pedidos.size(); i++)
        {
            if (pedidos.get(i).getID() == pedido.getID()){
                pedidos.set(i, pedido);
                guardarEnArchivo();
                return;
            }
        }
    }
    
    @Override
    public void eliminar(Pedido pedido){
        pedidos.removeIf(p -> p.getID() == pedido.getID());
        guardarEnArchivo();
    }
    
    public void guardarEnArchivo() {
        try {
            File archivo = new File(ARCHIVO);
            System.out.println("RUTA DEL ARCHIVO: " + archivo.getAbsolutePath());
            FileWriter writer = new FileWriter(ARCHIVO);
            for (Pedido pedido : pedidos) {
                writer.write(pedido.getID() + "," + pedido.getNombreCliente() + "," +
                           pedido.getProducto().getNombre() + "," + pedido.getCantidad() + "," + 
                        pedido.getSubtotal()+ "," + pedido.getIGV() +"," +
                        pedido.getTotal() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error guardando: " + e.getMessage());
        }
    }
    
    public void cargarDesdeArchivo() {
        
        try {
            File file = new File(ARCHIVO);
            if (!file.exists()) return;
        
            BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            
            while ((linea = reader.readLine()) != null) 
            {
                String[] datos = linea.split(",");
                if (datos.length == 7) 
                {
                    Pedido pedido = new Pedido(
                    datos[1], // nombreeCliente
                    new Producto(datos[2], 20, 20), // producto
                    Integer.parseInt(datos[3]) // cantidad
                );
                    
                    pedido.setID(Integer.parseInt(datos[0]));
                    pedido.setSubtotal(Double.parseDouble(datos[4]));
                    pedido.setIGV(Double.parseDouble(datos[5])); 
                    pedido.setTotal(Double.parseDouble(datos[6]));
                    pedidos.add(pedido);
                
                // Actualizar nextId
                    if (pedido.getID() >= nextId) 
                    {
                        nextId = pedido.getID() + 1;
                    }
                }
            }
            
            reader.close();
        } catch (IOException e) {
            System.out.println("Error cargando: " + e.getMessage());
        }
    }
}
