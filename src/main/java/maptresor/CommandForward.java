package maptresor;

public class CommandForward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointAdventurer newPointAdventurer = avanturerMapTresor.getPointRover().sumPoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor(newPointAdventurer, avanturerMapTresor.getDirection());
    }
}
