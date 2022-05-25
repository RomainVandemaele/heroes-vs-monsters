package bf.java.ex;

public abstract class Command {
    protected Character receiver;

    public Command(Character receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
