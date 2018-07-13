/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TheLoai;
import Views.Run;
import Views.Sach.PanelSach;
import Views.TheLoai.PanelEditTheLoai;
import Views.TheLoai.PanelNewTheLoai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerTheLoai {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    ControllerSach cls = new ControllerSach();

    public void countDb(JTextField findTheLoai) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = findTheLoai.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select count(*) from TheLoai";
                ps = connect.prepareStatement(sqlCommand);
            } else {
                sqlCommand = "select count(*) from TheLoai where TenTheLoai LIKE ?";
                ps = connect.prepareStatement(sqlCommand);
                ps.setString(1, "%" + search + "%");
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

    public long SoTrang(JTextField findTheLoai) {
        countDb(findTheLoai);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableTheLoai(org.jdesktop.swingx.JXTable jxt, long trang, JTextField findTheLoai) {
        countDb(findTheLoai);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String search = findTheLoai.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select top 10 MaTheLoai as 'Mã Danh Mục', TenTheLoai as 'Tên Danh Mục' from TheLoai "
                        + "where MaTheLoai not in (select top (? * 10 - 10) MaTheLoai from TheLoai order by MaTheLoai asc) order by MaTheLoai asc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
            } else {
                sqlCommand = "select top 10 MaTheLoai as 'Mã Danh Mục', TenTheLoai as 'Tên Danh Mục' from TheLoai "
                        + "where MaTheLoai not in (select top (? * 10 - 10) MaTheLoai from TheLoai where TenTheLoai LIKE ? order by MaTheLoai asc) "
                        + "and TenTheLoai LIKE ? "
                        + "order by MaTheLoai asc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
                ps.setString(2, "%" + search + "%");
                ps.setString(3, "%" + search + "%");
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
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerTacGia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JTextField findTheLoai, JLabel TrangTL) {
        long trang1 = Long.parseLong(TrangTL.getText());
        if (trang1 < SoTrang(findTheLoai)) {
            trang1++;
            TrangTL.setText("" + trang1);
            VeTableTheLoai(jxt, trang1, findTheLoai);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JTextField findTheLoai, JLabel TrangTL) {
        TrangTL.setText("1");
        long trang1 = Long.parseLong(TrangTL.getText());
        VeTableTheLoai(jxt, trang1, findTheLoai);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JTextField findTheLoai, JLabel TrangTL) {
        long trang1 = 1;
        if (SoTrang(findTheLoai) != 0) {
            trang1 = SoTrang(findTheLoai);
        }
        TrangTL.setText("" + trang1);
        VeTableTheLoai(jxt, trang1, findTheLoai);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JTextField findTheLoai, JLabel TrangTL) {
        long trang1 = Long.parseLong(TrangTL.getText());
        if (trang1 > 1) {
            trang1--;
            TrangTL.setText("" + trang1);
            VeTableTheLoai(jxt, trang1, findTheLoai);
        }
    }

    public void EditTLAdmin(org.jdesktop.swingx.JXTable jxt) {
        int count = jxt.getSelectedRowCount();
        if (count == 1) {
            String maTL = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            TheLoai tl = controll.eTheLoai(maTL);
            PanelEditTheLoai as = new PanelEditTheLoai(Run.pma, true, tl);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn nhiều hơn 1 hoặc chưa chọn!");
        }
    }

    public void SetEditTL(JLabel jl, JTextField jf, TheLoai tl) {
        jl.setText("" + tl.getMaTheLoai());
        jf.setText(tl.getTenTheLoai());
    }

    public int upDate(String TenTL, int MaTL) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE TheLoai SET TenTheLoai=? WHERE MaTheLoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTL);
            ps.setInt(2, MaTL);
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

    public boolean CheckTheLoai(String TenTL, int MaTL) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from TheLoai where MaTheLoai!=? and TenTheLoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaTL);
            ps.setString(2, TenTL);
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

    public void UpdateTLAdmin(JTextField TenTL, int MaTL, PanelEditTheLoai pet) {
        String TenTl = TenTL.getText().trim();
        if (TenTl.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên Danh Mục không được để trống!");
            TenTL.requestFocus();
            return;
        }
        if (CheckTheLoai(TenTl, MaTL) == false) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại tên Danh Mục này!");
            TenTL.requestFocus();
            return;
        }
        if (upDate(TenTl, MaTL) != 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.TheLoaiSach.getSelectedItem().toString();
                cls.VeJComboxTheLoai(PanelSach.TheLoaiSach);
                PanelSach.TheLoaiSach.setSelectedItem(select);
            }
            pet.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
        }

    }

    public boolean CheckNewTenTheLoai(String TenTL) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from TheLoai where TenTheLoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTL);
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

    public int NewTheLoai(String TenTL) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "INSERT INTO TheLoai(TenTheLoai) VALUES (?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTL);
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

    public void NewTLAdmin(JTextField ttl, PanelNewTheLoai pnt) {
        String TenTL = ttl.getText().trim();
        if (TenTL.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên Danh Mục không được để trống!");
            ttl.requestFocus();
            return;
        }
        if (CheckNewTenTheLoai(TenTL) == false) {
            JOptionPane.showMessageDialog(null, "Tên Danh Mục đã tồn tại!");
            ttl.requestFocus();
            return;
        }
        if (NewTheLoai(TenTL) != 0) {
            JOptionPane.showMessageDialog(null, "Thêm mới Danh Mục thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.TheLoaiSach.getSelectedItem().toString();
                cls.VeJComboxTheLoai(PanelSach.TheLoaiSach);
                PanelSach.TheLoaiSach.setSelectedItem(select);
            }
            pnt.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới Danh Mục không thành công!");
        }

    }

    public boolean CheckDelTheLoai(String MaTL) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM Sach WHERE MaTheLoai = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTL);
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

    public int countDelTheLoai(String MaTL) {
        con = new ConnectionDB();
        connect = con.connect();
        int del = 0;
        try {
            String sqlCommand = "DELETE FROM TheLoai WHERE MaTheLoai = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTL);
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

    public void DelTheLoai(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int counttl = jxt.getSelectedRowCount();
        if (counttl == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Thể Loại?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaTL = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelTheLoai(MaTL) == true) {
                    if (countDelTheLoai(MaTL) != 0) {
                        JOptionPane.showMessageDialog(null, "Xoá thành công!");
                        if (Run.pma.ps != null) {
                            String select = PanelSach.TheLoaiSach.getSelectedItem().toString();
                            cls.VeJComboxTheLoai(PanelSach.TheLoaiSach);
                            PanelSach.TheLoaiSach.setSelectedItem(select);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Xoá không thành công!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa!");
        }
    }
}
