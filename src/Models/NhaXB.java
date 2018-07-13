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
public class NhaXB {
    private int MaNXB;
    private String TenNXB;
    private String DiaChi;
    private String DienThoai;

    public NhaXB() {
    }

    public NhaXB(int MaNXB, String TenNXB, String DiaChi, String DienThoai) {
        this.MaNXB = MaNXB;
        this.TenNXB = TenNXB;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }

    public int getMaNXB() {
        return MaNXB;
    }

    public void setMaNXB(int MaNXB) {
        this.MaNXB = MaNXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
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
    
}
