/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kahvila;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import kahvila.classes.Entity_2;

public class Myyja extends GameObject implements Entity_2 {
    
    int checkPointX;
    int checkPointY;
  
    Random r = new Random();
    
    private Textures tex;
    
    private int speed = 1;//(r.nextInt(3) + 1);
    
    public Myyja(double x, double y, Textures tex){
        super(x,y);
        this.x = x;
        this.y = y;
        this.tex = tex;
    }
    
    public void tick(){
/*
    if(y<= 200){
    
    }else{
        y -= speed;
    }
    
          if(y > (Kahvila.WIDTH*Kahvila.SCALE)){
        y=-10;
        x=r.nextInt(Kahvila.WIDTH*Kahvila.SCALE);
       
} */
    //y++;
    
    }

 public void renderoi(Graphics g){
        g.drawImage(tex.myyja, (int)x, (int)y, null);
    
    }
     public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }
    
    public double getX(){
    return x; }
    public double getY(){
        return y;
    }
    
    public void setY(double y){
    this.y = y;
    }
    
    public String getTilaus(){
    return "";
    }
       //LISÄTTY ETTEI TULE ERRORIA
       public void liikuPisteeseen(int xPiste, int yPiste){
    if(x<xPiste){
    x+=speed;
    }else if(x>xPiste){
    x-=speed;
    }
    //y
    if(y<xPiste){
    y+=speed;
    }else if(y>xPiste){
    y-=speed;
    }
    }
       
           public int setCheckX(double x){
        checkPointX = (int)x;
    return checkPointX;
    }
      public int setCheckY(double y){
         checkPointY = (int)y;
    return checkPointY;
    }

}