import java.awt.geom.*;
import javax.swing.JLabel;
public class ProductorMoni extends Thread{
    private Y rc;
    private DibujaTanke panel; 
    private JLabel porce;

    public ProductorMoni(DibujaTanke panelM, Y rcM, JLabel porce){
        this.panel=panelM;
        this.rc=rcM;
        this.porce = porce;
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){
                synchronized(panel){
                        panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                        panel.repaint();
                        rc.setY(rc.getY()-5);
                        porce.setText(2.5*panel.agua.getAgua().size()+" %.");
                }
                try{
                    Thread.sleep(500+(int)Math.random()*200);
                }catch(Exception e){}
            }
        }
    }
}
