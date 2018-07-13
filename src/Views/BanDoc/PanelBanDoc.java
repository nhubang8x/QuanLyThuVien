/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.BanDoc;

import Controllers.ClassColorTable;
import Controllers.ControllerBanDoc;
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
public class PanelBanDoc extends javax.swing.JPanel {

    ControllerBanDoc cbd = new ControllerBanDoc();

    /**
     * Creates new form PanelTheLoai
     *
     */
    public PanelBanDoc() {
        initComponents();
        TableBanDoc.setDefaultRenderer(Object.class, new ClassColorTable());
    }

    //Hàm loading CSDL ra table Bạn Đọc
    public void LoadingTableBanDoc() {
        long trangbd = Long.parseLong(TrangBD.getText());
        cbd.VeTableBD(TableBanDoc, trangbd, luachonBD, findBD, TrangThaiBD);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpBanDoc = new javax.swing.JPopupMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        luachonBD = new javax.swing.JComboBox<>();
        findBD = new javax.swing.JTextField();
        NhanTimKiemTG4 = new javax.swing.JLabel();
        TrangThaiBD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableBanDoc = new org.jdesktop.swingx.JXTable(){
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
        TrangBD = new javax.swing.JLabel();
        firstbutton = new javax.swing.JLabel();
        prebutoon = new javax.swing.JLabel();
        nextbutton = new javax.swing.JLabel();
        lastbutton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        wall = new javax.swing.JLabel();

        PopUpBanDoc.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = TableBanDoc.rowAtPoint(SwingUtilities.convertPoint(PopUpBanDoc, new Point(0, 0), TableBanDoc));
                        if (rowAtPoint > -1) {
                            TableBanDoc.setRowSelectionInterval(rowAtPoint, rowAtPoint);
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
        PopUpBanDoc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem13.setText("Thêm mới");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem13);
        PopUpBanDoc.add(jSeparator9);

        jMenuItem14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem14.setText("Sửa");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem14);
        PopUpBanDoc.add(jSeparator10);

        jMenuItem15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/xoa.png"))); // NOI18N
        jMenuItem15.setText("Xóa");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem15);
        PopUpBanDoc.add(jSeparator13);

