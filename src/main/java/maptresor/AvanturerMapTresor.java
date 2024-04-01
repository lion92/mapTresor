package maptresor;

import commandParser.CommandParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AvanturerMapTresor {
    private final Direction direction;
    private final PointAdventurer pointAdventurer;
    private int tresorRecolte;
    private String commande;

    private List<PointTresor> pointTresorList;
    private List<MontainsPoint> montainsPoints;
    private String name;
    List<AvanturerMapTresor> pointAdventurers;

    public AvanturerMapTresor(int x, int y, Direction direction) {
        this.pointAdventurer = new PointAdventurer(x, y);
        this.direction = direction;
        pointAdventurers = new ArrayList<>();
    }

    public AvanturerMapTresor(Direction direction, PointAdventurer pointAdventurer, String name, int tresorRecolte, String commande, List<PointTresor>pointTresors, List<MontainsPoint>montainsPoints) {
        pointAdventurers = new ArrayList<>();
        this.direction = direction;
        this.pointAdventurer = pointAdventurer;
        this.name = name;
        this.tresorRecolte = tresorRecolte;
        this.commande = commande;
        this.pointTresorList=pointTresors;
        this.montainsPoints=montainsPoints;
    }


    public Direction getDirection() {
        return direction;
    }

    public AvanturerMapTresor(Direction direction, PointAdventurer pointAdventurer, String name, List<MontainsPoint> montainsPoints, List<PointTresor> pointTresorList) {
        this.direction = direction;
        this.pointAdventurer = pointAdventurer;
        this.pointTresorList = pointTresorList;
        this.montainsPoints = montainsPoints;
        this.name = name;
    }

    public List<AvanturerMapTresor> receiveCommandHistorique(String command) {
        List<AvanturerMapTresor> avanturerMapTresors = new ArrayList<>();
        AvanturerMapTresor current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            PointTresor tresor = new PointTresor(this.pointAdventurer.x(), this.pointAdventurer.y(), this.tresorRecolte);
            if (this.pointTresorList != null && this.pointTresorList.contains(tresor)) {
                System.out.println("tresor: " + tresor);
                var tresorCurrent = this.pointTresorList.stream().filter(tresor1 -> tresor1.getX() == pointAdventurer.x() && tresor1.getY() == pointAdventurer.y()).findFirst();
                tresorCurrent.ifPresent(pointTresor -> pointTresor.setNumbers(pointTresor.getNumbers() - 1));
                this.pointTresorList.remove(tresorCurrent.orElse(null));
                current.setTresorRecolte(current.getTresorRecolte()+1);
                this.pointTresorList.add(tresorCurrent.orElse(null));
                current = unitCommand.execute(current);
            } else if (this.montainsPoints != null && !this.montainsPoints.isEmpty() && this.isAdventuerFaceToMontaign(montainsPoints)) {

                System.out.println("Montain: ");
            } else {
                current = unitCommand.execute(current);

            }

            avanturerMapTresors.add(current);
        }

        return avanturerMapTresors;
    }

    private boolean isAdventuerFaceToMontaign(List<MontainsPoint> montainsPoints) {
        boolean b = false;
        for (MontainsPoint montainsPoint : montainsPoints) {
            b = this.isAdventuerFaceToMontaign(montainsPoint);
        }
        return b;
    }

    public AvanturerMapTresor receiveCommand(String command) {
        List<AvanturerMapTresor> avanturerMapTresors = new ArrayList<>();
        AvanturerMapTresor current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            current = unitCommand.execute(current);
        }
        setPointAdventurers(avanturerMapTresors);
        return current;
    }

    public Boolean isAdenturerGetATresor(PointTresor pointTresor) {
        return isAdventurierInATresor(pointTresor);
    }

    public Boolean isAdenturerIsFaceToAMontains(MontainsPoint montains) {
        return isAdventuerFaceToMontaign(montains);
    }

    private boolean isAdventuerFaceToMontaign(MontainsPoint montainsPoint) {
        AvanturerMapTresor foward;
        foward = this.receiveCommand("A");
        return foward.pointAdventurer.x() == montainsPoint.x() && foward.pointAdventurer.y() == montainsPoint.y();
    }


    private boolean isAdventurierInATresor(PointTresor pointTresor) {
        return this.pointAdventurer.x() == pointTresor.getX() && this.pointAdventurer.y() == pointTresor.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvanturerMapTresor avanturerMapTresor = (AvanturerMapTresor) o;
        return direction == avanturerMapTresor.direction && Objects.equals(pointAdventurer, avanturerMapTresor.pointAdventurer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, pointAdventurer);
    }

    @Override
    public String toString() {
        return "AvanturerMapTresor{" +
                "direction=" + direction +
                ", pointAdventurer=" + pointAdventurer +
                ", tresorRecolte=" + tresorRecolte +
                ", pointTresorList=" + pointTresorList +
                ", montainsPoints=" + montainsPoints +
                ", name='" + name + '\'' +
                ", pointAdventurers=" + pointAdventurers +
                '}';
    }

    public PointAdventurer getPointAdventurer() {
        return pointAdventurer;
    }

    public String getName() {
        return name;
    }

    public void setPointAdventurers(List<AvanturerMapTresor> pointAdventurers) {
        this.pointAdventurers = pointAdventurers;
    }

    public List<PointTresor> getPointTresorList() {
        return pointTresorList;
    }

    public List<MontainsPoint> getMontainsPoints() {
        return montainsPoints;
    }

    public int getTresorRecolte() {
        return tresorRecolte;
    }

    public String getCommande() {
        return commande;
    }

    public void setTresorRecolte(int tresorRecolte) {
        this.tresorRecolte = tresorRecolte;
    }

    public void setCommande(String commande) {
        this.commande = commande;
    }

    public void setPointTresorList(List<PointTresor> pointTresorList) {
        this.pointTresorList = pointTresorList;
    }

    public void setMontainsPoints(List<MontainsPoint> montainsPoints) {
        this.montainsPoints = montainsPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AvanturerMapTresor> getPointAdventurers() {
        return pointAdventurers;
    }
}
