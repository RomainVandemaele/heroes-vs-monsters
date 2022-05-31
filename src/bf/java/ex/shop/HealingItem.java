package bf.java.ex.shop;

public class HealingItem extends Item {

    private int hpGain;

    public HealingItem(String name,int price,int hpGain) {
        super(name,price);
        this.hpGain = hpGain;
    }

    @Override
    public void applyEffect() {
        if(owner != null) {
            owner.addHp(hpGain);
            System.out.printf("You gain %d HP which means you now have %d HP.\n",hpGain, owner.getHp());
        }
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
