import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorM extends Thread{
    private Y rc;
    private DibujaTanke panel; 
    private JLabel porce;
    private Lock mutex;
    
    public ProductorM(DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){
                if(mutex.tryLock()){
                    mutex.lock();
                        panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                        panel.repaint();
                        rc.setY(rc.getY()-5);
                        porce.setText(2.5*panel.agua.getAgua().size()+" %.");
                        mutex.unlock();
                }
                try{
                    Thread.sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
