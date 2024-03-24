package maptresor;

public class CommandForward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointRover newPointRover = avanturerMapTresor.getPointRover().sumPoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor(newPointRover, avanturerMapTresor.getDirection());
    }
}
