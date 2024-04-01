package maptresor;

import ParserFichier.StringParser;

import java.util.List;

public class main {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser("C - 3 - 4\n M - 1 - 1\n M - 2 - 2\n T - 0 - 3 - 2\n T - 1 - 3 - 1\n A - Indiana - 1 - 1 - S - AADADA\n");

        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor (Direction.WEST, new PointAdventurer(1,1), "kriss", stringParser.getMontainsPoints(), stringParser.getPointTresors() );
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique(avanturerMapTresor.getCommande());

        System.out.println(historiqueDeplacementApresCommand.toString());
    }
}
