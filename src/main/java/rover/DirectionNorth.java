package rover;

public class DirectionNorth implements IDirection{
    private PointRover pointRover;

    public DirectionNorth(PointRover rover) {
        this.pointRover = rover;
    }

    @Override
    public PointRover move() {
        return pointRover.moveNorth();
    }
}
