package rover;

public class DirectionEast implements IDirection{

    @Override
    public PointRover move(PointRover pointRover) {
        return new PointRover(pointRover.x() + 1, pointRover.y());
    }
}
