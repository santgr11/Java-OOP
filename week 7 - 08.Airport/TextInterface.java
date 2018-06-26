
/**
 *
 * @author SantGr
 */

import java.util.Scanner;

public class TextInterface {
    private final Scanner reader;    
    private final FlightSystem system;
    
    public TextInterface(FlightSystem newSystem){
        this.reader = new Scanner(System.in);        
        this.system = newSystem;
    }
    
    public void startAirportPanel(){
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        while(true){
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String input = reader.nextLine();
            
            if(input.equals("1")){
                this.addAirplane();
            }else if(input.equals("2")){
                this.addFlight();
            }else if(input.equals("x")){
                break;
            }
        }
        System.out.println("");
    }
    
    public void startFlightService(){
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        
        while(true){
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String input = reader.nextLine();
            
            if(input.equals("1")){
                this.system.printPlanes();
            }else if(input.equals("2")){
                this.system.printFlights();
            }else if(input.equals("3")){
                System.out.print("Give plane ID: ");
                String planeID = this.reader.nextLine();
                System.out.println(this.system.getPlane(planeID));
            }else if(input.equals("x")){
                break;
            }
        }
        
        System.out.println("");
    }
    
    private void addAirplane(){
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(this.reader.nextLine());
        
        this.system.addPlane(planeID, new Airplane(planeID, planeCapacity));
    }
    
    private void addFlight(){
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departure = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = this.reader.nextLine();
                
        this.system.addFlight(new Flight(this.system.getFlight(planeID), departure, destination));
        
    }
    
}
