/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.authentification;

import entities.User;
import javax.swing.JOptionPane;
import service.UserService;

/**
 *
 * @author HP
 */
public class CodeVérific extends javax.swing.JFrame {
    private UserService us;
    private static int code, count;
    private static User user;
    
    /**
     * Creates new form CodeVérific
     */
    public CodeVérific(int code, User user) {
        initComponents();
        this.code = code;
        this.user = user;
        us = new UserService();
        this.setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        envoyerBtn = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        codeTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        envoyerBtn.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        envoyerBtn.setForeground(new java.awt.Color(51, 102, 255));
        envoyerBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        envoyerBtn.setText("ENVOYER");
        envoyerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        envoyerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                envoyerBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(envoyerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(envoyerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 150, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 10));

        codeTxt.setBackground(new java.awt.Color(32, 33, 35));
        codeTxt.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        codeTxt.setForeground(new java.awt.Color(153, 153, 153));
        codeTxt.setBorder(null);
        jPanel1.add(codeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 250, 30));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Code :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/images/close.png"))); // NOI18N
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void envoyerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_envoyerBtnMouseClicked
        int codeT = Integer.parseInt(codeTxt.getText());
        if(codeT != code){
            JOptionPane.showMessageDialog(this, "Code de vérifiaction incorrect.");
            ++count;
            if(count == 3){
                count = 0;
                this.setVisible(false);
                (new RecupMdp()).setVisible(true);
            }
        }  
        else{
            this.setVisible(false);
            (new ChangePassword(user)).setVisible(true);
        }
    }//GEN-LAST:event_envoyerBtnMouseClicked

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
            java.util.logging.Logger.getLogger(CodeVérific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeVérific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeVérific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeVérific.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeVérific(code, user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeTxt;
    private javax.swing.JLabel envoyerBtn;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
