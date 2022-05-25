package bf.java.ex;

import bf.java.ex.mob.Hero;
import bf.java.ex.mob.Monster;

import java.util.ArrayList;

public class Map {
    private final int SIZE;
    private ArrayList<Monster> monsters;
    private Hero hero;

    public Map(int size) {
        SIZE = size;
        monsters = new ArrayList<Monster>();
    }

    public int getSize() {
        return SIZE;
    }

    public void display() {
        for (int i=0;i<SIZE;++i) {
            for(int j=0;j<SIZE;++j) {
                if(hero.getPositionX()==i && hero.getPositionY()==j) {
                    System.out.printf("H");
                }else  {
                    System.out.printf("-");
                }
            }
        }
    }


}
