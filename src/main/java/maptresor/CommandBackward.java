package maptresor;

public class CommandBackward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointAdventurer newPointAdventurer = avanturerMapTresor.getPointAdventurer().removePoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor( avanturerMapTresor.getDirection(), newPointAdventurer, avanturerMapTresor.getName(),avanturerMapTresor.getTresorRecolte(), avanturerMapTresor.getCommande());
    }
}
