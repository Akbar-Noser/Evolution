package ch.noseryoung.test;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.utils.OrganismStatsUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganismStatsUtilsTest {
    Organism o;
    @BeforeEach
    void setUp() {
        o = new Organism(0,0);
        o.setOrganismStats(new OrganismStats());
    }

    @Test
    void incrementAggression() {
        OrganismStatsUtils.incrementAggression(o);
        assertEquals(OrganismStatsUtils.DEFAULT_AGGRESSION + 1, o.getOrganismStats().getAggression());
    }

    @Test
    void incrementDefense() {
        OrganismStatsUtils.incrementDefense(o);
        assertEquals(OrganismStatsUtils.DEFAULT_DEFENSE + 1, o.getOrganismStats().getDefense());
    }

    @Test
    void incrementCharm() {
        OrganismStatsUtils.incrementCharm(o);
        assertEquals(OrganismStatsUtils.DEFAULT_CHARM + 1, o.getOrganismStats().getCharm());
    }

    @Test
    void incrementSpeed() {
        OrganismStatsUtils.incrementSpeed(o);
        assertEquals(OrganismStatsUtils.DEFAULT_SPEED + 1, o.getOrganismStats().getSpeed());
    }

    @Test
    void getRandomDirection() {
        Direction d = OrganismStatsUtils.getRandomDirection();
        assertTrue(d == Direction.DOWN || d == Direction.UP || d == Direction.RIGHT || d == Direction.LEFT);
    }
}