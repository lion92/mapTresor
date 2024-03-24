package maptresor;

public class CommandTurnLeft implements Command {
    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        return new AvanturerMapTresor(avanturerMapTresor.getPointRover(), avanturerMapTresor.getDirection().turnLeft());
    }
}
