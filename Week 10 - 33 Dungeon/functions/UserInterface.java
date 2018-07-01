
package dungeon.functions;

// @author SantGr

import dungeon.Dungeon;
import dungeon.characters.Vampire;
import dungeon.characters.Character;
import dungeon.characters.Player;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

 
public class UserInterface {
    private Scanner reader;
    private Dungeon dungeon;
    
    public UserInterface(Dungeon dungeon) {
        reader = new Scanner(System.in);
        this.dungeon = dungeon;
    }
    
    public void printInfo() {
        System.out.println(dungeon.getMoves());
        System.out.println("");
        System.out.println(dungeon.getPlayer().charInfo());
        for(Vampire vampire : dungeon.getVampires()) {
            System.out.println(vampire.charInfo());
        }
        
        System.out.println("");
        
        List<Character> characters = new ArrayList<Character>();
        
        characters.addAll(dungeon.getVampires());
        characters.add(dungeon.getPlayer());
        
        dungeon.getBoard().printBoardWithChar(characters);
    }
    
    //We ask the player for their moves and also make the vampires moves according.sss
    public void makeMove() {
        String moves = reader.nextLine();
        for(int i = 0; i < moves.length(); i++) {
            char where = moves.charAt(i);
            dungeon.getPlayer().move(where);
            for(Vampire vampire : dungeon.getVampires()) {
                vampire.move();                
            }
            
            this.checkAndDelete(dungeon.getVampires());
            
            
        }
    }
    
    //With this method we check if any vampire is now touching the player and delete it.
    public void checkAndDelete(List<Vampire> vampires) {
        List<Vampire> toDelete = new ArrayList<Vampire>();
        for(Vampire vampire : vampires) {
            if(vampire.getCoordinate().equals(dungeon.getPlayer().getCoordinate())) {
                    toDelete.add(vampire);
                }
        }
        
        vampires.removeAll(toDelete);        
    }
}
