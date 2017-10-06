
package kahvila;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import kahvila.classes.Entity_3;

public class Checkpoint extends GameObject implements Entity_3 {
    int id;
    
    private Textures tex;

    public Checkpoint(double x, double y, Textures tex, int id){
        super(x,y);
        this.x = x;
        this.y = y;
        this.tex = tex;
        this.id = id;
    }
    
    public void tick(){

    }

 public void renderoi(Graphics g){
        g.drawImage(tex.panos, (int)x, (int)y, null);
    
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
    public int getID(){
        return id;
    }
    

}


