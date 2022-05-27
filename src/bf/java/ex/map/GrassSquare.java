package bf.java.ex.map;

import bf.java.ex.mob.Wolf;

public class GrassSquare extends MapSquare{
    @Override
    public String toString() {
        if(character==null || character instanceof Wolf) {
            return "-";
        }else {
            return character.toString();
        }
    }
}
