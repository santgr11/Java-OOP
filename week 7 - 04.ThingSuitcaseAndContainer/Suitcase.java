/**
 *
 * @author SantGr
 */
import java.util.ArrayList;

public class Suitcase {
    private final ArrayList<Thing> things;
    private final int maxWeight;
    private int currWeight;
    
    public Suitcase(int maxWeight){
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
        this.currWeight = 0;
    }
    
    public void addThing(Thing thing){
        if( this.currWeight + thing.getWeight() <= this.maxWeight ){
            this.things.add(thing);
            this.currWeight += thing.getWeight();
        }
    }
    
    public String toString(){
        if( this.things.isEmpty() ){
            return "empty (0 kg)";
        }else if( this.things.size() == 1 ){
            return "1 thing (" + this.currWeight + " kg)";
        }
        
        
        return this.things.size() + " things (" + this.currWeight + " kg)";
    }
    
    public void printThings(){
        for( Thing thing : this.things ){
            System.out.println(thing);
        }
    }
    
    public int totalWeight(){
        return this.currWeight;
    }
    
    public Thing heaviestThing(){
        if( this.things.isEmpty() ){
            return null;
        }
        
        Thing heaviest = this.things.get(0);
        for( Thing thing : this.things ){
            if( thing.getWeight() > heaviest.getWeight() ){
                heaviest = thing;
            }
        }
        
        return heaviest;
    }
}
