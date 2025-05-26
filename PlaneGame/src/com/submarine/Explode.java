package com.submarine;
import java.awt.*;

import java.awt.Image;

public class Explode{

    public Explode(int x,int y){
        this.x =x;
        this.y =y;


    }

    int x,y;
    static Image [] img = new Image [12];
    static{
        for(int i=0;i<img.length-1;i++){
            img [i] = GameUtil.getImage("全部GIF图片帧/"+(1+i)+".png");
            img [i].getWidth(null);
        }
    }
    int count;
    boolean live =true;

    public void draw(Graphics c){
       if(count<img.length) {
        c.drawImage((img [count]), x, y,75,75,null);
        count++;
    }else{
        live = false;
    }

    }




}