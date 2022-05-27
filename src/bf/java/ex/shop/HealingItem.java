package bf.java.ex.shop;

public class HealingItem extends Item {

    private int hpGain;

    public HealingItem(String name,int price,int hpGain) {
        super(name,price);
        this.hpGain = hpGain;
    }

    @Override
    public int getBoost() {
        return hpGain;
    }

    @Override
    public Item clone() {
        return new HealingItem(name,price,hpGain);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(name+ " regain ").append(hpGain).append(" hp price : ").append(price).append("\n");
        return print.toString();
    }
}
