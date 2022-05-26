package bf.java.ex.delegate;

import bf.java.ex.mob.Character;

public class FightCommand extends Command<Character> {

    private Character enemy;


    public FightCommand(Character character,Character enemy) {
        super(character);
        this.enemy = enemy;
    }

//    public void changeEnemy(Character enemy) {
//        this.enemy = enemy;
//    }


    @Override
    public void execute() {
        receiver.hit(enemy);
    }
}
