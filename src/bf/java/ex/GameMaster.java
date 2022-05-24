package bf.java.ex;

import bf.java.ex.mob.*;

import java.util.Random;
import java.util.Scanner;

public class GameMaster {

    private Hero hero;
    private Monster enemy;
    private int enemyCount = 0;
    private Random r = new Random();

    public GameMaster() {
        initGame();
        gameLoop();
    }

    private void generateHero() {
        Scanner myScanner = new Scanner(System.in);
        int answer = 0;
        while (answer!=1 && answer!=2) {
            System.out.println("Are you a human(1) or a dwarf(2) ?");
            answer = myScanner.nextInt();
            if(answer==1) {
                hero = new Human();
            } else if (answer==2) {
                hero = new Dwarf();
            }else {
                System.out.println("You may enter a correct choice");
            }
        }

    }

    private void generateEnemy() {
        int monsterIndex = r.nextInt(3);
        switch (monsterIndex) {
            case 0 :
                enemy = new Wolf();
                break;
            case 1 :
                enemy = new Dragonet();
                break;
            case 2 :
                enemy = new Orc();
        }
    }

    private void gameLoop() {
        Scanner myScanner = new Scanner(System.in);
        while (!hero.isDead()) {
            System.out.printf("You are now facing a %s.\n",enemy.toString());
            while (!hero.isDead() && !enemy.isDead()) {
                System.out.printf("Your current stats are :\nFOR : %d END : %d HP : %d/%d.\n",hero.getForce(),hero.getEndurance(),hero.getHp(),hero.getMaxHealth());
                System.out.printf("The %s has now %d/%d HP left\n",enemy.toString(),enemy.getHp(),enemy.getMaxHealth());
                int answer = 0;
                while(answer!=1) {
                    System.out.println("Are you ready to hit?(Y=1)");
                    answer = myScanner.nextInt();
                }
                int damage = hero.getDamage();
                hero.hit(enemy,damage);
                System.out.printf("You did %s damages.\n",damage);
                System.out.printf("The %s has now %d/%d HP left\n",enemy.toString(),enemy.getHp(),enemy.getMaxHealth());

                if(!enemy.isDead()) {
                    System.out.printf("The %s is ready to attack.\n",enemy.toString());
                    damage = enemy.getDamage();
                    enemy.hit(hero,damage);
                    System.out.printf("The %s did %s damages.\n",enemy.toString(),damage);
                    System.out.printf("You now have %d/%d HP left\n",hero.getHp(),hero.getMaxHealth());
                }
            }
            if(!hero.isDead()) {
                System.out.printf("\n\nCongratulations your slained the %s.\nYou earned %d golds and %d leathers.\nNonetheless, the next monster is awaiting.\n\n\n",enemy.toString(),enemy.getGold(),enemy.getLeather());
                enemyCount++;
                hero.restoreHealth();
                generateEnemy();
            }
        }
        endGame();
    }

    public void initGame() {
        generateHero();
        generateEnemy();
    }

    private void endGame() {
        System.out.println("You have met your end.");
        System.out.printf("During your life as an hero you slained %d monsters.\nYou also collected %d golds and %d leathers.\n",enemyCount,hero.getGold(),hero.getLeather());
        System.out.println("May you have better results next time.");
    }

    public static void main(String[] args) {

    }
}
