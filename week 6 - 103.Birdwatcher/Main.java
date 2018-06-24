
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program

        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        Scanner reader = new Scanner(System.in);
        DataBase database = new DataBase();

        while (true) {
            System.out.print("?");
            String input = reader.nextLine();

            if (input.equals("Add")) {
                System.out.print("Name: ");
                String name = reader.nextLine();
                System.out.print("Latin Name: ");
                String latinName = reader.nextLine();

                Bird bird = new Bird(name, latinName);
                database.addBird(bird);
            } else if (input.equals("Observation")) {
                System.out.print("What was observed:? ");
                String observed = reader.nextLine();
                if (database.isInDB(observed)) {

                } else {
                    System.out.println("Is not a bird!");
                }
            } else if (input.equals("Show")) {
                System.out.print("What? ");
                String what = reader.nextLine();
                Bird found = database.searchBird(what);
                System.out.println(found);
            } else if (input.equals("Statistics")) {
                database.printStats();
            } else if (input.equals("Quit")) {
                break;
            }
        }
    }

}
