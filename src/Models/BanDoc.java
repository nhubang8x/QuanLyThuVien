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
public class BanDoc {

    private int MaBanDoc;
    private String Tendangnhap;
    private String Matkhau;
    private String HoTen;
    private String CMND;
    private byte[] Anh;
    private String DiaChi;
    private String DienThoai;
    private String Email;
    private Date NgaySinh;
    private int GioiTinh;
    private Date NgayTao;
    private int TienCuoc;
    private Date NgayHetHan;
    private int TrangThai;

    public BanDoc() {
    }

    public BanDoc(int MaBanDoc, String Tendangnhap, String Matkhau, String HoTen, String CMND, byte[] Anh, String DiaChi, String DienThoai, String Email, Date NgaySinh, int GioiTinh, Date NgayTao, int TienCuoc, Date NgayHetHan, int TrangThai) {
        this.MaBanDoc = MaBanDoc;
        this.Tendangnhap = Tendangnhap;
        this.Matkhau = Matkhau;
        this.HoTen = HoTen;
        this.CMND = CMND;
        this.Anh = Anh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.Email = Email;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.NgayTao = NgayTao;
        this.TienCuoc = TienCuoc;
        this.NgayHetHan = NgayHetHan;
        this.TrangThai = TrangThai;
    }

    public int getMaBanDoc() {
        return MaBanDoc;
    }

    public void setMaBanDoc(int MaBanDoc) {
        this.MaBanDoc = MaBanDoc;
    }

    public String getTendangnhap() {
        return Tendangnhap;
    }

    public void setTendangnhap(String Tendangnhap) {
        this.Tendangnhap = Tendangnhap;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public byte[] getAnh() {
        return Anh;
    }

    public void setAnh(byte[] Anh) {
        this.Anh = Anh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTienCuoc() {
        return TienCuoc;
    }

    public void setTienCuoc(int TienCuoc) {
        this.TienCuoc = TienCuoc;
    }

    public Date getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(Date NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

   

}
