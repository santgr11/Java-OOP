package dungeon.functions;

// @author SantGr
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Coordinate)) {
            return false;
        }

        Coordinate otherCoordinate = (Coordinate) otherObject;

        return (this.x == otherCoordinate.getX() && this.y == otherCoordinate.getY());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        return hash;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + ":" + this.y +")";
    }
}
