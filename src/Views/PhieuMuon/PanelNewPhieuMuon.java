/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.PhieuMuon;

import Controllers.ClassColorTable;
import Controllers.Controller;
import Controllers.ControllerPhieuMuon;
import Controllers.SetWallpaper;
import Models.BanDoc;
import Models.Sach;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy Thắng
 */
public class PanelNewPhieuMuon extends javax.swing.JDialog {

    int xMouse;
    int yMouse;
    ControllerPhieuMuon clpm;
    BanDoc bd;
    Sach sc;
    int tiencuoccan;
    Controller cl;

    /**
     * Creates new form NewJDialog
     */
    public PanelNewPhieuMuon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clpm = new ControllerPhieuMuon();
        cl = new Controller();
        clpm.setNewPM(ngaymuon, hantra);
        SachMuon.setDefaultRenderer(Object.class, new ClassColorTable());
        setTextTC();
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper790x570(walsetdb);
    }

    public void setTextTC() {
        tiencuoccan = clpm.TienCuocCan(SachMuon);
        hantra2.setText("" + tiencuoccan + " VNĐ");
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
        jLabel8 = new javax.swing.JLabel();
        MaBD = new javax.swing.JTextField();
        CheckBD = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        HoTenBD = new javax.swing.JLabel();
        NgayMuon1 = new javax.swing.JLabel();
        ngaymuon = new javax.swing.JLabel();
        NgayTra = new javax.swing.JLabel();
        hantra = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MaSach = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tensach = new javax.swing.JLabel();
        NgayMuon2 = new javax.swing.JLabel();
        hantra2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SachMuon = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        tacgia = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ngonngu = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(790, 570));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Libary manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHIẾU MƯỢN SÁCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 790, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã Bạn Đọc:");
        jLabel8.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, 30));
        getContentPane().add(MaBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        CheckBD.setText("Kiểm Tra");
        CheckBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBDActionPerformed(evt);
            }
        });
        getContentPane().add(CheckBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 90, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Họ Tên:");
        jLabel12.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel12.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel12.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 80, 30));

        HoTenBD.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        HoTenBD.setForeground(new java.awt.Color(255, 255, 255));
        HoTenBD.setMaximumSize(new java.awt.Dimension(110, 30));
        HoTenBD.setMinimumSize(new java.awt.Dimension(110, 30));
        HoTenBD.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(HoTenBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 280, 30));

        NgayMuon1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NgayMuon1.setForeground(new java.awt.Color(255, 255, 255));
        NgayMuon1.setText("Ngày Mượn:");
        NgayMuon1.setMaximumSize(new java.awt.Dimension(110, 30));
        NgayMuon1.setMinimumSize(new java.awt.Dimension(110, 30));
        NgayMuon1.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(NgayMuon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 30));

        ngaymuon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaymuon.setForeground(new java.awt.Color(255, 255, 255));
        ngaymuon.setMaximumSize(new java.awt.Dimension(110, 30));
        ngaymuon.setMinimumSize(new java.awt.Dimension(110, 30));
        ngaymuon.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngaymuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 230, 30));

        NgayTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NgayTra.setForeground(new java.awt.Color(255, 255, 255));
        NgayTra.setText("Hạn Trả:");
        NgayTra.setMaximumSize(new java.awt.Dimension(110, 30));
        NgayTra.setMinimumSize(new java.awt.Dimension(110, 30));
        NgayTra.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(NgayTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 80, 30));

        hantra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hantra.setForeground(new java.awt.Color(255, 255, 255));
        hantra.setMaximumSize(new java.awt.Dimension(110, 30));
        hantra.setMinimumSize(new java.awt.Dimension(110, 30));
        hantra.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(hantra, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 280, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã Sách:");
        jLabel6.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 30));

        MaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaSachActionPerformed(evt);
            }
        });
        MaSach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MaSachKeyReleased(evt);
            }
        });
        getContentPane().add(MaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 230, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tên Sách:");
        jLabel11.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel11.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel11.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 80, 30));

        tensach.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tensach.setForeground(new java.awt.Color(255, 255, 255));
        tensach.setMaximumSize(new java.awt.Dimension(110, 30));
        tensach.setMinimumSize(new java.awt.Dimension(110, 30));
        tensach.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 280, 30));

        NgayMuon2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NgayMuon2.setForeground(new java.awt.Color(255, 255, 255));
        NgayMuon2.setText("Tiền Cược Tối Thiểu:");
        NgayMuon2.setMaximumSize(new java.awt.Dimension(110, 30));
        NgayMuon2.setMinimumSize(new java.awt.Dimension(110, 30));
        NgayMuon2.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(NgayMuon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 150, 30));

        hantra2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hantra2.setForeground(new java.awt.Color(255, 255, 255));
        hantra2.setMaximumSize(new java.awt.Dimension(110, 30));
        hantra2.setMinimumSize(new java.awt.Dimension(110, 30));
        hantra2.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(hantra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 450, 30));

        SachMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sách", "Tên Sách", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SachMuon.setRowHeight(30);
        SachMuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SachMuon.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane3.setViewportView(SachMuon);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 600, 200));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/Them.png"))); // NOI18N
        jButton1.setText("Mượn Sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 140, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/lamlai.png"))); // NOI18N
        jButton2.setText("Làm lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 110, 40));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat_1.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 100, 40));

        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 90, 30));

        jButton7.setText("Xoá");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 90, 30));

        tacgia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tacgia.setForeground(new java.awt.Color(255, 255, 255));
        tacgia.setMaximumSize(new java.awt.Dimension(110, 30));
        tacgia.setMinimumSize(new java.awt.Dimension(110, 30));
        tacgia.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 230, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tác Giả:");
        jLabel13.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel13.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel13.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 30));

        ngonngu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngonngu.setForeground(new java.awt.Color(255, 255, 255));
        ngonngu.setMaximumSize(new java.awt.Dimension(110, 30));
        ngonngu.setMinimumSize(new java.awt.Dimension(110, 30));
        ngonngu.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 280, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngôn Ngữ:");
        jLabel14.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel14.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel14.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 80, 30));

        walsetdb.setBackground(new java.awt.Color(0, 0, 0));
        walsetdb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        walsetdb.setMaximumSize(new java.awt.Dimension(790, 570));
        walsetdb.setMinimumSize(new java.awt.Dimension(790, 570));
        walsetdb.setOpaque(true);
        walsetdb.setPreferredSize(new java.awt.Dimension(790, 570));
        getContentPane().add(walsetdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void CheckBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBDActionPerformed
        // TODO add your handling code here:
        bd = null;
        HoTenBD.setText("");
        String Ma = MaBD.getText().trim();
        if (Ma.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì!");
        } else {
            if (clpm.checkMBD(Ma) == false) {
                JOptionPane.showMessageDialog(null, "Mã Bạn Đọc bạn nhập không chính xác!");
            } else {
                bd = cl.eBanDoc(Ma);
                HoTenBD.setText(bd.getHoTen());
            }
        }
    }//GEN-LAST:event_CheckBDActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (sc == null) {
            JOptionPane.showMessageDialog(null, "Chưa có sách nào được chọn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            Vector v = new Vector();
            DefaultTableModel dtm = (DefaultTableModel) SachMuon.getModel();
            if (cl.SumSachCon(sc.getMaSach()) == 0) {
                JOptionPane.showMessageDialog(null, "Sách này không còn trong thư viện!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < dtm.getRowCount(); i++) {
                if (dtm.getValueAt(i, 0).equals(sc.getMaSach())) {
                    JOptionPane.showMessageDialog(null, "Đã có sách này trong danh sách mượn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            v.add(sc.getMaSach());
            v.add(sc.getTenSach());
            v.add(1);
            dtm.addRow(v);
            MaSach.setText("");
            tensach.setText("");
            tacgia.setText("");
            ngonngu.setText("");
            MaSach.requestFocus();
            setTextTC();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) SachMuon.getModel();
        //Lấy hàng vừa chọn
        int count = SachMuon.getSelectedRowCount();
        if (count == 1) {
            int numberDeleteRow = SachMuon.getSelectedRow();
            dtm.removeRow(numberDeleteRow);
            SachMuon.setModel(dtm);
            setTextTC();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void MaSachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MaSachKeyReleased
        // TODO add your handling code here:
        sc = null;
        tensach.setText("");
        tacgia.setText("");
        ngonngu.setText("");
        String masach = MaSach.getText().trim();
        if (clpm.SearchSach(MaSach) != 0) {
            sc = cl.eSach(masach);
            tensach.setText(sc.getTenSach());
            tacgia.setText(cl.ConvertTenTacGia(sc.getMaTacGia()));
            ngonngu.setText(cl.ConvertTenNN(sc.getMaNgonNgu()));
        }
    }//GEN-LAST:event_MaSachKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bd = null;
        sc = null;
        MaBD.setText("");
        HoTenBD.setText("");
        MaSach.setText("");
        tensach.setText("");
        tacgia.setText("");
        ngonngu.setText("");
        DefaultTableModel dm = (DefaultTableModel) SachMuon.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (bd == null) {
            JOptionPane.showMessageDialog(null, "Chưa có Mã và Tên bạn đọc mượn sách!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (SachMuon.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa có danh sách Sách mượn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (tiencuoccan > bd.getTienCuoc()) {
            JOptionPane.showMessageDialog(null, "Bạn đọc không đủ tiền cược để mượn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cl.CountPhieuMuonBanDoc(bd.getMaBanDoc()) != 0) {
            JOptionPane.showMessageDialog(null, "Bạn đọc đang có phiếu mượn chưa trả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        clpm.NewPMAdmin(bd, SachMuon, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaSachActionPerformed
        // TODO add your handling code here:
        jButton6ActionPerformed(evt);
    }//GEN-LAST:event_MaSachActionPerformed

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
            java.util.logging.Logger.getLogger(PanelNewPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelNewPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelNewPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelNewPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PanelNewPhieuMuon dialog = new PanelNewPhieuMuon(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckBD;
    private javax.swing.JLabel HoTenBD;
    private javax.swing.JTextField MaBD;
    private javax.swing.JTextField MaSach;
    private javax.swing.JLabel NgayMuon1;
    private javax.swing.JLabel NgayMuon2;
    private javax.swing.JLabel NgayTra;
    private org.jdesktop.swingx.JXTable SachMuon;
    private javax.swing.JLabel hantra;
    private javax.swing.JLabel hantra2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel ngaymuon;
    private javax.swing.JLabel ngonngu;
    private javax.swing.JLabel tacgia;
    private javax.swing.JLabel tensach;
    public static javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}
