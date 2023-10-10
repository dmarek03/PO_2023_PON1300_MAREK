package agh.ics.opp;

import agh.ics.opp.model.MoveDirection;

public class OptionsParser {

    public static int getArrayLength(String[] array){
        int length = 0;
        for(String elem : array){
            int cnt = switch (elem){
                case "f" -> 1;
                case "b" -> 1;
                case "l" -> 1;
                case "r" -> 1;
                default -> 0;
            };
            length = length + cnt;
        }
        return length;

    }
    public static MoveDirection[] parseToEnum(String[] args){
        int length = getArrayLength(args);
        MoveDirection[]  Directions = new MoveDirection[length];
        for(int idx = 0; idx < args.length ; idx ++){
            if (args[idx].equals("f")){
                Directions[idx] = MoveDirection.FORWARD;
            } else if (args[idx].equals("b")){
                Directions[idx] = MoveDirection.BACKWARD;
            } else if (args[idx].equals("r")){
            Directions[idx] = MoveDirection.RIGHT;
            } else if (args[idx].equals("l")){
            Directions[idx] = MoveDirection.LEFT;
            }

        }
        return Directions;

    }
}
