package maptresor;

public class CommandTurnRight implements Command {
    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        return new AvanturerMapTresor(avanturerMapTresor.getDirection().turnRight(), avanturerMapTresor.getPointAdventurer(), avanturerMapTresor.getName() ,0);
    }
}
