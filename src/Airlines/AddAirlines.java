/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airlines;

import Admin.AdminInformation;
import Admin.AdminPannel;
import DatabaseHandaler.DatabaseHandler;
import MyDate.MyDate;
import Feeds.Feed;
import User.HomePage;
import User.UserLogin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AddAirlines extends javax.swing.JFrame {

    private DatabaseHandler databaseHandaler = new DatabaseHandler();
    private Connection connection;
    private AdminInformation adminInformation;

    /**
     * Creates new form AddAirlines
     */
    public AddAirlines() {

    }

    public AddAirlines(AdminInformation adminInformation) {
        initComponents();
        this.adminInformation = adminInformation;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        airlinesjtextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        licenseNojtextfield = new javax.swing.JTextField();
        countryNamejtextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registerbutton = new javax.swing.JButton();
        backtoadminpannel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Airlines Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("License NO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Country Name");

        registerbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerbutton.setText("Register");
        registerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbuttonActionPerformed(evt);
            }
        });

        backtoadminpannel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        backtoadminpannel.setText("Back To Admin Pannel");
        backtoadminpannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtoadminpannelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airlinesjtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(licenseNojtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryNamejtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(backtoadminpannel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(airlinesjtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(licenseNojtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(countryNamejtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backtoadminpannel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbuttonActionPerformed
        // TODO add your handling code here:
      /* DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       Calendar calendar = Calendar.getInstance();*/

        String airlinesname = airlinesjtextfield.getText().trim().toString();
        String licenseNo = licenseNojtextfield.getText().trim().toString();
        String countryName = countryNamejtextfield.getText().trim().toString();
        int adminid = adminInformation.getAdminId();
       
         //checking if any field is empty or not
        if (!airlinesname.equals("") && !licenseNo.equals("") && !countryName.equals("")) {
            connection = databaseHandaler.connectDatabase();
            AirlinesInformation airlinesInformation = new AirlinesInformation(airlinesname, adminid, countryName, licenseNo);
            ResultSet resultSet = databaseHandaler.getAirlines(airlinesInformation, connection);
            ArrayList<AirlinesInformation> airlinesInformationList = databaseHandaler.getAirlinesInformation(resultSet);

            if (airlinesInformationList.size() > 0) {
                JOptionPane.showMessageDialog(null, "This Airlines is ALready Registered");
            } else {
                int res = databaseHandaler.insertAirlines(airlinesInformation, connection);
                if (res > 0) {
                    //dateFormat.format(calendar.getTime())
                    
                    Feed feed = new Feed(adminInformation.getAdminId(), "Registration of "+airlinesname,MyDate.getCurrentdate());
                    databaseHandaler.insertFeed(feed, connection);
                    JOptionPane.showMessageDialog(null, "Registration Completed ");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration Not Completed!!!!");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Fill Up all the fields ");
        }


    }//GEN-LAST:event_registerbuttonActionPerformed

    private void backtoadminpannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtoadminpannelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AdminPannel adminPannel = new AdminPannel(adminInformation);
        adminPannel.show();

    }//GEN-LAST:event_backtoadminpannelActionPerformed

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
            java.util.logging.Logger.getLogger(AddAirlines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAirlines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAirlines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAirlines.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAirlines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airlinesjtextfield;
    private javax.swing.JButton backtoadminpannel;
    private javax.swing.JTextField countryNamejtextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField licenseNojtextfield;
    private javax.swing.JButton registerbutton;
    // End of variables declaration//GEN-END:variables
}
