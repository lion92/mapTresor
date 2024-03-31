package maptresor;

public class CommandTurnLeft implements Command {
    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        return new AvanturerMapTresor(avanturerMapTresor.getDirection().turnLeft(),avanturerMapTresor.getPointAdventurer(), avanturerMapTresor.getName(),0);
    }
}
