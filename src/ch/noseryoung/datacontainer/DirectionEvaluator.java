package ch.noseryoung.datacontainer;

import ch.noseryoung.Organism;

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

    public void incrementVoteRight() {
        right++;
    }
    public void incrementVoteLeft() {
        left++;
    }
    public void incrementVoteUp() {
        up++;
    }
    public void incrementVoteDown() {
        down++;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }
}
