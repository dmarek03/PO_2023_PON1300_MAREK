package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AnimalTest {
    @Test
    public void isConvertingToStringCorrect(){
        Vector2d v1 = new Vector2d(1,3);
        Animal animal = new Animal(v1);
        String expectedOutput  = "(Position: (1,3), Orientation: Północ)";
        String invalidOutput  = "(Position:(1,3), Orientation: North)";
        assertEquals(expectedOutput, animal.toString());
        assertNotEquals(invalidOutput, animal.toString());

    }
    @Test
    public void isAnimalAtPosition(){
        Animal animal = new Animal();
        Vector2d pos = new Vector2d(2, 4);
        Animal animal1 = new Animal(pos);
        assertFalse(animal.isAt(pos));
        assertTrue(animal1.isAt(pos));

    }

    @Test
    public void CanAnimalMoveToPosition(){
        Animal animal = new Animal();
        Vector2d pos = new Vector2d(4, 4);
        Vector2d pos1 = new Vector2d(5, 4);
        Vector2d pos2 = new Vector2d(-1, 5);
        Vector2d pos3 = new Vector2d(0, 0);
        assertTrue(animal.canMoveTo(pos));
        assertTrue(animal.canMoveTo(pos3));
        assertFalse(animal.canMoveTo(pos1));
        assertFalse(animal.canMoveTo(pos2));
    }

    @Test
    public void isNextPositionCalculateCorrectly(){
        Animal animal = new Animal();
        Animal animal1 = new Animal(new Vector2d(3, 4));
        Animal animal2 = new Animal(new Vector2d(0, 0));
        MoveDirection direction1 = MoveDirection.FORWARD;
        MoveDirection direction2 = MoveDirection.BACKWARD;
        MoveDirection direction3 = MoveDirection.RIGHT;
        MoveDirection direction4 = MoveDirection.LEFT;
        Vector2d expectedPos1 = new Vector2d(2, 3);
        Vector2d expectedPos2 = new Vector2d(3, 4);
        Vector2d expectedPos3 = new Vector2d(0, 0);
        Vector2d expectedPos4 = new Vector2d(0, 1);
        animal.move(direction1);
        animal1.move(direction1);
        animal2.move(direction2);
        assertEquals(expectedPos1, animal.getCurrentPosition());
        assertEquals(expectedPos2, animal1.getCurrentPosition());
        assertEquals(expectedPos3, animal2.getCurrentPosition());
        animal.move(direction3);
        animal1.move(direction4);
        animal2.move(direction1);
        assertEquals(expectedPos1, animal.getCurrentPosition());
        assertEquals(expectedPos2, animal1.getCurrentPosition());
        assertEquals(expectedPos4, animal2.getCurrentPosition());

    }
    @Test
    public void isPositionGetterWorksCorrect(){
        Animal animal = new Animal();
        Animal animal1 = new Animal(new Vector2d(3, 2));
        Vector2d expectedPosition1 = new Vector2d(2, 2);
        Vector2d expectedPosition2 = new Vector2d(3, 2);
        assertEquals(expectedPosition1, animal.getCurrentPosition());
        assertEquals(expectedPosition2, animal1.getCurrentPosition());
    }

    @Test
    public void isOrientationGetterWorksCorrect(){
        Animal animal = new Animal();
        Animal animal1 = new Animal(new Vector2d(3, 2));
        MapDirection direction1 = MapDirection.NORTH;
        MapDirection direction2 = MapDirection.EAST;
        assertEquals(direction1, animal.getCurrentOrientation());
        assertEquals(direction1, animal1.getCurrentOrientation());
        assertNotEquals(direction2, animal1.getCurrentOrientation());
    }
}
