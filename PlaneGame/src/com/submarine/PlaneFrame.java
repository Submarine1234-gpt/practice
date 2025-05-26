package com.submarine;

import java.util.*;

import com.submarine.GameUtil.Audioplayer;

import java.awt.*;
import java.awt.event.*;

public class PlaneFrame extends Frame {
    Image backGround = GameUtil.getImage("images/Galaxy.jpg");
    Image planeI = GameUtil.getImage("images/Helicopter2.png");
    Plane plane = new Plane(GameUtil.getImage("images/Helicopter2.png"), "牢大", 30, 30, 20);
    Shell[] shell = new Shell[10];
    Explode explode;
    Audioplayer audioplayer;
    Date time1 = new Date();
    int tk;
    Date time2;
    boolean game = true;

    public void LauchFrame() {
        this.setTitle("傻逼游戏");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(200, 200);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent b) {
                System.exit(0);
            }
        });

        this.addKeyListener(new keyMonitor());

        // 定时刷新窗口

        new Thread(() -> {
            while (true) {
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }
            }
        }).start();

        for (int i = 0; i < shell.length - 1; i++) {
            shell[i] = new Shell();

        }

    }

    public static void main(String[] args) {
        PlaneFrame a = new PlaneFrame();
        a.LauchFrame();

    }

    private Image offScreenImage = null;

    @Override
    public void update(Graphics pen) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(500, 500); // 窗口大小
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff); // 先在内存图像上画
        pen.drawImage(offScreenImage, 0, 0, null); // 再整体画到屏幕
    }

    public void paint(Graphics pen) {

        pen.drawImage(backGround, 0, 0, 500, 500, null);
        plane.drawMyself(pen);
        if (!plane.live) {
            if (game) {
                printInfo(pen, "存活时间" + tk + "秒", 40, 20, 400, (new Color(36, 173, 100)));
                printInfo(pen, "曼巴OUT", 50, 50, 250, (new Color(36, 173, 243)));
                Audioplayer
                        .play("//C://Users//Submarine//OneDrive//桌面//JavaPractice//PlaneGame//src//audio//manba.wav");
                game = false;
                
            }
            return;

        } else {

            for (int i = 0; i < shell.length - 1; i++) {
                shell[i].drawMyself(pen);

                boolean boom = shell[i].getRec().intersects(plane.getRec());

                if (boom) {

                    plane.live = false;

                    Date time2 = new Date();
                    tk = ((int) (time2.getTime() - time1.getTime())) / 1000;

                    if (explode == null) {
                        explode = new Explode(plane.x, plane.y);
                    }

                    explode.draw(pen);

                }
            }
        }

    }

    public class keyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            plane.addDrection(e);
        }

        public void keyReleased(KeyEvent e) {
            plane.subDrection(e);
        }

    }

    public void printInfo(Graphics pen, String str, int size, int x, int y, Color color) {
        Graphics old = pen;

        Font f = new Font("微软雅黑", Font.BOLD, size);
        pen.setFont(f);
        pen.setColor(color);
        pen.drawString(str, x, y);
        pen = old;

    }

}