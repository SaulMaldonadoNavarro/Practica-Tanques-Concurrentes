import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
/**
 * @author saulm
 */
public class ConsumidorVC extends Thread{
    private Y rc;
    private DibujaTanke panel; 
    private JLabel porce;
    private Lock VCondition;
    private Lock mutex;
    private Condition condition;
    public boolean vc;  
    
    ConsumidorVC (DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
        mutex = new ReentrantLock();
        VCondition = new ReentrantLock();
        condition = VCondition.newCondition();       
    }
    
    public void run(){
        while(true){
         if(panel.agua.getAgua().size()>0){
            mutex.lock();
            try{
              mutex.lock();
              condition.await();         
            }catch(Exception e){}
            finally{
                mutex.unlock();
            }
              panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
              porce.setText(2.5*panel.agua.getAgua().size()+" %."); 
              panel.repaint();
              rc.setY(rc.getY()+5);
              //System.out.println("Consumo");
         }           
            try{
               Thread.sleep(500+(int)Math.random()*200);
            }catch(Exception e){}
         
        }
    }
    public void Acquire(){
        
    }
    
    public void Release(){
        
    }
}