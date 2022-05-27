package bf.java.ex.mob;

import bf.java.ex.mob.Hero;

public class Human extends Hero {
    static final int FOR_BONUS = 2;
    static final int END_BONUS = 1;

    public Human(int posX,int posY) {
        super(posX,posY);
    }
    @Override
    public int getDamage() {
        return getBaseDamage() + computeModifier(getForce()+FOR_BONUS);
    }

    @Override
    public String toString() {
        return "H";
    }

    @Override
    public String getName() {
        return "Human";
    }
}
