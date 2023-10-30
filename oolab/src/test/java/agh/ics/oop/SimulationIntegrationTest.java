package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.OptionsParser.parseToEnum;
import static agh.ics.oop.model.Animal.LOWER_LEFT_LIMIT;
import static agh.ics.oop.model.Animal.UPPER_RIGHT_LIMIT;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SimulationIntegrationTest {
    @Test
    public void shouldSimulationWorkCorrect(){
    List<Vector2d> positions = List.of(
            new Vector2d(3, 4),
            new Vector2d(0, 1),
            new Vector2d(2, 2)
    );
    String [] moves = {"f", "f", "f", "k","l", "ala", "R", "b", "r", "r"};
    List<MoveDirection> expectedMoves = List.of(
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.LEFT,
            MoveDirection.BACKWARD,
            MoveDirection.RIGHT,
            MoveDirection.RIGHT
    );
    List<MoveDirection> parsedMoves = parseToEnum(moves);
    assertIterableEquals(expectedMoves, parsedMoves);

    Simulation simulation = new Simulation(parsedMoves, positions);
    System.out.println(simulation.getAnimals());
    simulation.run();
    List<MapDirection> expectedOrientations = List.of(MapDirection.NORTH,MapDirection.NORTH,MapDirection.EAST);
    List<Vector2d> expectedPositions = List.of(new Vector2d(3, 4),new Vector2d(0, 1),new Vector2d(2, 3));

    for(int idx =0 ;idx < expectedOrientations.size() ;idx++){
        assertEquals(expectedOrientations.get(idx),simulation.getAnimals().get(idx).getCurrentOrientation());
        assertTrue(simulation.getAnimals().get(idx).isAt(expectedPositions.get(idx)));
        assertTrue(simulation.getAnimals().get(idx).getCurrentPosition().precedes(UPPER_RIGHT_LIMIT));
        assertTrue(simulation.getAnimals().get(idx).getCurrentPosition().follows(LOWER_LEFT_LIMIT));

    }




    }

}
