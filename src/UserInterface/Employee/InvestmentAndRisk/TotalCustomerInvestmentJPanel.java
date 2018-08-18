/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Employee.InvestmentAndRisk;

import business.Customer.Customer;
import business.Employee.Employee;
import business.Enterprise.Enterprise;
import business.Investment.InvestmentItem;
import business.Network.Network;
import business.Stock.Stock;
import business.Utilities;
import business.WorkQueue.InvestmentWorkRequest;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
 * @author Vrushali Shah
 */
public class TotalCustomerInvestmentJPanel extends javax.swing.JPanel {

    private JPanel requestInvContainer;
    private InvestmentWorkRequest iwr;

    //changes for jasper report
    private Enterprise enterprise;
    private DefaultTableModel model;
    private Map<String, Object> params;
    private static int viewCount = 0;

    /**
     * Creates new form RegionalCustomerInvestmentJPanel
     */
    public TotalCustomerInvestmentJPanel(JPanel requestInvContainer, InvestmentWorkRequest iwr, Enterprise enterprise) {
        initComponents();
        this.requestInvContainer = requestInvContainer;
        this.iwr = iwr;
        this.enterprise = enterprise;
        
        requestIDLabel.setText(String.valueOf(iwr.getId()));

        //changes for jasper report
        params = new HashMap<>();
        model = (DefaultTableModel) tblCustomerInv.getModel();

        if (iwr.getStatus().equals("Completed")) {
            btnProcessInvestment.setEnabled(false);
            btnViewReport.setEnabled(true);

        } else {
            btnProcessInvestment.setEnabled(true);
            btnViewReport.setEnabled(false);
        }
        populateTable();

    }

    public void populateTable() {
        double total = 0;
        DefaultTableModel model = (DefaultTableModel) tblCustomerInv.getModel();

        model.setRowCount(0);
        for (InvestmentItem item : iwr.getInvestment().getInvestmentList()) {
            Stock s = item.getStock();
            Object[] row = new Object[6];
            row[0] = s.getNetwork().getCountry().name();
            row[1] = s.getStockId();
            row[2] = s;
            row[3] = item.getQuantity();

            double price = Utilities.currentPrice(s);
            if (price == -1) {
                price = s.getStockHistoryList().get(0).getPrice();
            }

            row[4] = price;
            row[5] = s.getNetwork().getCountry().getValue();

            model.addRow(row);
            total += (price * item.getQuantity());
        }
         NumberFormat formatter = new DecimalFormat("#0.00");

        totalLabel.setText(String.valueOf(formatter.format(total)));
    }

    private void generateReportParameters() {
        //get params needed for report
        String reportBy = iwr.getReceiver().getPerson().getFirstName() + " " + iwr.getReceiver().getPerson().getLastName();
        String reportFor = iwr.getSender().getPerson().getFirstName() + " " + iwr.getSender().getPerson().getLastName();

        params.put("ReportGenBy", reportBy);
        params.put("ReportGenFor", reportFor);
    }

    private void showReport(int viewCount) {
        try {
            String outputFilename = "";

            outputFilename = "Report" + (viewCount) + ".html";

            String reportSource = System.getProperty("user.dir") + "\\src\\Reports\\Template\\Employee\\EmployeeReportFormat.jrxml";

            String reportDest = System.getProperty("user.dir") + "\\src\\Reports\\Results\\Employee\\" + outputFilename;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerInv = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        requestIDLabel = new javax.swing.JLabel();
        lblManagername = new javax.swing.JLabel();
        lblManagername1 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnProcessInvestment = new javax.swing.JButton();
        btnViewReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblCustomerInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network ID", "Stock ID", "Stock Name", "Quantity", "Price", "Currency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCustomerInv);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setText("Total Investment List");

        requestIDLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        requestIDLabel.setForeground(new java.awt.Color(0, 102, 0));

        lblManagername.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblManagername.setForeground(new java.awt.Color(0, 102, 0));
        lblManagername.setText("Request ID:");

        lblManagername1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblManagername1.setForeground(new java.awt.Color(0, 102, 0));
        lblManagername1.setText("Total Investment Amount:");

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 102, 0));

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

        btnProcessInvestment.setBackground(new java.awt.Color(0, 153, 153));
        btnProcessInvestment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnProcessInvestment.setForeground(new java.awt.Color(255, 255, 255));
        btnProcessInvestment.setText("Process Investment");
        btnProcessInvestment.setMaximumSize(new java.awt.Dimension(200, 200));
        btnProcessInvestment.setMinimumSize(new java.awt.Dimension(200, 200));
        btnProcessInvestment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessInvestmentActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblManagername1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 514, Short.MAX_VALUE)
                                    .addComponent(lblManagername)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(requestIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnProcessInvestment, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblManagername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21))
                    .addComponent(requestIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblManagername1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcessInvestment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(395, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goBack() {
        requestInvContainer.remove(this);
        ServeCustomerJPanel sc;
        sc = (ServeCustomerJPanel) requestInvContainer.getComponent(requestInvContainer.getComponentCount() - 1);
        sc.populateTable();
        CardLayout layout = (CardLayout) requestInvContainer.getLayout();
        layout.previous(requestInvContainer);
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProcessInvestmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessInvestmentActionPerformed
        // TODO add your handling code here:
        Employee e = (Employee) iwr.getReceiver().getPerson();
        Customer c = (Customer) iwr.getSender().getPerson();
        e.addInvestment(iwr.getInvestment());
        c.addInvestment(iwr.getInvestment());
        Network enterpriseNetwork = enterprise.getInNetwork();
        Network stockNetwork;
        double price = 0;
        for (InvestmentItem item : iwr.getInvestment().getInvestmentList()) {
            stockNetwork = item.getStock().getNetwork();
            price = item.getStock().getStockHistoryList().get(0).getPrice();
            if (stockNetwork != enterpriseNetwork) {
                price *= Utilities.getConversionRate(stockNetwork.getCountry().getValue(), enterpriseNetwork.getCountry().getValue());
            }

            item.setPrice(price);
        }
        iwr.setStatus("Completed");
        iwr.getInvestment().setFromCountry(enterpriseNetwork.getCountry());
        iwr.getInvestment().setCustomer(c);
        iwr.getInvestment().setEmployee(e);
        iwr.getInvestment().setDate(iwr.getResolveDate());
        c.addInvestment(iwr.getInvestment());

        JOptionPane.showMessageDialog(null, "Request processed successfully.");
        btnViewReport.setEnabled(true);
        btnProcessInvestment.setEnabled(false);
    }//GEN-LAST:event_btnProcessInvestmentActionPerformed

    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed

        // TODO add your handling code here:
        viewCount++;
        if (iwr.getStatus().equals("Completed")) {
            btnProcessInvestment.setEnabled(false);
        } else {
            btnProcessInvestment.setEnabled(true);
        }
        generateReportParameters();
        showReport(viewCount);

    }//GEN-LAST:event_btnViewReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnProcessInvestment;
    private javax.swing.JButton btnViewReport;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManagername;
    private javax.swing.JLabel lblManagername1;
    private javax.swing.JLabel requestIDLabel;
    private javax.swing.JTable tblCustomerInv;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
