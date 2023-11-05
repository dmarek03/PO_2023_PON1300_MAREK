package agh.ics.oop.model;
import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap, MoveValidator{
    private final int width;
    private final int height;
    private final Vector2d lowerLeftLimit;
    private final Vector2d upperRightLimit;
    private final Map<Vector2d, Animal> animals = new HashMap<>() ;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        lowerLeftLimit = new Vector2d(0,0);
        upperRightLimit = new Vector2d(width-1, height-1);
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
        animals.remove(animal.getCurrentPosition());
        animal.move(direction,this);
        animals.put(animal.getCurrentPosition(), animal);



    }
    @Override
    public  String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftLimit,upperRightLimit);
    }

    public Map<Vector2d, Animal> getAnimals(){
        return animals;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Vector2d getLowerLeftLimit() {
        return lowerLeftLimit;
    }

    public Vector2d getUpperRightLimit() {
        return upperRightLimit;
    }


}
