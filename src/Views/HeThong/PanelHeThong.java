/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.HeThong;

import Controllers.ControllerHeThong;
import Controllers.SetWallpaper;
import Controllers.Settings;
import Views.PanelMainAdmin;

/**
 *
 * @author Huy Thắng
 */
public class PanelHeThong extends javax.swing.JPanel {

    SetWallpaper sw;
    ControllerHeThong clht;

    /**
     * Creates new form PanelHeThong
     */
    public PanelHeThong() {
        initComponents();
        sw = new SetWallpaper();
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jRadioButton3.setSelected(true);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jRadioButton4.setSelected(true);
        }
        clht = new ControllerHeThong();
//        Settings.ReadLePhiInt();
//        Settings.ReadTienCuocGocInt();
//         Settings.ReadTienPhatQuanHanInt();
        setText();
    }

    public static void setText() {
        LePhi.setText(""+Settings.ReadLePhiInt());
        cuoccu.setText(""+Settings.ReadTienCuocGocInt());
        phatquahan.setText("" + Settings.ReadTienPhatQuanHanInt());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cuoccu = new javax.swing.JLabel();
        cuoccu1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cuoccu2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LePhi = new javax.swing.JLabel();
        cuoccu3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        cuoccu4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phatquahan = new javax.swing.JLabel();
        cuoccu5 = new javax.swing.JLabel();
        cuoccu6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        wall = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton3.setBackground(new java.awt.Color(52, 52, 52));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Giao diện Đen");
        jRadioButton3.setFocusPainted(false);
        jRadioButton3.setMaximumSize(new java.awt.Dimension(160, 30));
        jRadioButton3.setMinimumSize(new java.awt.Dimension(160, 30));
        jRadioButton3.setOpaque(false);
        jRadioButton3.setPreferredSize(new java.awt.Dimension(160, 30));
        jRadioButton3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton3ItemStateChanged(evt);
            }
        });
        add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 38, 160, 30));

        jRadioButton4.setBackground(new java.awt.Color(52, 52, 52));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Giao diện Xanh");
        jRadioButton4.setFocusPainted(false);
        jRadioButton4.setMaximumSize(new java.awt.Dimension(160, 30));
        jRadioButton4.setMinimumSize(new java.awt.Dimension(160, 30));
        jRadioButton4.setOpaque(false);
        jRadioButton4.setPreferredSize(new java.awt.Dimension(160, 30));
        jRadioButton4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton4ItemStateChanged(evt);
            }
        });
        add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 38, 160, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Giao diện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 80));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/to-export--database-icon-30861.png"))); // NOI18N
        jButton1.setText("Sao Lưu Dữ Liệu");
        jButton1.setMaximumSize(new java.awt.Dimension(165, 50));
        jButton1.setMinimumSize(new java.awt.Dimension(165, 50));
        jButton1.setPreferredSize(new java.awt.Dimension(165, 50));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 118, 165, 50));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/import-a-database-icon-30862.png"))); // NOI18N
        jButton2.setText("Phục Hồi Dữ Liệu");
        jButton2.setMaximumSize(new java.awt.Dimension(165, 50));
        jButton2.setMinimumSize(new java.awt.Dimension(165, 50));
        jButton2.setPreferredSize(new java.awt.Dimension(165, 50));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 118, 165, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Sao Lưu - Hồi Phục Dữ Liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 92, 696, 100));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tiền Cược Hiện Tại:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 224, 140, 30));

        cuoccu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cuoccu.setForeground(new java.awt.Color(255, 255, 255));
        add(cuoccu, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 224, 245, 30));

        cuoccu1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu1.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu1.setText("VNĐ");
        add(cuoccu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 224, 160, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tiền Cược Mới:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 264, 140, 30));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 264, 250, 30));

        cuoccu2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu2.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu2.setText("VNĐ");
        add(cuoccu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 264, 160, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Lệ Phí Hiện Tại:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 304, 140, 30));

        LePhi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LePhi.setForeground(new java.awt.Color(255, 255, 255));
        add(LePhi, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 304, 245, 30));

        cuoccu3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu3.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu3.setText("VNĐ");
        add(cuoccu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 304, 160, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lệ Phí Mới:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 344, 140, 30));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 344, 250, 30));

        cuoccu4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu4.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu4.setText("VNĐ");
        add(cuoccu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 344, 160, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phạt Quá Hạn Cũ:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 384, 140, 30));

        phatquahan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phatquahan.setForeground(new java.awt.Color(255, 255, 255));
        add(phatquahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 384, 245, 30));

        cuoccu5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu5.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu5.setText("VNĐ");
        add(cuoccu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 384, 160, 30));

        cuoccu6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cuoccu6.setForeground(new java.awt.Color(255, 255, 255));
        cuoccu6.setText("VNĐ");
        add(cuoccu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 424, 160, 30));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 424, 250, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phạt Quá Hạn Mới:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 424, 140, 30));

        jButton3.setText("Lưu Thay Đổi");
        jButton3.setMaximumSize(new java.awt.Dimension(110, 40));
        jButton3.setMinimumSize(new java.awt.Dimension(110, 40));
        jButton3.setPreferredSize(new java.awt.Dimension(110, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 480, 110, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Thay Đổi Tiền Cược - Lệ Phí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 194, 696, 340));
        add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 545));
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton3ItemStateChanged
        // TODO add your handling code here:
        Settings.WriteWallpaper("Wall1");
        sw.SetWallpaper920x635(PanelMainAdmin.wallMainAdmin);
        sw.SetWallpaper700x545(PanelHeThong.wall);
    }//GEN-LAST:event_jRadioButton3ItemStateChanged

    private void jRadioButton4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton4ItemStateChanged
        // TODO add your handling code here:
        Settings.WriteWallpaper("Wall2");
        sw.SetWallpaper920x635(PanelMainAdmin.wallMainAdmin);
        sw.SetWallpaper700x545(PanelHeThong.wall);
    }//GEN-LAST:event_jRadioButton4ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clht.saoluu();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clht.phuchoi();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clht.lephi_cuoc(jTextField1, jTextField2, jTextField3);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel LePhi;
    private javax.swing.ButtonGroup buttonGroup1;
    private static javax.swing.JLabel cuoccu;
    private javax.swing.JLabel cuoccu1;
    private javax.swing.JLabel cuoccu2;
    private javax.swing.JLabel cuoccu3;
    private javax.swing.JLabel cuoccu4;
    private javax.swing.JLabel cuoccu5;
    private javax.swing.JLabel cuoccu6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private static javax.swing.JLabel phatquahan;
    public static javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}