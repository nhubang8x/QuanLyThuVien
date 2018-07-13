/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.BanDoc;
import Views.BanDoc.PanelChiTietBanDoc;
import Views.BanDoc.PanelEditBanDoc;
import Views.BanDoc.PanelTangCuoc;
import Views.BanDoc.PanelGiaHan;
import Views.BanDoc.PanelNewBanDoc;
import Views.Run;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy Thắng
 */
public class ControllerBanDoc {

    DefaultTableModel dtm, dtmList;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    long countList, sotrangList;
    ControllerCheck cc;

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
                    sqlCommand = "select count(*) from BanDoc";
                    ps = connect.prepareStatement(sqlCommand);
                } else {
                    sqlCommand = "select count(*) from BanDoc where TrangThai = ?";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from BanDoc where MaBanDoc LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from BanDoc where TrangThai = ? and MaBanDoc LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(2, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Tên Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from BanDoc where HoTen LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from BanDoc where TrangThai = ? and HoTen LIKE ?";
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
        if (count == 0) {
            sotrang = 1;
        } else {
            if (count % 10 == 0) {
                sotrang = count / 10;
            } else {
                sotrang = count / 10 + 1;
            }
        }
        return sotrang;
    }

    public void VeTableBD(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox jcb1, JTextField find, JComboBox jcb2) {
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
            String sqlCommand = null;
            if (search.equals("")) {
                if (cb2.equals("Tất cả")) {
                    sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                            + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                            + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                            + "from BanDoc "
                            + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc order by MaBanDoc asc) "
                            + "order by MaBanDoc asc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                } else {
                    sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                            + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                            + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                            + "from BanDoc "
                            + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc where TrangThai = ? order by MaBanDoc asc) "
                            + "and TrangThai = ? order by MaBanDoc asc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                    ps.setInt(2, ControllerCheck.ChoosenFind(cb2));
                    ps.setInt(3, ControllerCheck.ChoosenFind(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                                + "from BanDoc "
                                + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc where MaBanDoc LIKE ? order by MaBanDoc asc) "
                                + "and MaBanDoc LIKE ? order by MaBanDoc asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                                + "from BanDoc "
                                + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc where TrangThai = ? and MaBanDoc LIKE ? order by MaBanDoc asc) "
                                + "and TrangThai = ? and MaBanDoc LIKE ? order by MaBanDoc asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.ChoosenFind(cb2));
                        ps.setString(5, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Tên Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                                + "from BanDoc "
                                + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc where HoTen LIKE ? order by MaBanDoc asc) "
                                + "and HoTen LIKE ? order by MaBanDoc asc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Họ Tên',CMND, DiaChi as 'Địa Chỉ', "
                                + "NgaySinh as 'Ngày Sinh', DienThoai as 'Điện thoại', Email as 'Email',GioiTinh as 'Giới Tính', "
                                + "NgayHetHan as 'Hạn Thẻ', TienCuoc as 'Tiền Cược', TrangThai as 'Trạng thái' "
                                + "from BanDoc "
                                + "where MaBanDoc not in (select top (? * 10 - 10) MaBanDoc from BanDoc where TrangThai = ? and HoTen LIKE ? order by MaBanDoc asc) "
                                + "and TrangThai = ? and HoTen LIKE ? order by MaBanDoc asc";
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
                v.add(8, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(9)));
                v.add(9, rs.getString(10));
                v.add(10, ControllerCheck.StatusStringBanDoc(rs.getInt(11)));
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        long trang1 = Long.parseLong(TrangBD.getText());
        if (trang1 < SoTrang(jcb1, find, jcb2)) {
            trang1++;
            TrangBD.setText("" + trang1);
            VeTableBD(jxt, trang1, jcb1, find, jcb2);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        TrangBD.setText("1");
        long trang1 = Long.parseLong(TrangBD.getText());
        VeTableBD(jxt, trang1, jcb1, find, jcb2);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        long trang1 = 1;
        if (SoTrang(jcb1, find, jcb2) != 0) {
            trang1 = SoTrang(jcb1, find, jcb2);
        }
        TrangBD.setText("" + trang1);
        VeTableBD(jxt, trang1, jcb1, find, jcb2);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        long trang1 = Long.parseLong(TrangBD.getText());
        if (trang1 > 1) {
            trang1--;
            TrangBD.setText("" + trang1);
            VeTableBD(jxt, trang1, jcb1, find, jcb2);
        }
    }

    public void EditBanDoc(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countBanDoc = jxt.getSelectedRowCount();
        if (countBanDoc == 1) {
            String mabd = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            BanDoc bd = controll.eBanDoc(mabd);
            PanelEditBanDoc as = new PanelEditBanDoc(Run.pma, true, bd);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chưa chọn bạn đọc nào!");
        }
    }

    public void SetEditBD(BanDoc bd, JLabel ma, JLabel ten, JLabel ngaysinh, JLabel gioitinh, JTextField diachi, JLabel use, JTextField cmnd, JTextField tel, JTextField mail, JLabel tien, JComboBox tinhtrang, JLabel ngaylam, JLabel ngayhet, JLabel anh) {
        ma.setText("" + bd.getMaBanDoc());
        ten.setText("" + bd.getHoTen());
        ngaysinh.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgaySinh()));
        gioitinh.setText(ControllerCheck.SexString(bd.getGioiTinh()));
        diachi.setText(bd.getDiaChi());
        use.setText(bd.getTendangnhap());
        cmnd.setText(bd.getCMND());
        tel.setText(bd.getDienThoai());
        mail.setText(bd.getEmail());
        tien.setText("" + bd.getTienCuoc());
        tinhtrang.setSelectedItem(ControllerCheck.StatusStringBanDoc(bd.getTrangThai()));
        ngaylam.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgayTao()));
        ngayhet.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgayHetHan()));
        anh.setIcon(new ImageIcon(new ImageIcon(bd.getAnh()).getImage().getScaledInstance(114, 151, Image.SCALE_AREA_AVERAGING)));
    }

    public int upDateAnh(int MaBD, String CMND, String Anh, String DienThoai, String DiaChi, String Email, String TrangThai) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE BanDoc SET CMND=?, Anh=?, DiaChi=?,DienThoai=?,Email=?,TrangThai=? WHERE MaBanDoc=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, CMND);
            ps.setBytes(2, ControllerCheck.ConvertFile(Anh));
            ps.setString(3, DiaChi);
            ps.setString(4, DienThoai);
            ps.setString(5, Email);
            ps.setInt(6, ControllerCheck.StatusIntBanDoc(TrangThai));
            ps.setInt(7, MaBD);
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

    public int upDateKoAnh(int MaBD, String CMND, String DienThoai, String DiaChi, String Email, String TrangThai) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE BanDoc SET CMND=?, DiaChi=?,DienThoai=?,Email=?,TrangThai=? WHERE MaBanDoc=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, CMND);
            ps.setString(2, DiaChi);
            ps.setString(3, DienThoai);
            ps.setString(4, Email);
            ps.setInt(5, ControllerCheck.StatusIntBanDoc(TrangThai));
            ps.setInt(6, MaBD);
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

    public boolean CheckCMNDBanDoc(String CMND, int MaBD) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where MaBD!=? and CMND=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBD);
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

    public boolean CheckDienThoaiBanDoc(String DienThoai, int MaBD) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where MaBD!=? and DienThoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBD);
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

    public boolean CheckEmailBanDoc(String email, int MaBD) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where MaBD!=? and Email=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBD);
            ps.setString(2, email);
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

    public void UpdateBDAdmin(JTextField CMND, String AnhMoi, JTextField DiaChi, JTextField DienThoai, JTextField Email, JComboBox trangthai, int MaBD, PanelEditBanDoc pebd) {
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
        if (CheckCMNDBanDoc(cmnd, MaBD) == false) {
            JOptionPane.showMessageDialog(null, "Số CMND đã được đăng ký!");
            CMND.requestFocus();
            return;
        }
        if (CheckDienThoaiBanDoc(dienthoai, MaBD) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại đã được đăng ký!");
            DienThoai.requestFocus();
            return;
        }
        if (CheckEmailBanDoc(mail, MaBD) == false) {
            JOptionPane.showMessageDialog(null, "Email đã được đăng ký!");
            Email.requestFocus();
            return;
        }
        if (AnhMoi.isEmpty()) {
            if (upDateKoAnh(MaBD, cmnd, dienthoai, diachi, mail, trangthai.getSelectedItem().toString()) != 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                pebd.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
            }
        } else {
            File f = new File(AnhMoi);
            String mimetype = new MimetypesFileTypeMap().getContentType(f);
            if (mimetype.startsWith("image/")) {
                if (upDateAnh(MaBD, cmnd, AnhMoi, dienthoai, diachi, mail, trangthai.getSelectedItem().toString()) != 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                    pebd.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
                return;
            }
        }
    }

    public boolean CheckNewCMND(String CMND) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where CMND=?";
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

    public boolean CheckNewDienThoai(String DienThoai) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where DienThoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, DienThoai);
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

    public boolean CheckNewTenDangNhap(String TenDangNhap) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from BanDoc where Tendangnhap=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenDangNhap);
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
            String sqlCommand = "select count(*) from BanDoc where Email=?";
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

    public int NewBanDoc(String Hoten, String CMND, String Anh, String DiaChi, String DienThoai, String Email, String TienCuoc, Date NgaySinh, String GioiTinh, String NgayTao, String NgayHetHan, String Tendangnhap) {
        con = new ConnectionDB();
        connect = con.connect();
        String MatKhau = "123456";
        int i = 0;
        java.sql.Date Ngaysinh = new java.sql.Date(NgaySinh.getTime());
        try {
            String sqlCommand = "INSERT INTO BanDoc(Tendangnhap,MatKhau,HoTen,CMND,Anh,DiaChi,DienThoai,Email,TienCuoc,NgaySinh,GioiTinh,NgayTao,NgayHetHan) VALUES (?,?,?,?,?,?,?,?,?,?,?,GETDATE(),DATEADD(YY,1,GETDATE()))";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, Tendangnhap);
            ps.setString(2, MD5Encryption.encryptMD5(MatKhau));
            ps.setString(3, Hoten);
            ps.setString(4, CMND);
            ps.setBytes(5, ControllerCheck.ConvertFile(Anh));
            ps.setString(6, DiaChi);
            ps.setString(7, DienThoai);
            ps.setString(8, Email);
            ps.setString(9, TienCuoc);
            ps.setDate(10, Ngaysinh);
            ps.setInt(11, ControllerCheck.SexInt(GioiTinh));
            i = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void NewBanDocAdmin(JTextField Hoten, JTextField CMND, String Anh, JTextField DiaChi, JTextField DienThoai, JTextField Email, JLabel TienCuoc, JDateChooser NgaySinh, JComboBox GioiTinh, JLabel NgayTao, JLabel NgayHetHan, JTextField Tendangnhap, PanelNewBanDoc pnn) {
        String hoten = Hoten.getText().trim();
        String cmnd = CMND.getText().trim();
        String diachi = DiaChi.getText().trim();
        String tel = DienThoai.getText().trim();
        String mail = Email.getText().trim();
        String tiencuoc = TienCuoc.getText().trim();
        String ngaytao = NgayTao.getText().trim();
        String ngayhethan = NgayHetHan.getText().trim();
        String tendangnhap = Tendangnhap.getText().trim();
        String gioitinh = GioiTinh.getSelectedItem().toString();
        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Họ tên không được để trống!");
            Hoten.requestFocus();
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
        if (tel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại không được để trống!");
            DienThoai.requestFocus();
            return;
        }
        if (mail.isEmpty()) {
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
        if (ControllerCheck.checkTel(tel) == false) {
            JOptionPane.showMessageDialog(null, "Điện thoại không đúng định dạng!");
            DienThoai.requestFocus();
            return;
        }
        if (ControllerCheck.checkEmail(mail) == false) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
            Email.requestFocus();
            return;
        }
        if (CheckNewCMND(cmnd) == false) {
            JOptionPane.showMessageDialog(null, "CMND đã được đăng ký!");
            CMND.requestFocus();
            return;
        }
        if (CheckNewDienThoai(tel) == false) {
            JOptionPane.showMessageDialog(null, "Điện thoại đã được đăng ký!");
            DienThoai.requestFocus();
            return;
        }
        if (CheckNewEmail(mail) == false) {
            JOptionPane.showMessageDialog(null, "Email đã được đăng ký!");
            Email.requestFocus();
            return;
        }
        if (CheckNewTenDangNhap(tendangnhap) == false) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã được đăng ký!");
            Tendangnhap.requestFocus();
            return;
        }
        File f = new File(Anh);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        if (mimetype.startsWith("image/")) {
            if (NewBanDoc(hoten, cmnd, Anh, diachi, tel, mail, tiencuoc, NgaySinhDate, gioitinh, ngaytao, ngayhethan, tendangnhap) != 0) {
                JOptionPane.showMessageDialog(null, "Thêm mới Bạn Đọc thành công!");
                pnn.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm mới Bạn Đọc không thành công!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Upload không phải file ảnh");
        }
    }

    public boolean CheckDelBanDoc(String MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM PhieuMuon WHERE MaBanDoc = ?";
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

    public int countDelBanDoc(String MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        int del = 0;
        try {
            String sqlCommand = "DELETE FROM BanDoc WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaBanDoc);
            del = ps.executeUpdate();
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
        return del;
    }

    public void DelBanDoc(org.jdesktop.swingx.JXTable jxt) {
        int countbd = jxt.getSelectedRowCount();
        if (countbd == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Bạn Đọc?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaBanDoc = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelBanDoc(MaBanDoc) == true) {
                    if (countDelBanDoc(MaBanDoc) != 0) {
                        JOptionPane.showMessageDialog(null, "Xoá bạn đọc thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Xoá bạn đọc không thành công!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể xoá bạn đọc!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa");
        }
    }

    public void DetailBanDoc(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String mabd = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            BanDoc bd = controll.eBanDoc(mabd);
            PanelChiTietBanDoc as = new PanelChiTietBanDoc(Run.pma, true, bd);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chưa chọn bạn đọc nào!");
        }
    }

    public void SetDetailBD(BanDoc bd, JLabel ma, JLabel ten, JLabel ngaysinh, JLabel gioitinh, JTextArea diachi, JLabel use, JLabel cmnd, JLabel tel, JLabel mail, JLabel tien, JLabel tinhtrang, JLabel ngaylam, JLabel ngayhet, JLabel anh) {
        ma.setText("" + bd.getMaBanDoc());
        ten.setText("" + bd.getHoTen());
        ngaysinh.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgaySinh()));
        gioitinh.setText(ControllerCheck.SexString(bd.getGioiTinh()));
        diachi.setText(bd.getDiaChi());
        use.setText(bd.getTendangnhap());
        cmnd.setText(bd.getCMND());
        tel.setText(bd.getDienThoai());
        mail.setText(bd.getEmail());
        tien.setText("" + bd.getTienCuoc());
        tinhtrang.setText(ControllerCheck.StatusStringBanDoc(bd.getTrangThai()));
        ngaylam.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgayTao()));
        ngayhet.setText(new SimpleDateFormat("dd-MM-yyyy").format(bd.getNgayHetHan()));
        anh.setIcon(new ImageIcon(new ImageIcon(bd.getAnh()).getImage().getScaledInstance(114, 151, Image.SCALE_AREA_AVERAGING)));
    }

    public void CountListSachMuon(int MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand;
            sqlCommand = "select count(*) from ChiTietPhieuMuon join PhieuMuon "
                    + "on ChiTietPhieuMuon.MaPhieuMuon=PhieuMuon.MaPhieuMuon "
                    + "where PhieuMuon.MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                countList = rs.getLong(1);
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

    public long SoTrangListSachMuon(int MaBanDoc) {
        CountListSachMuon(MaBanDoc);
        if (countList == 0) {
            sotrang = 1;
        } else {
            if (countList % 10 == 0) {
                sotrangList = countList / 10;
            } else {
                sotrangList = countList / 10 + 1;
            }
        }
        return sotrangList;
    }

    public void LoadListSachMuon(org.jdesktop.swingx.JXTable jxt, long trang, int MaBanDoc) {
        SoTrangListSachMuon(MaBanDoc);
        con = new ConnectionDB();
        connect = con.connect();
        dtmList = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "select top 10 ChiTietPhieuMuon.MaPhieuMuon as 'Mã Phiếu Mượn', TenSach as 'Tên sách', NgayMuon as 'Ngày Mượn', NgayTra as 'Ngày Trả', TrangThaiSach as 'Trạng Thái' "
                    + "from ChiTietPhieuMuon join PhieuMuon on ChiTietPhieuMuon.MaPhieuMuon = PhieuMuon.MaPhieuMuon "
                    + "join Sach on ChiTietPhieuMuon.MaSach = Sach.MaSach "
                    + "where PhieuMuon.MaPhieuMuon not in (select top (? * 10 - 10) PhieuMuon.MaPhieuMuon from ChiTietPhieuMuon join PhieuMuon on ChiTietPhieuMuon.MaPhieuMuon = PhieuMuon.MaPhieuMuon where PhieuMuon.MaBanDoc = ? order by PhieuMuon.MaPhieuMuon asc) "
                    + "and PhieuMuon.MaBanDoc = ? "
                    + "order by ChiTietPhieuMuon.MaPhieuMuon asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            ps.setInt(2, MaBanDoc);
            ps.setInt(3, MaBanDoc);
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
                v.add(3, rs.getDate(4) == null ? ("--/--/----") : (new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(4))));
                v.add(4, ControllerCheck.StatusStringCTPhieuMuon(rs.getInt(5)));
                dtmList.addRow(v);
            }
            jxt.setModel(dtmList);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void NextButtonList(org.jdesktop.swingx.JXTable jxt, JLabel TrangList, int MaBanDoc) {
        long trang1 = Long.parseLong(TrangList.getText());
        if (trang1 < SoTrangListSachMuon(MaBanDoc)) {
            trang1++;
            TrangList.setText("" + trang1);
            LoadListSachMuon(jxt, trang1, MaBanDoc);
        }
    }

    public void PreButtonList(org.jdesktop.swingx.JXTable jxt, JLabel TrangList, int MaBanDoc) {
        long trang1 = Long.parseLong(TrangList.getText());
        if (trang1 > 1) {
            trang1--;
            TrangList.setText("" + trang1);
            LoadListSachMuon(jxt, trang1, MaBanDoc);
        }
    }

    public void TangCuoc(org.jdesktop.swingx.JXTable jxt) {
        int countBanDoc = jxt.getSelectedRowCount();
        if (countBanDoc == 1) {
            String mabd = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            BanDoc bd = controll.eBanDoc(mabd);
            PanelTangCuoc nj = new PanelTangCuoc(Run.pma, true, bd);
            nj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chưa chọn bạn đọc nào!");
        }
    }

    public void TangCuocAdmin(JLabel cuoc1, JTextField cuoc2, int MaBanDoc, int Tcuoc1, JDialog jdl) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        int Tcuoc2 = 0;
        try {
            Tcuoc2 = Integer.parseInt(cuoc2.getText());
        } catch (Exception e) {
            check = false;
        }
        if (cuoc2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập gì!");
            cuoc2.requestFocus();
            return;
        }
        if (check == false) {
            JOptionPane.showMessageDialog(null, "Bạn nhập vào không phải là số!");
            cuoc2.requestFocus();
            return;
        }
        if (Tcuoc2 <= 0) {
            JOptionPane.showMessageDialog(null, "Tiền tăng cược không được là số âm!");
            cuoc2.requestFocus();
            return;
        }
        int TongCuocMoi = Tcuoc1 + Tcuoc2;
        try {
            String sqlCommand = "UPDATE BanDoc SET TienCuoc = ? WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, "" + TongCuocMoi);
            ps.setInt(2, MaBanDoc);
            int i = ps.executeUpdate();
            if (i != 0) {
                JOptionPane.showMessageDialog(null, "Thêm tiền cược thành công!");
                jdl.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm tiền cược không thành công!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void GiaHan(org.jdesktop.swingx.JXTable jxt) {
        int countBanDoc = jxt.getSelectedRowCount();
        if (countBanDoc == 1) {
            String mabd = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            BanDoc bd = controll.eBanDoc(mabd);
            PanelGiaHan nj = new PanelGiaHan(Run.pma, true, bd);
            nj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chưa chọn bạn đọc nào!");
        }
    }

    public void GiaHanAdmin(JLabel hanmoi, int MaBanDoc, JDialog jdl) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(hanmoi.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            String sqlCommand = "UPDATE BanDoc SET NgayHetHan = ?, TrangThai=1 WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setDate(1, sqlDate);
            ps.setInt(2, MaBanDoc);
            int count1 = ps.executeUpdate();
            if (count1 != 0) {
                JOptionPane.showMessageDialog(null, "Gia Hạn thành công!");
                jdl.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Gia hạn không thành công!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void ReMatKhau(String MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE BanDoc SET MatKhau = ? WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MD5Encryption.encryptMD5("123456"));
            ps.setString(2, MaBanDoc);
            int count1 = ps.executeUpdate();
            if (count1 != 0) {
                JOptionPane.showMessageDialog(null, "Resert thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Resert không thành công!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanDoc.class.getName()).log(Level.SEVERE, null, ex);
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

    public void ReMatKhauAdmin(org.jdesktop.swingx.JXTable jxt) {
        int countbd = jxt.getSelectedRowCount();
        if (countbd == 1) {
            int numberDelRow = jxt.getSelectedRow();
            String MaBanDoc = jxt.getValueAt(numberDelRow, 0).toString();
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn Resert Mật Khẩu Bạn Đọc có Mã" + MaBanDoc + "?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                ReMatKhau(MaBanDoc);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để Resert Mật Khẩu!");
        }
    }
}
