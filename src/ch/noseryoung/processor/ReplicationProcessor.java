package ch.noseryoung.processor;

import ch.noseryoung.Organism;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ReplicationProcessor {
    private final OrganismProcessor organismProcessor;
    private final COSProcessor cosProcessor;
    private final int MUTATION_CHANCE;

    public ReplicationProcessor(OrganismProcessor organismProcessor, COSProcessor cosProcessor) {
        this.organismProcessor = organismProcessor;
        this.cosProcessor = cosProcessor;
        MUTATION_CHANCE = 128;
    }

    private void mutateRandomGenome(Organism o) {
        o.getGenomes().remove(ThreadLocalRandom.current().nextInt(GenomeProcessor.AMOUNT_OF_GENOMES));
        o.getGenomes().add(GenomeProcessor.getRandomGenome());
    }

    public ArrayList<Organism> calcNextGeneration(ArrayList<Organism> interactionChildren) {
        ArrayList<Organism> oldGeneration = organismProcessor.getOrganisms();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        oldGeneration.forEach(organism -> {
            if(cosProcessor.evaluateCOS(organism)) {
                if (MUTATION_CHANCE == ThreadLocalRandom.current().nextInt(MUTATION_CHANCE + 1))
                    mutateRandomGenome(organism);
                nextGeneration.add(organism);
                nextGeneration.add(new Organism(organism));
            }
        });
        nextGeneration.addAll(interactionChildren);
        return nextGeneration;
    }


}