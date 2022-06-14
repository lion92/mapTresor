import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import maptresor.Direction;
import maptresor.MapTresor;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTresorTest {


    @ParameterizedTest
    @CsvSource({
            "0,1,2",
            "0,2,3",
            "0,3,4"})
    void test_parametric_moveNorth(int x,int y, int expectedY) {
        //Given
        MapTresor mapTresor =new MapTresor(x,y,Direction.NORTH);
        //When
        MapTresor mapTresorActual = mapTresor.receiveCommand("F");

        assertThat(mapTresorActual).isEqualTo(new MapTresor(x,expectedY,Direction.NORTH));

    }

    @Test
    void given_the_mapTresor_is_in_0_0_west_when_it_goes_forward_then_it_should_be_in_moins1_0_west() {
        //Given
        MapTresor mapTresor =new MapTresor(0,0,Direction.WEST);
        //When
        MapTresor mapTresorActual = mapTresor.receiveCommand("F");
        //Then
        assertThat(mapTresorActual).isEqualTo(new MapTresor(-1,0,Direction.WEST));
    }

    @Test
    void given_the_mapTresor_is_in_0_0_North_when_it_goes_backward_then_it_should_be_in_moins0_moins1_North() {
        //Given
        MapTresor mapTresor =new MapTresor(0,0,Direction.NORTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("B");
        assertThat(actualMapTresor).isEqualTo(new MapTresor(0,-1,Direction.NORTH));
    }

    @Test
    void given_the_mapTresor_is_in_0_0_East_when_it_goes_backward_then_it_should_be_in_moins1_0_East() {
        //Given
        MapTresor mapTresor =new MapTresor(0,0,Direction.EAST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("B");
        assertThat(actualMapTresor).isEqualTo(new MapTresor(-1,0,Direction.EAST));
    }

    @Test
    void given_the_mapTresor_is_in_0_0_South_when_it_goes_Backward_then_it_should_be_in_0_moins1_South() {
        //Given
        MapTresor mapTresor =new MapTresor(0,0,Direction.SOUTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("B");
        assertThat(actualMapTresor).isEqualTo(new MapTresor(0,1,Direction.SOUTH));
    }

    @Test
    void given_the_mapTresor_is_in_0_0_West_when_it_goes_Backward_then_it_should_be_in_1_0_West() {
        //Given
        MapTresor mapTresor =new MapTresor(0,0,Direction.WEST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("B");
        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,0,Direction.WEST));
    }

    @Test
    void sould_be_in_1_1_west_after_FBFB_from_1_1_West() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.WEST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("FBFB");
        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.WEST));
    }

    @Test
    void north_to_east() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.NORTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("R");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.EAST));
    }

    @Test
    void west_to_north() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.WEST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("R");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.NORTH));
    }

    @Test
    void south_to_west() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.SOUTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("R");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.WEST));
    }

    @Test
    void east_to_south() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.EAST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("R");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.SOUTH));
    }

    @Test
    void north_to_west() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.NORTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("L");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.WEST));
    }


    @Test
    void west_to_south() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.WEST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("L");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.SOUTH));
    }


    @Test
    void south_to_east() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.SOUTH);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("L");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.EAST));
    }

    @Test
    void east_to_north() {
        //Given
        MapTresor mapTresor =new MapTresor(1,1,Direction.EAST);
        //When
        MapTresor actualMapTresor = mapTresor.receiveCommand("L");

        assertThat(actualMapTresor).isEqualTo(new MapTresor(1,1,Direction.NORTH));
    }
}
