package ch.noseryoung.processor;

import ch.noseryoung.Organism;

import java.util.ArrayList;

public class ReplicationProcessor {
    private OrganismProcessor organismProcessor;

    public ReplicationProcessor(OrganismProcessor organismProcessor) {
        this.organismProcessor = organismProcessor;
    }

    public ArrayList<Organism> calcNextGeneration(ArrayList<Organism> interactionChildren) {
        ArrayList<Organism> oldGeneration = organismProcessor.getOrganisms();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        oldGeneration.forEach(organism -> {

            if(true) {
                nextGeneration.add(organism);
            }
        });
        nextGeneration.addAll(interactionChildren);
        return nextGeneration;
    }

}