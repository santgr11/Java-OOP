public class Main {
    public static void main(String[] Container) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        /* adding 100 suitcases with one brick in each, with each brick 1kg
        ** heavier than the previous one. This is to check the correct 
        ** functionality of the weight limit. */
        
        
        for( int i = 1; i <= 100; i++ ){
            Thing brick = new Thing("brick", i);
            Suitcase suitcase = new Suitcase( i );
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);            
        }
    }
}
   