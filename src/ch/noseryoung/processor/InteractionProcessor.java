package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.OrganismStats;

import java.util.ArrayList;
import java.util.Collection;

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
        Organism neighbour;
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        if (stats.getAggression() > 0) {
            if ((neighbour = getFirstNeighbour()) != null) {
                Organism winner = aggressionInteraction(organism, neighbour);
                nextGeneration.add(winner);
                if (winner.equals(neighbour))
                    return nextGeneration;
            }
        }
        if (stats.getCharm() > 0) {
            if ((neighbour = getFirstNeighbour()) != null) {
                nextGeneration.add(charmInteraction(organism, neighbour));
            }
        }
        return nextGeneration;
    }

    private Organism aggressionInteraction(Organism aggressor, Organism defender) {
        organismProcessor.getOrganisms().remove(aggressor);
        organismProcessor.getOrganisms().remove(defender);
        if (defender.getOrganismStats().getDefense() > aggressor.getOrganismStats().getAggression())
            return defender;
        return aggressor;
    }

    private Organism charmInteraction(Organism charmInitializer, Organism charmTarget) {
        ArrayList<Genome> childGenomes = new ArrayList<>();

        for (int i = 0; i < GenomeProcessor.AMOUNT_OF_GENOMES / 2; i++) {
            childGenomes.add(charmInitializer.getGenomes().get(i));
            childGenomes.add(charmTarget.getGenomes().get(i));
        }
        return new Organism(OrganismProcessor.DEFAULT_POSITION.getX(), OrganismProcessor.DEFAULT_POSITION.getY(),
                childGenomes);
    }

    private Organism getFirstNeighbour() {
        //TODO
        return null;
    }

}
