package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap implements WorldMap, MoveValidator {

    public RectangularMap(int width, int height) {
        super(width, height);
   }

    @Override
    public boolean canMoveTo(Vector2d position){
        return super.canMoveTo(position) && (lowerLeftLimit.precedes(position) && upperRightLimit.follows(position));
    }




}
