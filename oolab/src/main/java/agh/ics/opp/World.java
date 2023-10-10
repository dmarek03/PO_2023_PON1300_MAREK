package agh.ics.opp;

public class World {
    public static void run(String[] args){
        for(String arg : args){
            switch (arg){
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tyłu");
                case "r" -> System.out.println("Zwierzak skręca w prawo");
                case "l" -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("System wystartował");
        run(args);
        System.out.println("System zakończył działanie");

    }
}