package bf.java.ex.shop;

import bf.java.ex.mob.Monster;

public class DamageItem extends Item {
    private int damage;
    private Monster receiver;

    public DamageItem(String name, int price,int damage) {
        super(name, price);
        this.damage = damage;
    }

    public void applyEffect() {
        if(receiver!=null) {
            owner.hit(receiver,damage);
        }
    }

    public void setReceiver(Monster receiver) {
        this.receiver = receiver;
    }

    @Override
    public Item clone() {
        return new DamageItem(name,price,damage);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(name+ " do ").append(damage).append(" damages price : ").append(price).append("\n");
        return print.toString();
    }
}
