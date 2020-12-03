import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
/**
 * @author saulm
 */
public class ProductorVC extends Thread{
    private Y rc;
    private DibujaTanke panel; 
    private JLabel porce;
    private Lock VCondition;
    private Lock mutex;
    private Condition condition;
    public boolean vc;  
    
    ProductorVC (DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
        mutex = new ReentrantLock();
        VCondition = new ReentrantLock();
        condition = VCondition.newCondition();       
    }
    
    public void run(){
        while(true){
          if(panel.agua.getAgua().size()<40){
            try{
                mutex.lock();
                condition.signal();                         
            }catch(Exception e){}
            finally{
                mutex.unlock();
            }
              panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
              panel.repaint();
              rc.setY(rc.getY()-5);
              porce.setText(2.5*panel.agua.getAgua().size()+" %.");
              //System.out.println("Produce");
          }
            try{
               Thread.sleep(500+(int)Math.random()*200);
            }catch(Exception e){}
          
        }
    }
}




