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
public class TacGia {
    private int MaTacGia;
    private String TenTacGia;

    public TacGia() {
    }

    public TacGia(int MaTacGia, String TenTacGia) {
        this.MaTacGia = MaTacGia;
        this.TenTacGia = TenTacGia;
    }

    public int getMaTacGia() {
        return MaTacGia;
    }

    public void setMaTacGia(int MaTacGia) {
        this.MaTacGia = MaTacGia;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }
    
}
