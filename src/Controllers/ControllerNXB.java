/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.NhaXB;
import Views.NXB.PanelEditNXB;
import Views.NXB.PanelNewNXB;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hà
 */
public class ControllerNXB {

    DefaultTableModel dtm;
    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;
    long count, sotrang;
    ControllerSach cls = new ControllerSach();

    public void countDb(JTextField findnhaxb) {
        con = new ConnectionDB();
        connect = con.connect();
        String search = findnhaxb.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select count(*) from NhaXB";
                ps = connect.prepareStatement(sqlCommand);
            } else {
                sqlCommand = "select count(*) from NhaXB where TenNXB LIKE ?";
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

    public long SoTrang(JTextField findnxb) {
        countDb(findnxb);
        if (count % 10 == 0) {
            sotrang = count / 10;
        } else {
            sotrang = count / 10 + 1;
        }
        return sotrang;
    }

    public void VeTableNXB(org.jdesktop.swingx.JXTable jxt, long trang, JTextField findnxb) {
        con = new ConnectionDB();
        connect = con.connect();
        dtm = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        String search = findnxb.getText();
        try {
            String sqlCommand;
            if (search.equalsIgnoreCase("")) {
                sqlCommand = "select top 10 MaNXB as 'Mã NXB', TenNXB as 'Tên NXB',DienThoai as 'Điện Thoại', DiaChi as 'Địa Chỉ' from NhaXB "
                        + "where MaNXB not in (select top (? * 10 - 10) MaNXB from NhaXB order by MaNXB asc) order by MaNXB asc";
                ps = connect.prepareStatement(sqlCommand);
                ps.setLong(1, trang);
            } else {
                sqlCommand = "select top 10 MaNXB as 'Mã NXB', TenNXB as 'Tên NXB',DienThoai as 'Điện Thoại', DiaChi as 'Địa Chỉ' from NhaXB "
                        + "where MaNXB not in (select top (? * 10 - 10) MaNXB from NhaXB where TenNXB LIKE ? order by MaNXB asc) "
                        + "and TenNXB LIKE ? order by MaNXB asc";
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
                v.add(2, rs.getString(3));
                v.add(3, rs.getString(4));
                dtm.addRow(v);
            }
            jxt.setModel(dtm);
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

    public void NextButton(org.jdesktop.swingx.JXTable jxt, JTextField findnxb, JLabel TrangNXB) {
        long trang1 = Long.parseLong(TrangNXB.getText());
        if (trang1 < SoTrang(findnxb)) {
            trang1++;
            TrangNXB.setText("" + trang1);
            VeTableNXB(jxt, trang1, findnxb);
        }
    }

    public void FirstButton(org.jdesktop.swingx.JXTable jxt, JTextField findnxb, JLabel TrangNXB) {
        TrangNXB.setText("1");
        long trang1 = Long.parseLong(TrangNXB.getText());
        VeTableNXB(jxt, trang1, findnxb);
    }

    public void LastButton(org.jdesktop.swingx.JXTable jxt, JTextField findnxb, JLabel TrangNXB) {
        long trang1 = 1;
        if (SoTrang(findnxb) != 0) {
            trang1 = SoTrang(findnxb);
        }
        TrangNXB.setText("" + trang1);
        VeTableNXB(jxt, trang1, findnxb);
    }

    public void PreButton(org.jdesktop.swingx.JXTable jxt, JTextField findnxb, JLabel TrangNXB) {
        long trang1 = Long.parseLong(TrangNXB.getText());
        if (trang1 > 1) {
            trang1--;
            TrangNXB.setText("" + trang1);
            VeTableNXB(jxt, trang1, findnxb);
        }
    }

    public void EditNXBAdmin(org.jdesktop.swingx.JXTable jxt) {
        int countNXB = jxt.getSelectedRowCount();
        if (countNXB == 1) {
            String manxb = jxt.getValueAt(jxt.getSelectedRow(), 0).toString();
            Controller controll = new Controller();
            NhaXB nxb = controll.eNhaXB(manxb);
            PanelEditNXB as = new PanelEditNXB(Run.pma, true, nxb);
            as.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn đã chọn nhiều hơn 1 hoặc chưa chọn!");
        }
    }

    public void SetEditNXB(JLabel jl, JTextField jf, JTextField tf, JTextArea ja, NhaXB nxb) {
        jl.setText("" + nxb.getMaNXB());
        jf.setText(nxb.getTenNXB());
        tf.setText(nxb.getDienThoai());
        ja.setText(nxb.getDiaChi());
    }

    public int upDate(int MaNXB, String TenNXB, String DienThoai, String DiaChi) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "UPDATE NhaXB SET TenNXB=?, DienThoai=?, DiaChi=? WHERE MaNXB=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNXB);
            ps.setString(2, DienThoai);
            ps.setString(3, DiaChi);
            ps.setInt(4, MaNXB);
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

    public boolean CheckNameNXB(String TenNXB, int MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhaXB where TenNXB=? and MaNXB!=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNXB);
            ps.setInt(2, MaNXB);
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

    public boolean CheckTelNXB(String DienThoai, int MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhaXB where MaNXB!=? and DienThoai=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNXB);
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

    public void UpdateNXBAdmin(JTextField TenNN, JTextField Tel, int MaNXB, JTextArea ja, PanelEditNXB pen) {
        String TenNXB = TenNN.getText().trim();
        String DiaChi = ja.getText().trim();
        String DienThoai = Tel.getText().trim();
        if (TenNXB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên Nhà Xuất Bản không được để trống!");
            TenNN.requestFocus();
            return;
        }
        if (DienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại NXB không được để trống!");
            Tel.requestFocus();
            return;
        }
        if (DiaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ NXB không được để trống!");
            ja.requestFocus();
            return;
        }
        if (ControllerCheck.checkNumber(DienThoai) == false) {
            JOptionPane.showMessageDialog(null, "Bạn nhập vào không phải là số!");
            Tel.requestFocus();
            return;
        }
        if (ControllerCheck.checkTel(DienThoai) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!");
            Tel.requestFocus();
            return;
        }
        if (CheckNameNXB(TenNXB, MaNXB) == false) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại Nhà Xuất Bản này!");
            TenNN.requestFocus();
            return;
        }
        if (CheckTelNXB(DienThoai, MaNXB) == false) {
            JOptionPane.showMessageDialog(null, "Đã tồn tại số điện thoại này!");
            Tel.requestFocus();
            return;
        }
        if (upDate(MaNXB, TenNXB, DienThoai, DiaChi) != 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.NXBSach.getSelectedItem().toString();
                cls.VeJComboxNXB(PanelSach.NXBSach);
                PanelSach.NXBSach.setSelectedItem(select);
            }
            pen.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật không thành công!");
        }

    }

    public boolean CheckNewTenNXB(String TenNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhaXB where TenNXB=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNXB);
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

    public boolean CheckNewTelNXB(String DienThoai) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "select count(*) from NhaXB where DienThoai=?";
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

    public int NewNXB(String TenNXB, String DienThoai, String DiaChi) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "INSERT INTO NhaXB(TenNXB,DienThoai,DiaChi) VALUES (?,?,?)";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, TenNXB);
            ps.setString(2, DienThoai);
            ps.setString(3, DiaChi);
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

