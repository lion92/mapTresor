package maptresor;

public class CommandTurnRight implements Command {
    @Override
    public MapTresor execute(MapTresor mapTresor) {
        return new MapTresor(mapTresor.getPointRover(), mapTresor.getDirection().turnRight());
    }
}
