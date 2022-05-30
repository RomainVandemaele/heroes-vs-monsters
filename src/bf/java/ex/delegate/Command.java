package bf.java.ex.delegate;

public abstract class Command<T> {
    protected T receiver;

    public Command(T receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

}
