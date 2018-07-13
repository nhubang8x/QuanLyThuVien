/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Huy Thắng
 */
public class ControllerCheck {

    Controller cl = new Controller();

    public static boolean checkNumber(String s) {
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean checkTel(String s) {
        Pattern pattern = Pattern.compile("0[1-9]\\d{8,9}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean checkCMND(String s) {
        Pattern pattern = Pattern.compile("\\d{9}||\\d{12}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static boolean checkEmail(String s) {
        Pattern pattern = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static String DateNow() {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        return sdf.format(today.getTime());
    }

    public static String showCalendar(Calendar calendar) {
        // Hàm showCalender truyền vào giá trị calendar và đưa ra ngoài dòng chuỗi trả về
        // Có thể gọi ở main bằng cách dùng showCalender(<calendar>)
        int year = calendar.get(Calendar.YEAR);
        // Trả về giá trị từ 0 - 11  => công thêm 1 khi xuất ra màn hình
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return " " + ((day < 10) ? "0" + day : "" + day) + "-" + (((month + 1) < 10) ? "0" + (month + 1) : "" + (month + 1)) + "-" + year;
    }

    public static String ExpirationDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 1);
        return showCalendar(c);
    }

    public static String DateOfAppointment() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 14);
        return showCalendar(c);
    }

    public static String Extend(Date DateOfAppointment) {
        Calendar cal = Calendar.getInstance();
        if (DateOfAppointment.after(new Date()) == true) {
            cal.setTime(DateOfAppointment);
            cal.add(Calendar.YEAR, 1);
        } else {
            cal.add(Calendar.YEAR, 1);
        }
        return showCalendar(cal);
    }

    public static int ChoosenFind(String s) {
        int rt = 0;
        if (s.equals("Còn hạn") || s.equals("Đang Làm") || s.equals("Còn Sách")) {
            rt = 1;
        } else if (s.equals("Hết hạn") || s.equals("Đã Nghỉ") || s.equals("Hết Sách")) {
            rt = 0;
        }
        return rt;
    }

    public static String SexString(int s) {
        String rt = null;
        if (s == 0) {
            rt = "Nam";
        } else if (s == 1) {
            rt = "Nữ";
        }
        return rt;
    }

    public static int SexInt(String s) {
        int rt = 0;
        if (s.equals("Nam")) {
            rt = 0;
        } else if (s.equals("Nữ")) {
            rt = 1;
        }
        return rt;
    }

    public static String StatusStringNhanVien(int s) {
        String rt = null;
        if (s == 1) {
            rt = "Đang Làm";
        } else if (s == 0) {
            rt = "Đã Nghỉ";
        }
        return rt;
    }

    public static int StatusIntNhanVien(String s) {
        int rt = 0;
        if (s.equals("Đang Làm")) {
            rt = 1;
        } else if (s.equals("Đã Nghỉ")) {
            rt = 0;
        }
        return rt;
    }

    public static String StatusStringBanDoc(int s) {
        String rt = null;
        if (s == 1) {
            rt = "Còn Hạn";
        } else if (s == 0) {
            rt = "Hết Hạn";
        }
        return rt;
    }

    public static int StatusIntBanDoc(String s) {
        int rt = 0;
        if (s.equals("Còn Hạn")) {
            rt = 1;
        } else if (s.equals("Hết Hạn")) {
            rt = 0;
        }
        return rt;
    }

    public static String DecentralizationString(int s) {
        String rt = null;
        if (s == 1) {
            rt = "Administrator";
        } else if (s == 0) {
            rt = "Nhân Viên";
        }
        return rt;
    }

    public static int DecentralizationInt(String s) {
        int rt = 0;
        if (s.equals("Administrator")) {
            rt = 1;
        } else if (s.equals("Nhân Viên")) {
            rt = 0;
        }
        return rt;
    }

    public static String StatusStringPhieuMuon(int s) {
        String rt = null;
        switch (s) {
            case 0:
                rt = "Đã Trả";
                break;
            case 1:
                rt = "Đang Mượn";
                break;
            case 2:
                rt = "Quá Hạn";
                break;
            case 3:
                rt = "Quá Hạn + Mất/Hỏng Sách";
                break;
            default:
                rt = "Mất/Hỏng sách";
                break;
        }
        return rt;
    }

