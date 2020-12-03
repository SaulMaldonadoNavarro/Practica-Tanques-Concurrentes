import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Tankes extends JFrame{
    public DibujaTanke panelMutex, panelSemaforo, panelVC, panelMonitor, panelBarrera;
    private Y rcMutex, rcSem, rcVC, rcMoni, rcBarre;
    private ProductorM proM;
    private ConsumidorM conM;
    private ProductorSem proS;
    private ConsumidorSem conS;
    private ProductorVC proVC;
    private ConsumidorVC conVC;
    private ProductorMoni proMoni;
    private ConsumidorMoni conMoni;
    private ProductorBarre proBarre;
    private ConsumidorBarre conBarre;
    private Agua aguaMutex, aguaSem, aguaVC, aguaMoni, aguaBarre;   
    private JLabel eMutex, eSem,eVC, eMonitor, eBarrera;
    private JLabel pMutex, pSem, pVC, pMonitor, pBarrera;
   
    
    public Tankes(){
        setSize(850,350);
        eMutex = new JLabel("Mutex");
        eSem = new JLabel("Semaforo");
        eVC = new JLabel("Variable Condición"); 
        eMonitor = new JLabel("Monitor");
        eBarrera = new JLabel("Barrera");
        
        pMutex = new JLabel("Porcentaje: ");
        pSem = new JLabel("Porcentaje: ");
        pVC = new JLabel("Porcentaje: "); 
        pMonitor = new JLabel("Porcentaje: ");
        pBarrera = new JLabel("Porcentaje: ");
        
        rcMutex = new Y();
        rcSem = new Y();
        rcVC = new Y();
        rcMoni = new Y();
        rcBarre = new Y();
        
        
        aguaMutex = new Agua();
        aguaSem = new Agua();
        aguaVC = new Agua();
        aguaMoni = new Agua();
        aguaBarre = new Agua();
        
        panelMutex = new DibujaTanke(aguaMutex);
        panelSemaforo = new DibujaTanke(aguaSem);
        panelVC = new DibujaTanke(aguaVC);
        panelMonitor = new DibujaTanke(aguaMoni);
        panelBarrera = new DibujaTanke(aguaBarre);
        
        proM = new ProductorM(panelMutex,rcMutex,pMutex);
        conM = new ConsumidorM(panelMutex,rcMutex,pMutex);
        
        proS = new ProductorSem(panelSemaforo,rcSem,pSem);
        conS = new ConsumidorSem(panelSemaforo,rcSem,pSem);
       
        proVC = new ProductorVC(panelVC, rcVC, pVC);
        conVC = new ConsumidorVC(panelVC, rcVC, pVC);
        
        proMoni = new ProductorMoni(panelMonitor,rcMoni,pMonitor);
        conMoni = new ConsumidorMoni(panelMonitor,rcMoni,pMonitor);
        
        proBarre = new ProductorBarre(panelBarrera,rcBarre,pBarrera);
        conBarre = new ConsumidorBarre(panelBarrera,rcBarre,pBarrera);
        
        setLayout(new GridLayout());
        
        panelMutex.setLayout(null);
        eMutex.setBounds(50,20, 100, 25);
        pMutex.setBounds(70, 270, 100, 25);
        panelMutex.add(eMutex);
        panelMutex.add(pMutex);
        add(panelMutex);

        panelSemaforo.setLayout(null);
        eSem.setBounds(50,20, 100, 25);
        pSem.setBounds(70, 270, 100, 25);
        panelSemaforo.add(eSem);
        panelSemaforo.add(pSem);
        add(panelSemaforo);
        
        panelVC.setLayout(null);
        eVC.setBounds(50,20, 150, 25);
        pVC.setBounds(70, 270, 100, 25);
        panelVC.add(eVC);
        panelVC.add(pVC);
        add(panelVC);
        
        panelMonitor.setLayout(null);
        eMonitor.setBounds(50,20, 100, 25);
        pMonitor.setBounds(70, 270, 100, 25);
        panelMonitor.add(eMonitor);
        panelMonitor.add(pMonitor);
        add(panelMonitor);
        
        panelBarrera.setLayout(null);
        eBarrera.setBounds(50,20, 100, 25);
        pBarrera.setBounds(70, 270, 100, 25);
        panelBarrera.add(eBarrera);
        panelBarrera.add(pBarrera);
        add(panelBarrera);
        
        
        proM.start();
        conM.start();
        proS.start();
        conS.start();
        proVC.start();
        conVC.start();
        proMoni.start();
        conMoni.start();
        proBarre.start();
        conBarre.start();
        
    }
    
    public static void main(String[] args) {
        Tankes tanques = new Tankes();
        tanques.setVisible(true);
        tanques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

