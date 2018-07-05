package wormgame.domain;

// @author SantGr
import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;
import static wormgame.Direction.DOWN;
import static wormgame.Direction.LEFT;
import static wormgame.Direction.RIGHT;
import static wormgame.Direction.UP;

public class Worm {

    private int X;
    private int Y;
    private Direction direction;
    private List<Piece> body;
    private boolean hasToGrow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        X = originalX;
        Y = originalY;
        direction = originalDirection;
        body = new ArrayList<Piece>();
        body.add(new Piece(X, Y));
        hasToGrow = false;

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public int getLength() {
        return body.size();
    }

    public List<Piece> getPieces() {
        return body;
    }

    public void move() {
        if (direction == UP) {
            Y--;

        } else if (direction == DOWN) {
            Y++;

        } else if (direction == LEFT) {
            X--;

        } else {
            X++;
        }

        body.add(new Piece(X, Y));
        
        if(body.size() > 3 && !hasToGrow) {
            body.remove(0);
            hasToGrow = false;
        } else {
            hasToGrow = false;
        }

    }

    public void grow() {
        hasToGrow = true;

    }

    public boolean runsInto(Piece piece) {
        for (Piece bodyPiece : body) {
            if (bodyPiece.runsInto(piece)) {
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        for (Piece bodyPiece : body) {
            for (Piece anotherBodyPiece : body) {
                if (bodyPiece.equals(anotherBodyPiece)) {
                    continue;
                }

                if (bodyPiece.runsInto(anotherBodyPiece)) {
                    return true;
                }
            }
        }

        return false;
    }

}
