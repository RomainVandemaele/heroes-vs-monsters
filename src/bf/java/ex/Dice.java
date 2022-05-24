package bf.java.ex;

import java.security.SecureRandom;

public class Dice {

    private SecureRandom randomizer;
    private final int min;
    private final int max;

    public Dice(int minNumber,int maxNumber) {
        this.min = minNumber;
        this.max = maxNumber;
        randomizer = new SecureRandom();
    }

    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }

    public int throwDice() {
        return  (min + randomizer.nextInt(max-min+1) );
    }

}
