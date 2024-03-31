package maptresor;

import ParserFichier.StringParser;

import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println(new StringParser("C - 3 - 4\n M - 1 - 1\n M - 2 - 2\n T - 0 - 3 - 2\n T - 1 - 3 - 1\n").getPointTresors());


/*
        TresorMap tresorMap1 = new TresorMap("C - 4 - 4");
        PointTresor pointTresor = new PointTresor(0, 1);
        PointTresor pointTresor1 = new PointTresor(2, 3);
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor (Direction.WEST, new PointAdventurer(1,1), "kriss", List.of(),  List.of(pointTresor,pointTresor1));
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("ADADADA");

        System.out.println(historiqueDeplacementApresCommand.toString());*/
    }
}
