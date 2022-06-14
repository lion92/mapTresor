package maptresor;

public record PointRover(int x, int y) {

    public PointRover sumPoint(PointRover movement) {
        return new PointRover(this.x + movement.x(), this.y() + movement.y());
    }

    public PointRover removePoint(PointRover movement) {
        return new PointRover(this.x - movement.x(), this.y() - movement.y());
    }

}
