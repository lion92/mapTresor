import com.sun.tools.javac.Main;
import maptresor.*;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Map map1 = new Map("C - 4 - 4");
        PointTresor pointTresor = new PointTresor(0, 1);
        PointTresor pointTresor1 = new PointTresor(2, 3);
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor (Direction.WEST, new PointAdventurer(1,1), "kriss", List.of(),  List.of(pointTresor,pointTresor1));
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("AAAA");

        System.out.println(historiqueDeplacementApresCommand.toString());
    }
}
