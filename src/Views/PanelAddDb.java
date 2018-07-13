/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.SetWallpaper;
import Controllers.addData;
import Models.Database;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huy Thắng
 */
public class PanelAddDb extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    /**
     * Creates new form NewJFrame
     */
    public PanelAddDb() {
        initComponents();
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper400x360(walsetdb);
        try {
            InetAddress addr = InetAddress.getLocalHost();
            svname.setText(addr.getHostName());
            port.setText("1433");
            database.setText("QuanLyThuVien");
        } catch (UnknownHostException ex) {
            Logger.getLogger(PanelAddDb.class.getName()).log(Level.SEVERE, null, ex);
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

        close = new javax.swing.JLabel();
        mini = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        svname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        database = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/close-blue.png"))); // NOI18N
        close.setToolTipText("Thoát");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 5, 22, 22));

        mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/mini-blue.png"))); // NOI18N
        mini.setToolTipText("Thu nhỏ");
        mini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniMouseClicked(evt);
            }
        });
        getContentPane().add(mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 22, 22));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Libary manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/download-database.png"))); // NOI18N
        jLabel6.setText("SETUP DATABASE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 40));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Host");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, 30));

        svname.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        svname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(svname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 230, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Port:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 135, 110, 30));

        port.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        port.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(port, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 135, 230, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Database:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));

        database.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        database.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(database, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 230, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, 110, 30));

        user.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 225, 230, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, 30));

        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 230, 30));

        login.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/connection.png"))); // NOI18N
        login.setText("Kết nối");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 305, 140, 40));

        reset.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/Resert.png"))); // NOI18N
        reset.setText("Làm Lại");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 305, 140, 40));

        walsetdb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-3.png"))); // NOI18N
        getContentPane().add(walsetdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 360));

        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniMouseClicked
        // TODO add your handling code here:
        this.setState(PanelLogin.ICONIFIED);
    }//GEN-LAST:event_miniMouseClicked

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jLabel4MouseDragged

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel4MousePressed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        Database db = new Database();
        db.setHost(svname.getText());
        db.setPort(port.getText());
        db.setDbName(database.getText());
        db.setUser(user.getText());
        db.setPassword(new String(password.getPassword()));
        addData ad = new addData();
        ad.adData(db, this);
    }//GEN-LAST:event_loginActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        try {
            InetAddress addr = InetAddress.getLocalHost();
            svname.setText(addr.getHostName());
            port.setText("1433");
            database.setText("QuanLyThuVien");
            user.setText("");
            password.setText("");
        } catch (UnknownHostException ex) {
            Logger.getLogger(PanelAddDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JTextField database;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton login;
    private javax.swing.JLabel mini;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField port;
    private javax.swing.JButton reset;
    private javax.swing.JTextField svname;
    private javax.swing.JTextField user;
    private javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}