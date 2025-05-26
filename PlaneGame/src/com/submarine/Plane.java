package com.submarine;
import java.awt.*;
import java.awt.event.*;

public class Plane extends GameObject{
    public void drawMyself(Graphics pen){
        super.drawMyself(pen);
        if (live == true) {

        if(left){
            x=x-speed;
        }
        if(right){
            x=x+speed;
        }
        if(up){
            y=y-speed;
        }
        if(down){
            y=y+speed;
        } else{
            return;

        }

    }




    }
    public Plane(Image img,String name ,int x, int y, int speed){
         super(img, name, x, y, speed);
         live = true;
    }
   
    boolean left, right, up, down , live;
    public void addDrection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            up = true;
            break;
            case KeyEvent.VK_DOWN:
            down= true;
            break;
            case KeyEvent.VK_LEFT:
           left = true;
            break;
            case KeyEvent.VK_RIGHT:
            right = true;
            break;
            

        }
    }
    public void subDrection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            up = false;
            break;
            case KeyEvent.VK_DOWN:
            down= false;
            break;
            case KeyEvent.VK_LEFT:
           left = false;
            break;
            case KeyEvent.VK_RIGHT:
            right = false;
            break;
            

        }
    }
}
