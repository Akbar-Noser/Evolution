package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.OrganismStats;

import java.util.ArrayList;
import java.util.Collection;

public class InteractionProcessor {
    private FieldProcessor fieldProcessor;
    private OrganismProcessor organismProcessor;
    private ArrayList<Organism> organismsToRemove;

    public InteractionProcessor(OrganismProcessor organismProcessor, FieldProcessor fieldProcessor) {
        this.organismProcessor = organismProcessor;
        this.fieldProcessor = fieldProcessor;
        organismsToRemove = new ArrayList<>();
    }

    public ArrayList<Organism> startInteraction() {
        organismsToRemove.clear();
        ArrayList<Organism> organisms = organismProcessor.getOrganisms();
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        for (Organism organism : organisms)
            nextGeneration.addAll(interact(organism));
        for (Organism organism : organismsToRemove)
            organismProcessor.getOrganisms().remove(organism);
        return nextGeneration;
    }

    private ArrayList<Organism> interact(Organism organism) {
        OrganismStats stats = organism.getOrganismStats();
        Organism neighbour;
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        if (stats.getAggression() > 0 && stats.getAggression() > stats.getCharm()) {
            if ((neighbour = getFirstNeighbour(organism)) != null) {
                Organism winner = aggressionInteraction(organism, neighbour);
                nextGeneration.add(winner);
                if (winner.equals(neighbour))
                    return nextGeneration;
            }
            if ((neighbour = getFirstNeighbour(organism)) != null) {
                Organism winner = aggressionInteraction(organism, neighbour);
                nextGeneration.add(winner.equals(organism) ? new Organism(winner) : winner);
                if (winner.equals(neighbour))
                    return nextGeneration;
            }
        }
        if (stats.getCharm() > 3 && stats.getCharm() > stats.getAggression()) {
            if ((neighbour = getFirstNeighbour(organism)) != null) {
                nextGeneration.add(charmInteraction(organism, neighbour));
            }
        }
        return nextGeneration;
    }

    private Organism aggressionInteraction(Organism aggressor, Organism defender) {
        organismsToRemove.add(aggressor);
        organismsToRemove.add(defender);
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
        organismsToRemove.add(charmInitializer);
        return new Organism(OrganismProcessor.DEFAULT_POSITION.getX(), OrganismProcessor.DEFAULT_POSITION.getY(),
                childGenomes);
    }

    private Organism getFirstNeighbour(Organism organism) {
        int positionY = organism.getCurrentPosition().getY();
        int positionX = organism.getCurrentPosition().getX();
        Organism neighbour;
        for (int y = positionY - 1; y <  positionY + 1; y++) {
            for (int x = positionX - 1; x < positionX + 1; x++) {
                if ((neighbour = FieldProcessor.field[FieldProcessor.adjustToBounds(y, FieldProcessor.Y_AXIS_SIZE)]
                        [FieldProcessor.adjustToBounds(x, FieldProcessor.X_AXIS_SIZE)]) != null &&
                        !organismsToRemove.contains(neighbour) &&
                        !(x == positionX && y == positionY))
                    return neighbour;
            }
        }
        return null;
    }

}
