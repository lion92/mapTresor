import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import maptresor.Direction;
import maptresor.AvanturerMapTresor;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTresorTest {


    @ParameterizedTest
    @CsvSource({
            "0,1,2",
            "0,2,3",
            "0,3,4"})
    void test_parametric_moveNorth(int x,int y, int expectedY) {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(x,y,Direction.NORTH);
        //When
        AvanturerMapTresor avanturerMapTresorActual = avanturerMapTresor.receiveCommand("A");

        assertThat(avanturerMapTresorActual).isEqualTo(new AvanturerMapTresor(x,expectedY,Direction.NORTH));

    }

    @Test
    void given_the_mapTresor_is_in_0_0_west_when_it_goes_forward_then_it_should_be_in_moins1_0_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(0,0,Direction.WEST);
        //When
        AvanturerMapTresor avanturerMapTresorActual = avanturerMapTresor.receiveCommand("A");
        //Then
        assertThat(avanturerMapTresorActual).isEqualTo(new AvanturerMapTresor(-1,0,Direction.WEST));
    }


    @Test
    void north_to_east() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.NORTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.EAST));
    }

    @Test
    void west_to_north() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.WEST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.NORTH));
    }

    @Test
    void south_to_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.SOUTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.WEST));
    }

    @Test
    void east_to_south() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.EAST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("D");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.SOUTH));
    }

    @Test
    void north_to_west() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.NORTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.WEST));
    }


    @Test
    void west_to_south() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.WEST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.SOUTH));
    }


    @Test
    void south_to_east() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.SOUTH);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.EAST));
    }

    @Test
    void east_to_north() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.EAST);
        //When
        AvanturerMapTresor actualAvanturerMapTresor = avanturerMapTresor.receiveCommand("G");

        assertThat(actualAvanturerMapTresor).isEqualTo(new AvanturerMapTresor(1,1,Direction.NORTH));
    }

    @Test
    void should_collect_a_tresor_when_a_adventurer_is_in_the_same_case_of_T_for_tresor() {
        //Given
        AvanturerMapTresor avanturerMapTresor =new AvanturerMapTresor(1,1,Direction.EAST);

        Tresor tresor= new Tresor(2,1);
        //When
        Boolean isATresor = avanturerMapTresor.receiveCommand("A").isAdenturerGetATresor();

        assertThat(isATresor).isTrue();
    }
}