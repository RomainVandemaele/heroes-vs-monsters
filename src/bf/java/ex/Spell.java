package bf.java.ex;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Spell {
    // TODO: 25-05-22 : Generator of spell names
    private final int mpCost;
    private int damage;
    private Dice d4;
    private Dice d6;
    private String name;


    public Spell() {
        d4 =  new Dice(1,4);
        d6 = new Dice(1,6);
        this.mpCost = d4.throwDice();
        generateName();
    }

    private void generateName()  {
        try {
            File file = new File("src/bf/java/ex/spellNames.txt");
            FileReader fileReader = new FileReader(file);
            char c  = (char) fileReader.read();
            Scanner myScanner = new Scanner(file);
            int nSpell = myScanner.nextInt();
            Random random = new Random();
            int spellIndex = random.nextInt(nSpell);
            for(int i =0;i<spellIndex;++i) {
                myScanner.nextLine();
            }
            name = myScanner.nextLine();
            fileReader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getDamage() {
        return d6.throwDice();
    }

    public int getMpCost() {
        return mpCost;
    }

    @Override
    public String toString() {
        return name;
    }
}
