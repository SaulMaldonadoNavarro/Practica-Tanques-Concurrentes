
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
public class DibujaTanke extends JPanel{
    public Agua aguaM; 
    public Agua aguaS; 
    JLabel name1; 
    JLabel name2;     
    public DibujaTanke(Agua aguaM, Agua aguaS){
        this.aguaM = aguaM;
        this.aguaS = aguaS;
        name1 = new JLabel("Tanque Mutex");
        name2 = new JLabel("Tanque Semaforo");
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;
        Graphics2D g2 = (Graphics2D)g;
        
        name1.setBounds(60,0,100,50);
        add(name1);
        name2.setBounds(329,0,150,50);
        add(name2);
        
        g1.setColor(Color.BLACK); //Mutex
        g1.draw(new Rectangle2D.Double(50,50,100,200));
        g1.setColor(Color.BLUE);
        for(int i=0;i<aguaM.getAgua().size();i++){
            g1.fill((Rectangle2D)aguaM.getAgua().get(i));
        }
        
        g2.setColor(Color.BLACK);//Semaforo
        g2.draw(new Rectangle2D.Double(330,50,100,200));
        g2.setColor(Color.BLUE);
        for(int j=0;j<aguaS.getAgua().size();j++){
            g2.fill((Rectangle2D)aguaS.getAgua().get(j));
        }
        
    }
}
