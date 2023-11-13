package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap implements WorldMap{

    private  final int grassNumber;
    private Vector2d lowerLeftLimit;
    private Vector2d upperRightLimit ;
    private final Map<Vector2d,WorldElement> grassClowns = new HashMap<>() ;


    public GrassField(int n){
        super((int)Math.sqrt(n*10)+1, (int)Math.sqrt(n*10)+1);
        this.grassNumber = n;
        placeGrass();
    }

    public boolean isOccupiedByGrass(Vector2d position){
        return grassClowns.containsKey(position);
    }

    public void placeGrass(){
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(width+1, height+1, grassNumber);
        for(Vector2d grassPosition : randomPositionGenerator) {
           grassClowns.put(grassPosition, new Grass(grassPosition));
        }

    }


    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {return animal;}
        if (isOccupiedByGrass(position)) {
            return grassClowns.get(position);

        }
        return null;
    }
    private int [] findMapLimits(Map<Vector2d, WorldElement> map){
        int xMin = 0;
        int xMax = 0;
        int yMin = 0;
        int yMax= 0;
        for(Map.Entry<Vector2d,WorldElement> entry: map.entrySet()){
            int x =  entry.getKey().getX();
            int y = entry.getKey().getY();

            xMin = Math.min(xMin, x);
            xMax = Math.max(xMax, x);
            yMin = Math.min(yMin, y);
            yMax = Math.max(yMax,y);

        }
        return new int []{xMin, xMax,yMin, yMax};

    }

    @Override
    public String toString(){
        int  [] grassMapLimits = findMapLimits(this.grassClowns);
        int  [] animalMapLimits = findMapLimits(this.animals);
        int [] mapLimits = {0,0,0,0};
        for (int i=0;i<4;i++){
            switch (i % 2){
                case 0 -> mapLimits[i] = Math.min(grassMapLimits[i], animalMapLimits[i]);
                case 1 -> mapLimits[i] = Math.max(grassMapLimits[i], animalMapLimits[i]);
            }

        }
        MapVisualizer visualizer = new MapVisualizer(this);
        lowerLeftLimit = new Vector2d(mapLimits[0], mapLimits[2]);
        upperRightLimit = new Vector2d(mapLimits[1], mapLimits[3]);
        return visualizer.draw(lowerLeftLimit, upperRightLimit);


    }

    @Override
    public Map<Vector2d, WorldElement> getElement(){
        Map<Vector2d, WorldElement> mapElements = super.getElement();
        mapElements.putAll(grassClowns);
        return mapElements;
    }
    public Map<Vector2d, WorldElement> getGrassClowns(){return grassClowns;}

    public Map<Vector2d, WorldElement> getAnimals(){
        return animals;
    }
    @Override
    public Vector2d getLowerLeftLimit() {
        return lowerLeftLimit;
    }
    @Override
    public Vector2d getUpperRightLimit() {
        return upperRightLimit;
    }



}
