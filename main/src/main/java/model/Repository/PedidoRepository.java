/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.Repository;

import java.util.List;
import model.Pedido;

/**
 *
 * @author diana
 */
public interface PedidoRepository {
    public Pedido buscarporID(int id);
    public List<Pedido> buscarTodos();
    public void guardar(Pedido pedido);
    public void actualizar(Pedido pedido);
    public void eliminar(Pedido pedido);
}
