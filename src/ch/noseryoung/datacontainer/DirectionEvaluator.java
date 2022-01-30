package ch.noseryoung.datacontainer;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Processes the direction genomes to choose a single direction
 * which will then influence the movement
 */
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

    /**
     * evaluates all vote scores and chooses the direction with the highest score to
     * that direction will then influence future movement
     */
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

    /**
     * Used to increment the vote for a single direction based on a single
     * direction genome
     * @param direction whose vote score should be increased
     */
    public void incrementVote(Direction direction) {
        switch (direction) {
            case UP -> up++;
            case DOWN -> down++;
            case LEFT -> left++;
            case RIGHT -> right++;
        }
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

}
