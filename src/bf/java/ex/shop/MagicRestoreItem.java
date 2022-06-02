package bf.java.ex.shop;

public class MagicRestoreItem extends Item{
    private int mpGain;

    public MagicRestoreItem(String name, int price,int mpGain) {
        super(name, price);
        this.mpGain = mpGain;
    }

    @Override
    public void applyEffect() {
        if(getOwner() !=null) {
            getOwner().addMp(mpGain);
            System.out.printf("You gain %d MP which means you now have %d MP.\n",mpGain, getOwner().getMp());
        }
    }



    @Override
    public Item clone() {
        return new MagicRestoreItem(getName(),getPrice(),mpGain);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(getName() + " regain ").append(mpGain).append(" mp price : ").append(getPrice()).append("\n");
        return print.toString();
    }
}
