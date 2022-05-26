package bf.java.ex;

import bf.java.ex.delegate.Command;
import bf.java.ex.delegate.FightCommand;
import bf.java.ex.delegate.MoveCharactereCommand;
import bf.java.ex.mob.*;

import java.util.Random;
import java.util.Scanner;

public class GameMaster {

    private static final int N_ENEMIES = 10;
    private Hero hero;
    private Monster enemy;
    private int enemyCount = 0;
    private Random r = new Random();

    private Map map;

    //private Command[] commands;
    private Command command;

    Scanner myScanner = new Scanner(System.in);

    public GameMaster() {
        map = new Map(15);
        initGame();
        //map.display();
        gameLoop();
    }

    private void generateHero() {
        System.out.println("Are you a human(1) or a dwarf(2) ?");
        while (!myScanner.hasNext("[12]")) {
            System.out.println("You may enter a correct choice");
            myScanner.next();
        }
        int answer = myScanner.nextInt();
        int posX = r.nextInt(map.getSize());
        int posY = r.nextInt(map.getSize());
        if(answer==1) {
            hero = new Human(posX,posY);
        } else if (answer==2) {
            hero = new Dwarf(posX,posY);
        }
    }

    private void generateEnemy() {
        int monsterIndex = r.nextInt(3);
        // TODO: 25-05-22 put real and non overlapping positions
        int posX = r.nextInt(map.getSize());
        int posY = r.nextInt(map.getSize());
        switch (monsterIndex) {
            case 0 :
                enemy = new Wolf(posX,posY);
                break;
            case 1 :
                enemy = new Dragonet(posX,posY);
                break;
            case 2 :
                enemy = new Orc(posX,posY);
        }
        map.addMonster(enemy);
    }

    private void gameLoop() {
        while (!hero.isDead()) {
            mapExploration();
            enemy = map.getNearbyMonster();
            fight();
        }
        endGame();
    }

    private void mapExploration() {
        while (!map.isNearMonster()) {
            map.display();
            System.out.printf("In which direction would you like to move ? (z;q;s;d)");
            while (!myScanner.hasNext("[zqsd]")) {
                System.out.println("Invalid direction! Try again :");
                myScanner.next();
            }
            char decision = myScanner.next().charAt(0);
            command = new MoveCharactereCommand(map,decision);
            command.execute();
        }
    }


    private void fight() {
        System.out.printf("You are now facing a %s.\n",enemy.getName());
        while (!hero.isDead() && !enemy.isDead()) {
            fightTurn();
        }
        if(!hero.isDead()) {
            fightEnd();
        }
    }
    private void fightEnd() {
        System.out.printf("\n\nCongratulations your slained the %s.\nYou earned %d golds and %d leathers.\nNonetheless, the next monster is awaiting.\n\n\n",enemy.getName(),enemy.getGold(),enemy.getLeather());
        enemyCount++;
        hero.restoreHealth();
        generateEnemy();
    }

    private void fightTurn() {

        System.out.printf("Your current stats are :\nFOR : %d END : %d HP : %d/%d.\n",hero.getForce(),hero.getEndurance(),hero.getHp(),hero.getMaxHealth());
        System.out.printf("The %s has now %d/%d HP left\n",enemy.getName(),enemy.getHp(),enemy.getMaxHealth());

        System.out.println("Are you ready to hit?(Y=1)");
        while(!myScanner.hasNext("[1]")) {
            System.out.println("Are you ready to hit?(Y=1)");
            myScanner.next();
        }
        //System.out.println(myScanner.next().charAt(0));
        char answer =  myScanner.next().charAt(0);
        int damage = hero.getDamage();
        command = new FightCommand(hero,enemy);
        System.out.printf("You did %s damages.\n",damage);
        System.out.printf("The %s has now %d/%d HP left\n\n",enemy.getName(),enemy.getHp(),enemy.getMaxHealth());


        if(!enemy.isDead()) {
            System.out.printf("The %s is ready to attack.\n",enemy.getName());
            System.out.printf("Press 1 to continue to the %s turn",enemy.getName());
            while(!myScanner.hasNext("[1]")) {
                myScanner.next();
            }
            damage = enemy.getDamage();
            command = new FightCommand(enemy,hero);
            System.out.printf("The %s did %s damages.\n",enemy.getName(),damage);
            System.out.printf("You now have %d/%d HP left\n\n\n",hero.getHp(),hero.getMaxHealth());

            System.out.printf("Press 1 to continue to the next turn",enemy.getName());
            while(!myScanner.hasNext("[1]")) {
                myScanner.next();
            }
        }
    }

    public void initGame() {
        System.out.println("Welcome To the forest of Shorewood in the land of StormWall.\n");
        System.out.println("Here you may encounters lot of monsters like orcs, wolfs and dragonets.\n");
        System.out.println("But first let's talk about you :\n");
        generateHero();
        map.setHero(hero);
        for (int i=0;i<N_ENEMIES;i++) {
            generateEnemy();
        }

    }

    private void endGame() {
        System.out.println("You have met your end.");
        System.out.printf("During your life as an hero you slained %d monsters.\nYou also collected %d golds and %d leathers.\n",enemyCount,hero.getGold(),hero.getLeather());
        System.out.println("May you have better results next time.");
    }

}
