package bf.java.ex.delegate;

import bf.java.ex.Map;
import bf.java.ex.delegate.Command;

public class MoveCharactereCommand extends Command<Map> {

    private char movement;

    public MoveCharactereCommand(Map receiver, char operation) {
        super(receiver);
        this.movement = operation;
    }

    @Override
    public void execute() {
        receiver.moveCharacter(movement);
    }
}
