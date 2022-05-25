package bf.java.ex;

import bf.java.ex.mob.Character;

public abstract class Command {
    protected Character receiver;

    public Command(Character receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

}
