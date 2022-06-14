package rover;

public class DirectionNorth implements IDirection{

    @Override
    public PointRover move() {
        return new PointRover(0,  1);
    }
}
