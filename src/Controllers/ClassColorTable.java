/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClassColorTable extends DefaultTableRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component test = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            test.setBackground(Color.WHITE);
        } else {
            test.setBackground(new Color(204, 204, 204));
        }
        if (isSelected) {
            test.setBackground(new Color(102, 194, 255));
        }
        return test;
    }
    
}
