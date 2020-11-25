import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumidorM extends Thread{
    private Y cantidad;
    private DibujaTanke tanqueM;
    private Lock mutex;
    public ConsumidorM(DibujaTanke panelM, Y rcM){
        this.tanqueM=panelM;
        this.cantidad=rcM;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if (cantidad.getY()<250){
                if(mutex.tryLock()){
                    mutex.lock();
                        tanqueM.aguaM.getAgua().remove(tanqueM.aguaM.getAgua().size()-1);
                        cantidad.setY(cantidad.getY()+5);
                        System.out.println("Consumidor MUTEX");
                    mutex.unlock();
                }
                tanqueM.repaint();
                try{    
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
            }
        }
    }
}
