package ch.noseryoung.test;

import ch.noseryoung.processor.FieldProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldProcessorTest {

    @Test
    void isNotInBounds() {
        Assertions.assertTrue(FieldProcessor.isNotInBounds(FieldProcessor.X_AXIS_SIZE, FieldProcessor.X_AXIS_SIZE));
        assertTrue(FieldProcessor.isNotInBounds(FieldProcessor.Y_AXIS_SIZE, FieldProcessor.Y_AXIS_SIZE));
        assertTrue(FieldProcessor.isNotInBounds(-1, FieldProcessor.X_AXIS_SIZE));
        assertTrue(FieldProcessor.isNotInBounds(-1, FieldProcessor.Y_AXIS_SIZE));
    }

    @Test
    void adjustToBounds() {
        assertEquals(FieldProcessor.X_AXIS_SIZE - 1, FieldProcessor.adjustToBounds(FieldProcessor.X_AXIS_SIZE,
                FieldProcessor.X_AXIS_SIZE));
        assertEquals(FieldProcessor.Y_AXIS_SIZE - 1, FieldProcessor.adjustToBounds(FieldProcessor.Y_AXIS_SIZE,
                FieldProcessor.Y_AXIS_SIZE));
    }
}