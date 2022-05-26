package bf.java.ex.delegate;

import bf.java.ex.Map;
import bf.java.ex.mob.Character;

public abstract class Command<T> {
    public T receiver;

    public Command(T receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

}
