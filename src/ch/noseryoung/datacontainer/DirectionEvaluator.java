package ch.noseryoung.datacontainer;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DirectionEvaluator {
    private Organism organismToEvaluate;
    private int right;
    private int left;
    private int down;
    private int up;

    public DirectionEvaluator(Organism organismToEvaluate) {
        this.organismToEvaluate = organismToEvaluate;
        right = 0;
        left = 0;
        down = 0;
        up = 0;
    }

    public void evaluateDirection() {
        HashMap<Direction, Integer> directionMap = new HashMap<>(Map.of(Direction.RIGHT, right,
                Direction.LEFT, left,
                Direction.UP, up,
                Direction.DOWN, down));
        int highestValue = Collections.max(directionMap.entrySet(), Map.Entry.comparingByValue()).getValue();
        directionMap.entrySet().removeIf(entry -> highestValue > entry.getValue());
        Direction[] directions = directionMap.keySet().toArray(new Direction[0]);
        organismToEvaluate.getOrganismStats().setDirection(
                directions[ThreadLocalRandom.current().nextInt(directions.length)]);
    }

    public void incrementVote(Direction direction) {
        switch (direction) {
            case UP -> up++;
            case DOWN -> down++;
            case LEFT -> left++;
            case RIGHT -> right++;
        }
    }
}
