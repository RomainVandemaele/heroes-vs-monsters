package bf.java.ex;

import bf.java.ex.mob.Hero;
import bf.java.ex.mob.Monster;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class Map {
    private final int SIZE;
    private ArrayList<Monster> monsters;
    private Hero hero;
    private Monster enemy = null;

    public Map(int size) {
        SIZE = size;
        monsters = new ArrayList<Monster>();
    }

    public int getSize() {
        return SIZE;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public boolean isNearMonster() {
        Boolean isNear = false;
        int heroX = hero.getPositionX();
        int heroY = hero.getPositionY();

        Iterator<Monster> it = monsters.iterator();
        while (it.hasNext() && !isNear) {
            Monster m = it.next();
            int posX = m.getPositionX();
            int posY = m.getPositionY();
            isNear = posX==heroX && Math.abs(posY-heroY)<=1 || posY==heroY && Math.abs(posX-heroX)<=1;
            enemy = m;
        }
        return isNear;
    }

    public Monster getNearbyMonster() {
        return enemy;
    }


    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void moveCharacter(char direction) {
        int posX = hero.getPositionX();
        int posY = hero.getPositionY();
        switch (direction) {
            case 'z' :
                posY--;
                break;
            case 's' :
                posY = (posY+1)%SIZE;
                break;
            case 'q' :
                posX--;
                break;
            case 'd' :
                posX = (posX+1)%SIZE;
                break;
        }
        if(posX < 0) {
            posX = SIZE - 1;
        } else if (posY <0) {
            posY = SIZE - 1;
        }
        hero.changePosition(posX,posY);

    }

    public void display() {
        for (int i=0;i<SIZE;++i) {
            for(int j=0;j<SIZE;++j) {
                if(hero.getPositionY()==i && hero.getPositionX()==j) {
                    System.out.print(hero+" ");
                }else  {
                    System.out.printf("- ");
                }
            }
            System.out.printf("\n");
        }
    }


}
