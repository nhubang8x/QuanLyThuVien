/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Huy Thắng
 */
public class ConnectionDB {

    Database db = null;
    private Connection con;
    private boolean flag, flag1;

    public Connection connect() {
        Settings s = new Settings();
        db = Settings.ReadDatabase();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = db.UrlConnect();
            String user = db.getUser();
            String pass = db.getPassword();
            con = DriverManager.getConnection(url, user, pass);
            flag = true;
        } catch (ClassNotFoundException ex) {
            flag = false;
        } catch (SQLException ex) {
            flag = false;
        }
        return con;
    }

    public Connection connect(Database db1) {
        Settings s = new Settings();
        db = db1;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = db.UrlConnect();
            String user = db.getUser();
            String pass = db.getPassword();
            con = DriverManager.getConnection(url, user, pass);
            flag1 = true;
        } catch (ClassNotFoundException | SQLException ex) {
            flag1 = false;
        }
        return con;
    }

    public boolean checkConnection() {
        connect();
        if (flag == false) {
            return false;
        }
        return true;
    }

    public boolean checkConnection2(Database db1) {
        connect(db1);
        if (flag1 == false) {
            return false;
        }
        return true;
    }

    
}
