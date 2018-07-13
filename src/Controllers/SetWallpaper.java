/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Huy Thắng
 */
public class SetWallpaper {

    public void SetWallpaper400x195(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            ImageIcon I1 = new ImageIcon(getClass().getResource("/Images/Screen/gray-0.png"));
            jl.setIcon(I1);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            ImageIcon I2 = new ImageIcon(getClass().getResource("/Images/Screen/blue-0.png"));
            jl.setIcon(I2);
        }
    }

    public void SetWallpaper400x210(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            ImageIcon I1 = new ImageIcon(getClass().getResource("/Images/Screen/gray-1.png"));
            jl.setIcon(I1);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            ImageIcon I2 = new ImageIcon(getClass().getResource("/Images/Screen/blue-1.png"));
            jl.setIcon(I2);
        }
    }

    public void SetWallpaper400x300(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            ImageIcon I1 = new ImageIcon(getClass().getResource("/Images/Screen/gray-2.png"));
            jl.setIcon(I1);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            ImageIcon I2 = new ImageIcon(getClass().getResource("/Images/Screen/blue-2.png"));
            jl.setIcon(I2);
        }
    }

    public void SetWallpaper400x360(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            ImageIcon I1 = new ImageIcon(getClass().getResource("/Images/Screen/gray-3.png"));
            jl.setIcon(I1);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            ImageIcon I2 = new ImageIcon(getClass().getResource("/Images/Screen/blue-3.png"));
            jl.setIcon(I2);
        }
    }

    public void SetWallpaper920x635(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            ImageIcon I1 = new ImageIcon(getClass().getResource("/Images/Screen/gray-4.png"));
            jl.setIcon(I1);
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            ImageIcon I2 = new ImageIcon(getClass().getResource("/Images/Screen/blue-4.png"));
            jl.setIcon(I2);
        }
    }

    public void SetWallpaper700x545(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-5.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-5.png")));
        }
    }

    public void SetWallpaper630x710(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-6.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-6.png")));
        }
    }

    public void SetWallpaper900x600(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-7.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-7.png")));
        }
    }

    public void SetWallpaper320x200(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-8.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-8.png")));
        }
    }

    public void SetWallpaper320x240(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-9.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-9.png")));
        }
    }

    public void SetWallpaper400x240(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-10.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-10.png")));
        }
    }

    public void SetWallpaper400x315(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-11.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-11.png")));
        }
    }

    public void SetWallpaper630x550(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-12.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-12.png")));
        }
    }

    public void SetWallpaper630x580(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-13.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-13.png")));
        }
    }

    public void SetWallpaper630x590(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-14.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-14.png")));
        }
    }
    public void SetWallpaper470x400(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-15.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-15.png")));
        }
    }
    public void SetWallpaper630x620(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-16.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-16.png")));
        }
    }
    public void SetWallpaper630x640(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-17.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-17.png")));
        }
    }
    public void SetWallpaper710x570(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-18.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-18.png")));
        }
    }
    public void SetWallpaper790x570(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-19.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-19.png")));
        }
    }
    public void SetWallpaper710x610(JLabel jl) {
        if (Settings.ReadWallpaper().equals("Wall1")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/gray-20.png")));
        } else if (Settings.ReadWallpaper().equals("Wall2")) {
            jl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Screen/blue-20.png")));
        }
    }
}
