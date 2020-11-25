import java.awt.*;
import java.util.concurrent.Semaphore;
public class ConsumidorS extends Thread{
    private Y cantidad;
    private DibujaTanke tanqueS;
    private Semaphore sem;
    public ConsumidorS(DibujaTanke panelS, Y rcS){
        this.tanqueS=panelS;
        this.cantidad=rcS;
        sem = new Semaphore(1);
    }
     public void run(){
        while(true){
            if (cantidad.getY()<250){
                try{
                    sem.acquire();
                    
                        tanqueS.aguaS.getAgua().remove(tanqueS.aguaS.getAgua().size()-1);
                        cantidad.setY(cantidad.getY()+5);
                        System.out.println("Consumidor Semaforo");

                    sem.release();
                } catch (InterruptedException exc) { 
                    System.out.println(exc); 
                }
                
                tanqueS.repaint();
                try{    
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
        }
     }
}
