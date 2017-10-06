
package kahvila;


import java.util.LinkedList;
import kahvila.classes.Entity_1;
import kahvila.classes.Entity_2;
import kahvila.classes.Entity_3;


public class Fysiikat{
    
    
    //COLLISION
    public static boolean Collision(Entity_1 ent1, LinkedList<Entity_2> ent2){
    
        for(int i=0; i<ent2.size(); i++ ){ //käydään koko ent2 listan objektit läpi
        
            if(ent1.getBounds().intersects(ent2.get(i).getBounds())){  //jos e1 osuu e2 reunoihin -> TÖRMÄYS
            return true;
            }
        }
        return false;
    }
    public static boolean CollisionCheckPelaaja(Entity_3 ent3, LinkedList<Entity_2> ent2){
    
        for(int i=0; i<ent2.size(); i++ ){ //käydään koko ent2 listan objektit läpi
        
            if(ent3.getBounds().intersects(ent2.get(i).getBounds())){  //jos e1 osuu e2 reunoihin -> TÖRMÄYS
            return true;
            }
        }
        return false;
    }

    
}
