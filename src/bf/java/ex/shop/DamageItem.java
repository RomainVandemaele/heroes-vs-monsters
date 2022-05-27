package bf.java.ex.shop;

public class DamageItem extends Item {
    private int damage;

    public DamageItem(String name, int price,int damage) {
        super(name, price);
        this.damage = damage;
    }

    public int getBoost() {
        return damage;
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
