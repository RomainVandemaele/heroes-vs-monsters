package bf.java.ex.mob;

import bf.java.ex.Spell;
import bf.java.ex.mob.Character;
import bf.java.ex.shop.Item;

import java.util.ArrayList;

public abstract class Hero extends Character {

    private int mp;
    private Spell spell;

    private ArrayList<Item> items;

    public Hero(int posX,int posY) {
        super(posX, posY);
        mp = d6.throwDice() + d6.throwDice() + d6.throwDice();
        spell = new Spell();
    }

    public void restoreHealth() {
        hp = getMaxHealth();
    }

    //public void throwSpell(int index) {
    //    if(spells[index]!=null) {}
    //}

    public void addItem(Item item) {
        items.add(item);
    }

    public void throwSpell(Character enemy) {
        if(canThrowSpell()) {
            mp-= spell.getMpCost();
            final int damage = spell.getDamage();
            enemy.getHit(damage);
            System.out.printf("You throw %s and make %d damages.\n",spell,damage);
        }else {
            System.out.println("Not enough MP.\n");
        }
    }

    public int getMp() {
        return mp;
    }

    public boolean canThrowSpell() {
        return spell.getMpCost() <= mp;
    }

    @Override
    public void hit(Character enemy) {
        super.hit(enemy);
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

    @Override
    public String toString() {
        return "H";
    }
}
