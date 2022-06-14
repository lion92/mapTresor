package rover;

public class DirectionSouth implements IDirection{

    @Override
    public PointRover move() {
        return new PointRover(0,-1);
    }
}
