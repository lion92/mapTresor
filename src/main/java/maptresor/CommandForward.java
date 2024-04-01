package maptresor;

public class CommandForward implements Command {

    @Override
    public AvanturerMapTresor execute(AvanturerMapTresor avanturerMapTresor) {
        PointAdventurer newPointAdventurer = avanturerMapTresor.getPointAdventurer().sumPoint(avanturerMapTresor.getDirection().getForwardMouvement());
        return new AvanturerMapTresor( avanturerMapTresor.getDirection(), newPointAdventurer, avanturerMapTresor.getName(),avanturerMapTresor.getTresorRecolte(), avanturerMapTresor.getCommande());
    }
}
