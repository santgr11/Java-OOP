
package dungeon.characters;

// @author SantGr
 
public class Player extends Character {
    private int maxX;
    private int maxY;
    
    public Player(int maxX, int maxY) {
        super(0, 0);
        this.maxX = maxX - 1;
        this.maxY = maxY - 1;
    }
    
    @Override
    public String toString() {
        return "@";
    }
    
    public void move(char where) {
        if(where == 'w' && this.getY() - 1 >= 0) {
                super.moveUp();
            } else if (where == 's' && this.getY() + 1 <= maxY) {
                super.moveDown();
            } else if (where == 'a' && this.getX() - 1 >= 0) {
                super.moveLeft();
            } else if (where == 'd' && this.getX() + 1 <= maxX) {
                super.moveRight();
            }
    }

}
