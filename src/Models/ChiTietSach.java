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
public class ChiTietSach {
    private int MaChiTietSach;
    private int MaSach;
    private int SoTrang;
    private int MaNgonNgu;
    private String Bia;
    private int Gia;
    private int SoLuong;
    private int MaViTri;
    private int TrangThai;

    public ChiTietSach() {
    }

    public ChiTietSach(int MaChiTietSach, int MaSach, int SoTrang, int MaNgonNgu, String Bia, int Gia, int SoLuong, int MaViTri, int TrangThai) {
        this.MaChiTietSach = MaChiTietSach;
        this.MaSach = MaSach;
        this.SoTrang = SoTrang;
        this.MaNgonNgu = MaNgonNgu;
        this.Bia = Bia;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.MaViTri = MaViTri;
        this.TrangThai = TrangThai;
    }

    public int getMaChiTietSach() {
        return MaChiTietSach;
    }

    public void setMaChiTietSach(int MaChiTietSach) {
        this.MaChiTietSach = MaChiTietSach;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public int getMaNgonNgu() {
        return MaNgonNgu;
    }

    public void setMaNgonNgu(int MaNgonNgu) {
        this.MaNgonNgu = MaNgonNgu;
    }

    public String getBia() {
        return Bia;
    }

    public void setBia(String Bia) {
        this.Bia = Bia;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaViTri() {
        return MaViTri;
    }

    public void setMaViTri(int MaViTri) {
        this.MaViTri = MaViTri;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
