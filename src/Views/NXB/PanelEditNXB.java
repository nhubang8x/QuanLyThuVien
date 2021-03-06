/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.NXB;

import Controllers.ControllerNXB;
import Controllers.SetWallpaper;
import Models.NhaXB;

/**
 *
 * @author Huy Thắng
 */
public class PanelEditNXB extends javax.swing.JDialog {

    int xMouse;
    int yMouse;
    private NhaXB nxb;
    ControllerNXB cln;

    /**
     * Creates new form PanelEditNXB
     */
    public PanelEditNXB(java.awt.Frame parent, boolean modal, NhaXB nxb) {
        super(parent, modal);
        initComponents();
        this.nxb = nxb;
        cln = new ControllerNXB();
        cln.SetEditNXB(Ma, TenNXb, TelNXB, DiaChi, nxb);
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper400x360(walsetdb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Ma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TenNXb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TelNXB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DiaChi = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Libary manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CẬP NHẬT NHÀ XUẤT BẢN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã NXB:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 110, 30));

        Ma.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Ma.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 85, 240, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên NXB:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        TenNXb.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TenNXb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenNXbActionPerformed(evt);
            }
        });
        getContentPane().add(TenNXb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Điện thoại NXB:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, 110, 30));

        TelNXB.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TelNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelNXBActionPerformed(evt);
            }
        });
        getContentPane().add(TelNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 175, 240, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Địa chỉ NXB:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 30));

        DiaChi.setColumns(20);
        DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        DiaChi.setLineWrap(true);
        DiaChi.setRows(3);
        jScrollPane1.setViewportView(DiaChi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 240, 70));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/edit.png"))); // NOI18N
        jButton1.setText("Sửa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 305, 100, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/lamlai.png"))); // NOI18N
        jButton2.setText("Làm lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 305, 110, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat_1.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 305, 100, -1));

        walsetdb.setBackground(new java.awt.Color(0, 0, 0));
        walsetdb.setOpaque(true);
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

    private void TenNXbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenNXbActionPerformed
        // TODO add your handling code here:
        TelNXB.requestFocus();
    }//GEN-LAST:event_TenNXbActionPerformed

    private void TelNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelNXBActionPerformed
        // TODO add your handling code here:
        DiaChi.requestFocus();
    }//GEN-LAST:event_TelNXBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ControllerNXB clt = new ControllerNXB();
        clt.UpdateNXBAdmin(TenNXb, TelNXB, nxb.getMaNXB(), DiaChi, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ControllerNXB cln = new ControllerNXB();
        cln.SetEditNXB(Ma, TenNXb, TelNXB, DiaChi, nxb);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea DiaChi;
    private javax.swing.JLabel Ma;
    private javax.swing.JTextField TelNXB;
    private javax.swing.JTextField TenNXb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}
