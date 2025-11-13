package com.submarine;

import java.awt.*;

public class GameObject {
    Image img;
    String name;
    int x, y;
    int speed;
    int width, height;

    public void drawMyself(Graphics pen) {
        pen.drawImage(img, x, y, width, height, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }

    public GameObject(Image img, String name, int x, int y, int speed) {

        this.img = img;
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;

        if (img != null) {
            this.width = img.getWidth(null);
            this.height = img.getHeight(null);
        }

    }

}
