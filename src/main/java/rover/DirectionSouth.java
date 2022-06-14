package rover;

public class DirectionSouth implements IDirection{

    @Override
    public PointRover move(PointRover pointRover) {
        return new PointRover(pointRover.x(), pointRover.y() - 1);
    }
}
