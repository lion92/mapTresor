package maptresor;

public class CommandBackward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointAdventurer newPointAdventurer = avanturerMapTresor.getPointRover().removePoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor(newPointAdventurer, avanturerMapTresor.getDirection());
    }
}
