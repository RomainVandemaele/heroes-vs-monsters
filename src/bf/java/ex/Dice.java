package bf.java.ex;

import java.security.SecureRandom;

public class Dice {

    private SecureRandom randomizer;

    public Dice() {
        randomizer = new SecureRandom();
        randomizer.nextInt(10);
    }

    public byte throwDice(int nface,int nThrows) {
        byte result = 0;
        for (int i=0;i<nThrows;i++) {
            result += randomizer.nextInt(nface) + 1;
        }
        return result;
    }
}
