package bf.java.ex.mob;

import bf.java.ex.Spell;
import bf.java.ex.shop.DamageItem;
import bf.java.ex.shop.Item;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Character {

    private int mp;
    private int maxMagic;
    private Spell spell;

    private ArrayList<Item> inventory;

    public Hero(int posX,int posY) {
        super(posX, posY);
        maxMagic = d6.throwDice() + d6.throwDice() + d6.throwDice();
        mp = maxMagic;
        spell = new Spell();
        inventory = new ArrayList<Item>();

        gold = 10;
    }



    public void restoreHealth() {
        hp = getMacHealth();
    }

    public void addItem(Item item) {
        gold -= item.getPrice();
        inventory.add(item);
    }

    public void UseItem(Monster enemy) {
        for(int i = 0; i< inventory.size(); ++i) {
            System.out.printf("%d : %s ",i+1, inventory.get(i));
        }

        if(inventory.size() > 0) {
            System.out.println("Choose the item you want or return(0) to you fight?");
            Scanner myScanner = new Scanner(System.in);
            while (!myScanner.hasNext("[1-"+ String.valueOf(inventory.size()) + "]" )  ) {
                System.out.println("Have another try\n");
                myScanner.next();
            }
            int chosenIndex = myScanner.nextInt();
            Item item = inventory.get(chosenIndex-1);
            if(item instanceof DamageItem) {
                ((DamageItem) item).setReceiver(enemy);
            }
            item.applyEffect();
        }else {
            System.out.println("You have no item.");
        }

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


    @Override
    public void hit(Character enemy) {
        super.hit(enemy);
        getLoot(enemy);
    }


    public void hit(Character enemy,final int damage) {
        enemy.getHit(damage);
        getLoot(enemy);
    }

    private void getLoot(Character enemy) {
        if(enemy.isDead()) {
            addGold(enemy.getGold());
            addLeather(enemy.getLeather());
        }
    }

    public void addHp(int hp) {
        this.hp = Math.min(this.hp + hp, getMacHealth());
    }
    public void addMp(int mp) {
        this.mp = Math.min(this.mp + mp,getMaxMagic());
    }

    private void addGold(int gold) {
        this.gold += gold;
    }

    private void addLeather(int leather) {this.leather += leather;}

    public int getMp() {
        return mp;
    }

    public int getMaxMagic() {
        return maxMagic;
    }

    public boolean canThrowSpell() {
        return spell.getMpCost() <= mp;
    }

    @Override
    public String toString() {
        return "H";
    }
}
