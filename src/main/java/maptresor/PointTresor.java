package maptresor;

public class PointTresor {
    private int x;
    private int y;
    private int numbers;

    public PointTresor(int x, int y, int numbers) {
        this.x = x;
        this.y = y;
        this.numbers = numbers;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }


}
