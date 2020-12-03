import java.awt.geom.*;
import static java.lang.Thread.sleep;
import javax.swing.JLabel;

public class ConsumidorMoni extends Thread {
    private Y rc;
    private DibujaTanke panel;
    private JLabel porce;  
    
        public ConsumidorMoni(DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
    }
 
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()>0){
                synchronized(panel){
                        panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                        panel.repaint();
                        rc.setY(rc.getY()+5);
                        porce.setText(2.5*panel.agua.getAgua().size()+" %.");
                }
                try{
                    sleep((int)(500+Math.random()*200));
                }catch(Exception e){}
            }
        }
    
    }
        
}
