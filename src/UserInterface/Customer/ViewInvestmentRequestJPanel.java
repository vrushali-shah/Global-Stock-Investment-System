/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import business.Customer.Customer;
import business.Enterprise.Enterprise;
import business.Investment.Investment;
import business.Investment.InvestmentItem;
import business.Network.Network;
import business.Stock.Stock;
import business.WorkQueue.InvestmentWorkRequest;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Prashant Kabra (kabra.p@husky.neu.edu)
 */
public class ViewInvestmentRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewInvestmentRequestJPanel
     */
    private JPanel viewRequestContainer;
    private InvestmentWorkRequest iwr;

    //changes for jasper report
    private Enterprise enterprise;
    private Network network;
    private DefaultTableModel model;
    private Map<String, Object> params;
    private static int viewCount = 0;

    public ViewInvestmentRequestJPanel(JPanel viewRequestContainer, InvestmentWorkRequest iwr) {
        initComponents();
        this.viewRequestContainer = viewRequestContainer;
        this.iwr = iwr;
        populateTable();
        totaTxt.setText(String.valueOf(iwr.getInvestment().totalInvestment()));
        investmentTypeLabel.setText(iwr.getInvestment().getType() == 0 ? "Buy" : "Sell");

        //changes for jasper report
        network = iwr.getOrganisation().getInEnterprise().getInNetwork();
        params = new HashMap<>();
        model = (DefaultTableModel) tblTotalInv.getModel();

        if (iwr.getStatus().equals("Completed")) {
            btnViewReport.setEnabled(true);
        } else {
            btnViewReport.setEnabled(false);
        }
    }

    public void populateTable() {
        Investment investment = iwr.getInvestment();
        model = (DefaultTableModel) tblTotalInv.getModel();

        model.setRowCount(0);
        Customer c = investment.getCustomer();

        for (InvestmentItem item : investment.getInvestmentList()) {
            Object[] row = new Object[6];
            Stock s = item.getStock();
            row[0] = s.getStockId();
            row[1] = s;
            row[2] = s.getRisk().name();
            row[3] = item.getQuantity();
            row[4] = item.getPrice() != 0 ? item.getPrice() : "";
            row[5] = s.getNetwork().getCountry().getValue();
            model.addRow(row);
        }

    }

    private void generateReportParameters() {
        //get params needed for report
        String reportBy = iwr.getReceiver().getPerson().getFirstName() + " " + iwr.getReceiver().getPerson().getLastName();
        String reportFor = iwr.getSender().getPerson().getFirstName() + " " + iwr.getSender().getPerson().getLastName();

        //Map<String, Object> params = new HashMap<String, Object>();
        params.put("ReportGenBy", reportBy);
        params.put("ReportGenFor", reportFor);
        params.put("NetworkId", network.getId());
        params.put("NetworkName", network.getCountry().name());
    }

    private void showReport(int viewCount) {

        try {
            String outputFilename = "";

            outputFilename = "Report" + (viewCount) + ".html";
            String reportSource = System.getProperty("user.dir") + "\\src\\Reports\\Template\\Customer\\CustomerReportFormat.jrxml";

            String reportDest = System.getProperty("user.dir") + "\\src\\Reports\\Results\\Customer\\" + outputFilename;

            JRDataSource beanColDataSource = new JRTableModelDataSource(model);

            JasperReport jasperReport
                    = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, params, beanColDataSource);
            JasperExportManager.exportReportToHtmlFile(
                    jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jLabel24 = new javax.swing.JLabel();
        totaTxt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotalInv = new javax.swing.JTable();
        btnBack1 = new javax.swing.JButton();
        investmentTypeLabel = new javax.swing.JLabel();
        btnViewReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 153, 0));
        jLabel24.setText("Total Investment");

        totaTxt.setEditable(false);
        totaTxt.setBackground(new java.awt.Color(255, 255, 255));
        totaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totaTxtActionPerformed(evt);
            }
        });

        tblTotalInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StockId", "StockName", "Risk", "Quantity", "Price", "Currency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTotalInv.setRowHeight(20);
        jScrollPane3.setViewportView(tblTotalInv);

        btnBack1.setBackground(new java.awt.Color(0, 153, 153));
        btnBack1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("<<");
        btnBack1.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack1.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        investmentTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        investmentTypeLabel.setForeground(new java.awt.Color(255, 153, 0));
        investmentTypeLabel.setText("Investments");

        btnViewReport.setBackground(new java.awt.Color(0, 153, 153));
        btnViewReport.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewReport.setForeground(new java.awt.Color(255, 255, 255));
        btnViewReport.setText("View Report");
        btnViewReport.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewReport.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(investmentTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(26, 26, 26)
                        .addComponent(totaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(totaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(investmentTypeLabel))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void totaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totaTxtActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        viewRequestContainer.remove(this);
        CardLayout layout = (CardLayout) viewRequestContainer.getLayout();
        layout.previous(viewRequestContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed

        // TODO add your handling code here:
        viewCount++;
        generateReportParameters();
        showReport(viewCount);
    }//GEN-LAST:event_btnViewReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnViewReport;
    private javax.swing.JLabel investmentTypeLabel;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblTotalInv;
    private javax.swing.JTextField totaTxt;
    // End of variables declaration//GEN-END:variables
}
