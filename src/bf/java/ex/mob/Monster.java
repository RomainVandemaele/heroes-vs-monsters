package bf.java.ex.mob;

import bf.java.ex.mob.Character;

public abstract class Monster extends Character {

    public Monster(int posX,int posY) {
        super(posX,posY);
    }


    public abstract String getName();


}
