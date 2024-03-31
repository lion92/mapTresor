package maptresor;

public record PointTresor(int x, int y) {
    @Override
    public String toString() {
        return "PointTresor{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
