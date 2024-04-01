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
        montainsPoints = new ArrayList<>();
        pointTresors = new ArrayList<>();
        avanturerMapTresors = new ArrayList<>();
        tresorMap = null;
        map(fichier);

    }

    public void map(String fichier) {


        String[] ligne = fichier.split("\n");

        for (String ligneencopurs : ligne) {
            String[] ligneSplitCours = ligneencopurs.split("-");
            switch (ligneSplitCours[0].trim()) {
                case "C" -> tresorMap = new TresorMap(ligneencopurs.replace("]", ""));
                case "M" -> {

                    montainsPoints.add(new MontainsPoint(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim())));
                }
                case "T" -> {

                    pointTresors.add(new PointTresor(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim()), Integer.parseInt(ligneSplitCours[3].trim())));
                }
                case "A" -> {
                    System.out.println(ligneSplitCours[5].trim());
                    avanturerMapTresors.add(new AvanturerMapTresor(
                            ligneSplitCours[4].trim().equals("S") ? Direction.SOUTH :
                                    ligneSplitCours[4].trim().equals("W") ? Direction.WEST :
                                            ligneSplitCours[4].trim().equals("E") ? Direction.EAST :
                                                    ligneSplitCours[4].trim().equals("N") ?
                                                            Direction.NORTH : Direction.SOUTH,
                            new PointAdventurer(
                                    Integer.parseInt(ligneSplitCours[2].trim()),
                                    Integer.parseInt(ligneSplitCours[3].trim())),
                            ligneSplitCours[1].trim(),
                            0,
                            ligneSplitCours[5].trim(),
                            this.pointTresors,
                            this.montainsPoints
                    ));
                }
                default -> throw new IllegalStateException("Unexpected value: " + ligneSplitCours[0].trim());
            }
        }

    }

    public List<MontainsPoint> getMontainsPoints() {
        return montainsPoints;
    }

    public List<PointTresor> getPointTresors() {
        return pointTresors;
    }

    public void setMontainsPoints(List<MontainsPoint> montainsPoints) {
        this.montainsPoints = montainsPoints;
    }

    public void setPointTresors(List<PointTresor> pointTresors) {
        this.pointTresors = pointTresors;
    }

    public List<AvanturerMapTresor> getAvanturerMapTresors() {
        return avanturerMapTresors;
    }

    public void setAvanturerMapTresors(List<AvanturerMapTresor> avanturerMapTresors) {
        this.avanturerMapTresors = avanturerMapTresors;
    }

    public TresorMap getTresorMap() {
        return tresorMap;
    }

    public void setTresorMap(TresorMap tresorMap) {
        this.tresorMap = tresorMap;
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
