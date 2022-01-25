package ch.noseryoung.processor;

import ch.noseryoung.Organism;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The manager of the replication of the organisms
 */
public class ReplicationProcessor {
    private final OrganismProcessor organismProcessor;
    private final COSProcessor cosProcessor;
    private final int MUTATION_CHANCE;

    public ReplicationProcessor(OrganismProcessor organismProcessor, COSProcessor cosProcessor) {
        this.organismProcessor = organismProcessor;
        this.cosProcessor = cosProcessor;
        MUTATION_CHANCE = 128;
    }

    /**
     * A random genome will be deleted and replaced with a new random genome
     * @param o the organism whose genome should be mutated
     */
    private void mutateRandomGenome(Organism o) {
        o.getGenomes().remove(ThreadLocalRandom.current().nextInt(GenomeProcessor.AMOUNT_OF_GENOMES));
        o.getGenomes().add(GenomeProcessor.getRandomGenome());
    }

    /**
     * Generates the next generation by checking the active COS for every organism.
     * If the organism fulfills the criteria, it will generate two copies and die
     * @param interactionChildren the children resulting from interaction, the COS won't be
     *                            checked for them
     * @return The next generation
     */
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