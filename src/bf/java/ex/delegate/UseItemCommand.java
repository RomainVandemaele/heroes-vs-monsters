package bf.java.ex.delegate;

import bf.java.ex.mob.Hero;
import bf.java.ex.mob.Monster;

public class UseItemCommand extends Command<Hero> {

    public UseItemCommand(Hero receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        System.out.println("print");
        //receiver.UseItem();
    }


    public void execute(Monster enemy) {
        receiver.UseItem(enemy);
    }
}
