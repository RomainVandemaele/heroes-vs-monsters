package bf.java.ex.mob;

import bf.java.ex.Spell;
import bf.java.ex.shop.Item;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Character {

    private int mp;
    private int maxMagic;
    private Spell spell;

    private ArrayList<Item> items;

    public Hero(int posX,int posY) {
        super(posX, posY);
        maxMagic = d6.throwDice() + d6.throwDice() + d6.throwDice();
        mp = maxMagic;
        spell = new Spell();
        items = new ArrayList<Item>();
    }



    public void restoreHealth() {
        hp = getMaxHealth();
    }

    public void addHp(int hp) {
        this.hp = Math.min(this.hp + hp,getMaxHealth());
    }
    public void addMp(int mp) {
        this.mp = Math.min(this.mp + mp,getMaxMagic());
    }

    public int getMaxMagic() {
        return maxMagic;
    }


    //public void throwSpell(int index) {
    //    if(spells[index]!=null) {}
    //}

    public void addItem(Item item) {
        gold -= item.getPrice();
        items.add(item);
    }

    public void UseItem() {
        for(int i= 0;i<items.size();++i) {
            System.out.printf("%d : %s ",i+1,items.get(i));
        }

        System.out.println("Choose the item you want or return(0) to you fight?");
        Scanner myScanner = new Scanner(System.in);
        while (!myScanner.hasNext("[1-"+ String.valueOf(items.size()) + "]" )  ) {
            System.out.println("Have another try\n");
            myScanner.next();
        }
        int chosenIndex = myScanner.nextInt();
        items.get(chosenIndex-1).applyEffect();
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
