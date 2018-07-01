
package dungeon.functions;

// @author SantGr

import java.util.ArrayList;
import java.util.List;
import dungeon.characters.Character;

 
public class Board {
    private final int rows;
    private final int columns;
    private List<List<String>> boardTemplete;
    
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    public void insertCharacter(Character character) {
        int rowPlace = character.getCoordinate().getY();
        int columnPlace = character.getCoordinate().getX();
        
        this.boardTemplete.get(rowPlace).set(columnPlace, character.toString()); 
    }
    
    public void printBoardWithChar(List<Character> characters) {
        this.setBlankBoard();
        
        for(Character character : characters) {
            insertCharacter(character);
        }
        
        for(List<String> row : boardTemplete) {
            for(String place : row) {
                System.out.print(place);
            }
            System.out.println("");
        }
    }
    
    private void setBlankBoard() {
        this.boardTemplete = new ArrayList<List<String>>();
        for(int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<String>();
            for(int j = 0; j < columns; j++) {
                row.add(".");
            }
            boardTemplete.add(row);
        }
        
    }
}
