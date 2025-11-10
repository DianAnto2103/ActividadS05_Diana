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
    Pedido buscarporID(int id);
    List<Pedido> buscarTodos();
    void guardar(Pedido pedido);
    void actualizar(Pedido pedido);
    void eliminar(Pedido pedido);
}
