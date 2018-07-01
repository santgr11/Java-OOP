
package dungeon.characters;

// @author SantGr

import java.util.Random;

 
public class Vampire extends Character {
    private final boolean move;
    private final int maxX;
    private final int maxY;
    
    public Vampire(int maxX, int maxY, boolean move) {        
        super(new Random().nextInt(maxX), new Random().nextInt(maxY));
        this.maxX = maxX - 1;
        this.maxY = maxY - 1;
        this.move = move;
    }
    
    public void move(){
        if(this.move) {
            Random random = new Random();
            int whereMove = random.nextInt(5);
            
            
            //Choose at random where to move without leaving the table;
            if(whereMove == 1 && this.getY() - 1 >= 1) {
                super.moveUp();
            } else if (whereMove == 2 && this.getY() + 1 <= maxY) {
                super.moveDown();
            } else if (whereMove == 3 && this.getX() - 1 >= 1) {
                super.moveLeft();
            } else if (whereMove == 4 && this.getX() + 1 <= maxX) {
                super.moveRight();
            }
        }
    }
    
    @Override
    public String toString() {
        return "v";
    }

}
