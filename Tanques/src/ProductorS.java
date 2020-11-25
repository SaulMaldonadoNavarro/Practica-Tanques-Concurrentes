import java.awt.geom.*;
import java.util.concurrent.Semaphore;
public class ProductorS extends Thread{
    private Y cantidad;
    private DibujaTanke tanqueS; 
    private Semaphore sem;
    public ProductorS(DibujaTanke panelS, Y rcS){
        this.tanqueS=panelS;
        this.cantidad=rcS;
        sem = new Semaphore(1);
        
    }
    public void run(){
        while(true){
            if(cantidad.getY()>50){
                try 
                {
                    sem.acquire();
                    
                        tanqueS.aguaS.getAgua().add(new Rectangle2D.Double(330,cantidad.getY()-5, 100, 5));
                        cantidad.setY(cantidad.getY()-5);
                        System.out.println("Productor Semaforo");

                    sem.release(); 
                } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                }

                tanqueS.repaint();
                //condiciones para que no pare
                try{
                    Thread.sleep(650);
                }catch(Exception e){}
            }else if(cantidad.getY()<=50){
                System.out.println("Esperando ProductorS");
                try{
                    Thread.sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
