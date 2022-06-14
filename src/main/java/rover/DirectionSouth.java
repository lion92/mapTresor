package rover;

public class DirectionSouth implements IDirection{
    private PointRover pointRover;

    public DirectionSouth(PointRover rover) {
        this.pointRover = rover;
    }

    @Override
    public PointRover move() {
        return pointRover.moveSouth();
    }
}
