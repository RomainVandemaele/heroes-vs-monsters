package bf.java.ex.shop;

public class HealingItem extends Item {

    private int hpGain;

    public HealingItem(String name,int price,int hpGain) {
        super(name,price);
        this.hpGain = hpGain;
    }

    @Override
    public void applyEffect() {
        if(getOwner() != null) {
            getOwner().addHp(hpGain);
            System.out.printf("You gain %d HP which means you now have %d HP.\n",hpGain, getOwner().getHp());
        }
    }

    @Override
    public Item clone() {
        return new HealingItem(getName(),this.getPrice(),hpGain);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(getName()+ " regain ").append(hpGain).append(" hp price : ").append(this.getPrice()).append("\n");
        return print.toString();
    }
}
