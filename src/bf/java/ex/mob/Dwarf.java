package bf.java.ex.mob;

import bf.java.ex.mob.Hero;

public class Dwarf extends Hero {

    static final int END_BONUS = 1;

    public Dwarf(int posX,int posY) {
        super(posX,posY);
        //maxHealth = getEndurance() + computeModifier(getEndurance()+END_BONUS);
        //restoreHealth();
    }

    @Override
    public String toString() {
        return "D";
    }
}
