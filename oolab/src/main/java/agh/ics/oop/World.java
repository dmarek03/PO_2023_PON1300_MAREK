package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;


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


    public static void run(List<MoveDirection> parsedArgs){
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
//        System.out.println("========> lab1");
//        List<MoveDirection> parsedArgs = OptionsParser.parseToEnum(args);
//        System.out.println("System wystartował");
//        run(parsedArgs);
//        System.out.println("System zakończył działanie");
//        System.out.println("========> lab2");
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        Vector2d position3 = position1.add(position2);
//        System.out.println(position3.toString());
//        Vector2d oppVector = position3.opposite();
//        System.out.println(oppVector.toString());
//        MapDirection direct1 = MapDirection.SOUTH;
//        System.out.println(direct1.next());
//        System.out.println(direct1.previous());
//        System.out.println(direct1);
//        Vector2d v1 = direct1.toUnitVector();
//        System.out.println(v1.toString());
//        System.out.println("========> lab3");
//        Animal animal = new Animal(new Vector2d(3, 4));
//        Animal animal1 = new Animal();
//        RectangularMap map = new RectangularMap(6, 6);
//        System.out.println(animal);
//        System.out.println(animal1);
//        animal.move(MoveDirection.FORWARD, map);
//        System.out.println(animal);
//        animal.move(MoveDirection.LEFT, map);
//        System.out.println(animal);
//        animal.move(MoveDirection.FORWARD, map);
//        System.out.println(animal);
//        animal.move(MoveDirection.FORWARD, map);
//        System.out.println(animal);
//        animal.move(MoveDirection.FORWARD,map);
//        System.out.println(animal);
//        animal.move(MoveDirection.FORWARD,map);
//        System.out.println(animal);
//        System.out.println("========> Simulation");
//        List<MoveDirection> directions = OptionsParser.parseToEnum(args);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        Simulation simulation = new Simulation(directions,positions, map);
//        simulation.run();
        System.out.println("========> lab4");
        RectangularMap map1 = new RectangularMap(10, 10);
        map1.place(new Animal(new Vector2d(7,8)));
        System.out.println(map1);
        List<MoveDirection> directions = OptionsParser.parseToEnum(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(directions,positions, map1);
        System.out.println(map1);
        simulation.run();
        System.out.println("========> lab5");
        GrassField map2 = new GrassField(55);
        List<Animal> animals =  List.of(new Animal(new Vector2d(1, 22)), new Animal());
        for (Animal a : animals) System.out.println(map2.place(a));
        System.out.println(map2.getAnimals());
        System.out.println(map2.isOccupied(animals.get(1).getCurrentPosition()));
        System.out.println(map2.objectAt(animals.get(1).getCurrentPosition()));
        int i = 0;
        System.out.println(map2);
        for(MoveDirection d : directions){
            map2.move(animals.get(i%2), d);
            System.out.println(map2);
            i += 1;
        }
        System.out.println(map2.getGrassClowns());
        System.out.println(map2);


    }
}