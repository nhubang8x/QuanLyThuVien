/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Sach;

import Controllers.ClassColorTable;
import Controllers.ControllerSach;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Huy Thắng
 */
public class PanelSachBanDoc extends javax.swing.JPanel {

    ControllerSach cs;

    /**
     * Creates new form PanelSachBanDoc
     */
    public PanelSachBanDoc() {
        initComponents();
        TableSach.setDefaultRenderer(Object.class, new ClassColorTable());
        cs = new ControllerSach();
        vecombox();
        LoaddataSachBanDoc();
    }

    private void LoaddataSachBanDoc() {
        if (FindSach.getText().trim().isEmpty()) {
            cs.VeTableNone(TableSach);
        } else {
            long trangsach = Long.parseLong(TrangSach.getText());
            cs.VeTableSachBD(TableSach, trangsach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach);
        }
    }

    private void vecombox() {
        cs.VeJComboxNXB(NXBSach);
        cs.VeJComboxNgonNgu(NgonNguSach);
        cs.VeJComboxTacGia(TacGiaSach);
        cs.VeJComboxTheLoai(TheLoaiSach);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FindSach = new javax.swing.JTextField();
        TacGiaSach = new javax.swing.JComboBox<>();
        NgonNguSach = new javax.swing.JComboBox<>();
        NXBSach = new javax.swing.JComboBox<>();
        TheLoaiSach = new javax.swing.JComboBox<>();
        NhanTimKiemTG5 = new javax.swing.JLabel();
        NhanTimKiemTG7 = new javax.swing.JLabel();
        NhanTimKiemTG8 = new javax.swing.JLabel();
        NhanTimKiemTG6 = new javax.swing.JLabel();
        NhanTimKiemTG9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableSach = new org.jdesktop.swingx.JXTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TrangSach = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        wall = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FindSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        FindSach.setMargin(new java.awt.Insets(2, 5, 2, 2));
        FindSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FindSachKeyReleased(evt);
            }
        });
        add(FindSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 38, 588, 30));

        TacGiaSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TacGiaSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TacGiaSachItemStateChanged(evt);
            }
        });
        add(TacGiaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 78, 244, 30));

        NgonNguSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NgonNguSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NgonNguSachItemStateChanged(evt);
            }
        });
        add(NgonNguSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 78, 244, 30));

        NXBSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NXBSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NXBSachItemStateChanged(evt);
            }
        });
        add(NXBSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 118, 244, 30));

        TheLoaiSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TheLoaiSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TheLoaiSachItemStateChanged(evt);
            }
        });
        add(TheLoaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 118, 244, 30));

        NhanTimKiemTG5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG5.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG5.setText("Tác giả:");
        add(NhanTimKiemTG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 80, 30));

        NhanTimKiemTG7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG7.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG7.setText("NXB:");
        add(NhanTimKiemTG7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 118, 80, 30));

        NhanTimKiemTG8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG8.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG8.setText("Danh Mục:");
        add(NhanTimKiemTG8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 118, 80, 30));

        NhanTimKiemTG6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG6.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG6.setText("Ngôn Ngữ:");
        add(NhanTimKiemTG6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 78, 80, 30));

        NhanTimKiemTG9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG9.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG9.setText("Tên Sách: ");
        add(NhanTimKiemTG9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 38, 80, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 155));

        TableSach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableSach.setRowHeight(30);
        TableSach.setShowGrid(true);
        TableSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableSach.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane4.setViewportView(TableSach);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 680, 287));

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/first.png"))); // NOI18N
        jLabel60.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 496, -1, -1));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/back.png"))); // NOI18N
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 496, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 496, 50, 30));

        TrangSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrangSach.setForeground(new java.awt.Color(255, 255, 255));
        TrangSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangSach.setText("1");
        TrangSach.setPreferredSize(new java.awt.Dimension(20, 30));
        add(TrangSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 496, 20, -1));

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/next.png"))); // NOI18N
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 496, -1, -1));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/last.png"))); // NOI18N
        jLabel64.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
        });
        add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 496, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 167, 696, 378));
        add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 545));
    }// </editor-fold>//GEN-END:initComponents

    private void FindSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FindSachKeyReleased
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSachBanDoc();
    }//GEN-LAST:event_FindSachKeyReleased

    private void TacGiaSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TacGiaSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSachBanDoc();
    }//GEN-LAST:event_TacGiaSachItemStateChanged

    private void NgonNguSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NgonNguSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSachBanDoc();
    }//GEN-LAST:event_NgonNguSachItemStateChanged

    private void NXBSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NXBSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSachBanDoc();
    }//GEN-LAST:event_NXBSachItemStateChanged

    private void TheLoaiSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TheLoaiSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSachBanDoc();
    }//GEN-LAST:event_TheLoaiSachItemStateChanged

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        cs.FirstButtonBanDoc(TableSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangSach);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        cs.PreButtonBanDoc(TableSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangSach);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        // TODO add your handling code here:
        cs.NextButtonBanDoc(TableSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangSach);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        cs.LastButtonBanDoc(TableSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangSach);
    }//GEN-LAST:event_jLabel64MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FindSach;
    public static javax.swing.JComboBox<String> NXBSach;
    public static javax.swing.JComboBox<String> NgonNguSach;
    private javax.swing.JLabel NhanTimKiemTG5;
    private javax.swing.JLabel NhanTimKiemTG6;
    private javax.swing.JLabel NhanTimKiemTG7;
    private javax.swing.JLabel NhanTimKiemTG8;
    private javax.swing.JLabel NhanTimKiemTG9;
    private org.jdesktop.swingx.JXTable TableSach;
    public static javax.swing.JComboBox<String> TacGiaSach;
    public static javax.swing.JComboBox<String> TheLoaiSach;
    private javax.swing.JLabel TrangSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}
