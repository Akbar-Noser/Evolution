package ch.noseryoung.datacontainer;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;

public class DirectionEvaluator {
    private Organism organismToAssignTo;
    private int right;
    private int left;
    private int down;
    private int up;

    public DirectionEvaluator(Organism organismToAssignTo) {
        this.organismToAssignTo = organismToAssignTo;
        right = 0;
        left = 0;
        down = 0;
        up = 0;
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
