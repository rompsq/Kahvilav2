
package kahvila;

import java.awt.Graphics;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import kahvila.classes.Entity_1;
import kahvila.classes.Entity_2;
import kahvila.classes.Entity_3;
public class Controller {
    
   public LinkedList<Entity_1> e1 = new LinkedList<Entity_1>();
   public LinkedList<Entity_2> e2 = new LinkedList<Entity_2>();
   public LinkedList<Entity_3> e3 = new LinkedList<Entity_3>();
   private boolean lukitse = false; //eka checkpoint
    public int asiakasNro = 0; //KUN ASIAKAS TILAA, niin tämä nousee
    public int kassa;
    public int checkPointMaara = e3.size();
    int checkPointID;
    Boolean[] cVarattu = new Boolean[3];
  Entity_1 ent1;
  Entity_2 ent2;
  Entity_3 ent3;
  private Textures tex;
  public Boolean pelaajaJuoksee = true;
  
  public int ajastin = 0;
  
  Random r = new Random();
  
    public Controller(Textures tex){
        this.tex = tex;
      
    }

public void createAsiakas(int maara){
    for(int i=0; i < maara; i++){
    addEntity(new Asiakas(200, 400, tex, this));
    }
}
    
public void createPoyta(int x, int y){
  addEntity(new Poyta(x,y,tex));

}

public void createCheckPoint(int x, int y, int id){
  addEntity(new Checkpoint(x,y,tex, id));  //lisätään uusi id jokaiseen
}

    public void tick(){
       
        for(int i=0; i < e1.size(); i++){
        ent1 = e1.get(i);
        
        ent1.tick();
        }
        for(int i=0; i < e2.size(); i++){
        ent2 = e2.get(i);
        
        ent2.tick();
        }
            for(int i=0; i < e3.size(); i++){
        ent3 = e3.get(i);
        
        ent3.tick();
        }
       // System.out.println(e2.get(0).getY());
        
        if(Fysiikat.Collision(e1.get(0), e2)){
        System.out.println("Osuu");
        pelaajaJuoksee=false;
        
        }else{
        pelaajaJuoksee=true;
        }
        
        ajastin++;
      //  System.out.println("ajastin: "+ajastin);
        if(ajastin>600){
            for(int i=0; i<e3.size(); i++){ //TARKASTETAAN PAIKAT
            /*if(e3.get(i).getVarattu()==false)*/{
             createAsiakas(1); //TEE UUSI ASIAKAS AINA TIETYIN VÄLIAJOIN
            }
            }
        ajastin=0;
        }
        /**
     // for(int i=0; i<e3.size(); i++){
        if(Fysiikat.CollisionCheck(ent2, e3)){  //PELAAJA MENEE CHECKPOINTTIIN, varaa paikka
        //  ent3.setVarattu(true);
             System.out.println(e3.get(i).getID());
        //  cVarattu[checkPointID]=true;
         //   System.out.println("OSUU");
        }else{
       //  ent3.setVarattu(false);
        }
    //  }
    */
     
        if(Fysiikat.CollisionCheckPelaaja(ent3, e2)==true){  //PELAAJA MENEE CHECKPOINTTIIN, varaa paikka
      
          System.out.println(ent3.getID());
          cVarattu[ent3.getID()]=true;
          removeEntity(ent3);
        }else{
       //  ent3.setVarattu(false);
        }

               /**

        for(int i=0; i<e3.size(); i++){
            System.out.println(e3.get(i).getID());
          
            try{
            if(e2.get(i).getX() == e3.get(i).getX() && e2.get(i).getY()== e3.get(i).getY()){ //JOS OLLAAN SAMOISSA COORDINAATEISSA
                cVarattu[i]=true;
                System.out.println("a"+e3.get(i).getID());
            }
            }catch(Exception e){}
            * */
        
   
        }

    
    public void renderoi(Graphics g){
         for(int i=0; i < e1.size(); i++){
        ent1 = e1.get(i);
        
        ent1.renderoi(g);
        }
           for(int i=0; i < e2.size(); i++){
        ent2 = e2.get(i);
        
        ent2.renderoi(g);
    }
             for(int i=0; i < e3.size(); i++){
        ent3 = e3.get(i);
        
        ent3.renderoi(g);
    }
    }
    
    public void addEntity(Entity_1 block){
        e1.add(block);
    }
     public void removeEntity(Entity_1 block){
        e1.remove(block);
    }
         public void addEntity(Entity_2 block){
        e2.add(block);
    }
     public void removeEntity(Entity_2 block){
        e2.remove(block);
    }
    public void addEntity(Entity_3 block){
        e3.add(block);
    }
     public void removeEntity(Entity_3 block){
        e3.remove(block);
    }
     
     public LinkedList<Entity_1> getEntity_1(){
     return e1;
     }
       public LinkedList<Entity_2> getEntity_2(){
     return e2;
     }
            public LinkedList<Entity_3> getEntity_3(){
     return e3;
     }

}
