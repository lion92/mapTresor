package ParserFichier;

import maptresor.*;

import java.util.ArrayList;
import java.util.List;


public class StringParser {

    List<MontainsPoint> montainsPoints;
    List<PointTresor> pointTresors;
    List<AvanturerMapTresor> avanturerMapTresors;

    TresorMap tresorMap;
    public StringParser(String fichier) {
        map(fichier);

    }

    public void map(String fichier) {
        montainsPoints = new ArrayList<>();
        pointTresors = new ArrayList<>();
        avanturerMapTresors = new ArrayList<>();
        tresorMap=null;

        String[] ligne = fichier.split("\n");

        for (String ligneencopurs : ligne) {
            String[] ligneSplitCours = ligneencopurs.split("-");
            switch (ligneSplitCours[0].trim()) {
                case "C" -> tresorMap = new TresorMap(ligneencopurs.replace("]", ""));
                case "M" -> {
                    System.out.println(ligneSplitCours[1].trim());
                    System.out.println(ligneSplitCours[2].trim());
                    montainsPoints.add(new MontainsPoint(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim())));
                }
                case "T" -> {
                    System.out.println(ligneSplitCours[1].trim());
                    System.out.println(ligneSplitCours[2].trim());
                    pointTresors.add(new PointTresor(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim()), Integer.parseInt(ligneSplitCours[3].trim())));
                }
                default -> throw new IllegalStateException("Unexpected value: " + ligneSplitCours[0].trim());
            }
            if (ligneSplitCours[0].trim().equals("A")) {
                //par defaut si il n'y a pas de direction j'ai mis sud
                avanturerMapTresors.add(new AvanturerMapTresor(
                        ligneSplitCours[4].trim().equals("S")?Direction.SOUTH:
                                ligneSplitCours[4].trim().equals("W")?Direction.WEST:
                                ligneSplitCours[4].trim().equals("E")?Direction.EAST:
                                ligneSplitCours[4].trim().equals("N")?
                                        Direction.NORTH:Direction.SOUTH,
                        new PointAdventurer(
                                Integer.parseInt(ligneSplitCours[2].trim()),
                                Integer.parseInt(ligneSplitCours[3].trim())),
                        ligneSplitCours[1].trim(),
                        0,
                        ligneSplitCours[5].trim()));

            }
        }

    }

    public List<MontainsPoint> getMontainsPoints() {
        return montainsPoints;
    }

    public List<PointTresor> getPointTresors() {
        return pointTresors;
    }

    @Override
    public String toString() {
        return "StringParser{" +
                "montainsPoints=" + montainsPoints +
                ", pointTresors=" + pointTresors +
                ", avanturerMapTresors=" + avanturerMapTresors +
                ", tresorMap=" + tresorMap +
                '}';
    }
}
