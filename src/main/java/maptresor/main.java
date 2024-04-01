package maptresor;

import ParserFichier.StringParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class main {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser("C - 3 - 4\n M - 1 - 1\n M - 2 - 2\n T - 0 - 3 - 2\n T - 1 - 3 - 1\n A - Indiana - 1 - 1 - S - AADADA\n");



                TresorMap map1 = stringParser.getTresorMap();

                AvanturerMapTresor avanturerMapTresor = stringParser.getAvanturerMapTresors().get(0);
                List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique(avanturerMapTresor.getCommande());

                System.out.println(avanturerMapTresor.getPointTresorList());
        String positionMapsWithAll = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor));

        System.out.println(positionMapsWithAll);
    }
}
