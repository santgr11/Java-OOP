
public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        FlightSystem system = new FlightSystem();
        TextInterface text = new TextInterface(system);
        
        text.startAirportPanel();
        text.startFlightService();
    }
}
