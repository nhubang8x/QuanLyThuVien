/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.PhieuMuon;

import Controllers.ClassColorTable;
import Controllers.ControllerPhieuMuon;
import Controllers.SetWallpaper;
import Controllers.Settings;
import Models.PhieuMuon;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

/**
 *
 * @author Huy Thắng
 */
public class PanelTraPM extends javax.swing.JDialog {

    int xMouse;
    int yMouse;
    ControllerPhieuMuon clpm;
    PhieuMuon pm;
    TableColumn tbcm;
    int phatquahan = 0;
    int phatmathong = 0;

    /**
     * Creates new form PanelChiTietPM
     */
    public PanelTraPM(java.awt.Frame parent, boolean modal, PhieuMuon pm) {
        super(parent, modal);
        initComponents();
        this.pm = pm;
        clpm = new ControllerPhieuMuon();
        SachMuon.setDefaultRenderer(Object.class, new ClassColorTable());
        clpm.setChiTietPM(this.pm, mapm, mabd, HoTenBD, manv, HoTenNV, ngaymuon, hantra, ngaytra, tinhtrang);
        clpm.VeTableTraPM(SachMuon, pm.getMaPhieuMuon());
        tbcm = SachMuon.getColumnModel().getColumn(3);
        DefaultCellEditor ed = new DefaultCellEditor(jComboBox1);
        tbcm.setCellEditor(ed);
        ed.addCellEditorListener(new CellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                // TODO Auto-generated method stub
                setTienPhatMatHongSach();
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }

        });
        if (clpm.checkHanTra(pm.getMaPhieuMuon()) > 0) {
            phatquahan = Settings.ReadTienPhatQuanHanInt();
        }
        tienphatqh.setText(phatquahan + " VNĐ");
        setTienPhatMatHongSach();
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper710x610(walsetdb);
    }

    private void setTienPhatMatHongSach() {
        phatmathong = clpm.TienPhatCan(SachMuon);
        tienphathongmat.setText("" + phatmathong + " VNĐ");
        if (phatquahan != 0 && phatmathong == 0) {
            tinhtrang.setText("Quá Hạn");
        }
        if (phatquahan == 0 && phatmathong != 0) {
            tinhtrang.setText("Mất/Hỏng sách");
        }
        if (phatquahan != 0 && phatmathong != 0) {
            tinhtrang.setText("Quá Hạn + Mất/Hỏng Sách");
        }
        if (phatquahan == 0 && phatmathong == 0) {
            tinhtrang.setText("Đang Mượn");
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mapm = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mabd = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        HoTenBD = new javax.swing.JLabel();
        NgayMuon1 = new javax.swing.JLabel();
        manv = new javax.swing.JLabel();
        NgayTra = new javax.swing.JLabel();
        HoTenNV = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SachMuon = new org.jdesktop.swingx.JXTable();
        jLabel17 = new javax.swing.JLabel();
        tienphatqh = new javax.swing.JLabel();
        tienphathongmat = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        ngaymuon = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ngaytra = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        hantra = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tinhtrang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Mượn", "Đã Trả", "Mất Sách / Hỏng Sách" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(710, 610));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(710, 610));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Libary manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRẢ SÁCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mã Phiếu Mượn:");
        jLabel9.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel9.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel9.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 30));

        mapm.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        mapm.setForeground(new java.awt.Color(255, 255, 255));
        mapm.setMaximumSize(new java.awt.Dimension(110, 30));
        mapm.setMinimumSize(new java.awt.Dimension(110, 30));
        mapm.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(mapm, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 130, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã Bạn Đọc:");
        jLabel8.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel8.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 30));

        mabd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        mabd.setForeground(new java.awt.Color(255, 255, 255));
        mabd.setMaximumSize(new java.awt.Dimension(110, 30));
        mabd.setMinimumSize(new java.awt.Dimension(110, 30));
        mabd.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(mabd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Họ Tên Bạn Đọc:");
        jLabel12.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel12.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel12.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 140, 30));

        HoTenBD.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        HoTenBD.setForeground(new java.awt.Color(255, 255, 255));
        HoTenBD.setMaximumSize(new java.awt.Dimension(110, 30));
        HoTenBD.setMinimumSize(new java.awt.Dimension(110, 30));
        HoTenBD.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(HoTenBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 250, 30));

        NgayMuon1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NgayMuon1.setForeground(new java.awt.Color(255, 255, 255));
        NgayMuon1.setText("Mã Nhân Viên:");
        NgayMuon1.setMaximumSize(new java.awt.Dimension(110, 30));
        NgayMuon1.setMinimumSize(new java.awt.Dimension(110, 30));
        NgayMuon1.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(NgayMuon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 30));

        manv.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        manv.setForeground(new java.awt.Color(255, 255, 255));
        manv.setMaximumSize(new java.awt.Dimension(110, 30));
        manv.setMinimumSize(new java.awt.Dimension(110, 30));
        manv.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(manv, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        NgayTra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        NgayTra.setForeground(new java.awt.Color(255, 255, 255));
        NgayTra.setText("Họ Tên Nhân Viên:");
        NgayTra.setMaximumSize(new java.awt.Dimension(110, 30));
        NgayTra.setMinimumSize(new java.awt.Dimension(110, 30));
        NgayTra.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(NgayTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 140, 30));

        HoTenNV.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        HoTenNV.setForeground(new java.awt.Color(255, 255, 255));
        HoTenNV.setMaximumSize(new java.awt.Dimension(110, 30));
        HoTenNV.setMinimumSize(new java.awt.Dimension(110, 30));
        HoTenNV.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(HoTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 250, 30));

        SachMuon.setRowHeight(30);
        SachMuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SachMuon.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
            }
        );
        jScrollPane3.setViewportView(SachMuon);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 650, 200));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tiền Phạt Quá Hạn:");
        jLabel17.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel17.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel17.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 140, 30));

        tienphatqh.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tienphatqh.setForeground(new java.awt.Color(255, 255, 255));
        tienphatqh.setMaximumSize(new java.awt.Dimension(110, 30));
        tienphatqh.setMinimumSize(new java.awt.Dimension(110, 30));
        tienphatqh.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tienphatqh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 130, 30));

        tienphathongmat.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tienphathongmat.setForeground(new java.awt.Color(255, 255, 255));
        tienphathongmat.setMaximumSize(new java.awt.Dimension(110, 30));
        tienphathongmat.setMinimumSize(new java.awt.Dimension(110, 30));
        tienphathongmat.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tienphathongmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 170, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tiền Phạt Mất / Hỏng Sách:");
        jLabel18.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel18.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel18.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 190, 30));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat_1.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 100, 40));

        ngaymuon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaymuon.setForeground(new java.awt.Color(255, 255, 255));
        ngaymuon.setMaximumSize(new java.awt.Dimension(110, 30));
        ngaymuon.setMinimumSize(new java.awt.Dimension(110, 30));
        ngaymuon.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngaymuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ngày Mượn:");
        jLabel13.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel13.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel13.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 30));

        ngaytra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngaytra.setForeground(new java.awt.Color(255, 255, 255));
        ngaytra.setMaximumSize(new java.awt.Dimension(110, 30));
        ngaytra.setMinimumSize(new java.awt.Dimension(110, 30));
        ngaytra.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngaytra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ngày Trả:");
        jLabel15.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel15.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel15.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 30));

        hantra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hantra.setForeground(new java.awt.Color(255, 255, 255));
        hantra.setMaximumSize(new java.awt.Dimension(110, 30));
        hantra.setMinimumSize(new java.awt.Dimension(110, 30));
        hantra.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(hantra, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 150, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Hạn Trả:");
        jLabel14.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel14.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel14.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 110, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tình Trạng:");
        jLabel16.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel16.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel16.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 110, 30));

        tinhtrang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tinhtrang.setForeground(new java.awt.Color(255, 255, 255));
        tinhtrang.setMaximumSize(new java.awt.Dimension(110, 30));
        tinhtrang.setMinimumSize(new java.awt.Dimension(110, 30));
        tinhtrang.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tinhtrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 200, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Trả Sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 100, 40));

        walsetdb.setBackground(new java.awt.Color(0, 0, 0));
        walsetdb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        walsetdb.setMaximumSize(new java.awt.Dimension(790, 610));
        walsetdb.setMinimumSize(new java.awt.Dimension(790, 610));
        walsetdb.setOpaque(true);
        walsetdb.setPreferredSize(new java.awt.Dimension(790, 610));
        getContentPane().add(walsetdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 610));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 30));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        for (int i = 0; i < SachMuon.getRowCount(); i++) {
            String tinhtrangSach = SachMuon.getValueAt(i, 3).toString();
            if (tinhtrangSach.equals("Đang Mượn")) {
                check = false;
                break;
            }
        }
        if (check == false) {
            JOptionPane.showMessageDialog(null, "Còn sách chưa trả!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            clpm.TraSachAdmin(SachMuon, pm.getMaPhieuMuon(), phatquahan, phatmathong, tinhtrang, mabd, this);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HoTenBD;
    private javax.swing.JLabel HoTenNV;
    private javax.swing.JLabel NgayMuon1;
    private javax.swing.JLabel NgayTra;
    private org.jdesktop.swingx.JXTable SachMuon;
    private javax.swing.JLabel hantra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mabd;
    private javax.swing.JLabel manv;
    private javax.swing.JLabel mapm;
    private javax.swing.JLabel ngaymuon;
    private javax.swing.JLabel ngaytra;
    private javax.swing.JLabel tienphathongmat;
    private javax.swing.JLabel tienphatqh;
    private javax.swing.JLabel tinhtrang;
    public static javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}
