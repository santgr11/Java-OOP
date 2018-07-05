
package wormgame.gui;

// @author SantGr

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

 
public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame wormGame;
    private int piecesLenght;
    
    public DrawingBoard(WormGame wormGame, int pieceLenght) {
        this.wormGame = wormGame;
        this.piecesLenght = pieceLenght;
    }

    DrawingBoard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Apple apple = wormGame.getApple();
        g.setColor(Color.red);
        g.fillOval(apple.getX() * piecesLenght, apple.getY() * piecesLenght, piecesLenght, piecesLenght);
        
        g.setColor(Color.BLACK);
        for(Piece piece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(piece.getX() * piecesLenght, piece.getY() * piecesLenght, piecesLenght, piecesLenght, true);
        }
        
    }

    @Override
    public void update() {
        this.repaint();
    }

}
