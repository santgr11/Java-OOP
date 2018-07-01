package dungeon;

import dungeon.characters.Vampire;
import dungeon.functions.Board;
import java.util.ArrayList;
import java.util.List;
import dungeon.characters.Character;

public class Main {

    public static void main(String[] args) {
        //new Dungeon(10,10,5,14,true).run();

        Dungeon dungeon = new Dungeon(10, 15, 3, 15, false);
        dungeon.run();

    }
}
