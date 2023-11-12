package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RectangularMapTest  {

    @Test
    public void isPositionOccupiedByAnimal() {
        RectangularMap map = new RectangularMap(5, 5);
        List<Animal> animals = List.of(new Animal(), new Animal(new Vector2d(3, 4)), new Animal(new Vector2d(-3, 4)));
        for(Animal a: animals) {map.place(a);}
        assertTrue(map.isOccupied(animals.get(0).getCurrentPosition()));
        assertTrue(map.isOccupied(animals.get(1).getCurrentPosition()));
        assertFalse(map.isOccupied(animals.get(2).getCurrentPosition()));

    }

    @Test
    public void isObjectAtPosition(){
        RectangularMap map = new RectangularMap(10, 5);
        List<Animal> animals = List.of(new Animal(), new Animal(new Vector2d(9, 4)), new Animal(new Vector2d(7, 4)));
        List<Vector2d> expectedPositions = List.of(new Vector2d(2, 2), new Vector2d(9, 4));
        List<Animal> invalidAnimals = List.of(new Animal(
                new Vector2d(-5,4)),
                new Animal(new Vector2d(11, 4)),
                new Animal(new Vector2d(7, -4))
        );
        List<Vector2d> unexpectedPositions = List.of(new Vector2d(-5, 4), new Vector2d(11, 4), new Vector2d(7, -4));
        for(int i = 0 ;i < animals.size();i ++){
            map.place(animals.get(i));
            map.place(invalidAnimals.get(i));
        }
        for (int idx = 0; idx < expectedPositions.size(); idx++){
            assertEquals(animals.get(idx), map.objectAt(expectedPositions.get(idx)));
            assertNull(map.objectAt(unexpectedPositions.get(idx)));
        }


    }

    @Test
    public void areAnimalsPlacedCorrectly(){
        RectangularMap map = new RectangularMap(10, 10);
        List<Vector2d> positions = List.of(
                new Vector2d(1, 9),
                new Vector2d(2, 2),
                new Vector2d(0,5),
                new Vector2d(0,0),
                new Vector2d(9,9)
        );

        List<Animal> animals =  List.of(
                new Animal(new Vector2d(1, 9)),
                new Animal(),
                new Animal(new Vector2d(0,5)),
                new Animal(new Vector2d(0,0)),
                new Animal(new Vector2d(9,9))
        );
        List<Animal> animalsWhitWrongPosition =  List.of(
                new Animal(new Vector2d(-1, 9)),
                new Animal(new Vector2d(2,-2)),
                new Animal(new Vector2d(0,10)),
                new Animal(new Vector2d(10,0)),
                new Animal(new Vector2d(99,-9))
        );

        for(Animal aw: animalsWhitWrongPosition) {
            map.place(aw);
        }

        Map<Vector2d, Animal> expectedPlacedAnimals = new HashMap<>();
        assertEquals(expectedPlacedAnimals, map.getAnimals());

        for(Animal a: animals) {
            map.place(a);
        }

        for(int idx = 0;idx<positions.size();idx++){
            assertEquals(animals.get(idx), map.getAnimals().get(positions.get(idx)));

        }


    }

    @Test
    public void shouldAnimalsMoveCorrectly(){
        RectangularMap map = new RectangularMap(12, 12);
        List<Vector2d> positions = List.of(
                new Vector2d(4, 4),
                new Vector2d(5, 5),
                new Vector2d(5, 4),
                new Vector2d(4, 5)
        );
        List<Vector2d> expectedPositions = List.of(
                new Vector2d(4, 8),
                new Vector2d(5, 1),
                new Vector2d(10, 4),
                new Vector2d(1,5)
        );
        List<MapDirection> expectedOrientations = List.of(
                MapDirection.NORTH,
                MapDirection.SOUTH,
                MapDirection.EAST,
                MapDirection.WEST
        );

        List<MoveDirection> Moves = List.of(
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        );

        List<Animal> animals = new ArrayList<>();
        for(Vector2d pos : positions) animals.add(new Animal(pos));
        for(Animal a:  animals) {map.place(a);}
        for(int i=0; i < Moves.size();i++){
            map.move(animals.get(i%4), Moves.get(i));
        }
        for (int idx =0 ;idx < expectedOrientations.size() ;idx++){
            assertEquals(expectedOrientations.get(idx),map.getAnimals().get(expectedPositions.get(idx)).getCurrentOrientation());
            assertEquals(expectedPositions.get(idx), map.getAnimals().get(expectedPositions.get(idx)).getCurrentPosition());
        }


    }
}
