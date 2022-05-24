package bf.java.ex.mob;

import bf.java.ex.mob.Monster;

public class Orc extends Monster {

    private static int FOR_BONUS = 1;

    public Orc() {
        super();
        gold = d6.throwDice();
    }

    @Override
    public int getDamage() {
        return getBaseDamage() + computeModifier(getForce()+FOR_BONUS);
    }


    public String toString() {
        return "Orc";
    }
}
