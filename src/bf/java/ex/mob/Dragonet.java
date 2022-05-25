package bf.java.ex.mob;

public class Dragonet extends Monster {

    private static int END_BONUS = 1;

    public Dragonet(int posX,int posY) {
        super(posX,posY);
        //maxHealth = getEndurance() + computeModifier(getEndurance()+END_BONUS);
        //hp = getMaxHealth();
        gold = d6.throwDice();
        leather = d4.throwDice();
    }

    public String toString() {
        return "Dragonet";
    }
}
