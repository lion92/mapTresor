package rover;

public record PointRover(int x, int y) {
    PointRover moveNorth() {
        return new PointRover(x, y + 1);
    }

    public PointRover moveWest() {
        return new PointRover(x - 1, y);
    }

    public PointRover moveEast() {
        return new PointRover(x + 1, y);
    }

    public PointRover moveSouth() {
        return new PointRover(x, y - 1);
    }
}
