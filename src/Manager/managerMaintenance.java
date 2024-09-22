package Manager;


import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author khaientiew
 */
public class managerMaintenance extends javax.swing.JFrame {

    /**
     * Creates new form Manager_Login
     */
    public managerMaintenance() {
        initComponents();
        Color col = new Color(224, 240, 255);
        Color buttonColor = new Color(228, 228, 228);
        Color color = new Color(242, 242, 242);
        getContentPane().setBackground(col);
        btnSales.setBackground(buttonColor);
        btnMaintenance.setBackground(buttonColor);
        btnMainMenu.setBackground(buttonColor);
        btnLogOut.setBackground(buttonColor);
        btnResponse.setBackground(buttonColor);
        btnAssignScheduler.setBackground(buttonColor);
        btnEditStatus.setBackground(buttonColor);
        TbMaintenance.setBackground(color);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void buttonClick(String type) {
        managerMaintenanceClass issue = new managerMaintenanceClass();
        ArrayList<String[]> IssueList = issue.readIssues();
        loadTable(IssueList);
    }
    
    private void loadTable(ArrayList<String[]> issues) {
        DefaultTableModel model = (DefaultTableModel) TbMaintenance.getModel();
        model.setRowCount(0);
        
        for (String[] issue : issues) {
            model.addRow(issue);
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblCompanyName = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        lblMaintenanceList = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbMaintenance = new javax.swing.JTable();
        btnAssignScheduler = new javax.swing.JButton();
        btnResponse = new javax.swing.JButton();
        btnEditStatus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnMainMenu = new javax.swing.JButton();
        btnSales = new javax.swing.JButton();
        btnMaintenance = new javax.swing.JButton();
        CBStatus = new javax.swing.JComboBox<>();
        CBSchedular = new javax.swing.JComboBox<>();
        BtnView = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCompanyName.setFont(new java.awt.Font("Bradley Hand", 0, 36)); // NOI18N
        lblCompanyName.setText("Hall Symphony Inc.");
        lblCompanyName.setLocation(new java.awt.Point(0, 25));

        btnLogOut.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lblMaintenanceList.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        lblMaintenanceList.setText("Maintenance Operations List");

        TbMaintenance.setFont(new java.awt.Font("Apple LiGothic", 1, 18)); // NOI18N
        TbMaintenance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ticket ID", "HallID", "Date/Time", "Issue", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TbMaintenance);

        btnAssignScheduler.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnAssignScheduler.setText("Assign Scheduler");
        btnAssignScheduler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignSchedulerActionPerformed(evt);
            }
        });

        btnResponse.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnResponse.setText("Response");
        btnResponse.setSize(new java.awt.Dimension(78, 21));
        btnResponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponseActionPerformed(evt);
            }
        });

        btnEditStatus.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnEditStatus.setText("Edit Status");
        btnEditStatus.setSize(new java.awt.Dimension(78, 21));
        btnEditStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStatusActionPerformed(evt);
            }
        });

        btnMainMenu.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setPreferredSize(new java.awt.Dimension(80, 23));
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        btnSales.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnSales.setText("Sales Dashboard");
        btnSales.setPreferredSize(new java.awt.Dimension(80, 23));
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        btnMaintenance.setFont(new java.awt.Font("Gill Sans", 0, 18)); // NOI18N
        btnMaintenance.setText("Maintenance Operations");
        btnMaintenance.setPreferredSize(new java.awt.Dimension(80, 23));
        btnMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaintenanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        CBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Open", "Pending", "Close" }));

        BtnView.setText("View");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCompanyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMaintenanceList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnView))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAssignScheduler)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResponse))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CBSchedular, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditStatus)
                    .addComponent(CBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompanyName)
                    .addComponent(btnLogOut))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaintenanceList)
                            .addComponent(BtnView))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditStatus)
                    .addComponent(btnAssignScheduler)
                    .addComponent(btnResponse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBSchedular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        this.dispose();
        new managerMainMenu().setVisible(true);
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        this.dispose();
        new managerSales().setVisible(true);
    }//GEN-LAST:event_btnSalesActionPerformed

    private void btnMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaintenanceActionPerformed
        this.dispose();
        new managerMaintenance().setVisible(true);
    }//GEN-LAST:event_btnMaintenanceActionPerformed

    private void btnAssignSchedulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignSchedulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAssignSchedulerActionPerformed

    private void btnResponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResponseActionPerformed

    private void btnEditStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditStatusActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login.LoginPage().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(managerSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managerSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managerSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managerSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managerMaintenance().setVisible(true);
            }
        });
        
        
    }
    
    


    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnView;
    private javax.swing.JComboBox<String> CBSchedular;
    private javax.swing.JComboBox<String> CBStatus;
    private javax.swing.JTable TbMaintenance;
    private javax.swing.JButton btnAssignScheduler;
    private javax.swing.JButton btnEditStatus;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnMaintenance;
    private javax.swing.JButton btnResponse;
    private javax.swing.JButton btnSales;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCompanyName;
    private javax.swing.JLabel lblMaintenanceList;
    // End of variables declaration//GEN-END:variables
}
