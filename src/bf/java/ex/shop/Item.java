package bf.java.ex.shop;

public abstract class Item {
    protected int price;
    protected String name;

    public Item(String name,int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public abstract int getBoost();

    public abstract Item clone();

    public abstract String toString();
}
