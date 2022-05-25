package bf.java.ex.mob;

import bf.java.ex.Spell;
import bf.java.ex.mob.Character;

public class Hero extends Character {

    private int mp;
    private Spell[] spells;
    public Hero(int posX,int posY) {
        super(posX, posY);
        mp = d6.throwDice();
    }

    public void restoreHealth() {
        hp = getMaxHealth();
    }

    //public void throwSpell(int index) {
    //    if(spells[index]!=null) {}
    //}

    @Override
    public void hit(Character enemy, int damage) {
        super.hit(enemy, damage);
        if(enemy.isDead()) {
            addGold(enemy.getGold());
            addLeather(enemy.getLeather());
        }
    }

    private void addGold(int gold) {
        this.gold += gold;
    }

    private void addLeather(int leather) {
        this.leather += leather;
    }
}
