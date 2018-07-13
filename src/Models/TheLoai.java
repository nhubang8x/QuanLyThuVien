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
public class TheLoai {
    private int MaTheLoai;
    private String TenTheLoai;

    public TheLoai() {
    }

    public TheLoai(int MaTheLoai, String TenTheLoai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
    }

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }
    
}
