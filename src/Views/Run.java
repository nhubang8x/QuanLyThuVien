package Views;

import Models.NhanVien;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Huy Thắng
 */
public class Run {

    public static NhanVien nv;
    public static PanelMainAdmin pma;
    public static PanelLogin pl;
    PanelLoading pld;

    public static void QLTV() {
        pma = new PanelMainAdmin();
        pma.setVisible(true);
    }

    public static void Login() {
        pl = new PanelLogin();
        pl.setVisible(true);
    }

    public static void Loading() {
        PanelLoading pld = new PanelLoading();
        pld.setVisible(true);
    }

    public static void main(String[] args) throws ParseException {
        Loading();
    }
}
