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
            getOwner().hit(receiver,damage);
        }
    }

    public void setReceiver(Monster receiver) {
        this.receiver = receiver;
    }

    @Override
    public Item clone() {
        return new DamageItem(getName(),getPrice(),damage);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(getName()+ " do ").append(damage).append(" damages price : ").append(getPrice()).append("\n");
        return print.toString();
    }
}
