package bf.java.ex.shop;

import bf.java.ex.mob.Hero;

public abstract class Item {
    protected int price;
    protected String name;

    protected Hero owner;

    public Item(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public void setOwner(Hero owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public abstract void applyEffect();

    public abstract Item clone();

    public abstract String toString();
}
