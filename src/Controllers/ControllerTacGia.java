/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TacGia;
import Views.Run;
import Views.Sach.PanelSach;
import Views.TacGia.PanelEditTacGia;
import Views.TacGia.PanelNewTacGia;
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
 * @author Huy Thắng
 */
public class ControllerTacGia {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    ControllerSach cls = new ControllerSach();

    public void countDb(JTextField findtacgia) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = findtacgia.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select count(*) from TacGia";
                ps = connect.prepareStatement(sqlCommand);
            } else {
                sqlCommand = "select count(*) from TacGia where TenTacGia LIKE ?";
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

    public long SoTrang(JTextField findtacgia) {
        countDb(findtacgia);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableTacGia(org.jdesktop.swingx.JXTable jxt, long trang, JTextField findtacgia) {
        countDb(findtacgia);
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String search = findtacgia.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select top 10 MaTacGia as 'Mã Tác Giả', TenTacGia as 'Tên Tác Giả' from TacGia "
                        + "where MaTacGia not in (select top (? * 10 - 10) MaTacGia from TacGia order by MaTacGia asc) order by MaTacGia asc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
            } else {
                sqlCommand = "select top 10 MaTacGia as 'Mã Tác Giả', TenTacGia as 'Tên Tác Giả' from TacGia "
                        + "where MaTacGia not in (select top (? * 10 - 10) MaTacGia from TacGia where TenTacGia LIKE ? order by MaTacGia) "
                        + "and TenTacGia LIKE ? "
                        + "order by MaTacGia asc";
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

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JTextField findtacgia, JLabel TrangTG) {
        long trang1 = Long.parseLong(TrangTG.getText());
        if (trang1 < SoTrang(findtacgia)) {
            trang1++;
            TrangTG.setText("" + trang1);
            VeTableTacGia(jxt, trang1, findtacgia);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JTextField findtacgia, JLabel TrangTG) {
        TrangTG.setText("1");
        long trang1 = Long.parseLong(TrangTG.getText());
        VeTableTacGia(jxt, trang1, findtacgia);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JTextField findtacgia, JLabel TrangTG) {
        long trang1 = 1;
        if (SoTrang(findtacgia) != 0) {
            trang1 = SoTrang(findtacgia);
        }
        TrangTG.setText("" + trang1);
        VeTableTacGia(jxt, trang1, findtacgia);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JTextField findtacgia, JLabel TrangTG) {
        long trang1 = Long.parseLong(TrangTG.getText());
        if (trang1 > 1) {
            trang1--;
            TrangTG.setText("" + trang1);
            VeTableTacGia(jxt, trang1, findtacgia);
        }
    }

    public void EditTGAdmin(org.jdesktop.swingx.JXTable jxt) {
        int count = jxt.getSelectedRowCount();
        if (count == 1) {
            String maTG = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            TacGia tg = controll.eTacGia(maTG);
            PanelEditTacGia as = new PanelEditTacGia(Run.pma, true, tg);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn nhiều hơn 1 hoặc chưa chọn!");
        }
    }

    public void SetEditTG(JLabel jl, JTextField jf, TacGia tg) {
        jl.setText("" + tg.getMaTacGia());
        jf.setText(tg.getTenTacGia());
    }

    public int upDate(String TenTG, int MaTG) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE TacGia SET TenTacGia=? WHERE MaTacGia=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTG);
            ps.setInt(2, MaTG);
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

    public boolean CheckTacGia(String TenTG, int MaTG) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from TacGia where MaTacGia!=? and TenTacGia=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaTG);
            ps.setString(2, TenTG);
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

    public void UpdateTGAdmin(JTextField TenTG, int MaTG, PanelEditTacGia pet) {
        String TenTg = TenTG.getText().trim();
        if (TenTg.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống!");
            TenTG.requestFocus();
            return;
        }
        if (CheckTacGia(TenTg, MaTG) == false) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại tên tác giả này!");
            TenTG.requestFocus();
            return;
        }
        if (upDate(TenTg, MaTG) != 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.TacGiaSach.getSelectedItem().toString();
                cls.VeJComboxTacGia(PanelSach.TacGiaSach);
                PanelSach.TacGiaSach.setSelectedItem(select);
            }
            pet.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
        }
    }

    public boolean CheckNewTenTacGia(String TenTG) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from TacGia where TenTacGia=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTG);
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

    public int NewTacGia(String TenTG) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "INSERT INTO TacGia(TenTacGia) VALUES (?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenTG);
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

    public void NewTGAdmin(JTextField ttg, PanelNewTacGia pnt) {
        String TenTG = ttg.getText().trim();
        if (TenTG.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên tác giả không được để trống!");
            ttg.requestFocus();
            return;
        }
        if (CheckNewTenTacGia(TenTG) == false) {
            JOptionPane.showMessageDialog(null, "Tên tác giả đã tồn tại!");
            ttg.requestFocus();
            return;
        }
        int i = NewTacGia(TenTG);
        if (i != 0) {
            JOptionPane.showMessageDialog(null, "Thêm mới tác giả thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.TacGiaSach.getSelectedItem().toString();
                cls.VeJComboxTacGia(PanelSach.TacGiaSach);
                PanelSach.TacGiaSach.setSelectedItem(select);
            }
            pnt.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới tác giả không thành công!");
        }
    }

    public boolean CheckDelTacGia(String MaTG) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM Sach WHERE MaTacGia = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTG);
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

    public void countDelTacGia(String MaTG) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "DELETE FROM TacGia WHERE MaTacGia = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTG);
            count = ps.executeUpdate();
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

    public void DelTacGia(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int counttg = jxt.getSelectedRowCount();
        if (counttg > 0) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Tác Giả?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaTG = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelTacGia(MaTG) == true) {
                    countDelTacGia(MaTG);
                    if (Run.pma.ps != null) {
                        String select = PanelSach.TacGiaSach.getSelectedItem().toString();
                        cls.VeJComboxTacGia(PanelSach.TacGiaSach);
                        PanelSach.TacGiaSach.setSelectedItem(select);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa");
        }
    }
}
