/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huy Thắng
 */
public class Settings {

    public static Properties pro = new Properties();

    public static void CheckAndWriteSettings() {
        File fl = new File("config.properties");
        if (fl.exists() == false) {
            try {
                pro.setProperty("Wallpaper", "Wall1");
                pro.setProperty("Host", "");
                pro.setProperty("Port", "");
                pro.setProperty("DatabaseName", "");
                pro.setProperty("User", "");
                pro.setProperty("PassWord", "");
                pro.setProperty("LePhi", "500000");
                pro.setProperty("TienCuocGoc", "120000");
                pro.setProperty("TienPhatQuanHan", "50000");
                pro.store(new FileOutputStream("config.properties"), null);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void WriteWallpaper(String s) {
        try {
            pro.setProperty("Wallpaper", s);
            pro.store(new FileOutputStream("config.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String ReadWallpaper() {
        String line = "";
        boolean check = true;
        while (check) {
            try {
                pro.load(new FileInputStream("config.properties"));
                line = pro.getProperty("Wallpaper");
                if (line.isEmpty()) {
                    WriteWallpaper("Wall1");
                } else {
                    if (line.equals("Wall1") || line.equals("Wall2")) {
                        check = false;
                    } else {
                        WriteWallpaper("Wall1");
                    }

                }
            } catch (FileNotFoundException ex) {
                WriteWallpaper("Wall1");
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                WriteWallpaper("Wall1");
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                WriteWallpaper("Wall1");
            }
        }
        return line;
    }

    public static void WriteDatabase(Database db) {
        try {
            pro.setProperty("Host", db.getHost());
            pro.setProperty("Port", db.getPort());
            pro.setProperty("DatabaseName", db.getDbName());
            pro.setProperty("User", db.getUser());
            pro.setProperty("PassWord", db.getPassword());
            pro.store(new FileOutputStream("config.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Database ReadDatabase() {
        Database db = new Database();
        try {
            pro.load(new FileInputStream("config.properties"));
            db.setHost(pro.getProperty("Host"));
            db.setPort(pro.getProperty("Port"));
            db.setDbName(pro.getProperty("DatabaseName"));
            db.setUser(pro.getProperty("User"));
            db.setPassword(pro.getProperty("PassWord"));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }

    public static void WriteLePhi(String s) {
        try {
            pro.setProperty("LePhi", s);
            pro.store(new FileOutputStream("config.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String ReadLePhi() {
        String line = "";
        try {
            pro.load(new FileInputStream("config.properties"));
            line = pro.getProperty("LePhi");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public static void WriteTienCuocGoc(String s) {
        try {
            pro.setProperty("TienCuocGoc", s);
            pro.store(new FileOutputStream("config.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String ReadTienCuocGoc() {
        String line = "";
        try {
            pro.load(new FileInputStream("config.properties"));
            line = pro.getProperty("TienCuocGoc");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public static String ReadDatabaseName() {
        String line = "";
        try {
            pro.load(new FileInputStream("config.properties"));
            line = pro.getProperty("DatabaseName");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public static void WriteTienPhatQuaHan(String s) {
        try {
            pro.setProperty("TienPhatQuanHan", s);
            pro.store(new FileOutputStream("config.properties"), null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String ReadTienPhatQuanHan() {
        String line = "";
        try {
            pro.load(new FileInputStream("config.properties"));
            line = pro.getProperty("TienPhatQuanHan");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public static int ReadTienPhatQuanHanInt() {
        int tcc = 0;
        boolean check = true;
        while (check) {
            try {
                tcc = Integer.parseInt(Settings.ReadTienPhatQuanHan());
                if (tcc <= 0) {
                    Settings.WriteTienPhatQuaHan("50000");
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {
                Settings.WriteTienPhatQuaHan("50000");
            }
        }
        return tcc;
    }

    public static int ReadTienCuocGocInt() {
        int tcc = 0;
        boolean check = true;
        while (check) {
            try {
                tcc = Integer.parseInt(Settings.ReadTienCuocGoc());
                check = false;
                if (tcc <= 0) {
                    Settings.WriteTienCuocGoc("500000");
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {
                Settings.WriteTienCuocGoc("500000");
            }
        }
        return tcc;
    }

    public static int ReadLePhiInt() {
        int tcc = 0;
        boolean check = true;
        while (check) {
            try {
                tcc = Integer.parseInt(Settings.ReadLePhi());
                if (tcc <= 0) {
                    Settings.WriteLePhi("150000");
                } else {
                    check = false;
                }
            } catch (NumberFormatException e) {
                Settings.WriteLePhi("150000");
            }
        }
        return tcc;
    }
}
