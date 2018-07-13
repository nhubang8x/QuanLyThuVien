/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Database;
import Views.PanelAddDb;
import Views.PanelLoading;
import javax.swing.JOptionPane;

/**
 *
 * @author Huy Thắng
 */
public class addData {

    public void adData(Database db, PanelAddDb pa) {
        ConnectionDB con = new ConnectionDB();
        if (con.checkConnection2(db) == false) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối CSDL!");
        } else {
            JOptionPane.showMessageDialog(null, "Kết nối CSDL thành công!");
            Settings s = new Settings();
            s.WriteDatabase(db);
            PanelLoading pl = new PanelLoading();
            pl.setVisible(true);
            pa.dispose();
        }
    }
}
