
package kahvila;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import kahvila.classes.Entity_1;

public class Poyta extends GameObject implements Entity_1 {
    

    public Boolean[] paikkaVarattu = new Boolean[2];
    private Textures tex;
    
    
    public Poyta(double x, double y, Textures tex){
        super(x,y);
        this.x = x;
        this.y = y;
        this.tex = tex;
    }
    
    public void tick(){

    }

 public void renderoi(Graphics g){
        g.drawImage(tex.poyta, (int)x, (int)y, null);
    
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
    

}

