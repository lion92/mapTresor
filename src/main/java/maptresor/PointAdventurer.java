package maptresor;

public record PointAdventurer(int x, int y) {

    public PointAdventurer sumPoint(PointAdventurer movement) {
        return new PointAdventurer(this.x + movement.x(), this.y() + movement.y());
    }

    public PointAdventurer removePoint(PointAdventurer movement) {
        return new PointAdventurer(this.x - movement.x(), this.y() - movement.y());
    }

}
