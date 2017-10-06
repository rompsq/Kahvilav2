
package kahvila.classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity_3 {
    public void tick();
    public void renderoi(Graphics g);
    public Rectangle getBounds();
    
    public double getX();
    public double getY();
    public int getID();
}
