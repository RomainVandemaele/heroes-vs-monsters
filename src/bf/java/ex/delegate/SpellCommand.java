package bf.java.ex.delegate;

import bf.java.ex.mob.Character;
import bf.java.ex.mob.Hero;

public class SpellCommand extends Command<Hero> {

    private Character enemy;


    public SpellCommand(Hero character, Character enemy) {
        super(character);
        this.enemy = enemy;
    }


    @Override
    public void execute() {
        receiver.throwSpell(enemy);
    }
}
