package rover;

public class DirectionEast implements IDirection{

    @Override
    public PointRover move() {
        return new PointRover(1,0);
    }
}
