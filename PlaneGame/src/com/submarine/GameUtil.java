package com.submarine;
import java.awt.*;
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;

import javax.imageio.ImageIO;

public class GameUtil {
    public static Image getImage(String path){
        Image img = null;

        URL url = GameUtil.class.getClassLoader().getResource(path);
        try{
            img = ImageIO.read(url);



        }catch(IOException e){
            e.printStackTrace();

        }
        return img;


    }

    public class Audioplayer{



    public static void play(String path){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioInputStream);

              clip.start();



        }catch(LineUnavailableException | IOException | UnsupportedAudioFileException e){
            
            e.printStackTrace();

        }
        
        
        
        
        }
    }
}
    

