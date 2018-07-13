/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Sach;
import Views.Run;
import Views.Sach.PanelChiTietSach;
import Views.Sach.PanelEditSach;
import Views.Sach.PanelNewSach;
import Views.Sach.PanelNhapThemSach;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerSach {

    DefaultTableModel dtm, dtmList;
    ConnectionDB con;
    Connection connect;
    Statement st;
    ResultSet rs;
    long count, sotrang, CountSach, SoTrangSach, CountSachBD, SoTrangSachBD;
    PreparedStatement ps;
    DefaultComboBoxModel<String> dcm;
    ControllerCheck cl = new ControllerCheck();
    Controller conl = new Controller();

    public void countDb(JComboBox LuaChon1, JTextField FindSach, JComboBox TacGia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = FindSach.getText().trim();
        String cb1 = LuaChon1.getSelectedItem().toString().trim();
        String cb2 = TacGia.getSelectedItem().toString();
        String cb3 = ngonngu.getSelectedItem().toString().trim();
        String cb4 = nxb.getSelectedItem().toString().trim();
        String cb5 = theloai.getSelectedItem().toString().trim();
        String cb6 = trangthaisach.getSelectedItem().toString().trim();
        String sqlCommand = null;
        try {
            st = connect.createStatement();
            if (cb1.equals("Theo Mã Sách")) {
                sqlCommand = "SELECT COUNT(*) FROM Sach WHERE MaSach " + ControllerCheck.sMaSach(search)
                        + " and MaTacGia " + cl.sTacGia(cb2)
                        + " and MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and MaNXB " + cl.sNXB(cb4)
                        + " and MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Trangthai " + ControllerCheck.sTrangThaiSach(cb6);
            } else if (cb1.equals("Theo Tên Sách")) {
                sqlCommand = "SELECT COUNT(*) FROM Sach WHERE TenSach " + ControllerCheck.sTenSach(search)
                        + " and MaTacGia " + cl.sTacGia(cb2)
                        + " and MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and MaNXB " + cl.sNXB(cb4)
                        + " and MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Trangthai " + ControllerCheck.sTrangThaiSach(cb6);
            }
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                count = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long SoTrang(JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach) {
        countDb(LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableSach(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach) {
        countDb(LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String cb1 = LuaChon1.getSelectedItem().toString().trim();
        String search = FindSach.getText().trim();
        String cb2 = tacgia.getSelectedItem().toString().trim();
        String cb3 = ngonngu.getSelectedItem().toString().trim();
        String cb4 = nxb.getSelectedItem().toString().trim();
        String cb5 = theloai.getSelectedItem().toString().trim();
        String cb6 = trangthaisach.getSelectedItem().toString().trim();
        String sqlCommand = null;
        try {
            st = connect.createStatement();
            if (cb1.equals("Theo Mã Sách")) {
                sqlCommand = "select top 10 Sach.MaSach as 'Mã Sách',Sach.TenSach as 'Tên sách',NhaXB.TenNXB as 'Tên nhà xuất bản',TacGia.TenTacGia as 'Tên tác giả',TheLoai.TenTheLoai as 'Tên Danh Mục',NgonNgu.TenNgonNgu as 'Ngôn ngữ', "
                        + " Sach.NgayXB as 'Ngày xuất bản', Sach.GiaBan as 'Giá bán', Sach.SoLuong as 'Số Lượng Nhập',Sach.Tang as 'Tầng', "
                        + " Sach.Phong as 'Phòng', Sach.Gia as 'Giá',Sach.Ke as 'Kệ', Sach.TrangThai as 'Trạng thái' "
                        + " from Sach join NhaXB on Sach.MaNXB=NhaXB.MaNXB "
                        + " join TacGia on Sach.MaTacGia=TacGia.MaTacGia "
                        + " join TheLoai on Sach.MaTheLoai=TheLoai.MaTheLoai "
                        + " join NgonNgu on Sach.MaNgonNgu=NgonNgu.MaNgonNgu "
                        + " where Sach.MaSach not in (select top (" + "'" + trang + "'" + " * 10 - 10) Sach.MaSach from Sach  where "
                        + " Sach.MaSach " + ControllerCheck.sTenSach(search)
                        + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                        + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and Sach.MaNXB " + cl.sNXB(cb4)
                        + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Sach.TrangThai " + ControllerCheck.sTrangThaiSach(cb6)
                        + " order by Sach.MaSach asc) "
                        + " and Sach.MaSach " + ControllerCheck.sMaSach(search)
                        + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                        + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and Sach.MaNXB " + cl.sNXB(cb4)
                        + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Sach.Trangthai " + ControllerCheck.sTrangThaiSach(cb6)
                        + " order by MaSach asc";
            } else {
                sqlCommand = "select top 10 Sach.MaSach as 'Mã Sách',Sach.TenSach as 'Tên sách',NhaXB.TenNXB as 'Tên nhà xuất bản',TacGia.TenTacGia as 'Tên tác giả',TheLoai.TenTheLoai as 'Tên Danh Mục',NgonNgu.TenNgonNgu as 'Ngôn ngữ', "
                        + "Sach.NgayXB as 'Ngày xuất bản', Sach.GiaBan as 'Giá bán', Sach.SoLuong as 'Số Lượng Nhập', Sach.Tang as 'Tầng', "
                        + " Sach.Phong as 'Phòng', Sach.Gia as 'Giá',Sach.Ke as 'Kệ', Sach.TrangThai as 'Trạng thái' "
                        + " from Sach join NhaXB on Sach.MaNXB=NhaXB.MaNXB "
                        + " join TacGia on Sach.MaTacGia=TacGia.MaTacGia "
                        + " join TheLoai on Sach.MaTheLoai=TheLoai.MaTheLoai "
                        + " join NgonNgu on Sach.MaNgonNgu=NgonNgu.MaNgonNgu "
                        + " where Sach.MaSach not in (select top (" + "'" + trang + "'" + " * 10 - 10) Sach.MaSach from Sach where "
                        + " TenSach " + ControllerCheck.sTenSach(search)
                        + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                        + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and Sach.MaNXB " + cl.sNXB(cb4)
                        + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Sach.TrangThai " + ControllerCheck.sTrangThaiSach(cb6)
                        + " order by Sach.MaSach asc) "
                        + " and Sach.TenSach " + ControllerCheck.sTenSach(search)
                        + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                        + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                        + " and Sach.MaNXB " + cl.sNXB(cb4)
                        + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                        + " and Sach.TrangThai " + ControllerCheck.sTrangThaiSach(cb6)
                        + " order by Sach.MaSach asc";
            }
            rs = st.executeQuery(sqlCommand);
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            for (int i = 1; i <= socot; i++) {
                if (i == 10) {
                    String tenCot = "Số Lượng Hiện Còn";
                    dtm.addColumn(tenCot);
                }
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            //Vẽ Hàng
            Vector v;
            while (rs.next()) {
                v = new Vector();
                v.add(0, rs.getString("Mã Sách"));
                v.add(1, rs.getString("Tên sách"));
                v.add(2, rs.getString("Tên nhà xuất bản"));
                v.add(3, rs.getString("Tên tác giả"));
                v.add(4, rs.getString("Tên Danh Mục"));
                v.add(5, rs.getString("Ngôn ngữ"));
                v.add(6, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Ngày xuất bản")));
                v.add(7, rs.getString("Giá bán"));
                v.add(8, rs.getString("Số Lượng Nhập"));
                v.add(9, conl.SumSachCon(rs.getInt("Mã Sách")));
                v.add(10, rs.getString("Tầng"));
                v.add(11, rs.getString("Phòng"));
                v.add(12, rs.getString("Giá"));
                v.add(13, rs.getString("Kệ"));
                v.add(14, ControllerCheck.StatusStringSach(rs.getInt("Trạng thái")));
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeJComboxNgonNgu(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        try {
            String sql = "select TenNgonNgu from NgonNgu";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            dcm.addElement("Tất cả");
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxTheLoai(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        dcm.addElement("Tất cả");
        try {
            String sql = "select TenTheLoai from TheLoai";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxTacGia(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        dcm.addElement("Tất cả");
        try {
            String sql = "select TenTacGia from TacGia";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxNXB(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        dcm.addElement("Tất cả");
        try {
            String sql = "select TenNXB from NhaXB";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach, JLabel TrangSach) {
        long trang1 = Long.parseLong(TrangSach.getText());
        if (trang1 < SoTrang(LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach)) {
            trang1++;
            TrangSach.setText("" + trang1);
            VeTableSach(jxt, trang1, LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach, JLabel TrangSach) {
        TrangSach.setText("1");
        long trang1 = Long.parseLong(TrangSach.getText());
        VeTableSach(jxt, trang1, LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach, JLabel TrangSach) {
        long trang1 = 1;
        if (SoTrang(LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach) != 0) {
            trang1 = SoTrang(LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
        }
        TrangSach.setText("" + trang1);
        VeTableSach(jxt, trang1, LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JComboBox LuaChon1, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JComboBox trangthaisach, JLabel TrangSach) {
        long trang1 = Long.parseLong(TrangSach.getText());
        if (trang1 > 1) {
            trang1--;
            TrangSach.setText("" + trang1);
            VeTableSach(jxt, trang1, LuaChon1, FindSach, tacgia, ngonngu, nxb, theloai, trangthaisach);
        }
    }

    public void EditSachAdmin(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String masach = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Sach sch = conl.eSach(masach);
            PanelEditSach as = new PanelEditSach(Run.pma, true, sch);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách để sửa!!");
        }
    }

    public void SetEditSach(Sach sch, JLabel masach, JLabel tensach, JLabel ngayxb, JLabel sotrang, JLabel giaban, JLabel soluongnhap, JLabel tacgia, JLabel ngonngu, JLabel nhaxb, JLabel theloai, JTextArea tomtat, JTextField tang, JTextField phong, JTextField gia, JTextField ke, JLabel trangthai, JLabel bia) {
        masach.setText("" + sch.getMaSach());
        tensach.setText(sch.getTenSach());
        ngayxb.setText(new SimpleDateFormat("dd-MM-yyyy").format(sch.getNgayXB()));
        nhaxb.setText("" + conl.ConvertTenNXB(sch.getMaNXB()));
        tacgia.setText("" + conl.ConvertTenTacGia(sch.getMaTacGia()));
        ngonngu.setText("" + conl.ConvertTenNN(sch.getMaNgonNgu()));
        theloai.setText("" + conl.ConvertTenTheLoai(sch.getMaTheLoai()));
        soluongnhap.setText("" + sch.getSoluong());
        tomtat.setText(sch.getTomTat());
        sotrang.setText("" + sch.getSoTrang());
        giaban.setText("" + sch.getGiaBan() + " VND/Cuốn");
        tang.setText(sch.getTang());
        phong.setText(sch.getPhong());
        gia.setText(sch.getGia());
        ke.setText(sch.getKe());
        if (sch.getTrangthai() == 0) {
            trangthai.setText("Còn sách");
        } else {
            trangthai.setText("Hết sách");
        }
        bia.setIcon(new ImageIcon(new ImageIcon(sch.getBia()).getImage().getScaledInstance(114, 151, Image.SCALE_AREA_AVERAGING)));
    }

    public int upDateAnh(int MaSach, String TomTat, String Bia, String Tang, String Phong, String Gia, String Ke) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE Sach SET TomTat=?, Bia=?, Tang=?,Phong=?,Gia=?,Ke=? WHERE MaSach=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setNString(1, TomTat);
            ps.setBytes(2, ControllerCheck.ConvertFile(Bia));
            ps.setString(3, Tang);
            ps.setString(4, Phong);
            ps.setString(5, Gia);
            ps.setString(6, Ke);
            ps.setInt(7, MaSach);
            i = ps.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return i;
    }

    public int upDateKoAnh(int MaSach, String TomTat, String Tang, String Phong, String Gia, String Ke) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE Sach SET TomTat=?,Tang=?,Phong=?,Gia=?,Ke=? WHERE MaSach=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setNString(1, TomTat);
            ps.setString(2, Tang);
            ps.setString(3, Phong);
            ps.setString(4, Gia);
            ps.setString(5, Ke);
            ps.setInt(6, MaSach);
            i = ps.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return i;
    }

    public void UpdateSachAdmin(JTextArea tomtat, String Bia, JTextField tang, JTextField phong, JTextField gia, JTextField ke, int MaSach, PanelEditSach pes) {
        String tomTat = tomtat.getText().trim();
        String Tang = tang.getText().trim();
        String Phong = phong.getText().trim();
        String Gia = gia.getText().trim();
        String Ke = ke.getText().trim();
        if (tomTat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tóm tắt sách không được để trống!");
            tomtat.requestFocus();
            return;
        }
        if (Tang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tầng thư viện không được để trống!");
            tang.requestFocus();
            return;
        }
        if (Phong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phòng sách không được để trống!");
            phong.requestFocus();
            return;
        }
        if (Gia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá sách không được để trống!");
            gia.requestFocus();
            return;
        }
        if (Ke.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kệ sách không được để trống!");
            ke.requestFocus();
            return;
        }
        if (Bia.isEmpty()) {
            if (upDateKoAnh(MaSach, tomTat, Tang, Phong, Gia, Ke) != 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                pes.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
            }
        } else {
            File f = new File(Bia);
            String mimetype = new MimetypesFileTypeMap().getContentType(f);
            if (mimetype.startsWith("image/")) {
                if (upDateAnh(MaSach, tomTat, Bia, Tang, Phong, Gia, Ke) != 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    pes.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
            }

        }
    }

    public boolean CheckNewTenSach(String TenSach, String MaNgonNgu) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from Sach where TenSach=? and MaNgonNgu=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenSach);
            ps.setString(2, MaNgonNgu);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) != 0) {
                    check = false;
                }
            }
        } catch (SQLException ex) {
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return check;
    }

    public int NewSach(String TenSach, String MaNXB, String Anh, String MaTacGia, String MaTheLoai, String MaNgonNgu, String TomTat, Date NgayXB, String SoTrang, String SoLuong, String GiaBan, String Tang, String Phong, String Gia, String Ke) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        java.sql.Date ngayxb = new java.sql.Date(NgayXB.getTime());
        try {
            String sqlCommand = "INSERT INTO Sach(TenSach,MaNXB,Bia,MaTacGia,MaTheLoai,MaNgonNgu,TomTat,NgayXB,SoTrang,SoLuong,GiaBan,Tang,Phong,Gia,Ke) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenSach);
            ps.setString(2, MaNXB);
            ps.setBytes(3, ControllerCheck.ConvertFile(Anh));
            ps.setString(4, MaTacGia);
            ps.setString(5, MaTheLoai);
            ps.setString(6, MaNgonNgu);
            ps.setNString(7, TomTat);
            ps.setDate(8, ngayxb);
            ps.setString(9, SoTrang);
            ps.setString(10, SoLuong);
            ps.setString(11, GiaBan);
            ps.setString(12, Tang);
            ps.setString(13, Phong);
            ps.setString(14, Gia);
            ps.setString(15, Ke);
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return i;
    }

    public void NewSachAdmin(JTextField TenSach, JComboBox NXB, String Bia, JComboBox TacGia, JComboBox TheLoai, JComboBox NgonNgu, JTextArea TomTat, JDateChooser NgayXB, JTextField SoTrang, JTextField SoLuong, JTextField GiaBan, JTextField Tang, JTextField Phong, JTextField Gia, JTextField Ke, PanelNewSach pns) {
        String tensach = TenSach.getText().trim();
        String nxb = conl.ConvertNXB(NXB.getSelectedItem().toString());
        String tacgia = conl.ConvertTacGia(TacGia.getSelectedItem().toString());
        String theloai = conl.ConvertTheLoai(TheLoai.getSelectedItem().toString());
        String ngonngu = conl.ConvertNN(NgonNgu.getSelectedItem().toString());
        String tomtat = TomTat.getText().trim();
        String sotrangsach = SoTrang.getText().trim();
        String soluong = SoLuong.getText().trim();
        String giaban = GiaBan.getText().trim();
        String tang = Tang.getText().trim();
        String phong = Phong.getText().trim();
        String gia = Gia.getText().trim();
        String ke = Ke.getText().trim();
        if (tensach.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên sách không được để trống!");
            TenSach.requestFocus();
            return;
        }
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date Ngayxb = NgayXB.getDate();
        if (Ngayxb.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
            NgayXB.requestFocus();
            return;
        }
        if (tomtat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tóm tắt sách không được để trống!");
            TomTat.requestFocus();
            return;
        }
        if (sotrangsach.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số trang không được để trống!");
            SoTrang.requestFocus();
            return;
        }
        if (soluong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Số lượng không được để trống!");
            SoLuong.requestFocus();
            return;
        }
        if (giaban.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bán không được để trống!");
            GiaBan.requestFocus();
            return;
        }
        if (tang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tầng không được để trống!");
            Tang.requestFocus();
            return;
        }
        if (phong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phòng sách không được để trống!");
            Phong.requestFocus();
            return;
        }
        if (gia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá sách không được để trống!");
            Gia.requestFocus();
            return;
        }
        if (ke.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kệ sách không được để trống!");
            Ke.requestFocus();
            return;
        }
        if (Bia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bìa sách không được để trống!");
            return;
        }
        if (CheckNewTenSach(tensach, ngonngu) == false) {
            JOptionPane.showMessageDialog(null, "Sách này đã tồn tại với cùng ngôn ngữ!");
            TenSach.requestFocus();
            return;
        }
        if (ControllerCheck.checkNumber(sotrangsach) == false) {
            JOptionPane.showMessageDialog(null, "Số trang không phải là số!");
            SoTrang.requestFocus();
            return;
        }
        if (Integer.parseInt(sotrangsach) <= 0) {
            JOptionPane.showMessageDialog(null, "Số trang phải lớn hơn 0!");
            SoTrang.requestFocus();
            return;
        }
        if (ControllerCheck.checkNumber(giaban) == false) {
            JOptionPane.showMessageDialog(null, "Giá bán không phải là số!");
            SoTrang.requestFocus();
            return;
        }
        if (Integer.parseInt(giaban) <= 0) {
            JOptionPane.showMessageDialog(null, "Giá bán phải lớn hơn 0!");
            SoTrang.requestFocus();
            return;
        }
        if (ControllerCheck.checkNumber(soluong) == false) {
            JOptionPane.showMessageDialog(null, "Số lượng không phải là số!");
            SoLuong.requestFocus();
            return;
        }
        if (Integer.parseInt(soluong) <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!");
            SoLuong.requestFocus();
            return;
        }
        File f = new File(Bia);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        if (mimetype.startsWith("image/")) {
            if (NewSach(tensach, nxb, Bia, tacgia, theloai, ngonngu, tomtat, Ngayxb, sotrangsach, soluong, giaban, tang, phong, gia, ke) != 0) {
                JOptionPane.showMessageDialog(null, "Thêm sách mới thành công!");
                pns.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm sách mới không thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
        }
    }

    public boolean CheckDelSach(String MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM PhieuMuon WHERE MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) != 0) {
                    check = false;
                }
            }
        } catch (SQLException ex) {
        } finally {
            // Giáº£i phĂ³ng tĂ i nguyĂªn
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return check;
    }

    public int countDelSach(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        int delsach = 0;
        try {
            String sqlCommand = "DELETE FROM Sach WHERE MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            delsach = ps.executeUpdate();
        } catch (SQLException ex) {
        } finally {
            // Giáº£i phĂ³ng tĂ i nguyĂªn
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return delsach;
    }

    public void DelSach(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countbd = jxt.getSelectedRowCount();
        if (countbd == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Sách?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaSach = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelSach(MaSach) == true) {
                    if (countDelSach(MaSach) != 0) {
                        JOptionPane.showMessageDialog(null, "Xoá thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Xoá không thành công!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể xóa sách!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách để xóa");
        }
    }

    public void VeJComboxNgonNgu1(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        try {
            String sql = "select TenNgonNgu from NgonNgu";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxTheLoai1(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        try {
            String sql = "select TenTheLoai from TheLoai";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxTacGia1(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        try {
            String sql = "select TenTacGia from TacGia";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
        jxc.setModel(dcm);
    }

    public void VeJComboxNXB1(JComboBox jxc) {
        con = new ConnectionDB();
        connect = con.connect();
        dcm = new DefaultComboBoxModel<String>();
        try {
            String sql = "select TenNXB from NhaXB";
            ps = connect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dcm.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Giải phóng tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        jxc.setModel(dcm);
    }

    public void countDbSach(int MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COUNT(*) FROM ChiTietPhieuMuon WHERE TrangThaiSach!=1 AND MaSach=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaSach);
            rs = ps.executeQuery(sqlCommand);
            while (rs.next()) {
                CountSach = rs.getLong(1);
            }
        } catch (SQLException ex) {
        }
    }

    public long SoTrangSach(int MaSach) {
        countDbSach(MaSach);
        if (CountSach % 10 == 0) {
            SoTrangSach = CountSach / 10;
        } else {
            SoTrangSach = CountSach / 10 + 1;
        }
        return SoTrangSach;
    }

    public void EditSachAdminList(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String masach = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Sach sch = conl.eSach(masach);
            PanelChiTietSach as = new PanelChiTietSach(Run.pma, true, sch);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách để xem chi tiết!");
        }
    }

    public void SetEditSachList(Sach sch, JLabel masach, JLabel soluongcon, JLabel tensach, JLabel ngayxb, JLabel sotrang, JLabel giaban, JLabel soluongnhap, JLabel tacgia, JLabel ngonngu, JLabel nhaxb, JLabel theloai, JLabel tang, JLabel phong, JLabel gia, JLabel ke, JLabel bia) {
        Controller cls = new Controller();
        masach.setText("" + sch.getMaSach());
        soluongcon.setText("" + cls.SumSachCon(sch.getMaSach()));
        tensach.setText(sch.getTenSach());
        ngayxb.setText(new SimpleDateFormat("dd-MM-yyyy").format(sch.getNgayXB()));
        nhaxb.setText("" + conl.ConvertTenNXB(sch.getMaNXB()));
        tacgia.setText("" + conl.ConvertTenTacGia(sch.getMaTacGia()));
        ngonngu.setText("" + conl.ConvertTenNN(sch.getMaNgonNgu()));
        theloai.setText("" + conl.ConvertTenTheLoai(sch.getMaTheLoai()));
        soluongnhap.setText("" + sch.getSoluong());
        sotrang.setText("" + sch.getSoTrang());
        giaban.setText("" + sch.getGiaBan() + " VND");
        tang.setText(sch.getTang());
        phong.setText(sch.getPhong());
        gia.setText(sch.getGia());
        ke.setText(sch.getKe());
        bia.setIcon(new ImageIcon(new ImageIcon(sch.getBia()).getImage().getScaledInstance(114, 151, Image.SCALE_AREA_AVERAGING)));
    }

    public void LoadListSach(org.jdesktop.swingx.JXTable jxt, long trang, int MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        dtmList = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 10 ChiTietPhieuMuon.MaPhieuMuon AS 'Mã Phiếu Mượn', BanDoc.HoTen as 'Tên Người Mượn', PhieuMuon.NgayMuon as 'Ngày Mượn', ChiTietPhieuMuon.TrangThaiSach AS 'Trạng Thái' "
                    + "FROM ChiTietPhieuMuon JOIN PhieuMuon ON ChiTietPhieuMuon.MaPhieuMuon = PhieuMuon.MaPhieuMuon "
                    + "JOIN BanDoc ON PhieuMuon.MaBanDoc= BanDoc.MaBanDoc "
                    + "WHERE ChiTietPhieuMuon.MaSach = ? AND ChiTietPhieuMuon.TrangThaiSach != 0 AND "
                    + "ChiTietPhieuMuon.MaPhieuMuon NOT IN (SELECT TOP (? * 10 - 10) ChiTietPhieuMuon.MaPhieuMuon FROM ChiTietPhieuMuon WHERE ChiTietPhieuMuon.MaSach = ? AND ChiTietPhieuMuon.TrangThaiSach !=0 ORDER BY ChiTietPhieuMuon.MaPhieuMuon DESC) "
                    + "ORDER BY ChiTietPhieuMuon.MaPhieuMuon DESC";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaSach);
            ps.setLong(2, trang);
            ps.setInt(3, MaSach);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtmList.addColumn(tenCot);
            }
            //Vẽ Hàng
            Vector v;
            while (rs.next()) {
                v = new Vector();
                v.add(0, rs.getString(1));
                v.add(1, rs.getString(2));
                v.add(2, rs.getString(3));
                v.add(3, ControllerCheck.StatusStringCTPhieuMuon(rs.getInt(4)));
                dtmList.addRow(v);
            }
            jxt.setModel(dtmList);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NextButtonList(org.jdesktop.swingx.JXTable jxt, JLabel TrangList, int MaSach) {
        long trang1 = Long.parseLong(TrangList.getText());
        if (trang1 < SoTrangSach(MaSach)) {
            trang1++;
            TrangList.setText("" + trang1);
            LoadListSach(jxt, trang1, MaSach);
        }
    }

    public void PreButtonList(org.jdesktop.swingx.JXTable jxt, JLabel TrangList, int MaSach) {
        long trang1 = Long.parseLong(TrangList.getText());
        if (trang1 > 1) {
            trang1--;
            TrangList.setText("" + trang1);
            LoadListSach(jxt, trang1, MaSach);
        }
    }

    public void NhapThemSachAdmin(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String masach = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Sach sch = conl.eSach(masach);
            PanelNhapThemSach as = new PanelNhapThemSach(Run.pma, true, sch);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn sách để nhập thêm số lượng!");
        }
    }

    public int UpNhapThem(int MaSach, int soluong) {
        con = new ConnectionDB();
        connect = con.connect();
        dtmList = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        int update = 0;
        try {
            String sqlCommand = "UPDATE Sach SET Soluong = (Soluong + ?), TrangThai=1 WHERE MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, soluong);
            ps.setLong(2, MaSach);
            update = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return update;
    }

    public void NhapThem(int MaSach, JTextField Soluong, PanelNhapThemSach pnts) {
        String sonhap = Soluong.getText().trim();
        if (sonhap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì!");
            return;
        }
        try {
            int i = Integer.parseInt(sonhap);
            if (i <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng nhập thêm phải lớn hơn 0!");
            } else {
                int up = UpNhapThem(MaSach, i);
                if (up != 0) {
                    JOptionPane.showMessageDialog(null, "Nhập thêm sách thành công!");
                    pnts.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Nhập thêm sách không thành công!");
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Bạn nhập không phải là số!");
        }
    }

    public void countDbBD(JTextField FindSach, JComboBox TacGia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = FindSach.getText().trim();
        String cb2 = TacGia.getSelectedItem().toString();
        String cb3 = ngonngu.getSelectedItem().toString().trim();
        String cb4 = nxb.getSelectedItem().toString().trim();
        String cb5 = theloai.getSelectedItem().toString().trim();
        String sqlCommand = null;
        try {
            st = connect.createStatement();
            sqlCommand = "SELECT COUNT(*) FROM Sach WHERE TenSach " + ControllerCheck.sTenSach(search)
                    + " and MaTacGia " + cl.sTacGia(cb2)
                    + " and MaNgonNgu " + cl.sNgonNgu(cb3)
                    + " and MaNXB " + cl.sNXB(cb4)
                    + " and MaTheLoai " + cl.sTheLoai(cb5);
            rs = st.executeQuery(sqlCommand);
            while (rs.next()) {
                CountSachBD = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long SoTrangBD(JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai) {
        countDbBD(FindSach, tacgia, ngonngu, nxb, theloai);
        if (CountSachBD % 10 == 0) {
            SoTrangSachBD = CountSachBD / 10;
        } else {
            SoTrangSachBD = CountSachBD / 10 + 1;
        }
        return SoTrangSachBD;
    }

    public void VeTableNone(org.jdesktop.swingx.JXTable jxt) {
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        dtm.addColumn("Mã Sách");
        dtm.addColumn("Tên sách");
        dtm.addColumn("Tên nhà xuất bản");
        dtm.addColumn("Tên tác giả");
        dtm.addColumn("Tên Danh Mục");
        dtm.addColumn("Ngôn ngữ");
        dtm.addColumn("Ngày xuất bản");
        dtm.addColumn("Trạng thái");
        dtm.addColumn("Tầng");
        dtm.addColumn("Phòng");
        dtm.addColumn("Giá");
        dtm.addColumn("Kệ");
        jxt.setModel(dtm);
    }

    public void VeTableSachBD(org.jdesktop.swingx.JXTable jxt, long trang, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai) {
        countDbBD(FindSach, tacgia, ngonngu, nxb, theloai);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String search = FindSach.getText().trim();
        String cb2 = tacgia.getSelectedItem().toString().trim();
        String cb3 = ngonngu.getSelectedItem().toString().trim();
        String cb4 = nxb.getSelectedItem().toString().trim();
        String cb5 = theloai.getSelectedItem().toString().trim();
        String sqlCommand = null;
        try {
            st = connect.createStatement();
            sqlCommand = "select top 10 Sach.MaSach as 'Mã Sách',Sach.TenSach as 'Tên sách',NhaXB.TenNXB as 'Tên nhà xuất bản',TacGia.TenTacGia as 'Tên tác giả',TheLoai.TenTheLoai as 'Tên Danh Mục',NgonNgu.TenNgonNgu as 'Ngôn ngữ', "
                    + "Sach.NgayXB as 'Ngày xuất bản', Sach.Tang as 'Tầng', "
                    + " Sach.Phong as 'Phòng', Sach.Gia as 'Giá',Sach.Ke as 'Kệ', Sach.TrangThai as 'Trạng thái' "
                    + " from Sach join NhaXB on Sach.MaNXB=NhaXB.MaNXB "
                    + " join TacGia on Sach.MaTacGia=TacGia.MaTacGia "
                    + " join TheLoai on Sach.MaTheLoai=TheLoai.MaTheLoai "
                    + " join NgonNgu on Sach.MaNgonNgu=NgonNgu.MaNgonNgu "
                    + " where Sach.MaSach not in (select top (" + "'" + trang + "'" + " * 10 - 10) Sach.MaSach from Sach where "
                    + " TenSach " + ControllerCheck.sTenSach(search)
                    + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                    + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                    + " and Sach.MaNXB " + cl.sNXB(cb4)
                    + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                    + " order by Sach.MaSach asc) "
                    + " and Sach.TenSach " + ControllerCheck.sTenSach(search)
                    + " and Sach.MaTacGia " + cl.sTacGia(cb2)
                    + " and Sach.MaNgonNgu " + cl.sNgonNgu(cb3)
                    + " and Sach.MaNXB " + cl.sNXB(cb4)
                    + " and Sach.MaTheLoai " + cl.sTheLoai(cb5)
                    + " order by Sach.MaSach asc";
            rs = st.executeQuery(sqlCommand);
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            for (int i = 1; i <= socot; i++) {
                if (i == 10) {
                    String tenCot = "Số Lượng Hiện Còn";
                    dtm.addColumn(tenCot);
                }
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            //Vẽ Hàng
            Vector v;
            while (rs.next()) {
                v = new Vector();
                v.add(0, rs.getString("Mã Sách"));
                v.add(1, rs.getString("Tên sách"));
                v.add(2, rs.getString("Tên nhà xuất bản"));
                v.add(3, rs.getString("Tên tác giả"));
                v.add(4, rs.getString("Tên Danh Mục"));
                v.add(5, rs.getString("Ngôn ngữ"));
                v.add(6, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("Ngày xuất bản")));
                v.add(7, ControllerCheck.StatusStringSach(rs.getInt("Trạng thái")));
                v.add(8, rs.getString("Tầng"));
                v.add(9, rs.getString("Phòng"));
                v.add(10, rs.getString("Giá"));
                v.add(11, rs.getString("Kệ"));

                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NextButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JLabel TrangSach) {
        long trang1 = Long.parseLong(TrangSach.getText());
        if (trang1 < SoTrangBD(FindSach, tacgia, ngonngu, nxb, theloai)) {
            trang1++;
            TrangSach.setText("" + trang1);
            VeTableSachBD(jxt, trang1, FindSach, tacgia, ngonngu, nxb, theloai);
        }
    }

    public void FirstButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JLabel TrangSach) {
        TrangSach.setText("1");
        long trang1 = Long.parseLong(TrangSach.getText());
        VeTableSachBD(jxt, trang1, FindSach, tacgia, ngonngu, nxb, theloai);
    }

    public void LastButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JLabel TrangSach) {
        long trang1 = 1;
        if (SoTrangBD(FindSach, tacgia, ngonngu, nxb, theloai) != 0) {
            trang1 = SoTrangBD(FindSach, tacgia, ngonngu, nxb, theloai);
        }
        TrangSach.setText("" + trang1);
        VeTableSachBD(jxt, trang1, FindSach, tacgia, ngonngu, nxb, theloai);
    }

    public void PreButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JTextField FindSach, JComboBox tacgia, JComboBox ngonngu, JComboBox nxb, JComboBox theloai, JLabel TrangSach) {
        long trang1 = Long.parseLong(TrangSach.getText());
        if (trang1 > 1) {
            trang1--;
            TrangSach.setText("" + trang1);
            VeTableSachBD(jxt, trang1, FindSach, tacgia, ngonngu, nxb, theloai);
        }
    }
}
