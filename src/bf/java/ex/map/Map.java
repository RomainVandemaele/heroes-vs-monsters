package bf.java.ex.map;

import bf.java.ex.Dice;
import bf.java.ex.delegate.MonstersCreator;
import bf.java.ex.mob.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class Map {
    private final int SIZE;

    private MapSquare[][] squares;
    private final int N_MONSTERS; // 1 per 3*3 area
    private ArrayList<Monster> monsters;
    private Hero hero;
    private Monster nearbyEnemy = null;

    private MonstersCreator monsterGenerator;

    enum SQUARE_TYPE {
        GRASS,PLAIN,FOREST
    }

    public Map(int size) {
        SIZE = size;
        createMap();
        SecureRandom sr = new SecureRandom();
        N_MONSTERS = 5 + sr.nextInt(size/2);
        monsterGenerator = new MonstersCreator();
        generateMonster();
    }

    private void generatePatch(SQUARE_TYPE type) {
        final int PATCH_SIZE = 3;
        Dice dSize = new Dice(0,SIZE-1-PATCH_SIZE);
        final int startLine = dSize.throwDice();
        final int startCol = dSize.throwDice();
        for (int i =startLine;i<startLine+PATCH_SIZE;++i) {
            for (int j =startCol;j<startCol+PATCH_SIZE;++j) {
                if(squares[i][j]==null) {
                    switch (type) {
                        case FOREST :
                            squares[i][j] = new ForestSquare();
                            break;
                        case GRASS :
                            squares[i][j] = new GrassSquare();
                            break;
                        case PLAIN:
                            squares[i][j] = new PlainSquare();
                            break;
                    }
                }
            }
        }
    }

    private void createMap() {
        squares = new MapSquare[SIZE][SIZE];
        for (int l=0;l<squares.length;++l) {
            squares[l] = new MapSquare[SIZE];
            for (int c=0;c<squares[l].length;++c) {
                squares[l][c] = null;
            }
        }

        for(int i =0;i<SIZE/2;++i) {
            if(i%2==0) {
                generatePatch(SQUARE_TYPE.FOREST);
            }else {
                generatePatch(SQUARE_TYPE.GRASS);
            }
        }

        for (int l=0;l<squares.length;++l) {
            for (int c=0;c<squares[l].length;++c) {
                if(squares[l][c]==null) {
                    squares[l][c] = new PlainSquare();
                }
            }
        }
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
                Monster m = monsterGenerator.createMobs(posX,posY);
                monsters.add(m);
                squares[posY][posX].setCharacter(m);
                n--;
                j+=step;
            }
            i+=step;
        }
    }


    public void  removeMonster(Monster deadMonster) {
        squares[deadMonster.getPositionY()][deadMonster.getPositionX()].setCharacter(null);
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
        squares[hero.getPositionY()][hero.getPositionX()].setCharacter(hero);
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
            nearbyEnemy = m;
        }
        return isNear;
    }

    public Monster getNearbyMonster() {
        return nearbyEnemy;
    }


    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void moveCharacter(char direction) {
        int posX = hero.getPositionX();
        int posY = hero.getPositionY();
        squares[posY][posX].setCharacter(null);
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
        squares[posY][posX].setCharacter(hero);
    }

    public void display() {
        for (int i=0;i<SIZE;++i) {
            for(int j=0;j<SIZE;++j) {
                System.out.printf("%s ",squares[i][j]);
            }
            System.out.printf("\n");
        }
    }


}
