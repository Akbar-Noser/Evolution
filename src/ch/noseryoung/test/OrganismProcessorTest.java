package ch.noseryoung.test;

import ch.noseryoung.processor.OrganismProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganismProcessorTest {

    @Test
    void generateInitialOrganisms() {
        int amount = 500;
        OrganismProcessor organismProcessor = new OrganismProcessor();
        organismProcessor.generateInitialOrganisms(500);
        assertEquals(amount, organismProcessor.getOrganisms().size());
    }
}