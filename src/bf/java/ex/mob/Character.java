package bf.java.ex.mob;

import bf.java.ex.Dice;

public abstract class Character {
    protected int hp;
    private final int MAX_HP;
    private final int ENDURANCE;
    private final int FORCE;
    protected Dice d4;
    protected Dice d6;

    protected int gold = 0;
    protected int leather = 0;

    protected int positionX;
    protected int positionY;

    public Character(int posX,int posY) {
        d4 = new Dice(1,4);
        d6 = new Dice(1,6);
        int minEndurance = 6;
        int endurance = 0;
        int minForce = 6;
        int force = 0;
        for(int i=0;i<4;i++) {
            int tEnd = d6.throwDice();
            endurance += d6.throwDice();
            if(tEnd < minEndurance) {
                minEndurance = tEnd;
            }
            int tFor = d6.throwDice();
            force += tFor;
            if(tFor < minForce) {
                minForce = tFor;
            }
        }
        ENDURANCE = endurance - minEndurance;
        FORCE = force - minForce;
        MAX_HP = ENDURANCE + computeModifier(ENDURANCE);
        hp = MAX_HP;

        positionX = posX;
        positionY = posY;

    }

    public void changePosition(int newX,int newY) { //direction : z,q,s,d
        this.positionX = newX;
        this.positionY = newY;
    }

    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }

    protected int computeModifier(int value) {
        int modifier = -1 + value/5;
        if(value < 5) {
            modifier = -1;
        } else if (value < 10) {
            modifier = 0;
        } else if (value < 15) {
            modifier = 1;
        }else {
            modifier = 2;
        }
        return modifier;
    }

    protected int getBaseDamage() {
        return d4.throwDice();
    }

    protected int getDamage() {
        return getBaseDamage() + computeModifier(FORCE);
    }

    public void hit(Character enemy) {
        final int damage = getDamage();
        System.out.printf("%s did %d damage\n",this.getName(),damage);
        enemy.getHit(damage);
    }

    protected void getHit(int damage) {
        hp-=damage;
        if(hp <0) { hp = 0; }
    }

    public boolean isDead() {
        return hp <=0;
    }

    public int getEndurance() {
        return ENDURANCE;
    }

    public int getForce() {
        return FORCE;
    }

    public int getHp() {
        return hp;
    }

    public int getMacHealth() {
        return MAX_HP;
    }

    public int getLeather() {
        return leather;
    }

    public int getGold() {
        return gold;
    }


    public abstract String getName();
}
