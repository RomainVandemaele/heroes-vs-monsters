package bf.java.ex.delegate;

import bf.java.ex.map.Map;

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
