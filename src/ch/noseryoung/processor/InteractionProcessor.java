package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.OrganismStats;

import java.util.ArrayList;

public class InteractionProcessor {

    private OrganismProcessor organismProcessor;

    public InteractionProcessor(OrganismProcessor organismProcessor) {
        this.organismProcessor = organismProcessor;
    }

    public ArrayList<Organism> startInteraction() {
        ArrayList<Organism> organisms = organismProcessor.getOrganisms();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        for (Organism organism : organisms) {
            nextGeneration.addAll(interact(organism));
        }
        return nextGeneration;
    }

    private ArrayList<Organism> interact(Organism organism) {
        OrganismStats stats = organism.getOrganismStats();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        Organism neighbour = null;
        if (stats.getAggression() > 0) {
            if ((neighbour = getFirstNeighbour()) != null) {
                nextGeneration.add(aggressionInteraction(organism, neighbour));
            }
        }
        if (stats.getCharm() > 0) {
            if (neighbour != null || (neighbour = getFirstNeighbour()) != null) {
                nextGeneration.add(charmInteraction(organism, neighbour));
            }
        }
        return nextGeneration;
    }

    private Organism aggressionInteraction(Organism aggressor, Organism defender) {
        if (defender.getOrganismStats().getDefense() > aggressor.getOrganismStats().getAggression()) {
            organismProcessor.getOrganisms().remove(aggressor);
            return defender;
        }
        organismProcessor.getOrganisms().remove(defender);
        return aggressor;
    }

    private Organism charmInteraction(Organism parent1, Organism parent2) {
        ArrayList<Genome> childGenomes = new ArrayList<>();

        for (int i = 0; i < GenomeProcessor.AMOUNT_OF_GENOMES / 2; i++) {
            childGenomes.add(parent1.getGenomes().get(i));
            childGenomes.add(parent2.getGenomes().get(i));
        }
        return new Organism(OrganismProcessor.DEFAULT_POSITION.getX(), OrganismProcessor.DEFAULT_POSITION.getY(),
                childGenomes);
    }

    private Organism getFirstNeighbour() {
        //TODO
        return null;
    }

}
