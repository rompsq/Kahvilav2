
package kahvila;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException; 
import java.util.Arrays;
import java.util.LinkedList;


import kahvila.classes.Entity_1;
import kahvila.classes.Entity_2;
import kahvila.classes.Entity_3;


public class Kahvila extends Canvas implements Runnable{
    
    //NÄYTÖN KOKO YMS.
    public static final int WIDTH = 400;
    public static final int HEIGHT = 221;
    public static final int SCALE = 2;
    public final String TITLE = "Kahvila";
    
    Font font = new Font("Arial", 0, 25);
    
    private boolean running = false;
    private Thread thread;
    
    private synchronized void start(){
        if(running) 
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
        private BufferedImage kuva = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        private BufferedImage spritesheet = null;
        private BufferedImage background = null;

        private int asiakasMaara = 5; 
        private int Asiakas_poistettu;
        

        public LinkedList<Entity_1> e1;
        public LinkedList<Entity_2> e2;
        public LinkedList<Entity_3> e3;
   
    public int getAsiakas_maara() {
        return asiakasMaara;
    }

    public void setAsiakas_maara(int asiakasMaara) {
        this.asiakasMaara = asiakasMaara;
    }

    public int asiakasPoistettu() {
        return asiakasMaara;
    }

    public void setAsiakas_poistettu(int Asiakas_poistettu) {
        this.Asiakas_poistettu = Asiakas_poistettu;
    }
        
  //    private Asiakas p;
        private Controller c;
        private Textures tex;
        
    
    
        
        public void init(){  //TÄNNE SISÄÄN ASIAKKAAT, pöydät yms.
            requestFocus();
            KuvanLataaja lataaja = new KuvanLataaja();
            try{
                
                spritesheet = lataaja.lataakuva("spritesheet1.png");
                background = lataaja.lataakuva("background.jpg");
            }catch(IOException e){
            e.printStackTrace();
            }
            
          //  addKeyListener(new KeyInput(this));
            this.requestFocus();
            
            tex = new Textures(this);
            
            //asiakas = new asikas() :...  LISÄÄ ASIAKAS TÄNNE
            c = new Controller(tex);
            
            e1= c.getEntity_1();
            e2 = c.getEntity_2();
            e3 = c.getEntity_3();
            
            c.createAsiakas(1);
           // c.createMyyja();
            c.createPoyta(50, 150);
            c.createPoyta(50,300);
            c.createPoyta(375, 150);
            c.createPoyta(375, 300);
           for(int i=0; i<3; i++){
               c.cVarattu[i]=false;
           }
            
            c.createCheckPoint(265, 70, 0);
            c.createCheckPoint(130, 120, 1);
            c.createCheckPoint(65, 120, 2);
           // c.createCheckPoint(400,300, 3);
            //Spritesheet ss = new Spritesheet(spritesheet);
           // asiakas = ss.grabImage(1, 1, 32, 32);  //OTA ASIAKAS SPRITESTÄ 
            this.addKeyListener(new KeyInput(this));
             System.out.println("e1: "+e1.toString());  //e1 = poyta, e2 = asiakas
             System.out.println("e2: "+e2.toString());  //e1 = poyta, e2 = asiakas
             System.out.println("e3: "+e3.toString());  //e1 = poyta, e2 = asiakas
            
            
        }
    
    
     private synchronized void stop(){ //EI TARVITSE HUOMIOIDA
         if(!running)
         return;
         
         running = false;
         try{
         thread.join();
         }catch (InterruptedException e) {
         e.printStackTrace();
         }
         System.exit(1);
         
     }
    
    public void run(){  //EI TARVITSE HUOMIOIDA
        
        init();
        long aika = System.nanoTime();
        final double fps = 60.0;
        double ns = 1000000000 / fps;
        double delta = 0;
        int paivitykset = 0;
        int frames = 0;
        long ajastin = System.currentTimeMillis();
       if(frames == 61)frames--;
        if(paivitykset == 61)paivitykset--;
        
    while(running){
        
        long nyt = System.nanoTime();
        delta += (nyt - aika) / ns;
        aika = nyt;
        if(delta >= 1){
            tick();
            paivitykset++;
            delta--;
        }
    renderoi();
    frames++;
    
    if (System.currentTimeMillis() - ajastin > 1000){
        ajastin += 1000;
        paivitykset = 0;
        frames = 0;
    
    }
    }
    stop();
   
    }
    private void tick(){
 //   p.tick();
    c.tick();
    }
    
    private void renderoi(){  //TÄÄLLÄ PIIRRETÄÄN
        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){        
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.drawImage(kuva, 0, 0, getWidth(), getHeight(), null);
        /////piirrä tähän alle
        
        //ASIAKKAAN TILAUS
        g.drawImage(background, 0,0, null);
//        String tilaus = e2.get(c.asiakasNro).getTilaus(); //controllerissa nostetaan asiakkaan id
  //      g.drawString(tilaus, 100, 40);
        
        //KASSA
        int kassaValue = c.kassa;
        String kassa = "KASSA:"+String.valueOf(kassaValue)+"€";
        //
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString(kassa, 630, 30);
        
      // p.renderoi(g);
       c.renderoi(g);
       // g.drawImage(kuva, 0, 0, getWidth(), getHeight(), this);
       // g.drawImage(pelaaja, 100, 100, this);

        g.dispose();
        bs.show();
    }
      public void keyPressed(KeyEvent e){
          int key = e.getKeyCode();

          if(key == KeyEvent.VK_RIGHT){
             //TEE JOTAIN KUN NAPPIA PAINETAAN
          }
    }
    public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();
          
          if(key == KeyEvent.VK_RIGHT){
            //TEE JOTAIN KUN NAPPI ON VAPAUTETTU
          }    
    }

    public static void main(String args[]){  //RUUDUN TEKEMINEN
    Kahvila kahvila = new Kahvila();
    
    
    kahvila.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
    kahvila.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
    kahvila.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
    
    JFrame frame = new JFrame(kahvila.TITLE);
    frame.add(kahvila);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    kahvila.start();
}
    
    public BufferedImage getSpritesheet(){
       return spritesheet;
    }
    
}
    

