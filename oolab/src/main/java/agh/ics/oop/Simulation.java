package agh.ics.oop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class Simulation {

    private final List<MoveDirection> directions;

    private final List<Vector2d> positions;
    private final List<Animal> animals;

    // W implementacji listy animals wykorzystuję ArrayList, gdyż na tej liście częśćiej będą wykonywane operaje
    // odczytu i niż dodawania badź usuwania elementów, zatem wykorzystanie ArrayList będzię bardziej optymalne
    public Simulation(List<MoveDirection> directions, List<Vector2d> positions){
        this.directions = directions;
        this.positions = positions;
        List<Animal> animals = new ArrayList<>();
        for (Vector2d move : positions) animals.add(new Animal(move));
        this.animals = animals;


    }
    public void run() {
        int animalNumber = animals.size();
        for (int idx = 0; idx < directions.size();idx++){
            Animal animal = animals.get(idx % animalNumber);
            animal.move(directions.get(idx));
            System.out.printf("Zwierzę %d %s %n", idx % animalNumber, animal);
        }

    }
    public List<MoveDirection> getDirections() {
        return directions;
    }
    public List<Vector2d> getPositions() {
        return positions;
    }
    public List<Animal> getAnimals(){
        return Collections.unmodifiableList(animals);
    }

}
