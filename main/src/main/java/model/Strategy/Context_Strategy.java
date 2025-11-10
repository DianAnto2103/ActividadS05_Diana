/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Strategy;

/**
 *
 * @author diana
 */
public class Context_Strategy {
    private ImpuestoStrategy estrategia;
    
    public void setEstrategia(ImpuestoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    public double executeStrategy(double subtotal){
        return estrategia.calcular(subtotal);
    }
    
}
