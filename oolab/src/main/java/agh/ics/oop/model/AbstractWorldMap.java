package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {

    protected final Map<Vector2d, WorldElement> animals = new HashMap<>();

    protected final int width;
    protected final int height;
    protected final Vector2d lowerLeftLimit;
    protected final Vector2d upperRightLimit ;



    protected AbstractWorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        lowerLeftLimit = new Vector2d(0,0);
        upperRightLimit = new Vector2d(width-1, height-1);
    }



    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }
    public boolean canMoveTo(Vector2d position){
        return !isOccupied(position);
    }
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


    public  String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeftLimit, upperRightLimit);

    }


    public WorldElement objectAt(Vector2d position){

            return animals.get(position);
    }

    public Map<Vector2d, WorldElement> getElement() {
        return new HashMap<>(animals);
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

    public Map<Vector2d, WorldElement> getAnimals(){
        return animals;
    }




}
