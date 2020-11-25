import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorM extends Thread{
    private Y cantidad;
    private DibujaTanke tanqueM; 
    private Lock mutex;
    public ProductorM(DibujaTanke panelM, Y rcM){
        this.tanqueM=panelM;
        this.cantidad=rcM;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(cantidad.getY()>50){
                if(mutex.tryLock()){
                    mutex.lock();
                        tanqueM.aguaM.getAgua().add(new Rectangle2D.Double(50,cantidad.getY(), 100, 5));
                        cantidad.setY(cantidad.getY()-5);
                        System.out.println("Productor MUTEX");
                    mutex.unlock();
                }
                tanqueM.repaint();
                //condiciones para que no pare
                try{
                    Thread.sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }else if(cantidad.getY()<=50){
                System.out.println("Esperando ProductorM");
                try{
                    Thread.sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
