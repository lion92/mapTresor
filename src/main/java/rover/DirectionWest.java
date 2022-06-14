package rover;

public class DirectionWest implements IDirection{

    @Override
    public PointRover move() {
        return new PointRover(- 1, 0);
    }
}
