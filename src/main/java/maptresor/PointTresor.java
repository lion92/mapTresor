package maptresor;

public record PointTresor(int x, int y, int numbers) {
    @Override
    public String toString() {
        return "PointTresor{" +
                "x=" + x +
                ", y=" + y +
                ", numbers=" + numbers +
                '}';
    }
}

