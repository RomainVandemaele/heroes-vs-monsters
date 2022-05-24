package bf.java.ex.mob;

import bf.java.ex.mob.Hero;

public class Human extends Hero {
    static final int FOR_BONUS = 2;
    static final int END_BONUS = 1;

    public Human() {
        super();
        //maxHealth = getEndurance() + computeModifier(getEndurance()+END_BONUS);
        //restoreHealth();
    }
    @Override
    public int getDamage() {
        return getBaseDamage() + computeModifier(getForce()+FOR_BONUS);
    }
}