    public static int StatusIntPhieuMuon(String s) {
        int rt = 0;
        switch (s) {
            case "Đang Mượn":
                rt = 1;
                break;
            case "Đã Trả":
                rt = 0;
                break;
            case "Quá Hạn":
                rt = 2;
                break;
            case "Quá Hạn + Mất/Hỏng Sách":
                rt = 3;
                break;
            case "Mất/Hỏng sách":
                rt = 4;
                break;
            default:
                break;
        }
        return rt;
    }

    public static String StatusStringCTPhieuMuon(int s) {
        String rt = null;
        switch (s) {
            case 0:
                rt = "Đã Trả";
                break;
            case 1:
                rt = "Đang Mượn";
                break;
            case 2:
                rt = "Mất Sách / Hỏng Sách";
                break;
            default:
                break;
        }
        return rt;
    }

    public static int StatusIntCTPhieuMuon(String s) {
        int rt = 0;
        switch (s) {
            case "Đang Mượn":
                rt = 1;
                break;
            case "Đã Trả":
                rt = 0;
                break;
            case "Mất Sách / Hỏng Sách":
                rt = 2;
                break;
            default:
                break;
        }
        return rt;
    }

    public static String StatusStringSach(int s) {
        String rt = null;
        if (s == 1) {
            rt = "Còn sách";
        } else if (s == 0) {
            rt = "Hết Sách";
        }
        return rt;
    }

    public static int StatusIntSach(String s) {
        int rt = 0;
        if (s.equals("Hết sách")) {
            rt = 1;
        } else if (s.equals("Còn sách")) {
            rt = 0;
        }
        return rt;
    }

    public String sNgonNgu(String s) {
        String rt;
        if (s.equals("Tất cả")) {
            rt = "is not null";
        } else {
            rt = " = " + cl.ConvertNN(s);
        }
        return rt;
    }

    public String sTheLoai(String s) {
        String rt;
        if (s.equals("Tất cả")) {
            rt = "is not null";
        } else {
            rt = " = " + cl.ConvertTheLoai(s);
        }
        return rt;
    }

    public String sTacGia(String s) {
        String rt;
        if (s.equals("Tất cả")) {
            rt = "is not null";
        } else {
            rt = " = " + cl.ConvertTacGia(s);
        }
        return rt;
    }

    public String sNXB(String s) {
        String rt;
        if (s.equals("Tất cả")) {
            rt = "is not null";
        } else {
            rt = " = " + cl.ConvertNXB(s);
        }
        return rt;
    }

    public static String sMaSach(String s) {
        String rt;
        if (s.equals("")) {
            rt = "is not null";
        } else {
            rt = "LIKE " + "'%" + s + "%'";
        }
        return rt;
    }

    public static String sTenSach(String s) {
        String rt;
        if (s.equals("")) {
            rt = "is not null";
        } else {
            rt = "LIKE " + "'%" + s + "%'";
        }
        return rt;
    }

    public static String sTrangThaiSach(String s) {
        String rt = null;
        switch (s) {
            case "Còn Sách":
                rt = "= " + 1;
                break;
            case "Hết Sách":
                rt = "= " + 0;
                break;
            case "Tất Cả":
                rt = "is not null";
                break;
            default:
                break;
        }
        return rt;
    }

    public static Icon load(String linkImage, int k, int m) {
        try {
            BufferedImage image = ImageIO.read(new File(linkImage));
            int x = k;
            int y = m;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx = 0, dy = 0;
            if (x / y > ix / iy) {
                dy = y;
                dx = dy * ix / iy;
            } else {
                dx = x;
                dy = dx * iy / ix;
            }
            return new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] ConvertFile(String fileName) {
        FileInputStream fileInputStream = null;
        File file = new File(fileName);
        byte[] bFile = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return bFile;
    }

    public static int TinhTrangInt(String s) {
        int rt = 0;
        switch (s) {
            case "Đang Mượn":
                rt = 0;
                break;
            case "Quá Hạn":
                rt = 2;
                break;
            case "Quá Hạn + Mất/Hỏng Sách":
                rt = 3;
                break;
            case "Mất/Hỏng sách":
                rt = 4;
                break;
            default:
                break;
        }
        return rt;
    }

}
