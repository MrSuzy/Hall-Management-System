package Admin;


import Login.LoginPage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jason
 */
public class adminUserMenu extends javax.swing.JFrame {

    /**
     * Creates new form adminStaff
     */
    public adminUserMenu() {
        initComponents();
        /*
        try {
            mainLoginPage login = new mainLoginPage();
            lblUsername.setText(login.getUsername());
            DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
            model.setRowCount(0);
            FileReader fr = new FileReader("staff.txt");
            BufferedReader br = new BufferedReader(fr);
            String read;
            while ((read = br.readLine()) != null) {
                if (read.split(";")[3].equals(login.getUsername())) {
                    String name = read.split(";")[0];
                    String password = read.split(";")[1];
                    String email = read.split(";")[2];
                    String username = read.split(";")[3];
                    String dateTime = read.split(";")[4];
                    String status = read.split(";")[5];
                    model.addRow(new Object[]{name, password, email, username, dateTime, status});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        */
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
        directoryPanel = new javax.swing.JPanel();
        btnStaff = new javax.swing.JButton();
        btnHall = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        cbUser = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStaff = new javax.swing.JTable();
        cbStatus = new javax.swing.JComboBox<>();
        lblPageTitle = new javax.swing.JLabel();
        btnBlock = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblActive = new javax.swing.JLabel();
        lblBlocked = new javax.swing.JLabel();
        lblNumActive = new javax.swing.JLabel();
        lblNumBlocked = new javax.swing.JLabel();
        btnUnblock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 242, 253));

        directoryPanel.setBackground(new java.awt.Color(228, 228, 228));

        btnStaff.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnStaff.setText("Staff Management");
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });

        btnHall.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnHall.setText("Hall Management");
        btnHall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHallActionPerformed(evt);
            }
        });

        btnMainMenu.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout directoryPanelLayout = new javax.swing.GroupLayout(directoryPanel);
        directoryPanel.setLayout(directoryPanelLayout);
        directoryPanelLayout.setHorizontalGroup(
            directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(directoryPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHall, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        directoryPanelLayout.setVerticalGroup(
            directoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(directoryPanelLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHall, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        lblTitle.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
        lblTitle.setText("Hall Symphony Inc");

        lblUsername.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblUsername.setText("username");

        btnLogout.setBackground(new java.awt.Color(227, 242, 253));
        btnLogout.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnLogout.setText("logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        cbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer" }));

        btnView.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setName(""); // NOI18N

        tbStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Contact", "Email", "Date Time Created", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbStaff);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "active", "blocked" }));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addContainerGap(10, Short.MAX_VALUE))
        );

        lblPageTitle.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblPageTitle.setText("Customer Account Management");

        btnBlock.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnBlock.setText("Block");
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblActive.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblActive.setText("Active Users: ");

        lblBlocked.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblBlocked.setText("Blocked Users: ");

        lblNumActive.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblNumActive.setText("600");

        lblNumBlocked.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblNumBlocked.setText("20");

        btnUnblock.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnUnblock.setText("Unblock");
        btnUnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnblockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(directoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUnblock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPageTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(lblNumActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBlocked, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumBlocked, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblUsername)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPageTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblActive)
                            .addComponent(lblNumActive)
                            .addComponent(lblBlocked)
                            .addComponent(lblNumBlocked))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBlock)
                            .addComponent(btnDelete)
                            .addComponent(btnUnblock)))
                    .addComponent(directoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new adminMainPage().setVisible(true);
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new adminStaffMenu().setVisible(true);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnHallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHallActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new adminHallManage().setVisible(true);
    }//GEN-LAST:event_btnHallActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbStaff.getModel();
        // get the selected role from the cbRole
        String selectedRole = cbUser.getSelectedItem().toString();
        // get the selected status from the cbStatus
        String selectedStatus = cbStatus.getSelectedItem().toString();
        adminClass1 Admin = new adminClass1();
        Admin.loadUserByRole(selectedRole, selectedStatus, model);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbStaff.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a staff to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbStaff.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.deleteUser(email);
        
        // refresh table
        ((DefaultTableModel) tbStaff.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbStaff.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "User selection is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbStaff.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.updateUserStatus(email, adminClass1.userStatus.BLOCKED);
        
        // refresh table
        ((DefaultTableModel) tbStaff.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnBlockActionPerformed

    private void btnUnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnblockActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbStaff.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "User selection is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // get email from the selected row
        String email = tbStaff.getValueAt(selectedRow, 2).toString(); 
        
        // call the delete method
        adminClass1 Admin = new adminClass1();
        Admin.updateUserStatus(email, adminClass1.userStatus.ACTIVE);
        
        // refresh table
        ((DefaultTableModel) tbStaff.getModel()).removeRow(selectedRow);
    }//GEN-LAST:event_btnUnblockActionPerformed

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
            java.util.logging.Logger.getLogger(adminUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHall;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnUnblock;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbUser;
    private javax.swing.JPanel directoryPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblBlocked;
    private javax.swing.JLabel lblNumActive;
    private javax.swing.JLabel lblNumBlocked;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tbStaff;
    // End of variables declaration//GEN-END:variables
}
