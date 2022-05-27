package bf.java.ex.map;

import bf.java.ex.mob.Character;

public abstract class MapSquare {
    protected Character character = null;

    public void setCharacter(Character character) {
        this.character = character;
    }


    public abstract String toString();
}
