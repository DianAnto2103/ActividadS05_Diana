/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diana
 */
public abstract class Producto {
    private String nombre;
    private int stock;
    private double precio;
    
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }
   
}
