package bf.java.ex;

import bf.java.ex.mob.*;

import java.beans.PropertyEditorManager;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class Map {
    private final int SIZE;
    private final int N_MONSTERS; // 1 per 3*3 area
    private ArrayList<Monster> monsters;
    private Hero hero;
    private Monster enemy = null;

    public Map(int size) {
        SIZE = size;
        SecureRandom sr = new SecureRandom();
        N_MONSTERS = 5 + sr.nextInt(size/2);
        //N_MONSTERS = 25;
        generateMonster();
    }

    private void generateMonster() {
        int n = N_MONSTERS;
        SecureRandom sr = new SecureRandom();
        monsters = new ArrayList<Monster>();
        int step = (int) Math.floor( Math.sqrt ( (SIZE*SIZE)/N_MONSTERS ) );
        int i =0;
        while (n > 0 &&  i<SIZE) {
            int j=0;
            while(n>0 && j < SIZE) {
                int posX = Math.min( i + sr.nextInt(step), SIZE-1 );
                int posY = Math.min( j + sr.nextInt(step),SIZE-1 );
                //System.out.printf(" (%d %d) %d =>  Monster at %d %d\n",i,j,step,posX,posY);
                int type = sr.nextInt(3);
                Monster monster;
                switch (type) {
                    case 0 :
                        monster = new Wolf(posX,posY);
                        break;
                    case 1 :
                        monster = new Dragonet(posX,posY);
                        break;
                    default :
                        monster = new Orc(posX,posY);
                        break;
                }
                monsters.add(monster);
                n--;
                j+=step;
            }
            i+=step;
        }
    }


    public void  removeMonster(Monster deadMonster) {
        monsters.remove(deadMonster);
    }

    public int getNumberOfMonster() {
        return monsters.size();
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
