package ch.noseryoung.datacontainer;

import ch.noseryoung.customenum.Direction;
import ch.noseryoung.utils.OrganismStatsUtils;

public class OrganismStats {
    private int aggression;
    private int defense;
    private int speed;
    private int charm;
    private Direction direction;

    public OrganismStats() {
        aggression = OrganismStatsUtils.DEFAULT_AGGRESSION;
        defense = OrganismStatsUtils.DEFAULT_DEFENSE;
        speed = OrganismStatsUtils.DEFAULT_SPEED;
        charm = OrganismStatsUtils.DEFAULT_CHARM;
        direction = OrganismStatsUtils.getRandomDirection();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }
}
