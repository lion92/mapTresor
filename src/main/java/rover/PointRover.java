package rover;

public record PointRover(int x, int y) {

    public PointRover sumPoint(PointRover initial, PointRover mouvement){
        return new PointRover(initial.x+ mouvement.x(), initial.y()+ mouvement.y());
    }

}