        jMenuItem19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/add.png"))); // NOI18N
        jMenuItem19.setText("Chi Tiết");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem19);
        PopUpBanDoc.add(jSeparator14);

        jMenuItem20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/TangCuoc.png"))); // NOI18N
        jMenuItem20.setText("Tăng Cược");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem20);
        PopUpBanDoc.add(jSeparator15);

        jMenuItem21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/time.png"))); // NOI18N
        jMenuItem21.setText("Gia Hạn");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        PopUpBanDoc.add(jMenuItem21);
        PopUpBanDoc.add(jSeparator1);

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/lamlai.png"))); // NOI18N
        jMenuItem1.setText("Reset MK");
        PopUpBanDoc.add(jMenuItem1);

        setMinimumSize(new java.awt.Dimension(700, 545));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        luachonBD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        luachonBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Mã Bạn Đọc", "Theo Tên Bạn Đọc" }));
        luachonBD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                luachonBDItemStateChanged(evt);
            }
        });
        add(luachonBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 38, 170, 30));

        findBD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        findBD.setMargin(new java.awt.Insets(2, 5, 2, 2));
        findBD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findBDKeyReleased(evt);
            }
        });
        add(findBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 38, 337, 30));

        NhanTimKiemTG4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NhanTimKiemTG4.setForeground(new java.awt.Color(255, 255, 255));
        NhanTimKiemTG4.setText("Trạng thái:");
        add(NhanTimKiemTG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 78, 100, 30));

        TrangThaiBD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TrangThaiBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Còn hạn", "Hết hạn" }));
        TrangThaiBD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TrangThaiBDItemStateChanged(evt);
            }
        });
        TrangThaiBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrangThaiBDActionPerformed(evt);
            }
        });
        add(TrangThaiBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 78, 150, 30));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 10, 696, 115));

        TableBanDoc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TableBanDoc.setComponentPopupMenu(PopUpBanDoc);
        TableBanDoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TableBanDoc.setRowHeight(30);
        TableBanDoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableBanDoc.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane4.setViewportView(TableBanDoc);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 680, 272));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Trang");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 441, 50, 30));

        TrangBD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        TrangBD.setForeground(new java.awt.Color(255, 255, 255));
        TrangBD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangBD.setText("1");
        TrangBD.setPreferredSize(new java.awt.Dimension(20, 30));
        add(TrangBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 441, 20, -1));

        firstbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/first.png"))); // NOI18N
        firstbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        firstbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstbuttonMouseClicked(evt);
            }
        });
        add(firstbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 441, -1, -1));

        prebutoon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prebutoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/back.png"))); // NOI18N
        prebutoon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prebutoon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prebutoonMouseClicked(evt);
            }
        });
        add(prebutoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 441, -1, -1));

        nextbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nextbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/next.png"))); // NOI18N
        nextbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextbuttonMouseClicked(evt);
            }
        });
        add(nextbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 441, -1, -1));

        lastbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/last.png"))); // NOI18N
        lastbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lastbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastbuttonMouseClicked(evt);
            }
        });
        add(lastbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 441, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Danh Sách Bạn Đọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 127, 696, 363));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/TangCuoc.png"))); // NOI18N
        jButton9.setText("Tăng Cược");
        jButton9.setMaximumSize(new java.awt.Dimension(120, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(120, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 502, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/time.png"))); // NOI18N
        jButton8.setText("Gia Hạn");
        jButton8.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 502, -1, -1));

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
        add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 502, -1, -1));

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
        add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 502, -1, -1));

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
        add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 502, -1, -1));

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
        add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 502, -1, -1));
        add(wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 545));
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        PanelNewBanDoc pnbd = new PanelNewBanDoc(Run.pma, true);
        pnbd.setVisible(true);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        cbd.EditBanDoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        cbd.DelBanDoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        cbd.DetailBanDoc(TableBanDoc);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        cbd.TangCuoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
        cbd.GiaHan(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        cbd.DelBanDoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        cbd.EditBanDoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        cbd.DetailBanDoc(TableBanDoc);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        PanelNewBanDoc pnbd = new PanelNewBanDoc(Run.pma, true);
        pnbd.setVisible(true);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        cbd.GiaHan(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        cbd.TangCuoc(TableBanDoc);
        LoadingTableBanDoc();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void lastbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastbuttonMouseClicked
        // TODO add your handling code here:
        cbd.LastButton(TableBanDoc, luachonBD, findBD, TrangThaiBD, TrangBD);
    }//GEN-LAST:event_lastbuttonMouseClicked

    private void nextbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbuttonMouseClicked
        // TODO add your handling code here:
        cbd.NextButton(TableBanDoc, luachonBD, findBD, TrangThaiBD, TrangBD);
    }//GEN-LAST:event_nextbuttonMouseClicked

    private void prebutoonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prebutoonMouseClicked
        // TODO add your handling code here:
        cbd.PreButton(TableBanDoc, luachonBD, findBD, TrangThaiBD, TrangBD);
    }//GEN-LAST:event_prebutoonMouseClicked

    private void firstbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstbuttonMouseClicked
        // TODO add your handling code here:
        cbd.FirstButton(TableBanDoc, luachonBD, findBD, TrangThaiBD, TrangBD);
    }//GEN-LAST:event_firstbuttonMouseClicked

    private void TrangThaiBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrangThaiBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TrangThaiBDActionPerformed

    private void TrangThaiBDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TrangThaiBDItemStateChanged
        // TODO add your handling code here:
        TrangBD.setText("1");
        LoadingTableBanDoc();
    }//GEN-LAST:event_TrangThaiBDItemStateChanged

    private void findBDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findBDKeyReleased
        // TODO add your handling code here:
        TrangBD.setText("1");
        LoadingTableBanDoc();
    }//GEN-LAST:event_findBDKeyReleased

    private void luachonBDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_luachonBDItemStateChanged
        // TODO add your handling code here:
        findBD.setText("");
        TrangBD.setText("1");
        LoadingTableBanDoc();
    }//GEN-LAST:event_luachonBDItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NhanTimKiemTG4;
    private javax.swing.JPopupMenu PopUpBanDoc;
    private org.jdesktop.swingx.JXTable TableBanDoc;
    private javax.swing.JLabel TrangBD;
    private javax.swing.JComboBox<String> TrangThaiBD;
    private javax.swing.JTextField findBD;
    private javax.swing.JLabel firstbutton;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lastbutton;
    private javax.swing.JComboBox<String> luachonBD;
    private javax.swing.JLabel nextbutton;
    private javax.swing.JLabel prebutoon;
    private javax.swing.JLabel wall;
    // End of variables declaration//GEN-END:variables
}
