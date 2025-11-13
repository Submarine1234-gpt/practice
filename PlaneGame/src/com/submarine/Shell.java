package com.submarine;

import java.awt.*;


public class Shell extends GameObject {
    double degree;

    public Shell() {

        super(null, "shell", 250, 250, 5);
        degree = Math.random() * 2 * Math.PI;
        this.width = 10;
        this.height = 10;

    }

    @Override
    public void drawMyself(Graphics pen) {

        pen.setColor(Color.white);
        pen.fillOval(x, y, width, height);

        x = (int) (x + speed * Math.cos(degree));
        y = (int) (y + speed * Math.sin(degree));
        if (x < 0 || x > 490) {

            degree = Math.PI - degree;

        }
        if (y < 0 || y > 490) {
            degree = -(degree);
        }
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }

}
