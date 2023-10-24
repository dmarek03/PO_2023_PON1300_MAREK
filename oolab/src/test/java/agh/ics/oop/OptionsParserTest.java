package agh.ics.oop;
import static agh.ics.oop.OptionsParser.parseToEnum;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
//    @Test
//    public void hasOnlyExpectedMoves(){
//        String [] moves1 = {"f", "l", "r", "g", "t", "f", " i"};
//        String [] expectedMoves1 = {"f", "l", "r", "f"};
//        String [] testMoves1 = getExpectedMoves(moves1);
//        String [] moves2 = {"R", "F", "0", "ola", "kr", "r ", " f "};
//        String [] expectedMoves2 = {};
//        String [] testMoves2 = getExpectedMoves(moves2);
//        assertEquals(expectedMoves1.length, testMoves1.length);
//        // Przypadek gdy żaden ruch nie jest poprawny
//        assertEquals(expectedMoves2.length, testMoves2.length);
//        for(int idx = 0; idx < expectedMoves1.length; idx++) {
//            assertEquals(expectedMoves1[idx], testMoves1[idx]);
//        }
//    }

    @Test
    public void areMovesCorrectlyParsedToEnum(){
        String [] moves1 = {"f", "l", "r", "g", "t", "f", " i" , "L", "G", "r", "ala", "123"};
        List<MoveDirection> parsedMoves1 = Arrays.asList(
                MoveDirection.FORWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT
        );
        List<MoveDirection> testMoves1 = parseToEnum(moves1);
        String [] moves2 = {"F ", "lr" , "a;a" , "123455" , "f ", " r"};
        List<MoveDirection> parsedMoves2 = new ArrayList<>();
        List<MoveDirection> testMoves2 = parseToEnum(moves2);
        assertEquals(parsedMoves1.size(), testMoves1.size());
        assertEquals(parsedMoves2.size(), testMoves2.size());
        assertIterableEquals(parsedMoves1, testMoves1);
        assertIterableEquals(parsedMoves2, testMoves2);

    }
}
