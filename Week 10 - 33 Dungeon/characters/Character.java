
package dungeon.characters;

// @author SantGr

import dungeon.functions.Coordinate;

 
public class Character {
    private Coordinate coordinate;
    
    public Character(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }
    
    
    public void move(int dx, int dy) {
        this.coordinate.move(dx, dy);
    }
    
    public void moveUp() {
        this.move(0, -1);
    }
    
    public void moveDown() {
        this.move(0, 1);
    }
    
    public void moveLeft() {
        this.move(-1, 0);
    }
    
    public void moveRight() {
        this.move(1, 0);
    }
    
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
    
    public int getX() {
        return this.coordinate.getX();
    }
    
    public int getY() {
        return this.coordinate.getY();
    }
    
    public String charInfo() {
        return this.toString() + " " + this.getX() + " " + this.getY();
    }

}
