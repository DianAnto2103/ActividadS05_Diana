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
     * @param clientName Nombre del cliente
     * @param amount Monto total
     * @param taxCode Código de impuesto (1=IGV, 2=Otro)
     * @return Número de factura
     */
    public int createInvoice(String clientName, double amount, int taxCode) {
        // Lógica antigua de facturación
        System.out.println("Legacy: Factura creada para " + clientName);
        return 1000 + (int)(Math.random() * 1000); // Número de factura fake
    }
    
    /**
     * Método LEGACY - Obtiene estado con código numérico
     * @param invoiceNumber Número de factura
     * @return 1=Activa, 2=Pendiente, 3=Anulada
     */
    public int getInvoiceStatus(int invoiceNumber) {
        return 1; // Siempre activa para el ejemplo
    }
    
}
