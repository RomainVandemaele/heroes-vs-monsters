package bf.java.ex.shop;

import bf.java.ex.mob.Hero;

public abstract class Item {
    private int price;
    private String name;
    private Hero owner;

    public Item(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Hero getOwner() {
        return owner;
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
