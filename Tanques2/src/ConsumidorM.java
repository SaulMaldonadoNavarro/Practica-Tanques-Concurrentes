import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JLabel;

public class ConsumidorM extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private JLabel porce;
    private Lock mutex;
    public ConsumidorM(DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()>0){
                if(mutex.tryLock()){
                        mutex.lock();
                        panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                        panel.repaint();
                        rc.setY(rc.getY()+5);
                        porce.setText(2.5*panel.agua.getAgua().size()+" %.");
                        mutex.unlock();
                }
                try{
                    sleep((int)(500+Math.random()*200));
                }catch(Exception e){}
            }
        }
    
    }
}
