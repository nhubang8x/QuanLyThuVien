/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.BanDoc;
import Models.PhieuMuon;
import Views.PanelMainBanDoc;
import Views.PhieuMuon.PanelChiTietPM;
import Views.PhieuMuon.PanelNewPhieuMuon;
import Views.PhieuMuon.PanelTraPM;
import Views.Run;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerPhieuMuon {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang, countBanDoc, sotrangBanDoc;
    ControllerCheck cc;

    public void countDbBanDoc(JComboBox jcb1, int MaBanDoc) {
        con = new ConnectionDB();
        connect = con.connect();
        String cb1 = jcb1.getSelectedItem().toString().trim();
        try {
            String sqlCommand = "select count(*) from PhieuMuon where TrangThai = ? and MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, ControllerCheck.ChoosenFind(cb1));
            ps.setInt(2, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                countBanDoc = rs.getLong(1);
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

    public long SoTrangBanDoc(JComboBox jcb1, int MaBanDoc) {
        countDbBanDoc(jcb1, MaBanDoc);
        if (countBanDoc == 0) {
            sotrangBanDoc = 1;
        } else {
            if (countBanDoc % 10 == 0) {
                sotrangBanDoc = countBanDoc / 10;
            } else {
                sotrangBanDoc = countBanDoc / 10 + 1;
            }
        }
        return sotrangBanDoc;
    }

    public void VeTablePMBanDoc(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox jcb1, int MaBanDoc) {
        countDbBanDoc(jcb1, MaBanDoc);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String cb1 = jcb1.getSelectedItem().toString().trim();
        try {
            String sqlCommand;
            if (cb1.equals("Tất Cả")) {
                sqlCommand = "select top 20 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                        + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                        + "PhieuMuon.TrangThai as 'Trạng thái' "
                        + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                        + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                        + "where MaPhieuMuon not in (select top (? * 20 - 20) MaPhieuMuon from PhieuMuon where PhieuMuon.MaBanDoc = ? order by MaPhieuMuon desc) "
                        + "and PhieuMuon.MaBanDoc = ? order by MaPhieuMuon desc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
                ps.setInt(2, MaBanDoc);
                ps.setInt(3, MaBanDoc);
            } else {
                sqlCommand = "select top 20 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                        + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                        + "PhieuMuon.TrangThai as 'Trạng thái' "
                        + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                        + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                        + "where MaPhieuMuon not in (select top (? * 20 - 20) MaPhieuMuon from PhieuMuon where PhieuMuon.TrangThai = ? and PhieuMuon.MaBanDoc = ? order by MaPhieuMuon desc) "
                        + "and PhieuMuon.TrangThai = ? and PhieuMuon.MaBanDoc = ? order by MaPhieuMuon desc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
                ps.setInt(2, ControllerCheck.StatusIntPhieuMuon(cb1));
                ps.setInt(3, MaBanDoc);
                ps.setInt(4, ControllerCheck.StatusIntPhieuMuon(cb1));
                ps.setInt(5, MaBanDoc);
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
                v.add(3, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(4)));
                v.add(4, rs.getDate(5) == null ? ("--/--/----") : (new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(5))));
                v.add(5, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(6)));
                v.add(6, rs.getString(7));
                v.add(7, ControllerCheck.StatusStringPhieuMuon(rs.getInt(8)));
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

    public void NextButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, int MaBanDoc, JLabel TrangBD) {
        long trang1 = Long.parseLong(TrangBD.getText());
        if (trang1 < SoTrangBanDoc(jcb1, MaBanDoc)) {
            trang1++;
            TrangBD.setText("" + trang1);
            VeTablePMBanDoc(jxt, trang1, jcb1, MaBanDoc);
        }
    }

    public void FirstButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, int MaBanDoc, JLabel TrangBD) {
        TrangBD.setText("1");
        long trang1 = Long.parseLong(TrangBD.getText());
        VeTablePMBanDoc(jxt, trang1, jcb1, MaBanDoc);
    }

    public void LastButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, int MaBanDoc, JLabel TrangBD) {
        long trang1 = SoTrangBanDoc(jcb1, MaBanDoc);
        TrangBD.setText("" + trang1);
        VeTablePMBanDoc(jxt, trang1, jcb1, MaBanDoc);
    }

    public void PreButtonBanDoc(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, int MaBanDoc, JLabel TrangBD) {
        long trang1 = Long.parseLong(TrangBD.getText());
        if (trang1 > 1) {
            trang1--;
            TrangBD.setText("" + trang1);
            VeTablePMBanDoc(jxt, trang1, jcb1, MaBanDoc);
        }
    }

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
                    sqlCommand = "select count(*) from PhieuMuon";
                    ps = connect.prepareStatement(sqlCommand);
                } else {
                    sqlCommand = "select count(*) from PhieuMuon where TrangThai = ?";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setInt(1, ControllerCheck.ChoosenFind(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã phiếu Mượn")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from PhieuMuon where MaPhieuMuon LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from PhieuMuon where TrangThai = ? and MaPhieuMuon LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(2, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Mã Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from PhieuMuon where MaBanDoc LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from PhieuMuon where TrangThai = ? and MaBanDoc LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(2, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Mã Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select count(*) from PhieuMuon where MaNhanVien LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setString(1, "%" + search + "%");
                    } else {
                        sqlCommand = "select count(*) from PhieuMuon where TrangThai = ? and MaNhanVien LIKE ?";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setInt(1, ControllerCheck.StatusIntPhieuMuon(cb2));
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

    public void VeTablePM(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox jcb1, JTextField find, JComboBox jcb2) {
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
                    sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                            + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                            + "PhieuMuon.TrangThai as 'Trạng thái' "
                            + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                            + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                            + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon order by MaPhieuMuon desc) "
                            + "order by MaPhieuMuon desc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                } else {
                    sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                            + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                            + "PhieuMuon.TrangThai as 'Trạng thái' "
                            + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                            + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                            + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where PhieuMuon.TrangThai = ? order by MaPhieuMuon desc) "
                            + "and PhieuMuon.TrangThai = ? order by MaPhieuMuon desc";
                    ps = connect.prepareStatement(sqlCommand);
                    ps.setLong(1, trang);
                    ps.setInt(2, ControllerCheck.StatusIntPhieuMuon(cb2));
                    ps.setInt(3, ControllerCheck.StatusIntPhieuMuon(cb2));
                }
            } else {
                if (cb1.equals("Theo Mã phiếu Mượn")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where MaPhieuMuon LIKE ? order by MaPhieuMuon desc) "
                                + "and MaPhieuMuon LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where PhieuMuon.TrangThai = ? and MaPhieuMuon LIKE ? order by MaPhieuMuon desc) "
                                + "and PhieuMuon.TrangThai = ? and MaPhieuMuon LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(5, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Mã Bạn Đọc")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where MaBanDoc LIKE ? order by MaPhieuMuon desc) "
                                + "and PhieuMuon.MaBanDoc LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where TrangThai = ? and MaBanDoc LIKE ? order by MaPhieuMuon desc) "
                                + "and PhieuMuon.TrangThai = ? and PhieuMuon.MaBanDoc LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(5, "%" + search + "%");
                    }
                } else if (cb1.equals("Theo Mã Nhân Viên")) {
                    if (cb2.equals("Tất cả")) {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where MaNhanVien LIKE ? order by MaPhieuMuon desc) "
                                + "and PhieuMuon.MaNhanVien LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setString(2, "%" + search + "%");
                        ps.setString(3, "%" + search + "%");
                    } else {
                        sqlCommand = "select top 10 MaPhieuMuon as 'Mã Phiếu Mượn',BanDoc.HoTen as 'Tên bạn đọc',NhanVien.HoTen as 'Tên nhân viên', "
                                + "NgayMuon as 'Ngày mượn', NgayTra as 'Ngày trả', HanTra as 'Hạn trả', TienPhat as 'Tiền phạt', "
                                + "PhieuMuon.TrangThai as 'Trạng thái' "
                                + "from PhieuMuon join BanDoc on PhieuMuon.MaBanDoc=BanDoc.MaBanDoc "
                                + "join NhanVien on PhieuMuon.MaNhanVien=NhanVien.MaNhanVien "
                                + "where MaPhieuMuon not in (select top (? * 10 - 10) MaPhieuMuon from PhieuMuon where TrangThai = ? and MaNhanVien LIKE ? order by MaPhieuMuon desc) "
                                + "and PhieuMuon.TrangThai = ? and PhieuMuon.MaNhanVien LIKE ? order by MaPhieuMuon desc";
                        ps = connect.prepareStatement(sqlCommand);
                        ps.setLong(1, trang);
                        ps.setInt(2, ControllerCheck.StatusIntPhieuMuon(cb2));
                        ps.setString(3, "%" + search + "%");
                        ps.setInt(4, ControllerCheck.StatusIntPhieuMuon(cb2));
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
                v.add(3, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(4)));
                v.add(4, rs.getDate(5) == null ? ("--/--/----") : (new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(5))));
                v.add(5, new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(6)));
                v.add(6, rs.getString(7));
                v.add(7, ControllerCheck.StatusStringPhieuMuon(rs.getInt(8)));
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
            VeTablePM(jxt, trang1, jcb1, find, jcb2);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        TrangBD.setText("1");
        long trang1 = Long.parseLong(TrangBD.getText());
        VeTablePM(jxt, trang1, jcb1, find, jcb2);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        long trang1 = SoTrang(jcb1, find, jcb2);
        TrangBD.setText("" + trang1);
        VeTablePM(jxt, trang1, jcb1, find, jcb2);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JComboBox jcb1, JTextField find, JComboBox jcb2, JLabel TrangBD) {
        long trang1 = Long.parseLong(TrangBD.getText());
        if (trang1 > 1) {
            trang1--;
            TrangBD.setText("" + trang1);
            VeTablePM(jxt, trang1, jcb1, find, jcb2);
        }
    }

    public void setNewPM(JLabel ngaymuon, JLabel hantra) {
        ngaymuon.setText(ControllerCheck.DateNow());
        hantra.setText(ControllerCheck.DateOfAppointment());
    }

    public boolean checkMBD(String Ma) {
        con = new ConnectionDB();
        connect = con.connect();
        int maBD = 0;
        try {
            maBD = Integer.parseInt(Ma);
            try {
                String sql = "SELECT COUNT(*) FROM BanDoc WHERE MaBanDoc = ?";
                ps = connect.prepareStatement(sql);
                ps.setInt(1, maBD);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (rs.getInt(1) == 0) {
                        return false;
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
        } catch (HeadlessException | NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int SearchSach(JTextField find) {
        String search = find.getText().trim();
        dtm = new DefaultTableModel();
        con = new ConnectionDB();
        connect = con.connect();
        Vector v;
        int i = 0;
        try {
            String sql = "SELECT COUNT(*) FROM Sach WHERE MaSach = ?";
            ps = connect.prepareStatement(sql);
            ps.setString(1, search);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
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
        return i;
    }

    public int TienCuocCan(org.jdesktop.swingx.JXTable jxt) {
        int tcc = Settings.ReadTienPhatQuanHanInt();
        if (jxt.getRowCount() > 0) {
            for (int i = 0; i < jxt.getRowCount(); i++) {
                Controller cl = new Controller();
                String masach = jxt.getValueAt(i, 0).toString();
                tcc += cl.eGiaSach(masach);
            }
        }
        return tcc;
    }

    public void NewPMAdmin(BanDoc bd, org.jdesktop.swingx.JXTable jxt, PanelNewPhieuMuon pnpm) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sql = "INSERT INTO PhieuMuon(MaNhanVien,MaBanDoc,NgayMuon,HanTra) VALUES(?,?,GETDATE(),DATEADD(day,14,GETDATE()))";
            ps = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Run.nv.getMaNhanVien());
            ps.setInt(2, bd.getMaBanDoc());
            i = ps.executeUpdate();
            if (i != 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                int MaPM = rs.getInt(1);
                for (int j = 0; j < jxt.getRowCount(); j++) {
                    String MaSach = jxt.getValueAt(j, 0).toString();
                    NewCTPMAdmin(MaSach, MaPM);
                    Controller cl = new Controller();
                    if (cl.SumSachConLai(MaSach) == 0) {
                        SetSachTrangThai(MaSach);
                    }
                }
                JOptionPane.showMessageDialog(null, "Cho mượn thành công!");
                pnpm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Mượn không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public void NewCTPMAdmin(String MaSach, int MaPhieuMuon) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sql = "INSERT INTO ChiTietPhieuMuon(MaPhieuMuon,MaSach) VALUES(?,?)";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, MaPhieuMuon);
            ps.setString(2, MaSach);
            ps.executeUpdate();
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

    public void ChiTietPM(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String maphieumuon = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            PhieuMuon pm = controll.ePhieuMuon(maphieumuon);
            PanelChiTietPM pcpm = new PanelChiTietPM(Run.pma, true, pm);
            pcpm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì!");
        }
    }

    public void ChiTietPMBanDoc(org.jdesktop.swingx.JXTable jxt, PanelMainBanDoc pmbd) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String maphieumuon = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            PhieuMuon pm = controll.ePhieuMuon(maphieumuon);
            PanelChiTietPM pcpm = new PanelChiTietPM(pmbd, true, pm);
            pcpm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì!");
        }
    }

    public void setChiTietPM(PhieuMuon pm, JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4, JLabel jl5, JLabel jl6, JLabel jl7, JLabel jl8, JLabel jl9) {
        Controller controll = new Controller();
        jl1.setText("" + pm.getMaPhieuMuon());
        jl2.setText("" + pm.getMaBanDoc());
        jl3.setText("" + controll.NameBanDoc(pm.getMaBanDoc()));
        jl4.setText("" + pm.getMaNhanVien());
        jl5.setText("" + controll.NameAdminNhaVien(pm.getMaNhanVien()));
        jl6.setText(new SimpleDateFormat("dd-MM-yyyy").format(pm.getNgayMuon()));
        jl7.setText(new SimpleDateFormat("dd-MM-yyyy").format(pm.getHanTra()));
        jl8.setText(pm.getNgayTra() == null ? ("--/--/----") : (new SimpleDateFormat("dd-MM-yyyy").format(pm.getNgayTra())));
        jl9.setText(ControllerCheck.StatusStringPhieuMuon(pm.getTrangThai()));
    }

    public void VeTableCTPM(org.jdesktop.swingx.JXTable jxt, int MaPM) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT ChiTietPhieuMuon.MaSach AS 'Mã Sách', Sach.TenSach AS 'Tên Sách', ChiTietPhieuMuon.SoLuong AS 'Số Lượng', ChiTietPhieuMuon.TrangThaiSach AS 'Trạng Thái' "
                    + "FROM ChiTietPhieuMuon JOIN Sach ON ChiTietPhieuMuon.MaSach=Sach.MaSach WHERE MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaPM);
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
                v.add(3, ControllerCheck.StatusStringCTPhieuMuon(rs.getInt(4)));
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

    public void VeTableTraPM(org.jdesktop.swingx.JXTable jxt, int MaPM) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel();
        try {
            String sqlCommand = "SELECT ChiTietPhieuMuon.MaSach AS 'Mã Sách', Sach.TenSach AS 'Tên Sách', ChiTietPhieuMuon.SoLuong AS 'Số Lượng', ChiTietPhieuMuon.TrangThaiSach AS 'Trạng Thái' "
                    + "FROM ChiTietPhieuMuon JOIN Sach ON ChiTietPhieuMuon.MaSach=Sach.MaSach WHERE MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaPM);
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
                v.add(3, ControllerCheck.StatusStringCTPhieuMuon(rs.getInt(4)));
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

    public void TraPM(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String trangthai = jxt.getValueAt(jxt.getSelectedRow(), 7).toString();
            if (trangthai.equals("Đang Mượn")) {
                String maphieumuon = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
                Controller controll = new Controller();
                PhieuMuon pm = controll.ePhieuMuon(maphieumuon);
                PanelTraPM pcpm = new PanelTraPM(Run.pma, true, pm);
                pcpm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Phiếu mượn đã trả!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì!");
        }
    }

    public int checkHanTra(int MaPM) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sql = "SELECT DATEDIFF(day,HanTra,GETDATE()) FROM PhieuMuon WHERE MaPhieuMuon=?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, MaPM);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
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
        return i;
    }

    public int TienPhatCan(org.jdesktop.swingx.JXTable jxt) {
        int tcc = 0;
        if (jxt.getRowCount() > 0) {
            for (int i = 0; i < jxt.getRowCount(); i++) {
                if (jxt.getValueAt(i, 3).toString().equals("Mất Sách / Hỏng Sách")) {
                    Controller cl = new Controller();
                    String masach = jxt.getValueAt(i, 0).toString();
                    tcc += cl.eGiaSach(masach);
                }
            }
        }
        return tcc;
    }

    public void TraSachAdmin(org.jdesktop.swingx.JXTable jxt, int MaPM, int tienphatquahan, int tienphatmathong, JLabel tinhtrang, JLabel mabd, PanelTraPM ptpm) {
        int tinhtrangPm = ControllerCheck.TinhTrangInt(tinhtrang.getText().trim());
        con = new ConnectionDB();
        connect = con.connect();
        int tongphat = tienphatquahan + tienphatmathong;
        try {
            String sqlCommand = "UPDATE PhieuMuon set NgayTra=GETDATE(), TienPhat = ?,TrangThai=? WHERE MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, tongphat);
            ps.setInt(2, tinhtrangPm);
            ps.setInt(3, MaPM);
            ps.executeUpdate();
            for (int i = 0; i < jxt.getRowCount(); i++) {
                String masach = jxt.getValueAt(i, 0).toString();
                String tinhtrangSach = jxt.getValueAt(i, 3).toString();
                TraCTSachAdmin(MaPM, masach, tinhtrangSach);
                if (tinhtrangSach.equals("Mất Sách / Hỏng Sách")) {
                    SachCTPMSach(masach);
                    Controller cl = new Controller();
                    if (cl.SumSachConLai(masach) != 0) {
                        SetSachTrangThaiTra(masach);
                    }
                }
            }
            TienCuoCConLai(mabd.getText().trim(), tongphat);
            JOptionPane.showMessageDialog(null, "Trả Sách Thành Công!");
            ptpm.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void TraCTSachAdmin(int MaPM, String MaSach, String tinhtrang) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE ChiTietPhieuMuon set TrangThaiSach=? WHERE MaPhieuMuon = ? and MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, ControllerCheck.StatusIntCTPhieuMuon(tinhtrang));
            ps.setInt(2, MaPM);
            ps.setString(3, MaSach);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void SachCTPMSach(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        Controller cl = new Controller();
        int i = cl.SoSachMat(MaSach);
        try {
            String sqlCommand = "UPDATE Sach set SoMat=? WHERE  MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, i + 1);
            ps.setString(2, MaSach);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void TienCuoCConLai(String MaBD, int tongphat) {
        con = new ConnectionDB();
        connect = con.connect();
        Controller cl = new Controller();
        int i = cl.TienCuocBD(MaBD);
        int tongdu = i - tongphat;
        try {
            String sqlCommand = "UPDATE BanDoc set TienCuoc=? WHERE  MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, tongdu);
            ps.setString(2, MaBD);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void SetSachTrangThai(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE Sach SET Trangthai= 0 WHERE  MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void SetSachTrangThaiTra(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE Sach SET Trangthai= 1 WHERE  MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void DelCTPM(String MaPM) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "DELETE FROM ChiTietPhieuMuon WHERE  MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaPM);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void DelPM(String MaPM) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "DELETE FROM PhieuMuon WHERE  MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaPM);
            int i = ps.executeUpdate();
            if (i!=0) {
                JOptionPane.showMessageDialog(null, "Xoá thành công!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
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

    public void XoaPM(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String maphieumuon = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            PhieuMuon pm = controll.ePhieuMuon(maphieumuon);
            if (pm.getTrangThai() == 0) {
                DelCTPM(maphieumuon);
                DelPM(maphieumuon);
            } else {
                JOptionPane.showMessageDialog(null, "Bạn không thể xoá phiếu mượn này!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì!");
        }
    }
}
