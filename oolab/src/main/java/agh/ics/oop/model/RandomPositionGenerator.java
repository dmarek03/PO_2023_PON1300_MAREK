package agh.ics.oop.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int maxWidth;
    private final int maxHeight;
    private final int grassCount;
    private final List<Vector2d> positions;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {

        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.grassCount = grassCount;
        this.positions = generateRandomPositions();
    }

    private List<Vector2d> generateRandomPositions() {
        List<Vector2d> allPositions = new ArrayList<>();
        for (int x = 0; x < maxWidth; x++) {
            for (int y = 0; y < maxHeight; y++) {
                allPositions.add(new Vector2d(x, y));
            }
        }

        List<Vector2d> selectedPositions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < grassCount; i++) {
            int randomIndex = i + random.nextInt(maxWidth * maxHeight - i);
            Collections.swap(allPositions, i, randomIndex);
            selectedPositions.add(allPositions.get(i));
        }

        return selectedPositions;
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return positions.iterator();
    }

    public  List<Vector2d> getPositions(){
        return positions;
    }
}

