package maptresor;

import java.util.Objects;

public class PositionMap {
    private final int x;
        private final int y;
    private String item;

    public PositionMap(int x, int y, String item) {
        this.x = x;
        this.y = y;
        this.item = item;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionMap that = (PositionMap) o;
        return x == that.x && y == that.y && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, item);
    }

    @Override
    public String toString() {
        return "PositionMap{" +
                "x=" + x +
                ", y=" + y +
                ", item='" + item + '\'' +
                '}';
    }
}
