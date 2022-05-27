package bf.java.ex.map;

import bf.java.ex.mob.Hero;

public class ForestSquare extends MapSquare {
    @Override
    public String toString() {
        if(character instanceof Hero) {
            return character.toString();
        }else {
            return "*";
        }

    }
}
