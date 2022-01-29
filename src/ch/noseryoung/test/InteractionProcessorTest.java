package ch.noseryoung.test;

import ch.noseryoung.Organism;
import ch.noseryoung.processor.FieldProcessor;
import ch.noseryoung.processor.InteractionProcessor;
import ch.noseryoung.processor.OrganismProcessor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InteractionProcessorTest {

    @Test
    void aggressionWinner() {
        OrganismProcessor organismProcessor = new OrganismProcessor();
        InteractionProcessor interactionProcessor = new InteractionProcessor(organismProcessor, new FieldProcessor());
        Organism o1 = new Organism(0,0);
        o1.getOrganismStats().setAggression(5);
        o1.getOrganismStats().setCharm(0);
        Organism o2 = new Organism(1,1);
        o2.getOrganismStats().setDefense(5);
        o2.getOrganismStats().setAggression(0);
        organismProcessor.getOrganisms().add(o1);
        organismProcessor.getOrganisms().add(o2);
        FieldProcessor.field[0][0] = o1;
        FieldProcessor.field[1][1] = o2;
        ArrayList<Organism> result = interactionProcessor.startInteraction();
        assertEquals(1, result.size());
        assertSame(o1, result.get(0));
    }

    @Test
    void defenseWinner() {
        OrganismProcessor organismProcessor = new OrganismProcessor();
        InteractionProcessor interactionProcessor = new InteractionProcessor(organismProcessor, new FieldProcessor());
        Organism o1 = new Organism(0,0);
        o1.getOrganismStats().setAggression(5);
        o1.getOrganismStats().setCharm(0);
        Organism o2 = new Organism(1,1);
        o2.getOrganismStats().setDefense(6);
        o2.getOrganismStats().setAggression(0);
        organismProcessor.getOrganisms().add(o1);
        organismProcessor.getOrganisms().add(o2);
        FieldProcessor.field[0][0] = o1;
        FieldProcessor.field[1][1] = o2;
        ArrayList<Organism> result = interactionProcessor.startInteraction();
        assertEquals(1, result.size());
        assertSame(o2, result.get(0));
    }
}