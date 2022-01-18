package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.cos.SafetyOnLeftHalfCOS;

import java.util.ArrayList;

public class Starter {
    private final int INTIAL_ORGANISM_AMOUNT = 200;
    private final OrganismProcessor organismProcessor;
    private final FieldProcessor fieldProcessor;
    private final InteractionProcessor interactionProcessor;
    private final ReplicationProcessor replicationProcessor;

    public Starter() {
        organismProcessor = new OrganismProcessor();
        fieldProcessor = new FieldProcessor();
        interactionProcessor = new InteractionProcessor(organismProcessor);
        replicationProcessor = new ReplicationProcessor(organismProcessor, new COSProcessor(new SafetyOnLeftHalfCOS()));
        organismProcessor.generateInitialOrganisms(INTIAL_ORGANISM_AMOUNT);
    }

    public void start() {
        //TODO: change condition to something more sensible
        while (true) {
            //TODO: Spread organisms across the field
            fieldProcessor.moveAll(organismProcessor.getOrganisms());
            organismProcessor.setOrganisms(replicationProcessor.calcNextGeneration(
                    interactionProcessor.startInteraction()));
        }
    }
}
