package ch.noseryoung.test;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.datacontainer.Position;

import static org.junit.jupiter.api.Assertions.*;

class OrganismTest {

    @org.junit.jupiter.api.Test
    void move() {
        Organism organism = new Organism(10, 10);
        OrganismStats organismStats = new OrganismStats();
        organismStats.setDirection(Direction.RIGHT);
        organismStats.setSpeed(2);
        organism.setOrganismStats(organismStats);
        Position landingPosition = organism.move();
        assertEquals(landingPosition.getX(), 12);
        assertEquals(landingPosition.getY(), 10);
    }
}