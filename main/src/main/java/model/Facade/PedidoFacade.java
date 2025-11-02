/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Facade;

/**
 *
 * @author diana
 */
public class PedidoFacade {
    Pedido pedido;
    CalculoMontoTotal monto;
    StockProducto stock;
    
    public PedidoFacade() {
        this.pedido = new Pedido(null,null,0);
        this.stock = new StockProducto();
        this.monto = new CalculoMontoTotal();
    }
    
    public void ProcesarPedido(Pedido pedido){
        
    }
    
}
