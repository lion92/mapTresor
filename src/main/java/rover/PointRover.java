package rover;

import java.util.Objects;

public record PointRover(int x, int y) {
    PointRover moveNorth() {
        return new PointRover(x, y + 1);
    }

    public PointRover moveWest() {
    return new PointRover(x-1,y);
    }
}
