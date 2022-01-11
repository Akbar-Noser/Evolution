package ch.noseryoung.customenum;

public enum Direction {
    RIGHT(1, 0),
    LEFT(-1, 0),
    DOWN(0,1),
    UP(0,-1);

    private final int xDirectionFactor;
    private final int yDirectionFactor;
    Direction(int xDirectionFactor, int yDirectionFactor) {
        this.xDirectionFactor = xDirectionFactor;
        this.yDirectionFactor = yDirectionFactor;
    }

    public int getXDirectionFactor() {
        return xDirectionFactor;
    }

    public int getYDirectionFactor() {
        return yDirectionFactor;
    }
}
