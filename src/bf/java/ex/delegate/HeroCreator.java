package bf.java.ex.delegate;

import bf.java.ex.mob.Hero;
import bf.java.ex.mob.Human;

public class HeroCreator implements  MobCreator<Hero>{
    // TODO: 5/27/22 use it
    public HeroCreator() {}

    @Override
    public Hero createMobs(int posX, int posY) {
        return new Human(posX,posY);
    }
}
