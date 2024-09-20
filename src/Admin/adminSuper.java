/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Login.LoginPage;
import Manager.managerMainMenu;
import Scheduler.schedulerMainMenu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class adminSuper extends javax.swing.JFrame {

    /**
     * Creates new form adminSuper
     */
    public adminSuper() {
        initComponents();
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
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        directoryPanel = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        btnManagerMenu = new javax.swing.JButton();
        btnSchedulerMenu = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        cbUser = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        cbStatus = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnBlock = new javax.swing.JButton();
        btnUnblock = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblPageTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 242, 253));

        lblTitle.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
        lblTitle.setText("Hall Symphony Inc");

        lblUsername.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblUsername.setText("username");

        directoryPanel.setBackground(new java.awt.Color(228, 228, 228));

        btnMenu.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnMenu.setText("Main Menu");
        btnMenu.setToolTipText("");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnManagerMenu.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnManagerMenu.setText("Manager Menu");
        btnManagerMenu.setToolTipText("");
        btnManagerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerMenuActionPerformed(evt);
            }
        });

        btnSchedulerMenu.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnSchedulerMenu.setText("Scheduler Menu");
        btnSchedulerMenu.setToolTipText("");
        btnSchedulerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSchedulerMenuActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setToolTipText("");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout directoryPanelLayout = new javax.swing.GroupLayout(directoryPanel);
        directoryPanel.setLayout(directoryPanelLayout);
        directoryPanelLayout.setHorizontalGroup(
            directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, directoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManagerMenu)
                .addGap(18, 18, 18)
                .addComponent(btnSchedulerMenu)
                .addGap(18, 18, 18)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        directoryPanelLayout.setVerticalGroup(
            directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(directoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMenu)
                    .addComponent(btnManagerMenu)
                    .addComponent(btnSchedulerMenu)
                    .addComponent(btnLogout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "manager", "scheduler", "customer", "all" }));

        btnView.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setName(""); // NOI18N

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Contact", "Email", "Date Time Created", "Status", "Role"
            }
        ));
        jScrollPane1.setViewportView(tbUser);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "inactive", "blocked", "all" }));

        btnDelete.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBlock.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnBlock.setText("Block");
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });

        btnUnblock.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnUnblock.setText("Unblock");
        btnUnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnblockActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUnblock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(infoPanelLayout.createSequentialGroup()
                            .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnBlock)
                    .addComponent(btnUnblock)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lblPageTitle.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblPageTitle.setText("Users Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(directoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addComponent(directoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPageTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbUser.getModel();
        // get the selected role from the cbRole
        String selectedRole = cbUser.getSelectedItem().toString();
        // get the selected status from the cbStatus
        String selectedStatus = cbStatus.getSelectedItem().toString();
        adminClass1 Admin = new adminClass1();
        Admin.loadUserByRole(selectedRole, selectedStatus, model);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a staff to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbUser.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.deleteUser(email);
        
        // refresh table
        ((DefaultTableModel) tbUser.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbUser.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "User selection is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbUser.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.updateUserStatus(email, adminClass1.userStatus.BLOCKED);
        
        // refresh table
        ((DefaultTableModel) tbUser.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnBlockActionPerformed

    private void btnUnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnblockActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbUser.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "User selection is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbUser.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.updateUserStatus(email, adminClass1.userStatus.ACTIVE);
        
        // refresh table
        ((DefaultTableModel) tbUser.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnUnblockActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get the selected rows user data
        String name = tbUser.getValueAt(selectedRow, 0).toString();
        String phoneNum = tbUser.getValueAt(selectedRow, 1).toString();
        String email = tbUser.getValueAt(selectedRow, 2).toString();
        String status = tbUser.getValueAt(selectedRow, 5).toString();
        String role = tbUser.getValueAt(selectedRow, 6).toString();
        
        // instance of adminClass1
        adminClass1 Admin = new adminClass1();
        
        this.dispose();
        new adminEditScheduler(name, phoneNum, email, status, role).setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new adminAddScheduler().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new adminMainPage().setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnManagerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new managerMainMenu().setVisible(true);
    }//GEN-LAST:event_btnManagerMenuActionPerformed

    private void btnSchedulerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSchedulerMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new schedulerMainMenu().setVisible(true);
    }//GEN-LAST:event_btnSchedulerMenuActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminSuper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminSuper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminSuper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminSuper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminSuper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManagerMenu;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSchedulerMenu;
    private javax.swing.JButton btnUnblock;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbUser;
    private javax.swing.JPanel directoryPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tbUser;
    // End of variables declaration//GEN-END:variables
}