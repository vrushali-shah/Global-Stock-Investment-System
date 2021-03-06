/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import business.Customer.Customer;
import business.Customer.StockDetails;
import business.EcoSystem;
import business.Stock.Stock;
import business.Useraccount.UserAccount;
import business.Utilities;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class ViewHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewHistoryJPanel
     */
    private Customer customer;
    private EcoSystem ecosystem;
    private JPanel viewHistoryContainer;
    public ViewHistoryJPanel(JPanel viewHistoryContainer, EcoSystem ecosystem, UserAccount account) {
        initComponents();  
        this.viewHistoryContainer = viewHistoryContainer;
        this.ecosystem = ecosystem;
        this.customer = (Customer)account.getPerson();
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblTotalInv.getModel();

        model.setRowCount(0);

        for (Entry<Stock, StockDetails> entry : customer.getStockDetailMap().entrySet()) {
            double runningTotal = entry.getValue().getRunningTotal();
            Object[] row = new Object[7];
            Stock s = entry.getKey();
            row[0] = s.getStockId();
            row[1] = s;
            row[2] = s.getNetwork();
            row[3] = entry.getValue().getQuantity();
            row[4] = runningTotal;
            row[5] = runningTotal > 0 ? "Gain" : runningTotal < 0 ? "Loss" : "Nullified";
            row[6] = s.getRisk().name();
            model.addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotalInv = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tblTotalInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock ID", "Stock Name", "Network", "Quantity", "Running Total", "Gain/Loss", "Risk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTotalInv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblTotalInv;
    // End of variables declaration//GEN-END:variables
}
