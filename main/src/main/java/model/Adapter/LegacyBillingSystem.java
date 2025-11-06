/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Adapter;

/**
 *
 * @author diana
 */
public class LegacyBillingSystem {
    private int numeroFactura = 1000;
    /**
     * Método LEGACY - Crea factura con parámetros antiguos
     * @param idCliente
     * @param nameCliente
     * @param itemCode
     * @param unitValue
     * @param itemQty
     * @return Número de factura
     */
    public int createInvoice(int idCliente, String nameCliente,String itemCode, double unitValue, int itemQty) {
        // Generar número de factura secuencial
        numeroFactura++;
        
        // Simular procesamiento LEGACY
        System.out.println("=== SISTEMA LEGACY DE FACTURACION ===");
        System.out.println("FACTURA NUMERO: " + numeroFactura);
        System.out.println("CLIENTE ID: " + idCliente);
        System.out.println("CLIENTE NOMBRE: " + nameCliente);
        System.out.println("PRODUCTO: " + itemCode);
        System.out.println("VALOR UNIT: " + unitValue);
        System.out.println("CANTIDAD: " + itemQty);
        System.out.println("SUBTOTAL: " + (unitValue * itemQty));
        System.out.println("IGV: " + (unitValue * itemQty) * 0.18);
        System.out.println("TOTAL: " + (unitValue * itemQty) * 1.18);
        System.out.println("ESTADO: PROCESADO");
        System.out.println("=====================================");
        
        return numeroFactura;
    }
}
