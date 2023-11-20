package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updateCounter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCounter += 1;
        System.out.printf("Update number %d: %s%n", updateCounter, message);
        System.out.println(worldMap);
        System.out.printf("Number of total updates: %d%n", updateCounter);
        System.out.println();

    }
}
