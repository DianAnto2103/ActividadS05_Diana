/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;


/**
 *
 * @author diana
 */
public class Pedido {
    private String nombre_cliente;
    private String producto;
    private int cantidad;
    
    public Pedido(String nombre_cliente, String producto, int cantidad) {
        this.nombre_cliente = nombre_cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public boolean cantidadCorrecta(int cantidad){
        return cantidad > 0;
    }
   
    
    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
