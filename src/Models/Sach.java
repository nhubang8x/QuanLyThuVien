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
public class Sach {

    private int MaSach;
    private String TenSach;
    private int MaNXB;
    private int MaTacGia;
    private int MaTheLoai;
    private String TomTat;
    private Date NgayXB;
    private int SoTrang;
    private int MaNgonNgu;
    private byte[] Bia;
    private int GiaBan;
    private int Soluong;
    private int SoMat;
    private String Tang;
    private String Phong;
    private String Gia;
    private String Ke;
    private int Trangthai;

    public Sach() {
    }

    public Sach(int MaSach, String TenSach, int MaNXB, int MaTacGia, int MaTheLoai, String TomTat, Date NgayXB, int SoTrang, int MaNgonNgu, byte[] Bia, int GiaBan, int Soluong, int SoMat, String Tang, String Phong, String Gia, String Ke, int Trangthai) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.MaNXB = MaNXB;
        this.MaTacGia = MaTacGia;
        this.MaTheLoai = MaTheLoai;
        this.TomTat = TomTat;
        this.NgayXB = NgayXB;
        this.SoTrang = SoTrang;
        this.MaNgonNgu = MaNgonNgu;
        this.Bia = Bia;
        this.GiaBan = GiaBan;
        this.Soluong = Soluong;
        this.SoMat = SoMat;
        this.Tang = Tang;
        this.Phong = Phong;
        this.Gia = Gia;
        this.Ke = Ke;
        this.Trangthai = Trangthai;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(int MaNXB) {
        this.MaNXB = MaNXB;
    }

    public int getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(int MaTacGia) {
        this.MaTacGia = MaTacGia;
    }

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTomTat() {
        return TomTat;
    }

    public void setTomTat(String TomTat) {
        this.TomTat = TomTat;
    }

    public Date getNgayXB() {
        return NgayXB;
    }

    public void setNgayXB(Date NgayXB) {
        this.NgayXB = NgayXB;
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

    public byte[] getBia() {
        return Bia;
    }

    public void setBia(byte[] Bia) {
        this.Bia = Bia;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getSoMat() {
        return SoMat;
    }

    public void setSoMat(int SoMat) {
        this.SoMat = SoMat;
    }

    public String getTang() {
        return Tang;
    }

    public void setTang(String Tang) {
        this.Tang = Tang;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String Phong) {
        this.Phong = Phong;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String Gia) {
        this.Gia = Gia;
    }

    public String getKe() {
        return Ke;
    }

    public void setKe(String Ke) {
        this.Ke = Ke;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

}
