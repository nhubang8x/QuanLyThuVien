/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Sach;

import Controllers.ControllerCheck;
import Controllers.ControllerSach;
import Controllers.SetWallpaper;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Huy Thắng
 */
public class PanelNewSach extends javax.swing.JDialog {

    private String filePath = "";
    int xMouse;
    int yMouse;
    ControllerSach cls;

    /**
     * Creates new form PanelNewSach
     */
    public PanelNewSach(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cls = new ControllerSach();
        cls.VeJComboxNXB1(nhaxb);
        cls.VeJComboxNgonNgu1(ngonngu);
        cls.VeJComboxTacGia1(tacgia);
        cls.VeJComboxTheLoai1(theloai);
        SetWallpaper sw = new SetWallpaper();
        sw.SetWallpaper630x580(walsetdb);
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
        jLabel3 = new javax.swing.JLabel();
        hoten = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ngayxb = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        sotrang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        giabia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();
        soluongnhap = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tacgia = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        ngonngu = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        nhaxb = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        theloai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tomtat = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        tang = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        phong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        gia = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        ke = new javax.swing.JTextField();
        labelAnh = new javax.swing.JLabel();
        chonanh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        walsetdb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(630, 580));
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
        jLabel1.setText("THÊM MỚI SÁCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 630, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên sách:");
        jLabel3.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, 30));

        hoten.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 280, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày xuất bản:");
        jLabel10.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel10.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel10.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 30));

        JTextFieldDateEditor editor = (JTextFieldDateEditor) ngayxb.getDateEditor();
        editor.setEditable(false);
        ngayxb.setDateFormatString("dd-MM-yyyy");
        ngayxb.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ngayxb.setMaxSelectableDate(new java.util.Date(253370743297000L));
        ngayxb.setMinSelectableDate(null);
        getContentPane().add(ngayxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 180, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Số Trang:");
        jLabel13.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel13.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel13.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 30));

        sotrang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(sotrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Giá bìa:");
        jLabel16.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel16.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel16.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 30));

        giabia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(giabia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 180, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VND/Cuốn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 70, 30));

        JLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        JLabel11.setForeground(new java.awt.Color(255, 255, 255));
        JLabel11.setText("Số lượng nhập:");
        JLabel11.setMaximumSize(new java.awt.Dimension(110, 30));
        JLabel11.setMinimumSize(new java.awt.Dimension(110, 30));
        JLabel11.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(JLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 30));

        soluongnhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(soluongnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 180, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tác giả:");
        jLabel15.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel15.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel15.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 30));

        tacgia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(tacgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngôn Ngữ:");
        jLabel14.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel14.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel14.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 90, 30));

        ngonngu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(ngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 180, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nhà xuất bản:");
        jLabel20.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel20.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel20.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 110, 30));

        nhaxb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(nhaxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 180, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Danh Mục:");
        jLabel22.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel22.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel22.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 90, 30));

        theloai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(theloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 180, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tóm tắt:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 30));

        tomtat.setColumns(20);
        tomtat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tomtat.setLineWrap(true);
        tomtat.setRows(5);
        jScrollPane1.setViewportView(tomtat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 460, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tầng:");
        jLabel17.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel17.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel17.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 60, 30));

        tang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(tang, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 75, 30));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Phòng:");
        jLabel18.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel18.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel18.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 470, 50, 30));

        phong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 470, 75, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Giá:");
        jLabel19.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel19.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel19.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 50, 30));

        gia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 75, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Kệ:");
        jLabel21.setMaximumSize(new java.awt.Dimension(110, 30));
        jLabel21.setMinimumSize(new java.awt.Dimension(110, 30));
        jLabel21.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 470, 50, 30));

        ke.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(ke, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 470, 75, 30));

        labelAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/NoImages.png"))); // NOI18N
        labelAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(labelAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 90, 114, 151));

        chonanh.setText("Chọn");
        chonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonanhActionPerformed(evt);
            }
        });
        getContentPane().add(chonanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 80, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/Them.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 520, 130, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/lamlai.png"))); // NOI18N
        jButton2.setText("Làm lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 520, 110, -1));

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/thoat_1.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 520, 100, -1));

        walsetdb.setBackground(new java.awt.Color(0, 0, 0));
        walsetdb.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        walsetdb.setMaximumSize(new java.awt.Dimension(630, 590));
        walsetdb.setMinimumSize(new java.awt.Dimension(630, 590));
        walsetdb.setOpaque(true);
        walsetdb.setPreferredSize(new java.awt.Dimension(630, 590));
        getContentPane().add(walsetdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 580));

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

    private void chonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonanhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fillter = new FileNameExtensionFilter("Image file", ImageIO.getReaderFileSuffixes());
        fileChooser.setFileFilter(fillter);
        fileChooser.setMultiSelectionEnabled(false);
        int action = fileChooser.showOpenDialog(this);
        if (action == JFileChooser.APPROVE_OPTION) {
            File imgFile = fileChooser.getSelectedFile();
            filePath = imgFile.getAbsolutePath();
            labelAnh.setIcon(ControllerCheck.load(filePath, labelAnh.getWidth(), labelAnh.getHeight()));
        }
    }//GEN-LAST:event_chonanhActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cls.NewSachAdmin(hoten, nhaxb, filePath, tacgia, theloai, ngonngu, tomtat, ngayxb, sotrang, soluongnhap, giabia, tang, phong, gia, ke, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        filePath = "";
        hoten.setText("");
        ngayxb.setCalendar(null);
        sotrang.setText("");
        giabia.setText("");
        soluongnhap.setText("");
        tacgia.setSelectedIndex(0);
        ngonngu.setSelectedIndex(0);
        nhaxb.setSelectedIndex(0);
        theloai.setSelectedIndex(0);
        tomtat.setText("");
        phong.setText("");
        tang.setText("");
        gia.setText("");
        ke.setText("");
        labelAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/NoImages.png")));
    }//GEN-LAST:event_jButton2ActionPerformed

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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel11;
    private javax.swing.JButton chonanh;
    private javax.swing.JTextField gia;
    private javax.swing.JTextField giabia;
    private javax.swing.JTextField hoten;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ke;
    private javax.swing.JLabel labelAnh;
    private com.toedter.calendar.JDateChooser ngayxb;
    private javax.swing.JComboBox<String> ngonngu;
    private javax.swing.JComboBox<String> nhaxb;
    private javax.swing.JTextField phong;
    private javax.swing.JTextField soluongnhap;
    private javax.swing.JTextField sotrang;
    private javax.swing.JComboBox<String> tacgia;
    private javax.swing.JTextField tang;
    private javax.swing.JComboBox<String> theloai;
    private javax.swing.JTextArea tomtat;
    public static javax.swing.JLabel walsetdb;
    // End of variables declaration//GEN-END:variables
}
