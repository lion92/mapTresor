import maptresor.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTresorTest {


    @ParameterizedTest
    @CsvSource({
            "0,1,0",
            "0,2,1",
            "0,3,2"})
    void test_parametric_moveNorth(int x, int y, int expectedY) {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(x, y, Direction.NORTH);
        //When
        AvanturerMapTresor avanturerMapTresorActual = avanturerMapTresor.receiveCommand("A");

        assertThat(avanturerMapTresorActual).isEqualTo(new AvanturerMapTresor(x, expectedY, Direction.NORTH));

    }

    @Test
    void given_the_mapTresor_is_in_0_0_west_when_it_goes_forward_then_it_should_be_in_moins1_0_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(0, 0, Direction.WEST);
        //When
        AvanturerMapTresor avanturerMapTresorActual = avanturerMapTresor.receiveCommand("A");
        //Then
        assertThat(avanturerMapTresorActual).isEqualTo(new AvanturerMapTresor(-1, 0, Direction.WEST));
    }


    @Test
    void north_to_east() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.NORTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.EAST));
    }

    @Test
    void west_to_north() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.WEST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.NORTH));
    }

    @Test
    void south_to_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.SOUTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.WEST));
    }

    @Test
    void east_to_south() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.SOUTH));
    }

    @Test
    void north_to_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.NORTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.WEST));
    }


    @Test
    void west_to_south() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.WEST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.SOUTH));
    }


    @Test
    void south_to_east() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.SOUTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.EAST));
    }

    @Test
    void east_to_north() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1, 1, Direction.NORTH));
    }

    @Test
    void should_collect_a_tresor_when_a_adventurer_is_in_the_same_case_of_T_for_tresor() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);

        PointTresor pointTresor = new PointTresor(2, 1, 1);
        //When
        Boolean isATresor = avanturerMapTresor.receiveCommand("A").isAdenturerGetATresor(pointTresor);

        assertThat(isATresor).isTrue();
    }

    @Test
    void should_not_collect_a_tresor_when_a_adventurer_is_not_in_the_same_case_of_T_for_tresor() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);

        PointTresor pointTresor = new PointTresor(3, 1, 1);
        //When
        Boolean isATresor = avanturerMapTresor.isAdenturerGetATresor(pointTresor);

        assertThat(isATresor).isFalse();
    }

    @Test
    void should_stay_in_same_case_when_the_next_case_is_a_montaign_and_the_aventurer_go_foward() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);

        MontainsPoint montains = new MontainsPoint(2, 1);
        //When
        Boolean isAMontains = avanturerMapTresor.isAdenturerIsFaceToAMontains(montains);

        assertThat(isAMontains).isTrue();
    }

    @Test
    void should_stay_in_same_case_when_the_next_case_is_a_montaign_and_the_aventurer_go_foward_second_test() {
        //Given
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(1, 1, Direction.EAST);

        MontainsPoint montains = new MontainsPoint(2, 1);
        //When
        Boolean isAMontains = avanturerMapTresor.isAdenturerIsFaceToAMontains(montains);

        assertThat(isAMontains).isTrue();
    }

    @Test
    void should_draw_a_map_C_3_4() {
        TresorMap map1 = new TresorMap("C - 3 - 4");
        List<PositionMap> map = map1.getAllPostionMap();

        assertThat(map1.getGraph(map1.getAllPostionMap())).isEqualTo(" . - . - . \n . - . - . \n . - . - . \n . - . - . ");
    }

    @Test
    void should_draw_a_map_C_4_4() {
        TresorMap map1 = new TresorMap("C - 4 - 4");
        List<PositionMap> map = map1.getAllPostionMap();

        assertThat(map1.getGraph(map1.getAllPostionMap())).isEqualTo(" . - . - . - . \n . - . - . - . \n . - . - . - . \n . - . - . - . ");
    }

    @Test
    void should_draw_a_map_C_4_4_tresors() {
        TresorMap map1 = new TresorMap("C - 4 - 4");
        PointTresor pointTresor = new PointTresor(1, 1, 1);
        PointTresor pointTresor2 = new PointTresor(3, 2, 1);
        PointTresor pointTresor3 = new PointTresor(3, 1, 1);

        String positionMapsWithTresor = map1.getGraph(map1.putTresors(map1.getAllPostionMap(), List.of(pointTresor, pointTresor2, pointTresor3)));


        assertThat(positionMapsWithTresor).isEqualTo(" . - . - . - . \n . - T(1) - . - T(1) \n . - . - . - T(1) \n . - . - . - . ");
    }

    @Test
    void should_draw_a_map_C_4_4_montains() {
        TresorMap map1 = new TresorMap("C - 4 - 4");
        MontainsPoint montains = new MontainsPoint(2, 1);
        MontainsPoint montains1 = new MontainsPoint(1, 1);
        MontainsPoint montains2 = new MontainsPoint(3, 1);

        String positionMapsWithTresor = map1.getGraph(map1.putMontains(map1.getAllPostionMap(), List.of(montains, montains1, montains2)));

        assertThat(positionMapsWithTresor).isEqualTo(" . - . - . - . \n . - M - M - M \n . - . - . - . \n . - . - . - . ");
    }

    @Test
    void should_whow_mapPositions_of_an_adventurer_when_he_receive_command() {
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.NORTH, new PointAdventurer(1, 1), "kriss", 0, "AAAA",List.of(), List.of());

        assertThat(avanturerMapTresor
                .receiveCommandHistorique(avanturerMapTresor.getCommande())
                .size())
                .isEqualTo(4
                );
    }

    @Test
    void todo4() {
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.SOUTH, new PointAdventurer(1, 1), "kriss", 0, "AAAA", List.of(), List.of());
        TresorMap map1 = new TresorMap("C - 4 - 4");

        List<AvanturerMapTresor> avanturerMapTresors = avanturerMapTresor.receiveCommandHistorique(avanturerMapTresor.getCommande());

        String positionMapsWithTresor = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), avanturerMapTresors));


        assertThat(positionMapsWithTresor).isEqualTo(" . - . - . - . \n . - . - . - . \n . - (0) - . - . \n . - (1) - . - . ");
    }

    @Test
    void todo2() {

        TresorMap map1 = new TresorMap("C - 4 - 4");
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.WEST, new PointAdventurer(1, 1), "kriss", List.of(), List.of());
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("AAAA");

        String positionMapsWithAll = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor));

        System.out.println((map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor).toString()));
        assertThat(positionMapsWithAll).isEqualTo(" . - . - . - . \n (0) - . - . - . \n . - . - . - . \n . - . - . - . ");
    }

    @Test
    void todo3() {

        TresorMap map1 = new TresorMap("C - 4 - 4");
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.EAST, new PointAdventurer(1, 1), "kriss", List.of(), List.of());
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("AAAA");

        String positionMapsWithAll = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor));

        System.out.println((map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor).toString()));
        assertThat(positionMapsWithAll).isEqualTo(" . - . - . - . \n . - . - (0) - (1) \n . - . - . - . \n . - . - . - . ");
    }

    @Test
    void todo_() {

        TresorMap map1 = new TresorMap("C - 4 - 4");
            AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.WEST, new PointAdventurer(2, 1), "kriss", List.of(new MontainsPoint(2, 3), new MontainsPoint(3, 4)), List.of(new PointTresor(1, 3, 4)));
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("AAAA");

        String positionMapsWithAll = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor));

        System.out.println((map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor).toString()));
        assertThat(positionMapsWithAll).isEqualTo(" . - . - . - . \n (1) - (0) - . - . \n . - . - . - . \n . - T - M - . ");
    }

    @Test
    void todo___() {

        TresorMap map1 = new TresorMap("C - 4 - 4");
        AvanturerMapTresor avanturerMapTresor = new AvanturerMapTresor(Direction.WEST, new PointAdventurer(2, 1), "kriss", List.of(new MontainsPoint(2, 3), new MontainsPoint(3, 4),  new MontainsPoint(1, 4),  new MontainsPoint(4, 1)), List.of(new PointTresor(1, 3, 4), new PointTresor(1, 1, 4)));
        List<AvanturerMapTresor> historiqueDeplacementApresCommand = avanturerMapTresor.receiveCommandHistorique("AAAA");

        String positionMapsWithAll = map1.getGraph(map1.putAdventurer(map1.getAllPostionMap(), historiqueDeplacementApresCommand, avanturerMapTresor));

        assertThat(positionMapsWithAll).isEqualTo(" . - . - . - . \n (1) - (0)(4) - . - . \n . - . - . - . \n . - T(4) - M - . ");
    }
}
