package maptresor;

public class CommandForward implements Command {

    @Override
    public MapTresor execute(MapTresor mapTresor) {
        PointRover newPointRover = mapTresor.getPointRover().sumPoint(mapTresor.getDirection().getForwardMouvement());
        return new MapTresor(newPointRover, mapTresor.getDirection());
    }
}
