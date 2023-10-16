package agh.ics.oop.model;

public class Vector2d {
   final public int x;
   final public int y;
   public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
   }

   public int getX(){
       return this.x;
   }

    public int getY(){
        return this.y;
    }

    public String toString(int x, int y){
       return "("+ x +","+ y + ")";
    }

    public boolean precedes(Vector2d other){
       return (x >= other.x || y >= other.y);
    }

    public boolean follows(Vector2d other){
        return (x <= other.x || y <= other.y);
    }
    public Vector2d add(Vector2d other){
       return new Vector2d(x+other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x, y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));
    }
    public Vector2d opposite(){
       return new Vector2d(-x, -y);
    }
    public int hashCode(){
        return Integer.hashCode(x)+7727*Integer.hashCode(y);
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        return x == that.x && y == that.y;
    }

}


