/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy Thắng
 */
public class ControllerThongKe {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    Controller cl = new Controller();

    public void countDb(JComboBox find) {
        con = new ConnectionDB();
        connect = con.connect();
        int search = find.getSelectedIndex();
        try {
            String sqlCommand = null;
            switch (search) {
                case 0:
                    sqlCommand = "select count(*) from TheLoai";
                    break;
                case 1:
                    sqlCommand = "select count(*) from TacGia";
                    break;
                case 2:
                    sqlCommand = "select count(*) from NhaXB";
                    break;
                case 3:
                    sqlCommand = "select count(*) from NgonNgu";
                    break;
                case 4:
                    sqlCommand = "select count(*) from BanDoc";
                    break;
                default:
                    break;
            }
            ps = connect.prepareStatement(sqlCommand);
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

    public long SoTrang(JComboBox find) {
        countDb(find);
        if (count % 15 == 0) {
            sotrang = count / 15;
        } else {
            sotrang = count / 15 + 1;
        }
        return sotrang;
    }

    public void VeTableDanhMuc(org.jdesktop.swingx.JXTable jxt, long trang) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 15 MaTheLoai AS 'Mã Danh Mục',TenTheLoai as 'Tên Danh Mục' FROM TheLoai where MaTheLoai not in (select top (? * 15 - 15) MaTheLoai from TheLoai order by MaTheLoai asc) order by MaTheLoai asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            dtm.addColumn("STT");
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            dtm.addColumn("Số Lượng");
            //Vẽ Hàng
            Vector v;
            int i = 0;
            while (rs.next()) {
                v = new Vector();
                i++;
                v.add(0, i);
                v.add(1, rs.getInt(1));
                v.add(2, rs.getString(2));
                v.add(3, cl.CountDanhMuc(rs.getInt(1)) + " Cuốn");
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeTableTacGia(org.jdesktop.swingx.JXTable jxt, long trang) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 15 MaTacGia as 'Mã Tác Giả',TenTacGia as 'Tên Tác Giả' FROM TacGia where MaTacGia not in (select top (? * 15 - 15) MaTacGia from TacGia order by MaTacGia asc) order by MaTacGia asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            dtm.addColumn("STT");
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            dtm.addColumn("Số Lượng");
            //Vẽ Hàng
            Vector v;
            int i = 0;
            while (rs.next()) {
                v = new Vector();
                i++;
                v.add(0, i);
                v.add(1, rs.getInt(1));
                v.add(2, rs.getString(2));
                v.add(3, cl.CountTacGia(rs.getInt(1)) + " Cuốn");
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeTableNXB(org.jdesktop.swingx.JXTable jxt, long trang) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 15 MaNXB as 'Mã NXB',TenNXB as 'Tên NXB' FROM NhaXB where MaNXB not in (select top (? * 15 - 15) MaNXB from NhaXB order by MaNXB asc) order by MaNXB asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            dtm.addColumn("STT");
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            dtm.addColumn("Số Lượng");
            //Vẽ Hàng
            Vector v;
            int i = 0;
            while (rs.next()) {
                v = new Vector();
                i++;
                v.add(0, i);
                v.add(1, rs.getInt(1));
                v.add(2, rs.getString(2));
                v.add(3, cl.CountNXB(rs.getInt(1)) + " Cuốn");
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeTableNgonNgu(org.jdesktop.swingx.JXTable jxt, long trang) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 15 MaNgonNgu as 'Mã Ngôn Ngữ',TenNgonNgu as 'Tên Ngôn Ngữ' FROM NgonNgu where MaNgonNgu not in (select top (? * 15 - 15) MaNgonNgu from NgonNgu order by MaNgonNgu asc) order by MaNgonNgu asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            dtm.addColumn("STT");
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            dtm.addColumn("Số Lượng");
            //Vẽ Hàng
            Vector v;
            int i = 0;
            while (rs.next()) {
                v = new Vector();
                i++;
                v.add(0, i);
                v.add(1, rs.getInt(1));
                v.add(2, rs.getString(2));
                v.add(3, cl.CountNgonNgu(rs.getInt(1)) + " Cuốn");
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeTableBanDoc(org.jdesktop.swingx.JXTable jxt, long trang) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        try {
            String sqlCommand = "SELECT TOP 15 MaBanDoc as 'Mã Bạn Đọc',HoTen as 'Tên Bạn Đọc' FROM BanDoc where MaBanDoc not in (select top (? * 15 - 15) MaBanDoc from BanDoc order by MaBanDoc asc) "
                    + "order by MaBanDoc asc";
            ps = connect.prepareStatement(sqlCommand);
            ps.setLong(1, trang);
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int socot = rsm.getColumnCount();
            //Vẽ Cột
            dtm.addColumn("STT");
            for (int i = 1; i <= socot; i++) {
                String tenCot = rsm.getColumnName(i);
                dtm.addColumn(tenCot);
            }
            dtm.addColumn("Tổng Mượn");
            dtm.addColumn("Đang Mượn");
            dtm.addColumn("Đã Trả");
            dtm.addColumn("Quá Hạn");
            dtm.addColumn("Quá Hạn + Mất Sách");
            dtm.addColumn("Mất sách");
            //Vẽ Hàng
            Vector v;
            int i = 0;
            while (rs.next()) {
                v = new Vector();
                i++;
                v.add(0, i);
                v.add(1, rs.getInt(1));
                v.add(2, rs.getString(2));
                v.add(3, cl.CountBD(rs.getInt(1)));
                v.add(4, cl.CountBDDangMuon(rs.getInt(1)));
                v.add(5, cl.CountBDDaTra(rs.getInt(1)));
                v.add(6, cl.CountBDQuaHan(rs.getInt(1)));
                v.add(7, cl.CountBDQuaHan_Mat(rs.getInt(1)));
                v.add(8, cl.CountBDMat(rs.getInt(1)));
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void VeTablePhieuMuon(org.jdesktop.swingx.JXTable jxt) {
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        //Vẽ Cột
        dtm.addColumn("STT");
        dtm.addColumn("Trạng Thái Phiếu Mượn");
        dtm.addColumn("Tổng");
        //Vẽ Hàng
        dtm.addRow(new Object[]{"1", "Tổng Phiếu Mượn", cl.CountPM()});
        dtm.addRow(new Object[]{"2", "Đang Mượn", cl.CountPMDangMuon()});
        dtm.addRow(new Object[]{"3", "Đã Trả", cl.CountPMDaTra()});
        dtm.addRow(new Object[]{"4", "Quá Hạn", cl.CountPMQuaHan()});
        dtm.addRow(new Object[]{"5", "Quá Hạn + Mất/Hỏng Sách", cl.CountPMQuaHan_Mat()});
        dtm.addRow(new Object[]{"6", "Mất/Hỏng sách", cl.CountPMMat()});
        jxt.setModel(dtm);
    }

    public void VeTable(org.jdesktop.swingx.JXTable jxt, long trang, JComboBox find, JLabel jl) {
        int i = find.getSelectedIndex();
        switch (i) {
            case 0:
                jl.setText("THỐNG KÊ THEO DANH MỤC SÁCH");
                VeTableDanhMuc(jxt, trang);
                break;
            case 1:
                jl.setText("THỐNG KÊ THEO TÁC GIẢ SÁCH");
                VeTableTacGia(jxt, trang);
                break;
            case 2:
                jl.setText("THỐNG KÊ THEO NHÀ XUẤT BẢN SÁCH");
                VeTableNXB(jxt, trang);
                break;
            case 3:
                jl.setText("THỐNG KÊ THEO NGÔN NGỮ SÁCH");
                VeTableNgonNgu(jxt, trang);
                break;
            case 4:
                jl.setText("THỐNG KÊ THEO BẠN ĐỌC");
                VeTableBanDoc(jxt, trang);
                break;
            case 5:
                jl.setText("THỐNG KÊ THEO PHIẾU MƯỢN");
                VeTablePhieuMuon(jxt);
                break;
            default:
                break;
        }
    }

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JComboBox find, JLabel TrangTG) {
        long trang = Long.parseLong(TrangTG.getText());
        int i = find.getSelectedIndex();
        switch (i) {
            case 0:
                if (trang < SoTrang(find)) {
                    trang++;
                    TrangTG.setText("" + trang);
                    VeTableDanhMuc(jxt, trang);
                }
                break;
            case 1:
                if (trang < SoTrang(find)) {
                    trang++;
                    TrangTG.setText("" + trang);
                    VeTableTacGia(jxt, trang);
                }
                break;
            case 2:
                if (trang < SoTrang(find)) {
                    trang++;
                    TrangTG.setText("" + trang);
                    VeTableNXB(jxt, trang);
                }
                break;
            case 3:
                if (trang < SoTrang(find)) {
                    trang++;
                    TrangTG.setText("" + trang);
                    VeTableNgonNgu(jxt, trang);
                }
                break;
            case 4:
                if (trang < SoTrang(find)) {
                    trang++;
                    TrangTG.setText("" + trang);
                    VeTableBanDoc(jxt, trang);
                }
                break;
            default:
                break;
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JComboBox find, JLabel TrangTG) {
        TrangTG.setText("1");
        long trang = Long.parseLong(TrangTG.getText());
        int i = find.getSelectedIndex();
        switch (i) {
            case 0:
                VeTableDanhMuc(jxt, trang);
                break;
            case 1:
                VeTableTacGia(jxt, trang);
                break;
            case 2:
                VeTableNXB(jxt, trang);
                break;
            case 3:
                VeTableNgonNgu(jxt, trang);
                break;
            case 4:
                VeTableBanDoc(jxt, trang);
                break;
            default:
                break;
        }
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JComboBox find, JLabel TrangTG) {
        int i = find.getSelectedIndex();
        long trang;
        switch (i) {
            case 0:
                trang = SoTrang(find);
                TrangTG.setText("" + trang);
                VeTableDanhMuc(jxt, trang);
                break;
            case 1:
                trang = SoTrang(find);
                TrangTG.setText("" + trang);
                VeTableTacGia(jxt, trang);
                break;
            case 2:
                trang = SoTrang(find);
                TrangTG.setText("" + trang);
                VeTableNXB(jxt, trang);
                break;
            case 3:
                trang = SoTrang(find);
                TrangTG.setText("" + trang);
                VeTableNgonNgu(jxt, trang);
                break;
            case 4:
                trang = SoTrang(find);
                TrangTG.setText("" + trang);
                VeTableBanDoc(jxt, trang);
                break;
            default:
                break;
        }
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JComboBox find, JLabel TrangTG) {
        long trang = Long.parseLong(TrangTG.getText());
        int i = find.getSelectedIndex();
        switch (i) {
            case 0:
                if (trang > 1) {
                    trang--;
                    TrangTG.setText("" + trang);
                    VeTableDanhMuc(jxt, trang);
                }
                break;
            case 1:
                if (trang > 1) {
                    trang--;
                    TrangTG.setText("" + trang);
                    VeTableTacGia(jxt, trang);
                }
                break;
            case 2:
                if (trang > 1) {
                    trang--;
                    TrangTG.setText("" + trang);
                    VeTableNXB(jxt, trang);
                }
                break;
            case 3:
                if (trang > 1) {
                    trang--;
                    TrangTG.setText("" + trang);
                    VeTableNgonNgu(jxt, trang);
                }
                break;
            case 4:
                if (trang > 1) {
                    trang--;
                    TrangTG.setText("" + trang);
                    VeTableBanDoc(jxt, trang);
                }
                break;
            default:
                break;
        }
    }
}
