package bf.java.ex.shop;

public class MagicRestoreItem extends Item{
    private int mpGain;

    public MagicRestoreItem(String name, int price,int mpGain) {
        super(name, price);
        this.mpGain = mpGain;
    }

    @Override
    public void applyEffect() {
        if(owner !=null) {
            owner.addMp(mpGain);
            System.out.printf("You gain %d MP which means you now have %d MP.\n",mpGain, owner.getMp());
        }
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