    public void NewNXBAdmin(JTextField TenNxb, JTextField Tel, JTextArea ja, PanelNewNXB pnn) {
        String TenNXB = TenNxb.getText().trim();
        String DienThoai = Tel.getText().trim();
        String DiaChi = ja.getText().trim();
        if (TenNXB.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên Nhà xuất bản không được để trống!");
            TenNxb.requestFocus();
            return;
        }
        if (DienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Điện thoại không được để trống!");
            Tel.requestFocus();
            return;
        }
        if (DiaChi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
            ja.requestFocus();
            return;
        }
        if (ControllerCheck.checkNumber(DienThoai) == false) {
            JOptionPane.showMessageDialog(null, "Bạn nhập vào không phải là số!");
            Tel.requestFocus();
            return;
        }
        if (ControllerCheck.checkTel(DienThoai) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng!");
            Tel.requestFocus();
            return;
        }
        if (CheckNewTenNXB(TenNXB) == false) {
            JOptionPane.showMessageDialog(null, "Nhà xuất bản đã tồn tại!");
            TenNxb.requestFocus();
            return;
        }
        if (CheckNewTelNXB(DienThoai) == false) {
            JOptionPane.showMessageDialog(null, "Số diện thoại đã tồn tại!");
            Tel.requestFocus();
            return;
        }
        if (NewNXB(TenNXB, DienThoai, DiaChi) != 0) {
            JOptionPane.showMessageDialog(null, "Thêm mới Nhà xuất bản thành công!");
            if (Run.pma.ps != null) {
                String select = PanelSach.NXBSach.getSelectedItem().toString();
                cls.VeJComboxNXB(PanelSach.NXBSach);
                PanelSach.NXBSach.setSelectedItem(select);
            }
            pnn.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Thêm mới Nhà xuất bản không thành công!");
        }
    }

    public boolean CheckDelNXB(String MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        boolean check = true;
        try {
            String sqlCommand = "SELECT COUNT(*) FROM Sach WHERE MaNXB = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNXB);
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

    //Hàm thực hiện chức năng xoá NXB
    public void countDelNXB(String MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "DELETE FROM NhaXB WHERE MaNXB = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNXB);
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

    //Xóa nhà xuất bản
    public void DelNXB(org.jdesktop.swingx.JXTable jxt) {
        int countnxb = jxt.getSelectedRowCount();
        if (countnxb == 1) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "Bạn Có muốn xoá NXB?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                int numberDelRow = jxt.getSelectedRow();
                String MaNXB = jxt.getValueAt(numberDelRow, 0).toString();
                if (CheckDelNXB(MaNXB) == true) {
                    countDelNXB(MaNXB);
                    JOptionPane.showMessageDialog(null, "Xoá thành công");
                    if (Run.pma.ps != null) {
                        String select = PanelSach.NXBSach.getSelectedItem().toString();
                        cls.VeJComboxNXB(PanelSach.NXBSach);
                        PanelSach.NXBSach.setSelectedItem(select);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không thể xoá được");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xóa");
        }
    }
}
