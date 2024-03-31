package maptresor;

public record MontainsPoint(int x,int y){
    @Override
    public String toString() {
        return "MontainsPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
