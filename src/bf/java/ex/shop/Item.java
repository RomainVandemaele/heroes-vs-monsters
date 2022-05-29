package bf.java.ex.shop;

import bf.java.ex.mob.Hero;

public abstract class Item {
    protected int price;
    protected String name;

    protected Hero receiver;

    public Item(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public void setReceiver(Hero receiver) {
        this.receiver = receiver;
    }

    public int getPrice() {
        return price;
    }

    public abstract void applyEffect();

    public abstract Item clone();

    public abstract String toString();
}
