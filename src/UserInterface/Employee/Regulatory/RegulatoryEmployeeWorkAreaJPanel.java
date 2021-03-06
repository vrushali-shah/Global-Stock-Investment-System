/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Employee.Regulatory;

import UserInterface.Customer.FuturInvestmentJPanel;
import business.EcoSystem;
import business.Organisation.Organisation;
import business.Useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vrushali Shah
 */
public class RegulatoryEmployeeWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem ecosystem;
    private Organisation organisation;

    public RegulatoryEmployeeWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organisation organisation, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.ecosystem = ecosystem;
        this.organisation = organisation;
        expertJPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if (index == 1) {
                    ViewHistoryDataJPanel vh = (ViewHistoryDataJPanel) viewHistoryContainer.getComponent(0);
                    vh.populateTable();
                }
            }
        });
        loadPanelForProvideData();
        loadPanelViewHistory();
    }

    private void loadPanelForProvideData() {

        ProvideDataJPanel panel = new ProvideDataJPanel(provideDataContainer, organisation, account);
        provideDataContainer.add("ProvideDataJPanel", panel);
        CardLayout cardLayout = (CardLayout) provideDataContainer.getLayout();
        cardLayout.next(provideDataContainer);
    }

    private void loadPanelViewHistory() {

        ViewHistoryDataJPanel panel = new ViewHistoryDataJPanel(viewHistoryContainer, organisation, account);
        viewHistoryContainer.add("ViewHistoryDataJPanel", panel);
        CardLayout cardLayout = (CardLayout) viewHistoryContainer.getLayout();
        cardLayout.next(viewHistoryContainer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCustomername1 = new javax.swing.JLabel();
        expertJPanel = new javax.swing.JTabbedPane();
        provideDataContainer = new javax.swing.JPanel();
        viewHistoryContainer = new javax.swing.JPanel();
        lblManagername = new javax.swing.JLabel();
        txtLoginName = new javax.swing.JLabel();
        lblDisplayImg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Global Stock Investments Console");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Activity:");

        lblCustomername1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername1.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername1.setText("Regulatory Employee WorkArea");

        expertJPanel.setBackground(new java.awt.Color(255, 255, 255));

        provideDataContainer.setBackground(new java.awt.Color(255, 255, 255));
        provideDataContainer.setLayout(new java.awt.CardLayout());
        expertJPanel.addTab("Provide Customer Data", provideDataContainer);

        viewHistoryContainer.setBackground(new java.awt.Color(255, 255, 255));
        viewHistoryContainer.setLayout(new java.awt.CardLayout());
        expertJPanel.addTab("View History", viewHistoryContainer);

        lblManagername.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblManagername.setForeground(new java.awt.Color(0, 102, 0));
        lblManagername.setText("Regulatory Employee");

        txtLoginName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtLoginName.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomername1)))
                        .addGap(273, 273, 273)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblManagername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                            .addComponent(txtLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDisplayImg, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addComponent(expertJPanel))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblCustomername1)))
                    .addComponent(lblManagername)
                    .addComponent(lblDisplayImg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(expertJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane expertJPanel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JLabel lblDisplayImg;
    private javax.swing.JLabel lblManagername;
    private javax.swing.JPanel provideDataContainer;
    private javax.swing.JLabel txtLoginName;
    private javax.swing.JPanel viewHistoryContainer;
    // End of variables declaration//GEN-END:variables
}
