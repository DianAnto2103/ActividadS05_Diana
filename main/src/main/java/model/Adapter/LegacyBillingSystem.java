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
    /**
     * Método LEGACY - Crea factura con parámetros antiguos
     * @param clientId
     * @param productCode
     * @param unitPrice
     * @param quantity
     * @return Número de factura
     */
    public int createInvoice(int clientId, String productCode, double unitPrice, int quantity) {
        System.out.println("Legacy: Invoice created for client " + clientId);
        return 1001; // número de factura
    }
}
