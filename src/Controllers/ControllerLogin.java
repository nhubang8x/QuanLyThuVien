/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.BanDoc;
import Views.PanelMainBanDoc;
import Views.Run;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Huy Thắng
 */
public class ControllerLogin {

    PreparedStatement ps;
    ResultSet rs;

    public void CheckLoginAdmin(JTextField jtext, JPasswordField jpass) {
        ConnectionDB con = new ConnectionDB();
        Connection connect = con.connect();
        String pass = new String(jpass.getPassword()).trim();
        String user = jtext.getText().trim();
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống");
            jtext.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
            jpass.requestFocus();
            return;
        }
        try {
            String sqlCommand = "select count(*) from NhanVien where Tendangnhap = ? and MatKhau = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, user);
            ps.setString(2, MD5Encryption.encryptMD5(pass));
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc Mật khẩu không chính xác");
                    jtext.requestFocus();
                    return;
                } else {
                    Controller cl = new Controller();
                    Run.nv = cl.eNhanVienTKMK(user, MD5Encryption.encryptMD5(pass));
                    if (Run.nv.getTrangThai() == 1) {
                        Run.QLTV();
                        Run.pl.dispose();
                    } else if (Run.nv.getTrangThai() == 0) {
                        JOptionPane.showMessageDialog(null, "Tài khoản của bạn đã bị khóa! Xin vui lòng liên hệ Nhân sự để biết thêm chi tiết!");
                        jtext.requestFocus();
                        return;
                    }
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
    }

    public void CheckLoginBanDoc(JTextField jtext, JPasswordField jpass) {
        ConnectionDB con = new ConnectionDB();
        Connection connect = con.connect();
        String pass = new String(jpass.getPassword());
        String user = jtext.getText().trim();
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống");
            jtext.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
            jpass.requestFocus();
            return;
        }
        try {
            String sqlCommand = "select count(*) from BanDoc where Tendangnhap=? and MatKhau=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, user);
            ps.setString(2, MD5Encryption.encryptMD5(pass));
            rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc Mật khẩu không chính xác");
                jtext.requestFocus();
                return;
            } else {
                Controller cl = new Controller();
                BanDoc bandoc = cl.eBanDocTKMK(user, MD5Encryption.encryptMD5(pass));
                if (bandoc.getTrangThai() == 1) {
                    PanelMainBanDoc pmbd = new PanelMainBanDoc(bandoc);
                    pmbd.setVisible(true);
                    Run.pl.dispose();
                } else if (bandoc.getTrangThai() == 0) {
                    JOptionPane.showMessageDialog(null, "Tài khoản của bạn đã bị khóa! Xin vui lòng liên hệ Nhân sự để biết thêm chi tiết!");
                    jtext.requestFocus();
                    return;
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
    }

}
