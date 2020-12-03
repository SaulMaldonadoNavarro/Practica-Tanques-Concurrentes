/**
 * @author saulm
 */
import java.util.concurrent.Semaphore;
import java.awt.geom.*;
import javax.swing.JLabel;
public class ProductorSem extends Thread{
    private Y rc;
    private Semaphore sem;
    private DibujaTanke panel;
    private JLabel porce;
    ProductorSem(DibujaTanke panel, Y rc, JLabel porce){
        this.panel = panel;
        this.rc = rc;
        this.porce = porce;
        sem = new Semaphore(1);
    }
    
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){
                  try{
                    sem.acquire();
                    panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                    porce.setText(2.5*panel.agua.getAgua().size()+" %.");
                    panel.repaint();
                    rc.setY(rc.getY()-5);
                    sem.release();            
                  }catch(Exception e){};
                  try{
                      sleep((int)(500+Math.random()*200));
                  }catch(Exception e){};    
            }

        }
        
    }
    
}
