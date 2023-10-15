package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void run(MoveDirection[] parsedArgs){
        for(MoveDirection pars : parsedArgs){
            String message = switch (pars){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        MoveDirection[] parsedArgs = OptionsParser.parseToEnum(args);
        System.out.println("System wystartował");
        run(parsedArgs);
        System.out.println("System zakończył działanie");

    }
}