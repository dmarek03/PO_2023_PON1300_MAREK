package agh.ics.oop.model;

public interface WorldElement {

    boolean isAt(Vector2d position);
    public Vector2d getCurrentPosition();
    String toString();



}
