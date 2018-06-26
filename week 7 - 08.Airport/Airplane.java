
/**
 *
 * @author SantGr
 */
public class Airplane {
    private final String ID;
    private final int capacity;
    
    public Airplane(String ID, int capacity){
        this.ID = ID;
        this.capacity = capacity;
    }
    
    public String toString(){
        return this.ID + " (" + this.capacity + " ppl)";
    }
}
