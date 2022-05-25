package bf.java.ex.mob;

import bf.java.ex.mob.Monster;

public class Wolf extends Monster {

    public Wolf(int posX,int posY) {
        super(posX,posY);
        leather = d6.throwDice();
    }

    public String toString() {
        return "Wolf";
    }
}
