
package kahvila;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import kahvila.classes.Entity_2;

public class Asiakas extends GameObject implements Entity_2 {
    
    boolean checkKerran = true;
    boolean liiku = false;
    double finalCorX=0;
     double finalCorY=0;
     int checkMaara = 3; //CHECKPOINTTIEN MÄÄRÄ
        double[] xCheck = new double[checkMaara];
        double[] yCheck = new double[checkMaara];
       // System.out.println("CHECKPOINTTIEN MÄÄRÄ "+checkMaara);
      
     double[] hypotenuusa = new double[checkMaara];

     
     
    public int checkPointX;
    public int checkPointY;
    
    int ostosluku;
    public  String teksti = "";
    boolean tosi = false;
    Random r = new Random();
    
    private Textures tex;
    private Controller c;
    private int speed = 1;//(r.nextInt(3) + 1);
    
    public Asiakas(double x, double y, Textures tex, Controller c){ //TÄNNE CONTROLLER
        super(x,y);
        this.x = x;
        this.y = y;
        this.tex = tex;
        this.c = c;
    }
    
    public void tick(){
      //  System.out.println("Liikupisteeseen: "+checkPointX+"x, y:"+checkPointY);
      //  liikuPisteeseen(checkPointX, checkPointY);
     //   etsiLahinReitti();

            int max = 3;
            int min = 1;
            int range= (max-min)+1;
            int ra = (int) (Math.random() * range + min);
   if(tosi == false){
       y--;
    if(y <= 80){ //ASIAKAS OTTAA TILAUSKEN

       
       ostosluku = (int)(Math.random()*4);
       switch(ostosluku){
           case 0:
                teksti = "mustan kahvin";
                break;
           case 1:
                teksti = "maito kahvin";
                break;
           case 2:
                teksti = "espresson";
                break;
           case 3:
               teksti = "teen";
       }
           c.asiakasNro++; //nro nousee, niin seuraava asiakas saa tilauksen
           System.out.println("Asiakkaan nro "+c.asiakasNro);
             //KASSAN NOSTO
             int hinta = ra; //VAIHDA HINTA
             c.kassa += hinta;
        System.out.println("Hei, haluaisin "+teksti+".");
        teksti = "Hei, haluaisin "+teksti+".";
        tosi = true;
    }
       
       
    }
   else{
       meneIstumaan();
       //etsiLahinReitti();  //KUN OLLAAN TILATTU, etsitään lähin reitti
        }
    }
    
    public void liikuPisteeseen(int xPiste, int yPiste){
    if(x<xPiste){
    x+=speed;
    }else if(x>xPiste){
    x-=speed;
    }
    //y
    if(y<yPiste){
    y+=speed;
    }else if(y>yPiste){
    y-=speed;
    }
    }
    
   /* public void etsiLahinReitti(){
        
            for(int i=0; i<checkMaara; i++){ //ANNETAAN JOKAISEN CHECKPOINTIN COORDINAATIT
            System.out.println("C"+i+" "+c.e3.get(i).getVarattu());

            if(c.e3.get(i).getVarattu()==false){ //JOS PAIKKAA EI OLLA VARATTU
        xCheck[i] = c.e3.get(i).getX();
        yCheck[i] =  c.e3.get(i).getY();
        hypotenuusa[i]=Math.hypot(xCheck[i], yCheck[i]);

        try{
        if(hypotenuusa[i]<hypotenuusa[i-1]) //JOS EDELLINEN HYPOTENUUSA ON PIENEMPI, niin se valitaan reitiksi
        {
        finalCorX = xCheck[i];
        finalCorY = yCheck[i];
        }
        else{
        finalCorX = xCheck[i-1];
        finalCorY = yCheck[i-1];
        }
        }catch(Exception e){
        }

        liiku = true;
        } //PAIKKA EI VARATTU 
            else{
            liiku = false;
           }
        }
        
        if(liiku==true){
        Arrays.sort(hypotenuusa);
        System.out.println("LYHIN MATKA: "+hypotenuusa[0]+" , mennään koordinaatteihin: ["+finalCorX+","+finalCorY+"]");
        //KATSOTAAN MIHIN NÄISTÄ ON LYHIN REITTI
        liikuPisteeseen((int)finalCorX,(int)finalCorY);
        }
    }*/
    
    public void meneIstumaan(){
    
        if(checkKerran==true){ //TEHDÄÄN TÄMÄ LOOPPI VAIN KERRAN
            System.out.println(Arrays.toString(c.cVarattu));
            for(int i=0; i<checkMaara; i++){ //ANNETAAN JOKAISEN CHECKPOINTIN COORDINAATIT
           // System.out.println("C"+i+" "+c.e3.get(i).getVarattu());
          try{
            if(c.cVarattu[i]==false){ //JOS PAIKKAA EI OLLA VARATTU 
        finalCorX = c.e3.get(i).getX();
        finalCorY = c.e3.get(i).getY();

            }
            System.out.println(finalCorX+" "+finalCorY);
            checkKerran=false;
            }catch(Exception e){
                
                    }
                    }
        }
              liikuPisteeseen((int)finalCorX,(int)finalCorY);
            
    }

 public void renderoi(Graphics g){
        g.drawImage(tex.asiakas, (int)x, (int)y, null);
    
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
    
       
    public String getTilaus(){  //ANTAA TILAUKSEN TEKSTINÄ, esim maito kahvi tms.
    return teksti;
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
