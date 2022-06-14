import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rover.Direction;
import rover.Rover;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {


    @ParameterizedTest
    @CsvSource({
            "0,1,2",
            "0,2,3",
            "0,3,4"})
    void test_parametric_moveNorth(int x,int y, int expectedY) {
        //Given
        Rover rover=new Rover(x,y,Direction.NORTH);
        //When
        Rover roverActual=rover.receiveCommand("F");

        assertThat(roverActual).isEqualTo(new Rover(x,expectedY,Direction.NORTH));

    }

    @Test
    void given_the_rover_is_in_0_0_west_when_it_goes_forward_then_it_should_be_in_moins1_0_west() {
        //Given
        Rover rover=new Rover(0,0,Direction.WEST);
        //When
        Rover roverActual=rover.receiveCommand("F");
        //Then
        assertThat(roverActual).isEqualTo(new Rover(-1,0,Direction.WEST));
    }

    @Test
    void todo() {
        //Given
        Rover rover=new Rover(0,0,Direction.NORTH);
        //When
        Rover actualRover=rover.receiveCommand("B");
        assertThat(actualRover).isEqualTo(new Rover(0,-1,Direction.NORTH));
    }

    @Test
    void todo2() {
        //Given
        Rover rover=new Rover(0,0,Direction.EAST);
        //When
        Rover actualRover=rover.receiveCommand("B");
        assertThat(actualRover).isEqualTo(new Rover(-1,0,Direction.EAST));
    }

    @Test
    void todo3() {
        //Given
        Rover rover=new Rover(0,0,Direction.SOUTH);
        //When
        Rover actualRover=rover.receiveCommand("B");
        assertThat(actualRover).isEqualTo(new Rover(0,1,Direction.SOUTH));
    }

    @Test
    void todo4() {
        //Given
        Rover rover=new Rover(0,0,Direction.WEST);
        //When
        Rover actualRover=rover.receiveCommand("B");
        assertThat(actualRover).isEqualTo(new Rover(1,0,Direction.WEST));
    }

    @Test
    void todo5() {
        //Given
        Rover rover=new Rover(1,1,Direction.WEST);
        //When
        Rover actualRover=rover.receiveCommand("FBFB");
        assertThat(actualRover).isEqualTo(new Rover(1,1,Direction.WEST));
    }

}
