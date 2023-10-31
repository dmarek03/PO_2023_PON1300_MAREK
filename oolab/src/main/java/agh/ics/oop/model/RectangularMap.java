package agh.ics.oop.model;
import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{
    private int width;
    private int height;
    public final Vector2d lowerLeftLimit = new Vector2d(0,0);
    public final Vector2d upperRightLimit = new Vector2d(width-1,height-1);
    Map<Vector2d, Animal> animals = new HashMap<>() ;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position) && lowerLeftLimit.precedes(position) && upperRightLimit.follows(position);
    }
    @Override
    public Animal objectAt(Vector2d position){
        return animals.get(position);

    }

    @Override
    public boolean place (Animal animal){
        if (canMoveTo(animal.getCurrentPosition())){
            animals.put(animal.getCurrentPosition(),animal);
            return true;

        }
        return false;

    }
    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d newPosition = animal.calculateNextPosition(direction);
        if (canMoveTo(newPosition)){
            animals.remove(animal.getCurrentPosition());
            animal.move(direction);
            animals.put(newPosition, animal);
        }

    }
    @Override
    public  String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftLimit,upperRightLimit);
    }
}
