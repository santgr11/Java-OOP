
package dungeon;

// @author SantGr

import dungeon.characters.Player;
import dungeon.characters.Vampire;
import dungeon.functions.Board;
import dungeon.functions.UserInterface;
import dungeon.characters.Character;
import java.util.ArrayList;
import java.util.List;

 
public class Dungeon {
    private Board board;
    private List<Vampire> vampires;
    private int moves;
    private UserInterface ui;
    private Player player;    
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.board = new Board(length, height);
        this.vampires = new ArrayList<Vampire>();
        
        for(int i = 0; i < vampires; i++) {
            this.vampires.add( new Vampire(height, length, vampiresMove));
        }
        
        this.moves = moves;
        this.player = new Player(height, length);
        this.ui = new UserInterface(this);        
    }
    
    public int getMoves() {
        return this.moves;
    }
    
    public void run() {
        for(int i = this.moves; i > 0; i --){
            ui.printInfo();
            ui.makeMove();
            if(this.vampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            this.moves --;
            
        }
        System.out.println("YOU LOSE");
        
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public List<Vampire> getVampires() {
        return this.vampires;
    }
    
    public Board getBoard() {
        return this.board;
    }

}
