/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Sach;

import Controllers.ClassColorTable;
import Controllers.ControllerSach;
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
public class PanelSach extends javax.swing.JPanel {

    ControllerSach cs;

    /**
     * Creates new form PanelTheLoai
     */
    public PanelSach() {
        initComponents();
        TableSach.setDefaultRenderer(Object.class, new ClassColorTable());
        cs = new ControllerSach();
        vecombox();
    }

    public void vecombox() {
        cs.VeJComboxNXB(NXBSach);
        cs.VeJComboxNgonNgu(NgonNguSach);
        cs.VeJComboxTacGia(TacGiaSach);
        cs.VeJComboxTheLoai(TheLoaiSach);
    }

    public void LoaddataSach() {
        long trangsach = Long.parseLong(TrangSach.getText());
        cs.VeTableSach(TableSach, trangsach, LuaChonSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangThaiSach);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpSach = new javax.swing.JPopupMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        LuaChonSach = new javax.swing.JComboBox<>();
        FindSach = new javax.swing.JTextField();
        NhanTimKiemTG5 = new javax.swing.JLabel();
        TacGiaSach = new javax.swing.JComboBox<>();
        NhanTimKiemTG6 = new javax.swing.JLabel();
        NgonNguSach = new javax.swing.JComboBox<>();
        NhanTimKiemTG4 = new javax.swing.JLabel();
        TrangThaiSach = new javax.swing.JComboBox<>();
        NhanTimKiemTG7 = new javax.swing.JLabel();
        NXBSach = new javax.swing.JComboBox<>();
        NhanTimKiemTG8 = new javax.swing.JLabel();
        TheLoaiSach = new javax.swing.JComboBox<>();
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
        jLabel1 = new javax.swing.JLabel();
        TrangSach = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        wall = new javax.swing.JLabel();

        PopUpSach.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = TableSach.rowAtPoint(SwingUtilities.convertPoint(PopUpSach, new Point(0, 0), TableSach));
                        if (rowAtPoint > -1) {
                            TableSach.setRowSelectionInterval(rowAtPoint, rowAtPoint);
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
        PopUpSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem13.setText("Thêm mới");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        PopUpSach.add(jMenuItem13);
        PopUpSach.add(jSeparator9);

        jMenuItem14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem14.setText("Sửa");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        PopUpSach.add(jMenuItem14);
        PopUpSach.add(jSeparator10);

        jMenuItem15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jMenuItem15.setText("Xóa");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        PopUpSach.add(jMenuItem15);
        PopUpSach.add(jSeparator13);

        jMenuItem19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem19.setText("Chi Tiết");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        PopUpSach.add(jMenuItem19);
        PopUpSach.add(jSeparator14);

        jMenuItem20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/TangCuoc.png"))); // NOI18N
        jMenuItem20.setText("Nhập Thêm");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        PopUpSach.add(jMenuItem20);

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LuaChonSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LuaChonSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Sách", "Theo Tên Sách" }));
        LuaChonSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LuaChonSachItemStateChanged(evt);
            }
        });
        add(LuaChonSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 38, 170, 30));

        FindSach.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        FindSach.setMargin(new java.awt.Insets(2, 5, 2, 2));
        FindSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FindSachKeyReleased(evt);
            }
        });
        add(FindSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 38, 498, 30));

        NhanTimKiemTG5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG5.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG5.setText("Tác giả:");
        add(NhanTimKiemTG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 60, 30));

        TacGiaSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TacGiaSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TacGiaSachItemStateChanged(evt);
            }
        });
        add(TacGiaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 78, 185, 30));

        NhanTimKiemTG6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG6.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG6.setText("Ngôn Ngữ:");
        add(NhanTimKiemTG6, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 78, 80, 30));

        NgonNguSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NgonNguSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NgonNguSachItemStateChanged(evt);
            }
        });
        add(NgonNguSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 78, 143, 30));

        NhanTimKiemTG4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG4.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG4.setText("Trạng thái:");
        add(NhanTimKiemTG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 78, 80, 30));

        TrangThaiSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TrangThaiSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Còn Sách", "Hết Sách" }));
        TrangThaiSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TrangThaiSachItemStateChanged(evt);
            }
        });
        add(TrangThaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 78, 100, 30));

        NhanTimKiemTG7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG7.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG7.setText("NXB:");
        add(NhanTimKiemTG7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 118, 60, 30));

        NXBSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NXBSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NXBSachItemStateChanged(evt);
            }
        });
        add(NXBSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 118, 185, 30));

        NhanTimKiemTG8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG8.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG8.setText("Danh Mục:");
        add(NhanTimKiemTG8, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 118, 80, 30));

        TheLoaiSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TheLoaiSach.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TheLoaiSachItemStateChanged(evt);
            }
        });
        add(TheLoaiSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 118, 180, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 155));

        TableSach.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableSach.setComponentPopupMenu(PopUpSach);
        TableSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableSach.setRowHeight(30);
        TableSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableSach.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane4.setViewportView(TableSach);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 680, 232));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 441, 50, 30));

        TrangSach.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrangSach.setForeground(new java.awt.Color(255, 255, 255));
        TrangSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangSach.setText("1");
        TrangSach.setPreferredSize(new java.awt.Dimension(20, 30));
        add(TrangSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 441, 20, -1));

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
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 167, 696, 323));

        jButton29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jButton29.setText("Thêm mới");
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.setFocusable(false);
        jButton29.setMaximumSize(new java.awt.Dimension(125, 30));
        jButton29.setMinimumSize(new java.awt.Dimension(125, 30));
        jButton29.setPreferredSize(new java.awt.Dimension(125, 30));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 500, -1, -1));

        jButton30.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xem.png"))); // NOI18N
        jButton30.setText("Chi tiết");
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.setFocusable(false);
        jButton30.setMaximumSize(new java.awt.Dimension(105, 30));
        jButton30.setMinimumSize(new java.awt.Dimension(105, 30));
        jButton30.setPreferredSize(new java.awt.Dimension(105, 30));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, -1, -1));

        jButton31.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/sua.png"))); // NOI18N
        jButton31.setText("Sửa");
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.setFocusable(false);
        jButton31.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton31.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton31.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 500, -1, -1));

        jButton38.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jButton38.setText("Xóa");
        jButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton38.setFocusable(false);
        jButton38.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton38.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton38.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 500, -1, -1));

        jButton1.setText("Nhập Thêm");
        jButton1.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 500, 100, 30));
        add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 545));
    }// </editor-fold>//GEN-END:initComponents

    private void LuaChonSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LuaChonSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        FindSach.setText("");
        LoaddataSach();
    }//GEN-LAST:event_LuaChonSachItemStateChanged

    private void FindSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FindSachKeyReleased
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_FindSachKeyReleased

    private void TacGiaSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TacGiaSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_TacGiaSachItemStateChanged

    private void NgonNguSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NgonNguSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_NgonNguSachItemStateChanged

    private void TrangThaiSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TrangThaiSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_TrangThaiSachItemStateChanged

    private void NXBSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NXBSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_NXBSachItemStateChanged

    private void TheLoaiSachItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TheLoaiSachItemStateChanged
        // TODO add your handling code here:
        TrangSach.setText("1");
        LoaddataSach();
    }//GEN-LAST:event_TheLoaiSachItemStateChanged

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        cs.FirstButton(TableSach, LuaChonSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangThaiSach, TrangSach);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        // TODO add your handling code here:
        cs.PreButton(TableSach, LuaChonSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangThaiSach, TrangSach);
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        // TODO add your handling code here:
        cs.NextButton(TableSach, LuaChonSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangThaiSach, TrangSach);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        // TODO add your handling code here:
        cs.LastButton(TableSach, LuaChonSach, FindSach, TacGiaSach, NgonNguSach, NXBSach, TheLoaiSach, TrangThaiSach, TrangSach);
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        PanelNewSach pns = new PanelNewSach(Run.pma, true);
        pns.setVisible(true);
        LoaddataSach();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        cs.EditSachAdminList(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        cs.EditSachAdmin(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        cs.DelSach(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cs.NhapThemSachAdmin(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        PanelNewSach pns = new PanelNewSach(Run.pma, true);
        pns.setVisible(true);
        LoaddataSach();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        cs.EditSachAdmin(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        cs.DelSach(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        cs.EditSachAdminList(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        cs.NhapThemSachAdmin(TableSach);
        LoaddataSach();
    }//GEN-LAST:event_jMenuItem20ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FindSach;
    private javax.swing.JComboBox<String> LuaChonSach;
    public static javax.swing.JComboBox<String> NXBSach;
    public static javax.swing.JComboBox<String> NgonNguSach;
    private javax.swing.JLabel NhanTimKiemTG4;
    private javax.swing.JLabel NhanTimKiemTG5;
    private javax.swing.JLabel NhanTimKiemTG6;
    private javax.swing.JLabel NhanTimKiemTG7;
    private javax.swing.JLabel NhanTimKiemTG8;
    private javax.swing.JPopupMenu PopUpSach;
    private org.jdesktop.swingx.JXTable TableSach;
    public static javax.swing.JComboBox<String> TacGiaSach;
    public static javax.swing.JComboBox<String> TheLoaiSach;
    private javax.swing.JLabel TrangSach;
    public static javax.swing.JComboBox<String> TrangThaiSach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton38;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    public static javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}