package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap implements WorldMap, MoveValidator {
    private final Map<Vector2d, Animal> animals = new HashMap<>();


    public RectangularMap(int width, int height) {
        super(width, height);
   }
    @Override
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position) && (lowerLeftLimit.precedes(position) && upperRightLimit.follows(position));
    }
    @Override
    public boolean place (Animal animal){
        if (canMoveTo(animal.getCurrentPosition())){
            animals.put(animal.getCurrentPosition(),animal);
            return true;

        }
        return false;
    }

    public void move(Animal animal, MoveDirection direction){
        animals.remove(animal.getCurrentPosition());
        animal.move(direction,this);
        animals.put(animal.getCurrentPosition(), animal);
    }

    @Override
    public Animal objectAt(Vector2d position){
        return animals.get(position);
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
    }




}
