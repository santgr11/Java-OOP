/**
 *
 * @author SantGr
 */
import java.util.ArrayList;

public class Container {
    private final ArrayList<Suitcase> suitcases;
    private final int maxWeight;
    private int currWeight;
    
    public Container(int maxWeight){
        this.suitcases = new ArrayList<Suitcase>();
        this.maxWeight = maxWeight;
        this.currWeight = 0;
    }
    
    public void addSuitcase(Suitcase suitcase){
        if( this.currWeight + suitcase.totalWeight() <= this.maxWeight ){
            this.suitcases.add(suitcase);
            this.currWeight += suitcase.totalWeight();
        }
    }
    
    public String toString(){
        if( this.suitcases.isEmpty() ){
            return "empty (0 kg)";
        }else if( this.suitcases.size() == 1 ){
            return "1 suitcase (" + this.currWeight + " kg)";
        }
        
        
        return this.suitcases.size() + " suitcases (" + this.currWeight + " kg)";
    }
    
    public void printThings(){
        for( Suitcase suitcase : this.suitcases ){
            suitcase.printThings();
        }
    }
}
