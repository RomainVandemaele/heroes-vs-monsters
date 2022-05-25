package bf.java.ex;

import bf.java.ex.mob.Character;

public class MoveCharactereCommand extends Command {

    private char movement;

    public MoveCharactereCommand(Character receiver, char operation) {
        super(receiver);
        this.movement = operation;

    }

    @Override
    public void execute() {
        receiver.movePosition(movement);
    }
}
