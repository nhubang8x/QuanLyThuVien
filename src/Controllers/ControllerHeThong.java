/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.HeThong.PanelHeThong;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Huy Thắng
 */
public class ControllerHeThong {

    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

    public void saoluu() {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String Path = "";
            if (getClass().getResource("/CSDL").toString().contains("jar!")) {
                Path = getClass().getResource("/CSDL").toString().replace("jar:file:/", "").replace("/QuanLyThuVien-Pro.jar!", "").replace("/DataAccessLayers", "");
            } else {
                Path = getClass().getResource("/CSDL").toString().replace("file:/", "");
            }
            JFileChooser fc = new JFileChooser(Path);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Backup", "bak");
            fc.setFileFilter(filter);
            fc.setSelectedFile(new File("QuanLyThuVien-Pro.bak"));
            int returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                CallableStatement cs = connect.prepareCall("{call backupdl(?,?)}");
                cs.setString(1, Settings.ReadDatabaseName());
                cs.setString(2, file.getPath());
                cs.execute();
                JOptionPane.showMessageDialog(null, "Sao Lưu Dữ Liệu Thành Công");
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi " + ex.getMessage());
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

    public void phuchoi() {
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String Path = "";
            if (getClass().getResource("/CSDL").toString().indexOf("jar!") != -1) {
                Path = getClass().getResource("/CSDL").toString().replace("jar:file:/", "").replace("/QuanLyThuVien-Pro.jar!", "").replace("/CSDL", "");
            } else {
                Path = getClass().getResource("/CSDL").toString().replace("file:/", "");
            }
            JFileChooser fc = new JFileChooser(Path);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Backup", "bak");
            fc.setFileFilter(filter);
            fc.setSelectedFile(new File("QuanLyThuVien-Pro.bak"));
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String data = Settings.ReadDatabaseName();
                ps = connect.prepareStatement("USE master; ALTER DATABASE " + data + " SET SINGLE_USER WITH ROLLBACK IMMEDIATE; ALTER DATABASE " + data + " SET MULTI_USER; RESTORE DATABASE " + data + " FROM DISK = '" + file.getPath() + "' WITH REPLACE");
                boolean i = ps.execute();
                if (i == false) {
                    JOptionPane.showMessageDialog(null, "Khôi phục thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Khôi phục không thành công");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi " + ex.getMessage());
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

    public void lephi_cuoc(JTextField jx1, JTextField jx2, JTextField jx3) {
        String tiencuoc = jx1.getText().trim();
        String lephi = jx2.getText().trim();
        String phatquahan = jx3.getText().trim();
        if (tiencuoc.isEmpty() == false) {
            try {
                int TienCuocInt = Integer.parseInt(tiencuoc);
                if (TienCuocInt <= 0) {
                    JOptionPane.showMessageDialog(null, "Tiền Cược phải lớn hơn không!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    Settings.WriteTienCuocGoc(tiencuoc);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tiền Cược phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        if (lephi.isEmpty() == false) {
            try {
                int LePhiInt = Integer.parseInt(lephi);
                if (LePhiInt <= 0) {
                    JOptionPane.showMessageDialog(null, "Lệ Phí phải lớn hơn không!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    Settings.WriteLePhi(lephi);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lệ Phí phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (phatquahan.isEmpty() == false) {
            try {
                int TienPhatQuaHan = Integer.parseInt(phatquahan);
                if (TienPhatQuaHan <= 0) {
                    JOptionPane.showMessageDialog(null, "Tiền phạt quá hạn phải lớn hơn không!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    Settings.WriteTienPhatQuaHan(phatquahan);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tiền phạt quá hạn phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        if (tiencuoc.isEmpty() == false || lephi.isEmpty() == false || phatquahan.isEmpty() == false) {
            JOptionPane.showMessageDialog(null, "Thay đổi thành công!");
            PanelHeThong.setText();
            jx1.setText("");
            jx2.setText("");
            jx3.setText("");
        }
    }
}
