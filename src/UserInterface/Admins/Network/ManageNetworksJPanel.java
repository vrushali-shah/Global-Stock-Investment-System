/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admins.Network;

import business.Network.Network;
import business.Network.NetworkDirectory;
import business.Useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vrushali Shah
 */
public class ManageNetworksJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private NetworkDirectory networkDir;
    private UserAccount account;

    /**
     * Creates new form ManageNetworksJPanel
     */
    public ManageNetworksJPanel(JPanel userProcessContainer, NetworkDirectory networkDir, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.networkDir = networkDir;
        this.account = account;
        populateTable();

        lblDisplayImg.setIcon(account.getPerson().getImgIcon());
        txtLoginName.setText(account.getPerson().getFirstName() + " " + account.getPerson().getLastName());
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblNetwork.getModel();

        model.setRowCount(0);
        for (Network network : networkDir.getNetworkList()) {
            Object[] row = new Object[3];
            row[0] = network.getId();
            row[1] = network;
            row[2] = network.getEnterpriseDirectory().getEnterpriseList().size();
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

        lblCustomername1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblManagername = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetwork = new javax.swing.JTable();
        btnViewNetwork = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblDisplayImg = new javax.swing.JLabel();
        btnAddNetwork = new javax.swing.JButton();
        txtLoginName = new javax.swing.JLabel();
        btnDeleteNetwork = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblCustomername1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername1.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername1.setText("Manage Networks");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Activity:");

        lblManagername.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblManagername.setForeground(new java.awt.Color(0, 102, 0));
        lblManagername.setText("SystemAdmin");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Global Stock Investments Console");

        tblNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network Id", "Country Name", "Enterprise Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNetwork.setRowHeight(20);
        jScrollPane1.setViewportView(tblNetwork);

        btnViewNetwork.setBackground(new java.awt.Color(0, 153, 153));
        btnViewNetwork.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnViewNetwork.setText("View Network");
        btnViewNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewNetworkActionPerformed(evt);
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

        btnAddNetwork.setBackground(new java.awt.Color(0, 153, 153));
        btnAddNetwork.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAddNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNetwork.setText("Add Network");
        btnAddNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnAddNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnAddNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNetworkActionPerformed(evt);
            }
        });

        txtLoginName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtLoginName.setForeground(new java.awt.Color(0, 102, 0));

        btnDeleteNetwork.setBackground(new java.awt.Color(0, 153, 153));
        btnDeleteNetwork.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDeleteNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteNetwork.setText("Delete Network");
        btnDeleteNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnDeleteNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnDeleteNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNetworkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCustomername1)
                        .addGap(793, 793, 793)
                        .addComponent(txtLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblManagername)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDisplayImg, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAddNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(110, 110, 110)
                            .addComponent(btnViewNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblCustomername1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblManagername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDisplayImg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewNetworkActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNetwork.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row from table to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Network network = (Network) tblNetwork.getValueAt(selectedRow, 1);
            ViewNetworkJPanel viewNetworkJPanel = new ViewNetworkJPanel(userProcessContainer, network, account);
            userProcessContainer.add("viewNetworkJPanel", viewNetworkJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnViewNetworkActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNetworkActionPerformed
        // TODO add your handling code here:
        AddNetworkJPanel addNetworkJPanel = new AddNetworkJPanel(userProcessContainer, networkDir, account);
        userProcessContainer.add("addNetworkJPanel", addNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddNetworkActionPerformed

    private void btnDeleteNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNetworkActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblNetwork.getSelectedRow();
        if (selectedRow >= 0) {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the Network details?", "removeNetwork", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {

                Network network = (Network) tblNetwork.getValueAt(selectedRow, 1);
                networkDir.getNetworkList().remove(network);
                populateTable();
                JOptionPane.showMessageDialog(null, "Network deleted successfully.");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select any row.");
        }
    }//GEN-LAST:event_btnDeleteNetworkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNetwork;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteNetwork;
    private javax.swing.JButton btnViewNetwork;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JLabel lblDisplayImg;
    private javax.swing.JLabel lblManagername;
    private javax.swing.JTable tblNetwork;
    private javax.swing.JLabel txtLoginName;
    // End of variables declaration//GEN-END:variables
}
