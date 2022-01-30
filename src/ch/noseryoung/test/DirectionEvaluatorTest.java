package ch.noseryoung.test;

import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.datacontainer.DirectionEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionEvaluatorTest {
    DirectionEvaluator directionEvaluator;
    Organism o;

    @BeforeEach
    void setUp() {
        o = new Organism(0,0);
        directionEvaluator = new DirectionEvaluator(o);
    }

    @Test
    void evaluateDirection() {
        directionEvaluator.setRight(2);
        directionEvaluator.evaluateDirection();
        assertEquals(Direction.RIGHT, o.getOrganismStats().getDirection());
    }

    @Test
    void incrementVote() {
        directionEvaluator.incrementVote(Direction.RIGHT);
        assertEquals(1, directionEvaluator.getRight());
    }
}