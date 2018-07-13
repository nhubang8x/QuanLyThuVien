/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.NhanVien;

import Controllers.ClassColorTable;
import Controllers.ControllerNhanVien;
import Views.Run;
import java.awt.Component;
import java.awt.Point;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Huy Thắng
 */
public class PanelNhanVien extends javax.swing.JPanel {

    ControllerNhanVien cnv;

    /**
     * Creates new form PanelTheLoai
     */
    public PanelNhanVien() {
        initComponents();
        TableNhanVien.setDefaultRenderer(Object.class, new ClassColorTable());
        cnv = new ControllerNhanVien();
    }

    public void LoaddataNhanVien() {
        long trangnv = Long.parseLong(TrangNV.getText());
        cnv.VeTableNV(TableNhanVien, trangnv, luachonnv, findNV, TrangThaiNV);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpNhanVien = new javax.swing.JPopupMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        luachonnv = new javax.swing.JComboBox<>();
        findNV = new javax.swing.JTextField();
        NhanTimKiemTG4 = new javax.swing.JLabel();
        TrangThaiNV = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableNhanVien = new org.jdesktop.swingx.JXTable(){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        TrangNV = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        wall = new javax.swing.JLabel();

        PopUpNhanVien.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = TableNhanVien.rowAtPoint(SwingUtilities.convertPoint(PopUpNhanVien, new Point(0, 0), TableNhanVien));
                        if (rowAtPoint > -1) {
                            TableNhanVien.setRowSelectionInterval(rowAtPoint, rowAtPoint);
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
        PopUpNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenuItem16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem16.setText("Thêm mới");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        PopUpNhanVien.add(jMenuItem16);
        PopUpNhanVien.add(jSeparator11);

        jMenuItem17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem17.setText("Sửa");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        PopUpNhanVien.add(jMenuItem17);
        PopUpNhanVien.add(jSeparator12);

        jMenuItem18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jMenuItem18.setText("Xóa");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        PopUpNhanVien.add(jMenuItem18);

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        luachonnv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        luachonnv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Nhân Viên", "Theo Tên Nhân Viên" }));
        luachonnv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                luachonnvItemStateChanged(evt);
            }
        });
        add(luachonnv, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 38, 170, 30));

        findNV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        findNV.setMargin(new java.awt.Insets(2, 5, 2, 2));
        findNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findNVKeyReleased(evt);
            }
        });
        add(findNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 38, 337, 30));

        NhanTimKiemTG4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG4.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG4.setText("Trạng thái:");
        add(NhanTimKiemTG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 100, 30));

        TrangThaiNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TrangThaiNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang Làm", "Đã Nghỉ" }));
        TrangThaiNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TrangThaiNVItemStateChanged(evt);
            }
        });
        add(TrangThaiNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 78, 150, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 115));

        TableNhanVien.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableNhanVien.setComponentPopupMenu(PopUpNhanVien);
        TableNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableNhanVien.setRowHeight(30);
        TableNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableNhanVien.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane4.setViewportView(TableNhanVien);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 680, 272));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 441, 50, 30));

        TrangNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrangNV.setForeground(new java.awt.Color(255, 255, 255));
        TrangNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangNV.setText("1");
        TrangNV.setPreferredSize(new java.awt.Dimension(20, 30));
        add(TrangNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 441, 20, -1));

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
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 127, 696, 363));

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

    private void luachonnvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_luachonnvItemStateChanged
        // TODO add your handling code here:
        findNV.setText("");
        TrangNV.setText("1");
        LoaddataNhanVien();
    }//GEN-LAST:event_luachonnvItemStateChanged

    private void findNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findNVKeyReleased
        // TODO add your handling code here:
        TrangNV.setText("1");
        LoaddataNhanVien();
    }//GEN-LAST:event_findNVKeyReleased

    private void TrangThaiNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TrangThaiNVItemStateChanged
        // TODO add your handling code here:
        TrangNV.setText("1");
        LoaddataNhanVien();
    }//GEN-LAST:event_TrangThaiNVItemStateChanged

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        cnv.FirstButton(TableNhanVien, findNV, luachonnv, TrangThaiNV, TrangNV);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        cnv.PreButton(TableNhanVien, findNV, luachonnv, TrangThaiNV, TrangNV);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        // TODO add your handling code here:
        cnv.NextButton(TableNhanVien, findNV, luachonnv, TrangThaiNV, TrangNV);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        cnv.LastButton(TableNhanVien, findNV, luachonnv, TrangThaiNV, TrangNV);
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        PanelNewNhanVien pnnv = new PanelNewNhanVien(Run.pma, true);
        pnnv.setVisible(true);
        LoaddataNhanVien();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        cnv.EditNVAdmin(TableNhanVien);
        LoaddataNhanVien();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        cnv.DelNV(TableNhanVien);
        LoaddataNhanVien();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        PanelNewNhanVien pnnv = new PanelNewNhanVien(Run.pma, true);
        pnnv.setVisible(true);
        LoaddataNhanVien();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        cnv.EditNVAdmin(TableNhanVien);
        LoaddataNhanVien();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        cnv.DelNV(TableNhanVien);
        LoaddataNhanVien();
    }//GEN-LAST:event_jMenuItem18ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NhanTimKiemTG4;
    private javax.swing.JPopupMenu PopUpNhanVien;
    private org.jdesktop.swingx.JXTable TableNhanVien;
    private javax.swing.JLabel TrangNV;
    private javax.swing.JComboBox<String> TrangThaiNV;
    private javax.swing.JTextField findNV;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JComboBox<String> luachonnv;
    public static javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}