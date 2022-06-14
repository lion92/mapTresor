package rover;

public record PointRover(int x, int y) {

    public PointRover sumPoint( PointRover mouvement){
        return new PointRover(this.x+ mouvement.x(), this.y()+ mouvement.y());
    }

}
