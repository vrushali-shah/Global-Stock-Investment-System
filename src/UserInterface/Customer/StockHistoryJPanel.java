/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import business.EcoSystem;
import business.Network.Network;
import business.Stock.Stock;
import business.Stock.StockHistory;
import business.Utilities;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Vrushali Shah
 */
public class StockHistoryJPanel extends javax.swing.JPanel {

    private EcoSystem ecosystem;
    private JPanel stockHistoryContainer;

    /**
     * Creates new form StockSelectionJPanel
     */
    public StockHistoryJPanel(JPanel stockHistoryContainer, EcoSystem ecosystem) {
        initComponents();
        this.ecosystem = ecosystem;
        this.stockHistoryContainer = stockHistoryContainer;
       
        comboNetwork.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                populateTable((Network) comboNetwork.getSelectedItem());

            }
        });
         populateNetwork();
         comboNetwork.setSelectedIndex(0);
    }

    private void populateNetwork() {
        for (Network n : ecosystem.getNetworkDirectory().getNetworkList()) {
            comboNetwork.addItem(n);
        }
    }

    private void populateTable(Network n) {
        DefaultTableModel dtm = (DefaultTableModel) tblStock.getModel();
        dtm.setRowCount(0);

        for (Stock s : n.getStockCatalog().getStockList()) {
            Object row[] = new Object[2];
            row[0] = s.getStockId();
            row[1] = s;

            dtm.addRow(row);
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

        comboNetwork = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnGraph = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText("Stocks");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 0));
        jLabel18.setText("Networks");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StockID", "StockName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        btnGraph.setBackground(new java.awt.Color(0, 153, 153));
        btnGraph.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnGraph.setForeground(new java.awt.Color(255, 255, 255));
        btnGraph.setText("View Graph of selected stocks");
        btnGraph.setMaximumSize(new java.awt.Dimension(200, 200));
        btnGraph.setMinimumSize(new java.awt.Dimension(200, 200));
        btnGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(18, 18, 18)
                            .addComponent(comboNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel19)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(comboNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStockMouseClicked

    private void btnGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphActionPerformed
        // TODO add your handling code here:
        
        Network n = (Network) comboNetwork.getSelectedItem();
        TableModel model = tblStock.getModel();
        int[] selectedrows=tblStock.getSelectedRows();
        if(selectedrows.length==0)
            return;
          List<Stock> stocks = new ArrayList<>();
          
        for(int i=0;i<selectedrows.length;i++){
            stocks.add((Stock) model.getValueAt(i, 1));
        }
        
      
        
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Stock History",
                "Date", "Prices (" + n.getCountry().getValue() + ")",
                Utilities.createDatasetGroup(stocks),
                PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.darkGray);
        plot.setBackgroundPaint(Color.white);
        plot.setBackgroundAlpha(0.5f);
       plot.getRenderer().setSeriesPaint(0, Color.ORANGE);
        org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        ChartFrame frame = new ChartFrame("Price History", lineChart);
        frame.setVisible(true);
        frame.setSize(600, 600);

    }//GEN-LAST:event_btnGraphActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGraph;
    public javax.swing.JComboBox<Network> comboNetwork;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables
}
