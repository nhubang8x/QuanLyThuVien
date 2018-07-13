/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.NgonNgu;

import Controllers.ClassColorTable;
import Controllers.ControllerNgonNgu;
import Views.Run;
import java.awt.Point;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Huy Thắng
 */
public class PanelNgonNgu extends javax.swing.JPanel {

    ControllerNgonNgu cnn;

    /**
     * Creates new form PanelTheLoai
     */
    public PanelNgonNgu() {
        initComponents();
        TableNgonNgu.setDefaultRenderer(Object.class, new ClassColorTable());
        cnn = new ControllerNgonNgu();
    }

    public void LoaddataNgonNgu() {
        long trangbd = Long.parseLong(TrangNN.getText());
        cnn.VeTableNgonNgu(TableNgonNgu, trangbd, findngonngu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpNgonNgu = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jLabel17 = new javax.swing.JLabel();
        findngonngu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableNgonNgu = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        TrangNN = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        wall = new javax.swing.JLabel();

        PopUpNgonNgu.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = TableNgonNgu.rowAtPoint(SwingUtilities.convertPoint(PopUpNgonNgu, new Point(0, 0), TableNgonNgu));
                        if (rowAtPoint > -1) {
                            TableNgonNgu.setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }
                    }
                });
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // TODO Auto-generated method stub
            }

        });
        PopUpNgonNgu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem7.setText("Thêm mới");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        PopUpNgonNgu.add(jMenuItem7);
        PopUpNgonNgu.add(jSeparator5);

        jMenuItem8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem8.setText("Sửa");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        PopUpNgonNgu.add(jMenuItem8);
        PopUpNgonNgu.add(jSeparator6);

        jMenuItem9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jMenuItem9.setText("Xóa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        PopUpNgonNgu.add(jMenuItem9);

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tên Ngôn Ngữ:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 110, 30));

        findngonngu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        findngonngu.setMargin(new java.awt.Insets(2, 5, 2, 2));
        findngonngu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findngonnguKeyReleased(evt);
            }
        });
        add(findngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 38, 337, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 80));

        TableNgonNgu.setComponentPopupMenu(PopUpNgonNgu);
        TableNgonNgu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableNgonNgu.setRowHeight(30);
        TableNgonNgu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableNgonNgu.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane4.setViewportView(TableNgonNgu);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 680, 307));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 441, 50, 30));

        TrangNN.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrangNN.setForeground(new java.awt.Color(255, 255, 255));
        TrangNN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangNN.setText("1");
        TrangNN.setPreferredSize(new java.awt.Dimension(20, 30));
        add(TrangNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 441, 20, -1));

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/first.png"))); // NOI18N
        jLabel60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 441, -1, -1));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/back.png"))); // NOI18N
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 441, -1, -1));

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/next.png"))); // NOI18N
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 441, -1, -1));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/last.png"))); // NOI18N
        jLabel64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
        });
        add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 441, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Ngôn Ngữ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 92, 696, 398));

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jButton13.setText("Thêm mới");
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setFocusable(false);
        jButton13.setMaximumSize(new java.awt.Dimension(125, 30));
        jButton13.setMinimumSize(new java.awt.Dimension(125, 30));
        jButton13.setPreferredSize(new java.awt.Dimension(125, 30));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 502, -1, -1));

        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/sua.png"))); // NOI18N
        jButton15.setText("Sửa");
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.setFocusable(false);
        jButton15.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton15.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton15.setPreferredSize(new java.awt.Dimension(105, 30));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 502, -1, -1));

        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jButton16.setText("Xóa");
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.setFocusable(false);
        jButton16.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton16.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton16.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 502, -1, -1));
        add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 545));
    }// </editor-fold>//GEN-END:initComponents

    private void findngonnguKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findngonnguKeyReleased
        // TODO add your handling code here:
        TrangNN.setText("1");
        LoaddataNgonNgu();
    }//GEN-LAST:event_findngonnguKeyReleased

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        cnn.FirstButton(TableNgonNgu, findngonngu, TrangNN);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        cnn.PreButton(TableNgonNgu, findngonngu, TrangNN);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        // TODO add your handling code here:
        cnn.NextButton(TableNgonNgu, findngonngu, TrangNN);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        cnn.LastButton(TableNgonNgu, findngonngu, TrangNN);
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        PanelNewNgonNgu pnnn = new PanelNewNgonNgu(Run.pma, true);
        pnnn.setVisible(true);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        cnn.EditNNAdmin(TableNgonNgu);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        cnn.DelNgonNgu(TableNgonNgu);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        PanelNewNgonNgu pnnn = new PanelNewNgonNgu(Run.pma, true);
        pnnn.setVisible(true);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        cnn.EditNNAdmin(TableNgonNgu);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        cnn.DelNgonNgu(TableNgonNgu);
        LoaddataNgonNgu();
    }//GEN-LAST:event_jMenuItem9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopUpNgonNgu;
    private org.jdesktop.swingx.JXTable TableNgonNgu;
    private javax.swing.JLabel TrangNN;
    private javax.swing.JTextField findngonngu;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    public static javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}