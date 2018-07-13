/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Hà
 */
public class PhieuMuon {
    private int MaPhieuMuon;
    private int MaNhanVien;
    private int MaBanDoc;
    private Date NgayMuon;
    private Date NgayTra;
    private Date HanTra;
    private int TienPhat;
    private int TrangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(int MaPhieuMuon, int MaNhanVien, int MaBanDoc, Date NgayMuon, Date NgayTra, Date HanTra, int TienPhat, int TrangThai) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaNhanVien = MaNhanVien;
        this.MaBanDoc = MaBanDoc;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
        this.HanTra = HanTra;
        this.TienPhat = TienPhat;
        this.TrangThai = TrangThai;
    }

    public int getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(int MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaBanDoc() {
        return MaBanDoc;
    }

    public void setMaBanDoc(int MaBanDoc) {
        this.MaBanDoc = MaBanDoc;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public Date getHanTra() {
        return HanTra;
    }

    public void setHanTra(Date HanTra) {
        this.HanTra = HanTra;
    }

    public int getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(int TienPhat) {
        this.TienPhat = TienPhat;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
