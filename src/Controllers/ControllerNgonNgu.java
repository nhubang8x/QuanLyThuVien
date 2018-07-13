/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NgonNgu;
import Views.NgonNgu.PanelEditNgonNgu;
import Views.NgonNgu.PanelNewNgonNgu;
import Views.Run;
import Views.Sach.PanelSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerNgonNgu {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    ControllerSach cls = new ControllerSach();

    public void countDb(JTextField findngonngu) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = findngonngu.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select count(*) from NgonNgu";
                ps = connect.prepareStatement(sqlCommand);
            } else {
                sqlCommand = "select count(*) from NgonNgu where TenNgonNgu LIKE ?";
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

    public long SoTrang(JTextField findngongu) {
        countDb(findngongu);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableNgonNgu(org.jdesktop.swingx.JXTable jxt, long trang, JTextField findngonngu) {
        con = new ConnectionDB();
        connect = con.connect();
        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String search = findngonngu.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select top 10 MaNgonNgu as 'Mã Ngôn Ngữ', TenNgonNgu as 'Tên Ngôn Ngữ' from NgonNgu "
                        + "where MaNgonNgu not in (select top (? * 10 - 10) MaNgonNgu from NgonNgu order by MaNgonNgu asc) order by MaNgonNgu asc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
            } else {
                sqlCommand = "select top 10 MaNgonNgu as 'Mã Ngôn Ngữ', TenNgonNgu as 'Tên Ngôn Ngữ' from NgonNgu "
                        + "where MaNgonNgu not in (select top (? * 10 - 10) MaNgonNgu from NgonNgu where TenNgonNgu LIKE ? order by MaNgonNgu asc) "
                        + "and TenNgonNgu LIKE ? "
                        + "order by MaNgonNgu asc";
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
        }
    }

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JTextField findngongu, JLabel TrangNN) {
        long trang1 = Long.parseLong(TrangNN.getText());
        if (trang1 < SoTrang(findngongu)) {
            trang1++;
            TrangNN.setText("" + trang1);
            VeTableNgonNgu(jxt, trang1, findngongu);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JTextField findngongu, JLabel TrangNN) {
        TrangNN.setText("1");
        long trang1 = Long.parseLong(TrangNN.getText());
        VeTableNgonNgu(jxt, trang1, findngongu);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JTextField findngongu, JLabel TrangNN) {
        long trang1 = 1;
        if (SoTrang(findngongu) != 0) {
            trang1 = SoTrang(findngongu);
        }
        TrangNN.setText("" + trang1);
        VeTableNgonNgu(jxt, trang1, findngongu);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JTextField findngonngu, JLabel TrangNN) {
        long trang1 = Long.parseLong(TrangNN.getText());
        if (trang1 > 1) {
            trang1--;
            TrangNN.setText("" + trang1);
            VeTableNgonNgu(jxt, trang1, findngonngu);
        }
    }

    public static void EditNNAdmin(org.jdesktop.swingx.JXTable jxt) {
        int count = jxt.getSelectedRowCount();
        if (count == 1) {
            String maNN = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            NgonNgu nn = controll.eNgonNgu(maNN);
            PanelEditNgonNgu as = new PanelEditNgonNgu(Run.pma, true, nn);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn nhiều hơn 1 hoặc chưa chọn!");
        }
    }

    public void SetEditNN(JLabel jl, JTextField jf, NgonNgu nn) {
        jl.setText("" + nn.getMaNgonNgu());
        jf.setText(nn.getNgonNgu());
    }

    public int upDate(String TenNN, int MaNN) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE NgonNgu SET TenNgonNgu=? WHERE MaNgonNgu=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNN);
            ps.setInt(2, MaNN);
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

    public boolean CheckNgonNgu(String TenNN, int MaNN) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NgonNgu where MaNgonNgu!=? and TenNgonNgu=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNN);
            ps.setString(2, TenNN);
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

    public void UpdateNNAdmin(JTextField TenNN, int MaNN, PanelEditNgonNgu pen) {
        String TenNn = TenNN.getText().trim();
        if (TenNn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên Ngôn ngữ không được để trống!");
            TenNN.requestFocus();
            return;
        }
        if (CheckNgonNgu(TenNn, MaNN) == false) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại tên Ngôn ngữ này!");
            TenNN.requestFocus();
            return;
        }
        if (upDate(TenNn, MaNN) != 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.NgonNguSach.getSelectedItem().toString();
                cls.VeJComboxNgonNgu(PanelSach.NgonNguSach);
                PanelSach.NgonNguSach.setSelectedItem(select);
            }
            pen.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật không thành công!");
        }
    }

    public boolean CheckNewTenNgonNgu(String TenNN) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NgonNgu where TenNgonNgu=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNN);
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

    public int NewNgonNgu(String TenNN) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "INSERT INTO NgonNgu(TenNgonNgu) VALUES (?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNN);
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

    public void NewNNAdmin(JTextField tnn, PanelNewNgonNgu pnn) {
        String TenNN = tnn.getText().trim();
        if (TenNN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên ngôn ngữ không được để trống!");
            tnn.requestFocus();
            return;
        }
        if (CheckNewTenNgonNgu(TenNN) == false) {
            JOptionPane.showMessageDialog(null, "Tên ngôn ngữ đã tồn tại!");
            tnn.requestFocus();
            return;
        }
        if (NewNgonNgu(TenNN) != 0) {
            JOptionPane.showMessageDialog(null, "Thêm mới ngôn ngữ thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.NgonNguSach.getSelectedItem().toString();
                cls.VeJComboxNgonNgu(PanelSach.NgonNguSach);
                PanelSach.NgonNguSach.setSelectedItem(select);
            }
            pnn.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới ngôn ngữ không thành công!");
        }
    }

    public boolean CheckDelNgonNgu(String MaNN) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM Sach WHERE MaNgonNgu = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNN);
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

    public int countDelNgonNgu(String MaNN) {
        con = new ConnectionDB();
        connect = con.connect();
        int del = 0;
        try {
            String sqlCommand = "DELETE FROM NgonNgu WHERE MaNgonNgu = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNN);
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

    public void DelNgonNgu(org.jdesktop.swingx.JXTable jxt) {
        con = new ConnectionDB();
        connect = con.connect();
        int countnn = jxt.getSelectedRowCount();
        if (countnn == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá Ngôn Ngữ?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaNN = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelNgonNgu(MaNN) == true) {
                    if (countDelNgonNgu(MaNN) != 0) {
                        JOptionPane.showMessageDialog(null, "Xoá thành công!");
                        if (Run.pma.ps != null) {
                            String select = PanelSach.NgonNguSach.getSelectedItem().toString();
                            cls.VeJComboxNgonNgu(PanelSach.NgonNguSach);
                            PanelSach.NgonNguSach.setSelectedItem(select);
                        }
                    } else {
                        JOptionPane.showConfirmDialog(null, "Xoá không thành công!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa");
        }
    }
}
