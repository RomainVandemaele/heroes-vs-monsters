package bf.java.ex.mob;

import bf.java.ex.mob.Character;

public class Hero extends Character {


    public Hero() {
        super();
    }

    public void restoreHealth() {
        hp = getMaxHealth();
    }

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
