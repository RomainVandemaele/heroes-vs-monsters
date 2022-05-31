package bf.java.ex.delegate;

import bf.java.ex.mob.Dragonet;
import bf.java.ex.mob.Monster;
import bf.java.ex.mob.Orc;
import bf.java.ex.mob.Wolf;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MonstersCreator implements MobCreator<Monster> {

    public MonstersCreator() {}

    @Override
    public Monster createMobs(int posX,int posY) {
        SecureRandom sr = new SecureRandom();
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
        return monster;
    }
}
