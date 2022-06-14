package maptresor;

public class CommandTurnLeft implements Command {
    @Override
    public MapTresor execute(MapTresor mapTresor) {
        return new MapTresor(mapTresor.getPointRover(), mapTresor.getDirection().turnLeft());
    }
}
