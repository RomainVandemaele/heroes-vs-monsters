package bf.java.ex.shop;

public class MagicRestoreItem extends Item{
    private int mpGain;

    public MagicRestoreItem(String name, int price,int mpGain) {
        super(name, price);
        this.mpGain = mpGain;
    }

    @Override
    public int getBoost() {
        return mpGain;
    }

    @Override
    public Item clone() {
        return new MagicRestoreItem(name,price,mpGain);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(name+ " regain ").append(mpGain).append(" mp price : ").append(price).append("\n");
        return print.toString();
    }
}
