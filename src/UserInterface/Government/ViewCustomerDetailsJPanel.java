/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Government;

import business.Enterprise.Enterprise;
import business.Investment.Investment;
import business.Investment.InvestmentItem;
import business.Utilities;
import business.WorkQueue.GovernmentWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;

/**
 *
 * @author Vrushali Shah
 */
public class ViewCustomerDetailsJPanel extends javax.swing.JPanel {

    private JPanel viewCustomerHistoryContainer;
    private GovernmentWorkRequest gwr;

    /**
     * Creates new form ViewCustomerDetailsJPanel
     */
    public ViewCustomerDetailsJPanel(JPanel viewCustomerHistoryContainer, GovernmentWorkRequest gwr) {
        initComponents();
        this.viewCustomerHistoryContainer = viewCustomerHistoryContainer;
        this.gwr = gwr;
        populateEnterpriseTable();
        txtID.setText(String.valueOf(gwr.getCustomer().getId()));
        txtCustName.setText(gwr.getCustomer().getFirstName() + " " + gwr.getCustomer().getLastName());
    }

    private void populateEnterpriseTable() {

        DefaultTableModel model = (DefaultTableModel) tblDetails.getModel();

        model.setRowCount(0);

        for (Map.Entry<Enterprise, List<Investment>> entry : gwr.getEnterpriseInvestMap().entrySet()) {
            Enterprise enterprise = entry.getKey();

            Object[] row = new Object[3];
            row[0] = enterprise.getEnterpriseId();
            row[1] = enterprise;
            row[2] = entry.getValue() == null ? "Waiting for data" : entry.getValue().size();

            model.addRow(row);

        }

    }

    private void populateInvestments(Enterprise e) {
        List<Investment> investmentList = gwr.getEnterpriseInvestMap().get(e);
        DefaultTableModel model = (DefaultTableModel) tblEnterpriseInvestments.getModel();

        model.setRowCount(0);

        for (Investment investment : investmentList) {
            for (InvestmentItem item : investment.getInvestmentList()) {
                Object[] row = new Object[4];
                row[0] = item.getStock();
                row[1] = item.getStock().getCompanyName();
                row[2] = item.getQuantity();
                row[3] = item.getPrice();

                model.addRow(row);
            }
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

        lblCustId = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCustId1 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnterpriseInvestments = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        btnEnterpriseInvestments = new javax.swing.JButton();
        btnViewCustomerAnalysis = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblCustId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustId.setForeground(new java.awt.Color(255, 153, 0));
        lblCustId.setText("Customer ID:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblCustId1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustId1.setForeground(new java.awt.Color(255, 153, 0));
        lblCustId1.setText("Customer Name");

        txtCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustNameActionPerformed(evt);
            }
        });

        tblEnterpriseInvestments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Stock Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEnterpriseInvestments);

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Id", "Enterprise Name", "Number of Investment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetails);

        btnEnterpriseInvestments.setBackground(new java.awt.Color(0, 153, 153));
        btnEnterpriseInvestments.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEnterpriseInvestments.setForeground(new java.awt.Color(255, 255, 255));
        btnEnterpriseInvestments.setText("View Enterprise Investments");
        btnEnterpriseInvestments.setMaximumSize(new java.awt.Dimension(200, 200));
        btnEnterpriseInvestments.setMinimumSize(new java.awt.Dimension(200, 200));
        btnEnterpriseInvestments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterpriseInvestmentsActionPerformed(evt);
            }
        });

        btnViewCustomerAnalysis.setBackground(new java.awt.Color(0, 153, 153));
        btnViewCustomerAnalysis.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewCustomerAnalysis.setForeground(new java.awt.Color(255, 255, 255));
        btnViewCustomerAnalysis.setText("View Customer Analysis");
        btnViewCustomerAnalysis.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewCustomerAnalysis.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewCustomerAnalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCustomerAnalysisActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<<");
        btnBack.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCustId1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCustId)
                                .addGap(18, 18, 18)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewCustomerAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEnterpriseInvestments, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustId)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustId1)
                            .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnViewCustomerAnalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnEnterpriseInvestments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustNameActionPerformed

    private void btnEnterpriseInvestmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpriseInvestmentsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDetails.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the enterprise from table to view investments", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            Enterprise e = (Enterprise) tblDetails.getValueAt(selectedRow, 1);
            if (gwr.getEnterpriseInvestMap().get(e) != null) {
                populateInvestments(e);
            } else {
                DefaultTableModel model = (DefaultTableModel) tblEnterpriseInvestments.getModel();
                model.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Data not received yet", "Infomation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEnterpriseInvestmentsActionPerformed

    private void btnViewCustomerAnalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCustomerAnalysisActionPerformed
        // TODO add your handling code here:

        Map<String, Integer> stockInv = new HashMap<>();
        for (Map.Entry<Enterprise, List<Investment>> customerEntry : gwr.getEnterpriseInvestMap().entrySet()) {
            Enterprise enterprise = customerEntry.getKey();
            List<Investment> investmentList = customerEntry.getValue();

            if (investmentList != null) {
                for (Investment inv : investmentList) {
                    for (InvestmentItem item : inv.getInvestmentList()) {

                        String companyName = item.getStock().getNetwork().getCountry().name();
                        if (stockInv.containsKey(companyName)) {
                            stockInv.put(companyName, stockInv.get(companyName) + 1);
                        } else {
                            stockInv.put(companyName, 1);
                        }
                    }
                }
            }
        }

        if (stockInv.size() == 0) {
            return;
        }

        JFreeChart piechart = ChartFactory.createPieChart(
                "Customer Stock Investment",
                Utilities.createPieDataset(stockInv), true,
                true,
                false);

//        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
//                "Quantity {0} : ({3})", new DecimalFormat("0"), new DecimalFormat("0%"));
//        ((PiePlot) piechart.getPlot()).setLabelGenerator(labelGenerator);
        //CategoryPlot plot = piechart.getCategoryPlot();
        PiePlot plot = (PiePlot) piechart.getPlot();

        //plot.setRangeGridlinePaint(Color.ORANGE);
        plot.setCircular(true);
        plot.setLabelGap(0.01);
        ChartFrame frame = new ChartFrame("Pie Chart", piechart);
        plot.setBackgroundPaint(Color.white);
        frame.setVisible(true);
        frame.setSize(800, 800);

    }//GEN-LAST:event_btnViewCustomerAnalysisActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        viewCustomerHistoryContainer.remove(this);
        CardLayout layout = (CardLayout) viewCustomerHistoryContainer.getLayout();
        layout.previous(viewCustomerHistoryContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnterpriseInvestments;
    private javax.swing.JButton btnViewCustomerAnalysis;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustId;
    private javax.swing.JLabel lblCustId1;
    private javax.swing.JTable tblDetails;
    private javax.swing.JTable tblEnterpriseInvestments;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
