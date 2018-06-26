
/**
 *
 * @author SantGr
 */

import java.util.ArrayList;
import java.util.HashMap;

public class FlightSystem {
    private final HashMap<String, Airplane> planes;
    private final ArrayList<Flight> flights;
    
    public FlightSystem(){
        this.planes = new HashMap<String, Airplane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void addPlane(String planeID, Airplane plane){
        planes.put(planeID, plane);
    }
    
    public void addFlight(Flight flight){
        flights.add(flight);
    }
    
    public Airplane getFlight(String planeID){
        return planes.get(planeID);
    }
    
    public void printPlanes(){
        for( Airplane plane : this.planes.values()){
            System.out.println(plane);
        }
    }
    
    public void printFlights(){
        for(Flight flight : this.flights){
            System.out.println(flight);
        }
    }
    
    public Airplane getPlane(String planeID){
        return this.planes.get(planeID);
    }
}
