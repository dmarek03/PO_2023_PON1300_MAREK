package agh.ics.opp;

import agh.ics.opp.model.MoveDirection;

public class World {

    public static void run(MoveDirection[] parsedArgs){
        for(MoveDirection pars : parsedArgs){
            switch (pars){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
    public static void main(String[] args) {
        MoveDirection[] parsedArgs = OptionsParser.parseToEnum(args);
        System.out.println("System wystartował");
        run(parsedArgs);
        System.out.println("System zakończył działanie");

    }
}