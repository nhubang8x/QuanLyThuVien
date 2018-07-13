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
public class NgonNgu {
    private int MaNgonNgu;
    private String NgonNgu;

    public NgonNgu() {
    }

    public NgonNgu(int MaNgonNgu, String NgonNgu) {
        this.MaNgonNgu = MaNgonNgu;
        this.NgonNgu = NgonNgu;
    }

    public int getMaNgonNgu() {
        return MaNgonNgu;
    }

    public void setMaNgonNgu(int MaNgonNgu) {
        this.MaNgonNgu = MaNgonNgu;
    }

    public String getNgonNgu() {
        return NgonNgu;
    }

    public void setNgonNgu(String NgonNgu) {
        this.NgonNgu = NgonNgu;
    }
    
}
