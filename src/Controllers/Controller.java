/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.BanDoc;
import Models.NgonNgu;
import Models.NhaXB;
import Models.NhanVien;
import Models.PhieuMuon;
import Models.Sach;
import Models.TacGia;
import Models.TheLoai;
import Views.PanelChangeMK;
import Views.Run;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Huy Thắng
 */
public class Controller {

    ConnectionDB con;
    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

    public String ConvertNXB(String tennxb) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select MaNXB from NhaXB where TenNXB=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setString(1, tennxb);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("MaNXB");
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
        return Ma;
    }

    public String ConvertTacGia(String tentg) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select MaTacGia from TacGia where TenTacGia=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setString(1, tentg);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("MaTacGia");
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
        return Ma;
    }

    public String ConvertTheLoai(String tentl) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select MaTheLoai from TheLoai where TenTheLoai=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setString(1, tentl);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("MaTheLoai");
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
        return Ma;
    }

    public String ConvertNN(String tennn) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select MaNgonNgu from NgonNgu where TenNgonNgu=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setString(1, tennn);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("MaNgonNgu");
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
        return Ma;
    }

    public String ConvertTenNXB(int MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select TenNXB from NhaXB where MaNXB =?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, MaNXB);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("TenNXB");
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
        return Ma;
    }

    public String ConvertTenTacGia(int MaTacGia) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select TenTacGia from TacGia where MaTacGia=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, MaTacGia);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("TenTacGia");
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
        return Ma;
    }

    public String ConvertTenTheLoai(int MaTheLoai) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select TenTheLoai from TheLoai where MaTheLoai=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, MaTheLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("TenTheLoai");
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
        return Ma;
    }

    public String ConvertTenNN(int MaNgonNgu) {
        con = new ConnectionDB();
        connect = con.connect();
        String Ma = null;
        try {
            String sqlcmd = "select TenNgonNgu from NgonNgu where MaNgonNgu=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, MaNgonNgu);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ma = rs.getString("TenNgonNgu");
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
        return Ma;
    }

    public String NameAdminNhaVien(int ma) {
        con = new ConnectionDB();
        connect = con.connect();
        String Name = null;
        try {
            String sqlcmd = "select HoTen from NhanVien where MaNhanVien=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                Name = rs.getString("HoTen");
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
        return Name;
    }

    public String NameBanDoc(int ma) {
        con = new ConnectionDB();
        connect = con.connect();
        String Name = null;
        try {
            String sqlcmd = "select HoTen from BanDoc where MaBanDoc=?";
            ps = connect.prepareStatement(sqlcmd);
            ps.setInt(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                Name = rs.getString("HoTen");
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
        return Name;
    }

    public NhaXB eNhaXB(String MaNXB) {
        con = new ConnectionDB();
        connect = con.connect();
        NhaXB nxb = new NhaXB();
        try {
            String sqlCommand = "select MaNXB,TenNXB,DienThoai, DiaChi from NhaXB where MaNXB = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNXB);
            rs = ps.executeQuery();
            while (rs.next()) {
                nxb.setMaNXB(rs.getInt("MaNXB"));
                nxb.setTenNXB(rs.getString("TenNXB"));
                nxb.setDienThoai(rs.getString("DienThoai"));
                nxb.setDiaChi(rs.getString("DiaChi"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return nxb;
    }

    public NgonNgu eNgonNgu(String MaNN) {
        con = new ConnectionDB();
        connect = con.connect();
        NgonNgu nn = new NgonNgu();
        try {
            String sqlCommand = "select MaNgonNgu,TenNgonNgu from NgonNgu where MaNgonNgu = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNN);
            rs = ps.executeQuery();
            while (rs.next()) {
                nn.setMaNgonNgu(rs.getInt("MaNgonNgu"));
                nn.setNgonNgu(rs.getString("TenNgonNgu"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return nn;
    }

    public TheLoai eTheLoai(String MaTL) {
        con = new ConnectionDB();
        connect = con.connect();
        TheLoai tl = new TheLoai();
        try {
            String sqlCommand = "select MaTheLoai,TenTheLoai from TheLoai where MaTheLoai = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTL);
            rs = ps.executeQuery();
            while (rs.next()) {
                tl.setMaTheLoai(rs.getInt("MaTheLoai"));
                tl.setTenTheLoai(rs.getString("TenTheLoai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return tl;
    }

    public TacGia eTacGia(String MaTG) {
        con = new ConnectionDB();
        connect = con.connect();
        TacGia tg = new TacGia();
        try {
            String sqlCommand = "select * from TacGia where MaTacGia = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaTG);
            rs = ps.executeQuery();
            while (rs.next()) {
                tg.setMaTacGia(rs.getInt("MaTacGia"));
                tg.setTenTacGia(rs.getString("TenTacGia"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return tg;
    }

    public BanDoc eBanDoc(String MaBD) {
        con = new ConnectionDB();
        connect = con.connect();
        BanDoc bd = new BanDoc();
        try {
            String sqlCommand = "select * from BanDoc where MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaBD);
            rs = ps.executeQuery();
            while (rs.next()) {
                bd.setMaBanDoc(rs.getInt("MaBanDoc"));
                bd.setTendangnhap(rs.getString("Tendangnhap"));
                bd.setMatkhau(rs.getString("MatKhau"));
                bd.setHoTen(rs.getString("HoTen"));
                bd.setCMND(rs.getString("CMND"));
                bd.setAnh(rs.getBytes("Anh"));
                bd.setDiaChi(rs.getString("DiaChi"));
                bd.setDienThoai(rs.getString("DienThoai"));
                bd.setEmail(rs.getString("Email"));
                bd.setNgaySinh(rs.getDate("NgaySinh"));
                bd.setGioiTinh(rs.getInt("GioiTinh"));
                bd.setNgayTao(rs.getDate("NgayTao"));
                bd.setTienCuoc(rs.getInt("TienCuoc"));
                bd.setNgayHetHan(rs.getDate("NgayHetHan"));
                bd.setTrangThai(rs.getInt("TrangThai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return bd;
    }

    public NhanVien eNhanVien(String MaNV) {
        con = new ConnectionDB();
        connect = con.connect();
        NhanVien nv = new NhanVien();
        try {
            String sqlCommand = "select * from NhanVien where MaNhanVien = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv.setMaNhanVien(rs.getInt("MaNhanVien"));
                nv.setAnh(rs.getBytes("Anh"));
                nv.setTendangnhap(rs.getString("Tendangnhap"));
                nv.setMatkhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setCMND(rs.getString("CMND"));
                nv.setDienThoai(rs.getString("DienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setPhanQuyen(rs.getInt("PhanQuyen"));
                nv.setTrangThai(rs.getInt("TrangThai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return nv;
    }

    public NhanVien eNhanVienTKMK(String user, String mk) {
        con = new ConnectionDB();
        connect = con.connect();
        NhanVien nv = new NhanVien();
        try {
            String sqlCommand = "select * from NhanVien where Tendangnhap = ? and Matkhau=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, user);
            ps.setString(2, mk);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv.setMaNhanVien(rs.getInt("MaNhanVien"));
                nv.setAnh(rs.getBytes("Anh"));
                nv.setTendangnhap(rs.getString("Tendangnhap"));
                nv.setMatkhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setCMND(rs.getString("CMND"));
                nv.setDienThoai(rs.getString("DienThoai"));
                nv.setEmail(rs.getString("Email"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setPhanQuyen(rs.getInt("PhanQuyen"));
                nv.setTrangThai(rs.getInt("TrangThai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return nv;
    }

    public BanDoc eBanDocTKMK(String user, String pass) {
        con = new ConnectionDB();
        connect = con.connect();
        BanDoc bd = new BanDoc();
        try {
            String sqlCommand = "select * from BanDoc where Tendangnhap = ? and MatKhau=?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                bd.setMaBanDoc(rs.getInt("MaBanDoc"));
                bd.setTendangnhap(rs.getString("Tendangnhap"));
                bd.setMatkhau(rs.getString("MatKhau"));
                bd.setHoTen(rs.getString("HoTen"));
                bd.setCMND(rs.getString("CMND"));
                bd.setAnh(rs.getBytes("Anh"));
                bd.setDiaChi(rs.getString("DiaChi"));
                bd.setDienThoai(rs.getString("DienThoai"));
                bd.setEmail(rs.getString("Email"));
                bd.setNgaySinh(rs.getDate("NgaySinh"));
                bd.setGioiTinh(rs.getInt("GioiTinh"));
                bd.setNgayTao(rs.getDate("NgayTao"));
                bd.setTienCuoc(rs.getInt("TienCuoc"));
                bd.setNgayHetHan(rs.getDate("NgayHetHan"));
                bd.setTrangThai(rs.getInt("TrangThai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return bd;
    }

    public Sach eSach(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        Sach sch = new Sach();
        try {
            String sqlCommand = "select * from Sach where MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                sch.setMaSach(rs.getInt("MaSach"));
                sch.setTenSach(rs.getString("TenSach"));
                sch.setNgayXB(rs.getDate("NgayXB"));
                sch.setSoTrang(rs.getInt("SoTrang"));
                sch.setGiaBan(rs.getInt("GiaBan"));
                sch.setSoluong(rs.getInt("SoLuong"));
                sch.setSoMat(rs.getInt("SoMat"));
                sch.setTomTat(rs.getString("TomTat"));
                sch.setMaNXB(rs.getInt("MaNXB"));
                sch.setMaNgonNgu(rs.getInt("MaNgonNgu"));
                sch.setMaTacGia(rs.getInt("MaTacGia"));
                sch.setMaTheLoai(rs.getInt("MaTheLoai"));
                sch.setBia(rs.getBytes("Bia"));
                sch.setTang(rs.getString("Tang"));
                sch.setPhong(rs.getString("Phong"));
                sch.setGia(rs.getString("Gia"));
                sch.setKe(rs.getString("Ke"));
                sch.setTrangthai(rs.getInt("TrangThai"));
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return sch;
    }

    public PhieuMuon ePhieuMuon(String MaPM) {
        con = new ConnectionDB();
        connect = con.connect();
        PhieuMuon pm = new PhieuMuon();
        try {
            String sqlCommand = "select * from PhieuMuon where MaPhieuMuon = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaPM);
            rs = ps.executeQuery();
            while (rs.next()) {
                pm.setMaPhieuMuon(rs.getInt("MaPhieuMuon"));
                pm.setMaBanDoc(rs.getInt("MaBanDoc"));
                pm.setMaNhanVien(rs.getInt("MaNhanVien"));
                pm.setNgayMuon(rs.getDate("NgayMuon"));
                pm.setNgayTra(rs.getDate("NgayTra"));
                pm.setHanTra(rs.getDate("HanTra"));
                pm.setTienPhat(rs.getInt("TienPhat"));
                pm.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Giáº£i phĂ³ng tĂ i nguyĂªn
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return pm;
    }

    public int SumSachCon(int MaSach) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT (SoLuong - SoMat -(SELECT coalesce(SUM(SoLuong),0) FROM ChiTietPhieuMuon WHERE MaSach = ? AND TrangThaiSach=1)) FROM Sach WHERE MaSach =?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaSach);
            ps.setInt(2, MaSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int SumSachConLai(String MaSach) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT (SoLuong - SoMat -(SELECT coalesce(SUM(SoLuong),0) FROM ChiTietPhieuMuon WHERE MaSach = ? AND TrangThaiSach=1)) FROM Sach WHERE MaSach =?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            ps.setString(2, MaSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountDanhMuc(int MaTheLoai) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaTheLoai),0) FROM Sach WHERE MaTheLoai = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaTheLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountTacGia(int MaTacGia) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaTacGia),0) FROM Sach WHERE MaTacGia = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaTacGia);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountNXB(int MaNXB) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaNXB),0) FROM Sach WHERE MaNXB = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNXB);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountNgonNgu(int MaNgonNgu) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaNgonNgu),0) FROM Sach WHERE MaNgonNgu = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaNgonNgu);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBD(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBDDaTra(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =0";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBDDangMuon(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =1";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBDQuaHan(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =2";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBDQuaHan_Mat(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =3";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountBDMat(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =4";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPM() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPMDaTra() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon WHERE TrangThai = 0";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPMDangMuon() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon WHERE TrangThai =1";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPMQuaHan() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon WHERE TrangThai =2";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPMQuaHan_Mat() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon WHERE TrangThai =3";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int CountPMMat() {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(*),0) FROM PhieuMuon WHERE TrangThai =4";
            ps = connect.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public void chaneMKAdmin(JPasswordField jx1, JPasswordField jx2, JPasswordField jx3, PanelChangeMK pcmk) {
        String passcu = new String(jx1.getPassword());
        String passmoi = new String(jx2.getPassword());
        String repassmoi = new String(jx3.getPassword());
        if (passcu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx1.requestFocus();
            return;
        }
        if (passmoi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx2.requestFocus();
            return;
        }
        if (repassmoi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không được để trống!", "Lỗi", JOptionPane.ERROR);
            jx3.requestFocus();
            return;
        }
        if (MD5Encryption.encryptMD5(passcu).equals(Run.nv.getMatkhau()) == false) {
            JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx1.requestFocus();
            return;
        }
        if (passmoi.length() < 6 || passmoi.length() > 13) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới phải từ 6 - 13 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx2.requestFocus();
            return;
        }
        if (repassmoi.equals(passmoi) == false) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không khớp với mật khẩu cũ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx3.requestFocus();
            return;
        }
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE NhanVien SET MatKhau = ? WHERE MaNhanVien = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MD5Encryption.encryptMD5(passmoi));
            ps.setInt(2, Run.nv.getMaNhanVien());
            int i = ps.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Sửa Mật khẩu không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sửa mật khẩu thành công!");
                pcmk.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public void chaneMKBanDoc(JPasswordField jx1, JPasswordField jx2, JPasswordField jx3, BanDoc bd, PanelChangeMK pcmk) {
        String passcu = new String(jx1.getPassword());
        String passmoi = new String(jx2.getPassword());
        String repassmoi = new String(jx3.getPassword());
        if (passcu.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx1.requestFocus();
            return;
        }
        if (passmoi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx2.requestFocus();
            return;
        }
        if (repassmoi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx3.requestFocus();
            return;
        }
        if (MD5Encryption.encryptMD5(passcu).equals(bd.getMatkhau()) == false) {
            JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx1.requestFocus();
            return;
        }
        if (passmoi.length() < 6 || passmoi.length() > 13) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới phải từ 6 - 13 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx2.requestFocus();
            return;
        }
        if (repassmoi.equals(passmoi) == false) {
            JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không khớp với mật khẩu cũ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            jx3.requestFocus();
            return;
        }
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "UPDATE BanDoc SET MatKhau = ? WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MD5Encryption.encryptMD5(passmoi));
            ps.setInt(2, bd.getMaBanDoc());
            int i = ps.executeUpdate();
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Sửa Mật khẩu không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sửa mật khẩu thành công!");
                pcmk.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int eGiaSach(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "select GiaBan from Sach where MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt("GiaBan");
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
                if (con != null) {
                    connect.close();
                }
            } catch (SQLException se) {
            }
        }
        return i;
    }

    public int CountPhieuMuonBanDoc(int MaBanDoc) {
        int i = 0;
        con = new ConnectionDB();
        connect = con.connect();
        try {
            String sqlCommand = "SELECT COALESCE(COUNT(MaBanDoc),0) FROM PhieuMuon WHERE MaBanDoc = ? and TrangThai =1";
            ps = connect.prepareStatement(sqlCommand);
            ps.setInt(1, MaBanDoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerSach.class.getName()).log(Level.SEVERE, null, ex);
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

    public int SoSachMat(String MaSach) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "SELECT SoMat FROM Sach WHERE MaSach = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaSach);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
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
        return i;
    }

    public int TienCuocBD(String MaBD) {
        con = new ConnectionDB();
        connect = con.connect();
        int i = 0;
        try {
            String sqlCommand = "SELECT TienCuoc FROM BanDoc WHERE MaBanDoc = ?";
            ps = connect.prepareStatement(sqlCommand);
            ps.setString(1, MaBD);
            rs = ps.executeQuery();
            while (rs.next()) {
                i = rs.getInt(1);
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
        return i;
    }
}
