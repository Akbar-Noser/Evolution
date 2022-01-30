package ch.noseryoung.test;

import ch.noseryoung.Organism;
import ch.noseryoung.cos.SafetyOnLeftQuarterCOS;
import ch.noseryoung.processor.FieldProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafetyOnLeftQuarterCOSTest {

    @Test
    void passedConditionForSurvival() {
        Organism o = new Organism(FieldProcessor.X_AXIS_SIZE / 4, FieldProcessor.Y_AXIS_SIZE - 1);
        Assertions.assertTrue(new SafetyOnLeftQuarterCOS().conditionForSurvival(o));
    }

    @Test
    void failedConditionForSurvival() {
        Organism o = new Organism(FieldProcessor.X_AXIS_SIZE / 4 + 1, 0);
        assertFalse(new SafetyOnLeftQuarterCOS().conditionForSurvival(o));
    }
}