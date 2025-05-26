package com.submarine;
import java.util.*;

import com.submarine.GameUtil.Audioplayer;

import java.awt.*;
import java.awt.event.*;
public class PlaneFrame extends Frame {
    Image backGround = GameUtil.getImage("images/Galaxy.jpg");
    Image planeI = GameUtil.getImage("images/Helicopter2.png");
    Plane plane = new Plane(GameUtil.getImage("images/Helicopter2.png"),"牢大",30,30,20);
    Shell [] shell = new Shell[10];
    Explode explode;
    Audioplayer audioplayer ;
    Date time1 = new Date();
    



    public void LauchFrame(){
        this.setTitle("傻逼游戏");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(200,200);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent b){
               System.exit(0) ;
            }
        });
        

        this.addKeyListener(new keyMonitor());

        // 定时刷新窗口
        new Thread(() -> {
            while (true) {
                repaint();
                try { Thread.sleep(20); } catch (InterruptedException e) {}
            }
        }).start();

        for (int i = 0; i < shell.length-1; i++ ) {
            shell [i] = new Shell() ;

        }



        

        

    }




    public static void main(String[] args){
        PlaneFrame a = new PlaneFrame();
        a.LauchFrame();
        
    }



     private Image offScreenImage = null;

    @Override
    public void update(Graphics pen) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(500, 500); // 窗口大小
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff); // 先在内存图像上画
        pen.drawImage(offScreenImage, 0, 0, null); // 再整体画到屏幕
    }
    
    
    public void paint(Graphics pen){
        
        if(!plane.live){
             
             printInfo(pen,"曼巴OUT",30,250,250,(new Color(36,173,243)));
             printInfo(pen,"time2-time1",30,250,200,(new Color(36,173,243)));
                
                }


    
        
        
        
        pen.drawImage(backGround,0,0,500,500,null);
        plane.drawMyself(pen);
        for(int i=0; i<shell.length-1; i++){

            
            shell[i].drawMyself(pen);

         

            
             boolean boom = shell[i].getRec().intersects(plane.getRec());


                 if (boom) {
                
                System.out.println("Man,What can i say");

                plane.live = false ;
               
                Date time2 = new Date();
               
                

                



                if(explode==null){
                    explode = new Explode(plane.x, plane.y);
                }

                explode.draw(pen);
                break;

                

                  }

                  
                    
                  
        
            
        

        }
        
        


    
    }

    public class keyMonitor extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            plane.addDrection(e);
        }
        public void keyReleased(KeyEvent e){
            plane.subDrection(e);
        }

    }

    public void printInfo(Graphics pen,String str, int size, int x, int y, Color color){

        Font f = new Font("微软雅黑",Font.BOLD,size);
        pen.setFont(f);
        pen.setColor(color );
        pen.drawString(str, 250, 250);

    }



   


}