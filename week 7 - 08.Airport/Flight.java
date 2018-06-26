
/**
 *
 * @author SantGr
 */
public class Flight {
    private final Airplane airplane;
    private final String from;
    private final String to;
    
    public Flight(Airplane airplane, String departure, String destination){
        this.airplane = airplane;
        this.from = departure;
        this.to = destination;
    }
    
    public String toString(){
        return this.airplane.toString() + " (" + this.from + "-" + this.to +")";
    }
}
