package bf.java.ex.delegate;

import bf.java.ex.mob.Hero;

public class UseItemCommand extends Command<Hero> {

    public UseItemCommand(Hero receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.UseItem();
    }
}
