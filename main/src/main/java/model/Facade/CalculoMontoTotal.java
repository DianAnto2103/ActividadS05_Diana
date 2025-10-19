/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

import java.util.ArrayList;
import model.Cama;
import model.Producto;
import model.Silla;
import model.Sillon;

/**
 *
 * @author diana
 */
public class CalculoMontoTotal {
    ArrayList<Producto> producto;
    double IGV;
    double total;
    
    public CalculoMontoTotal() {
        producto = new ArrayList<>();
        producto.add(new Cama());
        producto.add(new Silla());
        producto.add(new Sillon());
    }
    
    public double calcularIGV(Pedido pedido){
        for(int i = 0; i < producto.size(); i++){
            Producto p = producto.get(i);
            if(p.getNombre().equals(pedido.getProducto())){
               IGV = p.getPrecio()*0.18;
               return IGV;
            }
        }
        return 0;
    }
    
    
    public double calcularTotal(Pedido pedido){
        for(int i = 0; i < producto.size(); i++){
            Producto p = producto.get(i);
            if(p.getNombre().equals(pedido.getProducto())){
               total = p.getPrecio() + IGV;
               return total;
            }
        }
        return 0;
    }
    
}
