
package kahvila.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity_2 {
    public void tick();
    public void renderoi(Graphics g);
     public Rectangle getBounds();
    
    public double getX();
    public double getY();
    public String getTilaus();
    public void liikuPisteeseen(int x, int y);
    public int setCheckX(double x);
    public int setCheckY(double y);
}
