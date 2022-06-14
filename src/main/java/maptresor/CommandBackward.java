package maptresor;

public class CommandBackward implements Command {

    @Override
    public MapTresor execute(MapTresor mapTresor) {
        PointRover newPointRover = mapTresor.getPointRover().removePoint(mapTresor.getDirection().getForwardMouvement());
        return new MapTresor(newPointRover, mapTresor.getDirection());
    }
}
