/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NhanVien;
import Views.NhanVien.PanelEditNhanVien;
import Views.NhanVien.PanelNewNhanVien;
import Views.NhanVien.PanelNewNhanVienFirst;
import Views.Run;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerNhanVien {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;

    public void countDb(JComboBox jcb1, JTextField find, JComboBox jcb2) {
        con = new ConnectionDB();
        connect = con.connect();
        String cb1 = jcb1.getSelectedItem().toString().trim();
        String search = find.getText().trim();
        String cb2 = jcb2.getSelectedItem().toString().trim();
        try {
            String sqlCommand;
            if (search.equals("")) {
                if (cb2.equals("Tất cả")) {
                    sqlCommand = "select count(*) from NhanVien";
                    ps = connect.prepareStatement(sqlCommand);
                } else {
                    sqlCommand = "select count(*) from NhanVien where TrangThai = ?";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from NhanVien where MaNhanVien LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from NhanVien where TrangThai = ? and MaNhanVien LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(2, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Tên Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from NhanVien where HoTen LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from NhanVien where TrangThai = ? and HoTen LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(2, "%" + search + "%");
                    }
                }
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getLong(1);
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
    }

    public long SoTrang(JComboBox jcb1, JTextField find, JComboBox jcb2) {
        countDb(jcb1, find, jcb2);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableNV(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox jcb1, JTextField find, JComboBox jcb2) {
        countDb(jcb1, find, jcb2);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String cb1 = jcb1.getSelectedItem().toString().trim();
        String search = find.getText().trim();
        String cb2 = jcb2.getSelectedItem().toString().trim();
        try {
            String sqlCommand;
            if (search.equals("")) {
                if (cb2.equals("Tất cả")) {
                    sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                            + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                            + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                            + "from NhanVien "
                            + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien order by MaNhanVien asc) "
                            + "order by MaNhanVien asc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                } else {
                    sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                            + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                            + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                            + "from NhanVien "
                            + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien where TrangThai = ? order by MaNhanVien asc) "
                            + "and TrangThai = ? order by MaNhanVien asc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                    ps.setInt(2, ControllerCheck.ChoosenFind(cb2));
                    ps.setInt(3, ControllerCheck.ChoosenFind(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                                + "from NhanVien "
                                + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien where MaNhanVien LIKE ? order by MaNhanVien asc) "
                                + "and MaNhanVien LIKE ? order by MaNhanVien asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                                + "from NhanVien "
                                + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien where TrangThai = ? and MaNhanVien LIKE ? order by MaNhanVien asc) "
                                + "and TrangThai = ? and MaNhanVien LIKE ? order by MaNhanVien asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(5, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Tên Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                                + "from NhanVien "
                                + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien where HoTen LIKE ? order by MaNhanVien asc) "
                                + "and HoTen LIKE ? order by MaNhanVien asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaNhanVien as 'Mã Nhân Viên',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "PhanQuyen as 'Phân Quyền',TrangThai as 'Trạng thái' "
                                + "from NhanVien "
                                + "where MaNhanVien not in (select top (? * 10 - 10) MaNhanVien from NhanVien where TrangThai = ? and HoTen LIKE ? order by MaNhanVien asc) "
                                + "and TrangThai = ? and HoTen LIKE ? order by MaNhanVien asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(5, "%" + search + "%");
                    }
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            //Vẽ Hàng
            Vector v;
            while (rs.next()) {
                v = new Vector();
                v.add(0, rs.getString(1));
                v.add(1, rs.getString(2));
                v.add(2, rs.getString(3));
                v.add(3, rs.getString(4));
                v.add(4, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(5)));
                v.add(5, rs.getString(6));
                v.add(6, rs.getString(7));
                v.add(7, ControllerCheck.SexString(rs.getInt(8)));
                v.add(8, ControllerCheck.DecentralizationString(rs.getInt(9)));
                v.add(9, ControllerCheck.StatusStringNhanVien(rs.getInt(10)));
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
        }
    }

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JTextField findnv, JComboBox jcb1, JComboBox jcb2, JLabel TrangNV) {
        long trang1 = Long.parseLong(TrangNV.getText());
        if (trang1 < SoTrang(jcb1, findnv, jcb2)) {
            trang1++;
            TrangNV.setText("" + trang1);
            VeTableNV(jxt, trang1, jcb1, findnv, jcb2);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JTextField findnv, JComboBox jcb1, JComboBox jcb2, JLabel TrangNV) {
        TrangNV.setText("1");
        long trang1 = Long.parseLong(TrangNV.getText());
        VeTableNV(jxt, trang1, jcb1, findnv, jcb2);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JTextField findnv, JComboBox jcb1, JComboBox jcb2, JLabel TrangNV) {
        long trang1 = 1;
        if (SoTrang(jcb1, findnv, jcb2) != 0) {
            trang1 = SoTrang(jcb1, findnv, jcb2);
        }
        TrangNV.setText("" + trang1);
        VeTableNV(jxt, trang1, jcb1, findnv, jcb2);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JTextField findnv, JComboBox jcb1, JComboBox jcb2, JLabel TrangNV) {
        long trang1 = Long.parseLong(TrangNV.getText());
        if (trang1 > 1) {
            trang1--;
            TrangNV.setText("" + trang1);
            VeTableNV(jxt, trang1, jcb1, findnv, jcb2);
        }
    }

    public void EditNVAdmin(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String manv = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            NhanVien nv = controll.eNhanVien(manv);
            PanelEditNhanVien as = new PanelEditNhanVien(Run.pma, true, nv);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn nhiều hơn 1 hoặc chưa chọn!");
        }
    }

    public void SetEditNV(NhanVien nv, JLabel Ma, JLabel HoTen, JLabel Ngaysinh, JLabel gioitinh, JTextField CMND, JTextField Diachi, JTextField Email, JTextField Dienthoai, JLabel tendangnhap, JLabel ngaytao, JComboBox Phanquyen, JComboBox Trangthai, JLabel anh) {
        Ma.setText("" + nv.getMaNhanVien());
        HoTen.setText(nv.getHoTen());
        Ngaysinh.setText(new SimpleDateFormat("dd-MM-yyyy").format(nv.getNgaySinh()));
        gioitinh.setText(ControllerCheck.SexString(nv.getGioiTinh()));
        CMND.setText(nv.getCMND());
        Diachi.setText(nv.getDiaChi());
        Email.setText(nv.getEmail());
        Dienthoai.setText(nv.getDienThoai());
        tendangnhap.setText(nv.getTendangnhap());
        ngaytao.setText(new SimpleDateFormat("dd-MM-yyyy").format(nv.getNgayTao()));
        if (nv.getPhanQuyen() == 1) {
            Phanquyen.setSelectedItem("Administrator");
        } else {
            Phanquyen.setSelectedItem("Nhân Viên");
        }
        if (nv.getTrangThai() == 1) {
            Trangthai.setSelectedItem("Đang Làm");
        } else {
            Trangthai.setSelectedItem("Đã Nghỉ");
        }
        anh.setIcon(new ImageIcon(new ImageIcon(nv.getAnh()).getImage().getScaledInstance(114, 151, Image.SCALE_AREA_AVERAGING)));
    }

    public int upDateAnh(int MaNV, String CMND, String Anh, String DienThoai, String DiaChi, String Email, String TrangThai, String PhanQuyen) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE NhanVien SET CMND=?, Anh=?, DiaChi=?,DienThoai=?,Email=?,TrangThai=?,PhanQuyen=? WHERE MaNhanVien=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, CMND);
            ps.setBytes(2, ControllerCheck.ConvertFile(Anh));
            ps.setString(3, DiaChi);
            ps.setString(4, DienThoai);
            ps.setString(5, Email);
            ps.setInt(6, ControllerCheck.StatusIntNhanVien(TrangThai));
            ps.setInt(7, ControllerCheck.DecentralizationInt(PhanQuyen));
            ps.setInt(8, MaNV);
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

    public int upDateKoAnh(int MaNV, String CMND, String DienThoai, String DiaChi, String Email, String TrangThai, String PhanQuyen) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE NhanVien SET CMND=?, DiaChi=?,DienThoai=?,Email=?,TrangThai=?,PhanQuyen=? WHERE MaNhanVien=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, CMND);
            ps.setString(2, DiaChi);
            ps.setString(3, DienThoai);
            ps.setString(4, Email);
            ps.setInt(5, ControllerCheck.StatusIntNhanVien(TrangThai));
            ps.setInt(6, ControllerCheck.DecentralizationInt(PhanQuyen));
            ps.setInt(7, MaNV);
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

    public boolean CheckCMNDNV(String CMND, int MaNhanVien) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where MaNhanVien!=? and CMND=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNhanVien);
            ps.setString(2, CMND);
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

    public boolean CheckEmailNV(String Email, int MaNhanVien) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where MaNhanVien!=? and Email=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNhanVien);
            ps.setString(2, Email);
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

    public boolean CheckDienThoaiNV(String DienThoai, int MaNV) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where MaNV!=? and DienThoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNV);
            ps.setString(2, DienThoai);
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

    public void UpdateNVAdmin(JTextField CMND, String AnhMoi, JTextField DiaChi, JTextField DienThoai, JTextField Email, JComboBox trangthai, JComboBox phanquyen, int MaNV, PanelEditNhanVien penv) {
        String cmnd = CMND.getText().trim();
        String diachi = DiaChi.getText().trim();
        String dienthoai = DienThoai.getText().trim();
        String mail = Email.getText().trim();
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không được để trống!");
            CMND.requestFocus();
            return;
        }
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
            DiaChi.requestFocus();
            return;
        }
        if (dienthoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại không được để trống!");
            DienThoai.requestFocus();
            return;
        }
        if (mail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống!");
            Email.requestFocus();
            return;
        }
        if (ControllerCheck.checkCMND(cmnd) == false) {
            JOptionPane.showMessageDialog(null, "Chứng minh nhân dân không đúng!");
            CMND.requestFocus();
            return;
        }
        if (ControllerCheck.checkTel(dienthoai) == false) {
            JOptionPane.showMessageDialog(null, "Điện thoại không đúng!");
            DienThoai.requestFocus();
            return;
        }
        if (ControllerCheck.checkEmail(mail) == false) {
            JOptionPane.showMessageDialog(null, "Email không đúng!");
            Email.requestFocus();
            return;
        }
        if (CheckCMNDNV(cmnd, MaNV) == false) {
            JOptionPane.showMessageDialog(null, "Số CMND đã được đăng ký!");
            CMND.requestFocus();
            return;
        }
        if (CheckDienThoaiNV(dienthoai, MaNV) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại đã được đăng ký!");
            DienThoai.requestFocus();
            return;
        }
        if (CheckEmailNV(mail, MaNV) == false) {
            JOptionPane.showMessageDialog(null, "Email đã được đăng ký!");
            Email.requestFocus();
            return;
        }
        if (AnhMoi.isEmpty()) {
            if (upDateKoAnh(MaNV, cmnd, dienthoai, diachi, mail, trangthai.getSelectedItem().toString(), phanquyen.getSelectedItem().toString()) != 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                penv.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật nhân viên không thành công!");
            }
        } else {
            File f = new File(AnhMoi);
            String mimetype = new MimetypesFileTypeMap().getContentType(f);
            if (mimetype.startsWith("image/")) {
                if (upDateAnh(MaNV, cmnd, AnhMoi, dienthoai, diachi, mail, trangthai.getSelectedItem().toString(), phanquyen.getSelectedItem().toString()) != 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công!");
                    penv.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật nhân viên không thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
            }
        }
    }

    public boolean CheckNewTendangnhap(String Tendangnhap) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where Tendangnhap=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, Tendangnhap);
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

    public boolean CheckNewCMND(String CMND) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where CMND=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, CMND);
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

    public boolean CheckNewEmail(String Email) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhanVien where Tendangnhap=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, Email);
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

    public int NewNV(String Hoten, String CMND, String Anh, String DiaChi, String DienThoai, String Email, Date NgaySinh, String GioiTinh, String Tendangnhap, String PhanQuyen) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        String MatKhau = "123456";
        java.sql.Date ngaysinh = new java.sql.Date(NgaySinh.getTime());
        java.sql.Date ngaytao = new java.sql.Date(new Date().getTime());
        try {
            String sqlCommand = "INSERT INTO NhanVien(HoTen,CMND,Anh,DiaChi,DienThoai,Email,NgaySinh,GioiTinh,NgayTao,Tendangnhap,MatKhau,PhanQuyen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, Hoten);
            ps.setString(2, CMND);
            ps.setBytes(3, ControllerCheck.ConvertFile(Anh));
            ps.setString(4, DiaChi);
            ps.setString(5, DienThoai);
            ps.setString(6, Email);
            ps.setDate(7, ngaysinh);
            ps.setInt(8, ControllerCheck.SexInt(GioiTinh));
            ps.setDate(9, ngaytao);
            ps.setString(10, Tendangnhap);
            ps.setString(11, MD5Encryption.encryptMD5(MatKhau));
            ps.setInt(12, ControllerCheck.DecentralizationInt(PhanQuyen));
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Giải phóng tài anguyên
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

    public void NewNVAdmin(JTextField HoTen, JTextField CMND, String Anh, JTextField DiaChi, JTextField DienThoai, JTextField Email, JDateChooser NgaySinh, JComboBox GioiTinh, JTextField Tendangnhap, JComboBox PhanQuyen, PanelNewNhanVien pnn) {
        String hoten = HoTen.getText().trim();
        String cmnd = CMND.getText().trim();
        String diachi = DiaChi.getText().trim();
        String dienthoai = DienThoai.getText().trim();
        String email = Email.getText().trim();
        String tendangnhap = Tendangnhap.getText().trim();
        String gioitinh = GioiTinh.getSelectedItem().toString();
        String phanquyen = PhanQuyen.getSelectedItem().toString();
        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
            HoTen.requestFocus();
            return;
        }
        Date NgaySinhDate = NgaySinh.getDate();
        if (NgaySinhDate.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
            NgaySinh.requestFocus();
            return;
        }
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CMND không được để trống!");
            CMND.requestFocus();
            return;
        }
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
            DiaChi.requestFocus();
            return;
        }
        if (dienthoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại không được để trống!");
            DienThoai.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống!");
            Email.requestFocus();
            return;
        }
        if (tendangnhap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống!");
            Tendangnhap.requestFocus();
            return;
        }
        if (Anh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ảnh không được để trống!");
            return;
        }
        if (ControllerCheck.checkCMND(cmnd) == false) {
            JOptionPane.showMessageDialog(null, "CMND không đúng định dạng!");
            CMND.requestFocus();
            return;
        }
        if (NgaySinhDate.after(new Date())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được quá ngày hiện tại!");
            NgaySinh.requestFocus();
            return;
        }
        if (ControllerCheck.checkTel(dienthoai) == false) {
            JOptionPane.showMessageDialog(null, "Điện thoại không đúng định dạng!");
            DienThoai.requestFocus();
            return;
        }
        if (ControllerCheck.checkEmail(email) == false) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
            Email.requestFocus();
            return;
        }
        File f = new File(Anh);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        if (mimetype.startsWith("image/")) {
            if (NewNV(hoten, cmnd, Anh, diachi, dienthoai, email, NgaySinhDate, gioitinh, tendangnhap, phanquyen) != 0) {
                JOptionPane.showMessageDialog(null, "Thêm mới Nhân Viên thành công!");
                pnn.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới Nhân Viên không thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
        }
    }

    public boolean CheckDelNV(String MaNV) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM PhieuMuon WHERE MaNhanVien = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNV);
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

    public void countDelNV(String MaNV) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNV);
            int condelnv = ps.executeUpdate();
            if (condelnv != 0) {
                JOptionPane.showMessageDialog(null, "Xoá thành công Nhân viên!");
            } else {
                JOptionPane.showMessageDialog(null, "Xoá nhân viên không thành công!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "KXoá nhân viên không thành công!");
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
    }

    public void DelNV(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countNV = jxt.getSelectedRowCount();
        if (countNV == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Nhân Viên?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaNV = jxt.getValueAt(numberDelRow, 0).toString();
                if (MaNV.equalsIgnoreCase("" + Run.nv.getMaNhanVien())) {
                    JOptionPane.showMessageDialog(null, "Không thể xoá bản thân được");
                    return;
                } else {
                    if (CheckDelNV(MaNV) == true) {
                        countDelNV(MaNV);
                    } else {
                        JOptionPane.showMessageDialog(null, "Không thể xoá Nhân viên");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa");
        }
    }

    public int NewNVFirst(String Hoten, String CMND, String Anh, String DiaChi, String DienThoai, String Email, Date NgaySinh, String GioiTinh, String Tendangnhap, String MatKhau) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        java.sql.Date ngaysinh = new java.sql.Date(NgaySinh.getTime());
        java.sql.Date ngaytao = new java.sql.Date(new Date().getTime());
        try {
            String sqlCommand = "INSERT INTO NhanVien(HoTen,CMND,Anh,DiaChi,DienThoai,Email,NgaySinh,GioiTinh,NgayTao,Tendangnhap,MatKhau,PhanQuyen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, Hoten);
            ps.setString(2, CMND);
            ps.setBytes(3, ControllerCheck.ConvertFile(Anh));
            ps.setString(4, DiaChi);
            ps.setString(5, DienThoai);
            ps.setString(6, Email);
            ps.setDate(7, ngaysinh);
            ps.setInt(8, ControllerCheck.SexInt(GioiTinh));
            ps.setDate(9, ngaytao);
            ps.setString(10, Tendangnhap);
            ps.setString(11, MD5Encryption.encryptMD5(MatKhau));
            ps.setInt(12, 1);
            i = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ControllerNhanVien.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Giải phóng tài anguyên
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

    public void NewNVAdminFirst(JTextField HoTen, JTextField CMND, String Anh, JTextField DiaChi, JTextField DienThoai, JTextField Email, JDateChooser NgaySinh, JComboBox GioiTinh, JTextField Tendangnhap, JPasswordField MatKhau, PanelNewNhanVienFirst pnnf) {
        String hoten = HoTen.getText().trim();
        String cmnd = CMND.getText().trim();
        String diachi = DiaChi.getText().trim();
        String dienthoai = DienThoai.getText().trim();
        String email = Email.getText().trim();
        String tendangnhap = Tendangnhap.getText().trim();
        String matkhau = new String(MatKhau.getPassword());
        String gioitinh = GioiTinh.getSelectedItem().toString();
        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
            HoTen.requestFocus();
            return;
        }
        Date NgaySinhDate = NgaySinh.getDate();
        if (NgaySinhDate.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!");
            NgaySinh.requestFocus();
            return;
        }
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CMND không được để trống!");
            CMND.requestFocus();
            return;
        }
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
            DiaChi.requestFocus();
            return;
        }
        if (dienthoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại không được để trống!");
            DienThoai.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email không được để trống!");
            Email.requestFocus();
            return;
        }
        if (tendangnhap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống!");
            Tendangnhap.requestFocus();
            return;
        }
        if (matkhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống!");
            MatKhau.requestFocus();
            return;
        }
        if (Anh.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ảnh không được để trống!");
            return;
        }
        if (ControllerCheck.checkCMND(cmnd) == false) {
            JOptionPane.showMessageDialog(null, "CMND không đúng định dạng!");
            CMND.requestFocus();
            return;
        }
        if (NgaySinhDate.after(new Date())) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không được quá ngày hiện tại!");
            NgaySinh.requestFocus();
            return;
        }
        if (ControllerCheck.checkTel(dienthoai) == false) {
            JOptionPane.showMessageDialog(null, "Điện thoại không đúng định dạng!");
            DienThoai.requestFocus();
            return;
        }
        if (ControllerCheck.checkEmail(email) == false) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
            Email.requestFocus();
            return;
        }
        File f = new File(Anh);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        if (mimetype.startsWith("image/")) {
            if (NewNVFirst(hoten, cmnd, Anh, diachi, dienthoai, email, NgaySinhDate, gioitinh, tendangnhap, matkhau) != 0) {
                JOptionPane.showMessageDialog(null, "Thêm mới Nhân Viên thành công!");
                Run.Loading();
                pnnf.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới Nhân Viên không thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
        }
    }
}
