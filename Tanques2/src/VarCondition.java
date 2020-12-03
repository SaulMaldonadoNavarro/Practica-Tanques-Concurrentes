import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
/**
 * @author saulm
 */
public class VarCondition {
    private Lock VCondition;
    private Condition condition;
    public boolean vc;
    
    VarCondition(){
        VCondition = new ReentrantLock();
        condition = VCondition.newCondition();
    }
    
    public void Acquire(){
        
    }
    
    public void Release(){
        
    }
}
