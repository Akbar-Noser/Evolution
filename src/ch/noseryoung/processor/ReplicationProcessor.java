package ch.noseryoung.processor;

import ch.noseryoung.Organism;

import java.util.ArrayList;

public class ReplicationProcessor {
    private final OrganismProcessor organismProcessor;
    private final COSProcessor cosProcessor;

    public ReplicationProcessor(OrganismProcessor organismProcessor, COSProcessor cosProcessor) {
        this.organismProcessor = organismProcessor;
        this.cosProcessor = cosProcessor;
    }

    public ArrayList<Organism> calcNextGeneration(ArrayList<Organism> interactionChildren) {
        ArrayList<Organism> oldGeneration = organismProcessor.getOrganisms();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        oldGeneration.forEach(organism -> {
            if(cosProcessor.evaluateCOS(organism))
                nextGeneration.add(organism);
        });
        nextGeneration.addAll(interactionChildren);
        return nextGeneration;
    }

}