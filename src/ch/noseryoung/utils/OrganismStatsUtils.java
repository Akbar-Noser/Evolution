package ch.noseryoung.utils;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;

import java.util.concurrent.ThreadLocalRandom;

public class OrganismStatsUtils {
    public final static int DEFAULT_AGGRESSION = 0;
    public final static int DEFAULT_DEFENSE = 0;
    public final static int DEFAULT_CHARM = 0;
    public final static int DEFAULT_SPEED = 1;

    public static void incrementAggression(Organism organism) {
        organism.getOrganismStats().setAggression(organism.getOrganismStats().getAggression() + 1);
    }
    public static void incrementDefense(Organism organism) {
        organism.getOrganismStats().setDefense(organism.getOrganismStats().getDefense() + 1);
    }
    public static void incrementCharm(Organism organism) {
        organism.getOrganismStats().setCharm(organism.getOrganismStats().getCharm() + 1);
    }
    public static void incrementSpeed(Organism organism) {
        organism.getOrganismStats().setSpeed(organism.getOrganismStats().getSpeed() + 1);
    }

    public static Direction getRandomDirection() {
        return Direction.values()[ThreadLocalRandom.current().nextInt(Direction.values().length)];
    }
}
