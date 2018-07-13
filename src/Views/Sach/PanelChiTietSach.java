/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Sach;

import Controllers.ControllerSach;
import Controllers.SetWallpaper;
import Models.Sach;

/**
 *
 * @author Huy Thắng
 */
public class PanelChiTietSach extends javax.swing.JDialog {

    int xMouse;
    int yMouse;
    Sach sc;
    ControllerSach cls;

    /**
     * Creates new form PanelChiTietSach
     *
     * @param parent
     * @param modal
     * @param sc
     */
    public PanelChiTietSach(java.awt.Frame parent, boolean modal, Sach sc) {
        super(parent, modal);
        initComponents();
        this.sc = sc;
        cls = new ControllerSach();
        cls.SetEditSachList(this.sc, masach, soluongcon, tensach, ngayxb, sotrang, giabia, soluongnhap, tacgia, ngonngu, nxb, theloai, tang, phong, gia, ke, labelAnh);
        long trang = Long.parseLong(trangSach.getText());
        cls.LoadListSach(ListSach, trang, sc.getMaSach());
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper630x640(walsetdb);
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
        jLabel6 = new javax.swing.JLabel();
        masach = new javax.swing.JLabel();
        JLabel12 = new javax.swing.JLabel();
        soluongcon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tensach = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ngayxb = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sotrang = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        giabia = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();
        soluongnhap = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tacgia = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ngonngu = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nxb = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        theloai = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tang = new javax.swing.JLabel();
        phong = new javax.swing.JLabel();
        gia = new javax.swing.JLabel();
        ke = new javax.swing.JLabel();
        labelAnh = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListSach = new org.jdesktop.swingx.JXTable();
        jLabel91 = new javax.swing.JLabel();
        trangSach = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 640));
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
        jLabel1.setText("CHI TIẾT SÁCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 40));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã sách:");
        jLabel6.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 90, 76, 30));

        masach.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        masach.setForeground(new java.awt.Color(255, 255, 255));
        masach.setMaximumSize(new java.awt.Dimension(110, 30));
        masach.setMinimumSize(new java.awt.Dimension(110, 30));
        masach.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(masach, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 130, 30));

        JLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        JLabel12.setForeground(new java.awt.Color(255, 255, 255));
        JLabel12.setText("Số lượng còn:");
        JLabel12.setMaximumSize(new java.awt.Dimension(110, 30));
        JLabel12.setMinimumSize(new java.awt.Dimension(110, 30));
        JLabel12.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(JLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 110, 30));

        soluongcon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        soluongcon.setForeground(new java.awt.Color(255, 255, 255));
        soluongcon.setMaximumSize(new java.awt.Dimension(110, 30));
        soluongcon.setMinimumSize(new java.awt.Dimension(110, 30));
        soluongcon.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(soluongcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 120, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên sách:");
        jLabel3.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 130, 76, 30));

        tensach.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tensach.setForeground(new java.awt.Color(255, 255, 255));
        tensach.setMaximumSize(new java.awt.Dimension(110, 30));
        tensach.setMinimumSize(new java.awt.Dimension(110, 30));
        tensach.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tensach, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 370, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày xuất bản:");
        jLabel10.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel10.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel10.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 110, 30));

        ngayxb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngayxb.setForeground(new java.awt.Color(255, 255, 255));
        ngayxb.setMaximumSize(new java.awt.Dimension(110, 30));
        ngayxb.setMinimumSize(new java.awt.Dimension(110, 30));
        ngayxb.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngayxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 120, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Số Trang:");
        jLabel13.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel13.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel13.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 170, 76, 30));

        sotrang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        sotrang.setForeground(new java.awt.Color(255, 255, 255));
        sotrang.setMaximumSize(new java.awt.Dimension(110, 30));
        sotrang.setMinimumSize(new java.awt.Dimension(110, 30));
        sotrang.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(sotrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 120, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Giá bìa:");
        jLabel16.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel16.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel16.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 210, 76, 30));

        giabia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        giabia.setForeground(new java.awt.Color(255, 255, 255));
        giabia.setMaximumSize(new java.awt.Dimension(110, 30));
        giabia.setMinimumSize(new java.awt.Dimension(110, 30));
        giabia.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(giabia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 120, 30));

        JLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        JLabel11.setForeground(new java.awt.Color(255, 255, 255));
        JLabel11.setText("Số lượng nhập:");
        JLabel11.setMaximumSize(new java.awt.Dimension(110, 30));
        JLabel11.setMinimumSize(new java.awt.Dimension(110, 30));
        JLabel11.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(JLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 110, 30));

        soluongnhap.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        soluongnhap.setForeground(new java.awt.Color(255, 255, 255));
        soluongnhap.setMaximumSize(new java.awt.Dimension(110, 30));
        soluongnhap.setMinimumSize(new java.awt.Dimension(110, 30));
        soluongnhap.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(soluongnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 120, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tác Giả:");
        jLabel15.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel15.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel15.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 30));

        tacgia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tacgia.setForeground(new java.awt.Color(255, 255, 255));
        tacgia.setMaximumSize(new java.awt.Dimension(110, 30));
        tacgia.setMinimumSize(new java.awt.Dimension(110, 30));
        tacgia.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 180, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngôn Ngữ:");
        jLabel14.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel14.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel14.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 90, 30));

        ngonngu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngonngu.setForeground(new java.awt.Color(255, 255, 255));
        ngonngu.setMaximumSize(new java.awt.Dimension(110, 30));
        ngonngu.setMinimumSize(new java.awt.Dimension(110, 30));
        ngonngu.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 180, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nhà Xuất Bản:");
        jLabel20.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel20.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel20.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 30));

        nxb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        nxb.setForeground(new java.awt.Color(255, 255, 255));
        nxb.setMaximumSize(new java.awt.Dimension(110, 30));
        nxb.setMinimumSize(new java.awt.Dimension(110, 30));
        nxb.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(nxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Danh Mục:");
        jLabel22.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel22.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel22.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 90, 30));

        theloai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        theloai.setForeground(new java.awt.Color(255, 255, 255));
        theloai.setMaximumSize(new java.awt.Dimension(110, 30));
        theloai.setMinimumSize(new java.awt.Dimension(110, 30));
        theloai.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(theloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 180, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tầng:");
        jLabel17.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel17.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel17.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 60, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Phòng:");
        jLabel18.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel18.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel18.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 330, 50, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Giá:");
        jLabel19.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel19.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel19.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 50, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Kệ:");
        jLabel21.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel21.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel21.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 330, 50, 30));

        tang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tang.setForeground(new java.awt.Color(255, 255, 255));
        tang.setMaximumSize(new java.awt.Dimension(110, 30));
        tang.setMinimumSize(new java.awt.Dimension(110, 30));
        tang.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(tang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 75, 30));

        phong.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        phong.setForeground(new java.awt.Color(255, 255, 255));
        phong.setMaximumSize(new java.awt.Dimension(110, 30));
        phong.setMinimumSize(new java.awt.Dimension(110, 30));
        phong.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 330, 75, 30));

        gia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        gia.setForeground(new java.awt.Color(255, 255, 255));
        gia.setMaximumSize(new java.awt.Dimension(110, 30));
        gia.setMinimumSize(new java.awt.Dimension(110, 30));
        gia.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 75, 30));

        ke.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ke.setForeground(new java.awt.Color(255, 255, 255));
        ke.setMaximumSize(new java.awt.Dimension(110, 30));
        ke.setMinimumSize(new java.awt.Dimension(110, 30));
        ke.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(ke, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 330, 75, 30));

        labelAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/NoImages.png"))); // NOI18N
        labelAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(labelAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 114, 151));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Danh sách sách:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 160, 30));

        ListSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(ListSach);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 410, 160));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/pre_one.png"))); // NOI18N
        jLabel91.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 540, -1, -1));

        trangSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        trangSach.setForeground(new java.awt.Color(255, 255, 255));
        trangSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trangSach.setText("1");
        trangSach.setMaximumSize(new java.awt.Dimension(32, 32));
        trangSach.setMinimumSize(new java.awt.Dimension(32, 32));
        trangSach.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(trangSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 540, -1, -1));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/next_one.png"))); // NOI18N
        jLabel93.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 540, -1, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat_1.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 590, 100, -1));

        walsetdb.setBackground(new java.awt.Color(0, 0, 0));
        walsetdb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        walsetdb.setMaximumSize(new java.awt.Dimension(630, 640));
        walsetdb.setMinimumSize(new java.awt.Dimension(630, 640));
        walsetdb.setOpaque(true);
        walsetdb.setPreferredSize(new java.awt.Dimension(630, 640));
        getContentPane().add(walsetdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 640));

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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 30));

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

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        // TODO add your handling code here:
        cls.PreButtonList(ListSach, trangSach, sc.getMaSach());
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        cls.NextButtonList(ListSach, trangSach, sc.getMaSach());
    }//GEN-LAST:event_jLabel93MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel12;
    private org.jdesktop.swingx.JXTable ListSach;
    private javax.swing.JLabel gia;
    private javax.swing.JLabel giabia;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel ke;
    private javax.swing.JLabel labelAnh;
    private javax.swing.JLabel masach;
    private javax.swing.JLabel ngayxb;
    private javax.swing.JLabel ngonngu;
    private javax.swing.JLabel nxb;
    private javax.swing.JLabel phong;
    private javax.swing.JLabel soluongcon;
    private javax.swing.JLabel soluongnhap;
    private javax.swing.JLabel sotrang;
    private javax.swing.JLabel tacgia;
    private javax.swing.JLabel tang;
    private javax.swing.JLabel tensach;
    private javax.swing.JLabel theloai;
    private javax.swing.JLabel trangSach;
    public static javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}