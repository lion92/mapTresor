package ParserFichier;

import maptresor.*;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;

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
            if (ligneSplitCours[0].trim().equals("C")) {
                tresorMap = new TresorMap(ligneencopurs.replace("]",""));
            } else if (ligneSplitCours[0].trim().equals("M")) {
                System.out.println(ligneSplitCours[1].trim());
                System.out.println(ligneSplitCours[2].trim());
                montainsPoints.add(new MontainsPoint(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim())));
            }
            else if (ligneSplitCours[0].trim().equals("T")) {
                System.out.println(ligneSplitCours[1].trim());
                System.out.println(ligneSplitCours[2].trim());
                pointTresors.add(new PointTresor(Integer.parseInt(ligneSplitCours[1].trim()), Integer.parseInt(ligneSplitCours[2].trim()), Integer.parseInt(ligneSplitCours[3].trim())));
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
                        Integer.parseInt(ligneSplitCours[5].trim())));

            }
        }

    }

    public List<MontainsPoint> getMontainsPoints() {
        return montainsPoints;
    }

    public void setMontainsPoints(List<MontainsPoint> montainsPoints) {
        this.montainsPoints = montainsPoints;
    }

    public List<PointTresor> getPointTresors() {
        return pointTresors;
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

    @Override
    public String toString() {
        return "StringParser{" +
                "montainsPoints=" + montainsPoints +
                ", pointTresors=" + pointTresors +
                ", avanturerMapTresors=" + avanturerMapTresors +
                ", tresorMap=" + tresorMap +
                '}';
    }

    public TresorMap getTresorMap() {
        return tresorMap;
    }

    public void setTresorMap(TresorMap tresorMap) {
        this.tresorMap = tresorMap;
    }
}
