package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);

        random = new Random();

        this.apple = new Apple(random.nextInt(width), random.nextInt(height));
        while (worm.runsInto(apple)) {
            this.apple = new Apple(random.nextInt(width), random.nextInt(height));
        }

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            this.setApple(new Apple(random.nextInt(width), random.nextInt(height)));
            while (worm.runsInto(apple)) {
                this.setApple(new Apple(random.nextInt(width), random.nextInt(height)));
            }
        }

        if (worm.runsIntoItself()) {
            this.continues = false;
        }

        if (worm.getPieces().get(worm.getLength() - 1).getX() == width
                || worm.getPieces().get(worm.getLength() - 1).getX() < 0
                || worm.getPieces().get(worm.getLength() - 1).getY() == height
                || worm.getPieces().get(worm.getLength() - 1).getY() < 0) {
            this.continues = false;
        }

        this.updatable.update();

        setDelay(1000 / worm.getLength());

    }

    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        Random random = new Random();
        this.apple = apple;
    }

}
