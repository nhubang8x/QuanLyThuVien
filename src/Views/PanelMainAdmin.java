/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.SetWallpaper;
import Controllers.Settings;
import Views.HeThong.PanelHeThong;
import Views.BaoCao.PanelBaoCao;
import Views.NXB.PanelNXB;
import Views.PhieuMuon.PanelPhieuMuon;
import Views.TheLoai.PanelTheLoai;
import Views.Sach.PanelSach;
import Views.TacGia.PanelTacGia;
import Views.NgonNgu.PanelNgonNgu;
import Views.BanDoc.PanelBanDoc;
import Views.NhanVien.PanelNhanVien;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Huy Thắng
 */
public class PanelMainAdmin extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    PanelTrangChu home;
    public PanelSach ps;
    PanelPhieuMuon ppm;
    PanelTacGia ptg;
    PanelNXB pnxb;
    PanelTheLoai ptl;
    PanelNgonNgu pnn;
    PanelBanDoc pbd;
    PanelBaoCao pbc;
    PanelNhanVien pnv;
    PanelHeThong pht;
    Settings s;
    SetWallpaper sw;

    /**
     * Creates new form NewJFrame
     */
    public PanelMainAdmin() {
        initComponents();        
        if (Run.nv.getPhanQuyen() == 0) {
            quanlyNV.setEnabled(false);
        }
        home = new PanelTrangChu();
        jpLayout.add(home);
        jpLayout.updateUI();
        sw = new SetWallpaper();
        sw.SetWallpaper920x635(wallMainAdmin);
        TenNV.setText("Xin chào: " + Run.nv.getHoTen());
        Clock clock = new Clock();
        clock.start();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

    public class Clock extends Thread {

        public Clock() {
        }

        @Override
        public void run() {
            while (true) {
                Calendar calendar = Calendar.getInstance();
                String str;
                str = sdf.format(calendar.getTime());
                Time.setText("Thời gian: " + str);
                try {
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void reloadPanel(int i) {
        jpLayout.removeAll();
        switch (i) {
            case 1:
                if (home == null) {
                    home = new PanelTrangChu();
                }
                jpLayout.add(home);
                break;
            case 2:
                if (ps == null) {
                    ps = new PanelSach();
                }
                jpLayout.add(ps);
                sw.SetWallpaper700x545(PanelSach.wall);
                ps.LoaddataSach();
                break;
            case 3:
                if (ppm == null) {
                    ppm = new PanelPhieuMuon();
                }
                jpLayout.add(ppm);
                sw.SetWallpaper700x545(PanelPhieuMuon.wall);
                ppm.LoaddataPhieuMuon();
                break;
            case 4:
                if (ptg == null) {
                    ptg = new PanelTacGia();
                }
                jpLayout.add(ptg);
                ptg.LoaddataTacGia();
                sw.SetWallpaper700x545(PanelTacGia.wall);
                break;
            case 5:
                if (pnxb == null) {
                    pnxb = new PanelNXB();
                }
                sw.SetWallpaper700x545(PanelNXB.wall);
                pnxb.LoaddataNXB();
                jpLayout.add(pnxb);
                break;
            case 6:
                if (ptl == null) {
                    ptl = new PanelTheLoai();
                }
                sw.SetWallpaper700x545(PanelTheLoai.wall);
                ptl.LoaddataTheLoai();
                jpLayout.add(ptl);
                break;
            case 7:
                if (pnn == null) {
                    pnn = new PanelNgonNgu();
                }
                jpLayout.add(pnn);
                sw.SetWallpaper700x545(PanelNgonNgu.wall);
                pnn.LoaddataNgonNgu();
                break;
            case 8:
                if (pbd == null) {
                    pbd = new PanelBanDoc();
                }
                jpLayout.add(pbd);
                sw.SetWallpaper700x545(PanelBanDoc.wall);
                pbd.LoadingTableBanDoc();
                break;
            case 9:
                if (pbc == null) {
                    pbc = new PanelBaoCao();
                }
                sw.SetWallpaper700x545(PanelBaoCao.wall);
                jpLayout.add(pbc);
                break;
            case 10:
                if (pnv == null) {
                    pnv = new PanelNhanVien();
                }
                sw.SetWallpaper700x545(PanelNhanVien.wall);
                pnv.LoaddataNhanVien();
                jpLayout.add(pnv);
                break;
            case 11:
                if (pht == null) {
                    pht = new PanelHeThong();
                }
                sw.SetWallpaper700x545(PanelHeThong.wall);
                jpLayout.add(pht);
                break;
            default:
                break;
        }
        jpLayout.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mini = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TenNV = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        doimk = new javax.swing.JLabel();
        trangchu = new org.jdesktop.swingx.JXButton();
        quanlysach = new org.jdesktop.swingx.JXButton();
        quanlyPM = new org.jdesktop.swingx.JXButton();
        quanlyTG = new org.jdesktop.swingx.JXButton();
        quanlyNXB = new org.jdesktop.swingx.JXButton();
        quanlyTL = new org.jdesktop.swingx.JXButton();
        quanlyNN = new org.jdesktop.swingx.JXButton();
        quanlyBD = new org.jdesktop.swingx.JXButton();
        baocaothongke = new org.jdesktop.swingx.JXButton();
        quanlyNV = new org.jdesktop.swingx.JXButton();
        quanlyHT = new org.jdesktop.swingx.JXButton();
        jpLayout = new javax.swing.JPanel();
        wallMainAdmin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 635));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(920, 635));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/mini-blue.png"))); // NOI18N
        mini.setToolTipText("Thu nhỏ");
        mini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniMouseClicked(evt);
            }
        });
        getContentPane().add(mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 5, 22, 22));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/close-blue.png"))); // NOI18N
        close.setToolTipText("Thoát");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 5, 22, 22));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Libary manager");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 250, 30));

        TenNV.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        TenNV.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 240, 40));

        Time.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 32, 180, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat.png"))); // NOI18N
        jLabel2.setText("Đăng xuất");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 32, 110, 40));

        doimk.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        doimk.setForeground(new java.awt.Color(255, 255, 255));
        doimk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doimk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/newpass.png"))); // NOI18N
        doimk.setText("Đổi mật khẩu");
        doimk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doimk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doimkMouseClicked(evt);
            }
        });
        getContentPane().add(doimk, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 32, 130, 40));

        trangchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/trangchu.png"))); // NOI18N
        trangchu.setText("Trang Chủ");
        trangchu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        trangchu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        trangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangchuActionPerformed(evt);
            }
        });
        getContentPane().add(trangchu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 200, 45));

        quanlysach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/books-icon-512.png"))); // NOI18N
        quanlysach.setText("Quản Lý Sách");
        quanlysach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlysach.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlysach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlysachActionPerformed(evt);
            }
        });
        getContentPane().add(quanlysach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 200, 45));

        quanlyPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/phieumuon.png"))); // NOI18N
        quanlyPM.setText("Quản Lý Phiếu Mượn");
        quanlyPM.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyPM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyPM.setMargin(new java.awt.Insets(2, 14, 2, 2));
        quanlyPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyPMActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, 200, 45));

        quanlyTG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/tacgia.png"))); // NOI18N
        quanlyTG.setText("Quản Lý Tác Giả");
        quanlyTG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyTG.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyTGActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 200, 45));

        quanlyNXB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/nha-may.png"))); // NOI18N
        quanlyNXB.setText("Quản Lý NXB");
        quanlyNXB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyNXB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyNXBActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 200, 45));

        quanlyTL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/phanloai.png"))); // NOI18N
        quanlyTL.setText("Quản Lý Danh Mục");
        quanlyTL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyTL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyTLActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 325, 200, 45));

        quanlyNN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/ngongnu.png"))); // NOI18N
        quanlyNN.setText("Quản Lý Ngôn Ngữ");
        quanlyNN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyNN.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyNNActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 200, 45));

        quanlyBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/people.png"))); // NOI18N
        quanlyBD.setText("Quản Lý Bạn Đọc");
        quanlyBD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyBDActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, 200, 45));

        baocaothongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/baocao.png"))); // NOI18N
        baocaothongke.setText("Báo Cáo - Thống Kê");
        baocaothongke.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        baocaothongke.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        baocaothongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baocaothongkeActionPerformed(evt);
            }
        });
        getContentPane().add(baocaothongke, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 475, 200, 45));

        quanlyNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/nam.png"))); // NOI18N
        quanlyNV.setText("Quản Lý Nhân Viên");
        quanlyNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyNVActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 525, 200, 45));

        quanlyHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/hethong.png"))); // NOI18N
        quanlyHT.setText("Quản Lý Hệ Thống");
        quanlyHT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quanlyHT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quanlyHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyHTActionPerformed(evt);
            }
        });
        getContentPane().add(quanlyHT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 575, 200, 45));

        jpLayout.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jpLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 75, 700, 545));

        wallMainAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-4.png"))); // NOI18N
        getContentPane().add(wallMainAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 635));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniMouseClicked
        // TODO add your handling code here:
        this.setState(PanelLogin.ICONIFIED);
    }//GEN-LAST:event_miniMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Run.nv = null;
        Run.Login();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void trangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangchuActionPerformed
        // TODO add your handling code here:
        reloadPanel(1);
    }//GEN-LAST:event_trangchuActionPerformed

    private void quanlysachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlysachActionPerformed
        // TODO add your handling code here:
        reloadPanel(2);
    }//GEN-LAST:event_quanlysachActionPerformed

    private void quanlyPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyPMActionPerformed
        // TODO add your handling code here:
        reloadPanel(3);
    }//GEN-LAST:event_quanlyPMActionPerformed

    private void quanlyTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyTGActionPerformed
        // TODO add your handling code here:
        reloadPanel(4);
    }//GEN-LAST:event_quanlyTGActionPerformed

    private void quanlyNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyNXBActionPerformed
        // TODO add your handling code here:
        reloadPanel(5);
    }//GEN-LAST:event_quanlyNXBActionPerformed

    private void quanlyTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyTLActionPerformed
        // TODO add your handling code here:
        reloadPanel(6);
    }//GEN-LAST:event_quanlyTLActionPerformed

    private void quanlyNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyNNActionPerformed
        // TODO add your handling code here:
        reloadPanel(7);
    }//GEN-LAST:event_quanlyNNActionPerformed

    private void quanlyBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyBDActionPerformed
        // TODO add your handling code here:
        reloadPanel(8);
    }//GEN-LAST:event_quanlyBDActionPerformed

    private void baocaothongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baocaothongkeActionPerformed
        // TODO add your handling code here:
        reloadPanel(9);
    }//GEN-LAST:event_baocaothongkeActionPerformed

    private void quanlyNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyNVActionPerformed
        // TODO add your handling code here:
        reloadPanel(10);
    }//GEN-LAST:event_quanlyNVActionPerformed

    private void quanlyHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyHTActionPerformed
        // TODO add your handling code here:
        reloadPanel(11);
    }//GEN-LAST:event_quanlyHTActionPerformed

    private void doimkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doimkMouseClicked
        // TODO add your handling code here:
        PanelChangeMK pcmk = new PanelChangeMK(this, true, false);
        pcmk.setVisible(true);
    }//GEN-LAST:event_doimkMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TenNV;
    private javax.swing.JLabel Time;
    private org.jdesktop.swingx.JXButton baocaothongke;
    private javax.swing.JLabel close;
    private javax.swing.JLabel doimk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jpLayout;
    private javax.swing.JLabel mini;
    private org.jdesktop.swingx.JXButton quanlyBD;
    private org.jdesktop.swingx.JXButton quanlyHT;
    private org.jdesktop.swingx.JXButton quanlyNN;
    private org.jdesktop.swingx.JXButton quanlyNV;
    private org.jdesktop.swingx.JXButton quanlyNXB;
    private org.jdesktop.swingx.JXButton quanlyPM;
    private org.jdesktop.swingx.JXButton quanlyTG;
    private org.jdesktop.swingx.JXButton quanlyTL;
    private org.jdesktop.swingx.JXButton quanlysach;
    private org.jdesktop.swingx.JXButton trangchu;
    public static javax.swing.JLabel wallMainAdmin;
    // End of variables declaration//GEN-END:variables
}
