import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Tankes extends JFrame{
    public DibujaTanke panel;
    private Y rcM;
    private ProductorM proM;
    private ConsumidorM conM;
    private Y rcS;
    private Agua aguaM;   
    private Lock mutex;
    
    private ProductorS proS;
    private ConsumidorS conS;
    private Agua aguaS;    
    private Semaphore semaforo;
    
    public Tankes(){
        setSize(500,350);
        mutex = new ReentrantLock();
        semaforo = new Semaphore(1);
        rcM = new Y();
        rcS = new Y();
        aguaM = new Agua();
        aguaS = new Agua();
        panel = new DibujaTanke(aguaM,aguaS);
        proM = new ProductorM(panel,rcM);
        conM = new ConsumidorM(panel,rcM);
        proS = new ProductorS(panel,rcS);
        conS = new ConsumidorS(panel,rcS);
        
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(panel);
        
        proM.start();
        conM.start();
        proS.start();
        conS.start();
    }
    
    public static void main(String[] args) {
        Tankes tanques = new Tankes();
        tanques.setVisible(true);
        tanques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

