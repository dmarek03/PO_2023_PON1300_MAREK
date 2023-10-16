package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
//    public static void run(String[] args){
//        System.out.println("Zwierzak idzie do przodu");
//    }


//    public static void run(String[] args){
//        System.out.println("Zwierzak idzie do przodu");
//        for (int i = 0; i < args.length ; i++){
//            if(i < args.length -1) {
//                System.out.print(args[i] + ",");
//            }else System.out.println(args[i]);
//        }
//
//    }
//
//    public static void run(String[] args){
//        for(String arg : args){
//            switch (arg){
//                case "f" -> System.out.println("Zwierzak idzie do przodu");
//                case "b" -> System.out.println("Zwierzak idzie do tyłu");
//                case "r" -> System.out.println("Zwierzak skręca w prawo");
//                case "l" -> System.out.println("Zwierzak skręca w lewo");
//            }
//        }


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