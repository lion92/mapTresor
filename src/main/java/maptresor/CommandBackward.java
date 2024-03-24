package maptresor;

public class CommandBackward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointRover newPointRover = avanturerMapTresor.getPointRover().removePoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor(newPointRover, avanturerMapTresor.getDirection());
    }
}
