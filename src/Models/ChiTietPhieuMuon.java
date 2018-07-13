/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Hà
 */
public class ChiTietPhieuMuon {
    private int MaPhieuMuon;
    private int MaChiTietSach;
    private int TrangThaiSach;

    public ChiTietPhieuMuon() {
    }

    public ChiTietPhieuMuon(int MaPhieuMuon, int MaChiTietSach, int TrangThaiSach) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaChiTietSach = MaChiTietSach;
        this.TrangThaiSach = TrangThaiSach;
    }

    public int getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(int MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public int getMaChiTietSach() {
        return MaChiTietSach;
    }

    public void setMaChiTietSach(int MaChiTietSach) {
        this.MaChiTietSach = MaChiTietSach;
    }

    public int getTrangThaiSach() {
        return TrangThaiSach;
    }

    public void setTrangThaiSach(int TrangThaiSach) {
        this.TrangThaiSach = TrangThaiSach;
    }
    
}
