package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static String[] getExpectedMoves(String[] array){
        int length = 0;
        for(String elem : array){
            int cnt = switch (elem){
                case "f", "b" ,"l" , "r" -> 1;
                default -> 0;
            };
            length += cnt;
        }
        String[] expectedMoves = new String[length];
        int idx = 0;
        for(String a : array){
            if (a.equals("f") || a.equals("b") || a.equals("l") || a.equals("r")){
                expectedMoves[idx] = a;
                idx += 1;
            }
            if (idx > length){
                break;
            }


        }
        return expectedMoves;

    }
    public static MoveDirection[] parseToEnum(String[] args){
        String[] expectedMoves = getExpectedMoves(args);
        MoveDirection[]  Directions = new MoveDirection[expectedMoves.length];
        for(int idx = 0; idx < expectedMoves.length ; idx ++){
            switch (expectedMoves[idx]) {
                case "f" -> Directions[idx] = MoveDirection.FORWARD;
                case "b" -> Directions[idx] = MoveDirection.BACKWARD;
                case "r" -> Directions[idx] = MoveDirection.RIGHT;
                case "l" -> Directions[idx] = MoveDirection.LEFT;
            }

        }

        return Directions;

    }
}
