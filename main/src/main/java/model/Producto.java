/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diana
 */
public class Producto {
    String nombre;
    int cantidadStock;
    double precio;
    
    public Producto(String nombre, int cantidadStock, double precio) {
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }  
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidadStock;
    }

    public void setCantidad(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
