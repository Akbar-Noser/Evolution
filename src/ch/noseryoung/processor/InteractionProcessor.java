package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.OrganismStats;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Manages the interactions between the organisms and its offspring
 */
public class InteractionProcessor {
    private FieldProcessor fieldProcessor;
    private OrganismProcessor organismProcessor;
    private ArrayList<Organism> organismsToRemove;

    public InteractionProcessor(OrganismProcessor organismProcessor, FieldProcessor fieldProcessor) {
        this.organismProcessor = organismProcessor;
        this.fieldProcessor = fieldProcessor;
        organismsToRemove = new ArrayList<>();
    }

    /**
     * starts the interaction between all the organisms
     * @return the children created by the interaction
     */
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

    /**
     * The interaction initiated by a single organism. Aggression interaction will start
     * if the aggression stat is bigger than 0 and the aggression stat is bigger than the
     * charm stat. The charm interaction will start if the charm stat is bigger than 3 and
     * the charm stat is bigger than the aggression stat. They will always interact with
     * the first neighbour they find.
     * @param organism the interaction initiator
     * @return The children resulting from the interaction
     */
    private ArrayList<Organism> interact(Organism organism) {
        OrganismStats stats = organism.getOrganismStats();
        Organism neighbour;
        ArrayList<Organism> nextGeneration = new ArrayList<>();
        if (stats.getAggression() > 3 && stats.getAggression() > stats.getCharm()) {
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

    /**
     * The interaction resulting from aggression genomes. The defender will win if he has
     * a higher defense stat, than the aggressor's aggression stat, otherwise the aggressor will win.
     * @param aggressor the initiator of the aggression interaction
     * @param defender the victim of the aggression interaction
     * @return Two copies of the winner
     */
    private Organism aggressionInteraction(Organism aggressor, Organism defender) {
        organismsToRemove.add(aggressor);
        organismsToRemove.add(defender);
        if (defender.getOrganismStats().getDefense() > aggressor.getOrganismStats().getAggression())
            return defender;
        return aggressor;
    }

    /**
     * The interaction resulting from charm genomes. The resulting child will
     * have half of one and half of the other parent's genome.
     * @param charmInitializer the initiator of the charm interaction
     * @param charmTarget the receiver of the charm interaction
     * @return the child with half of one and half of the other parent's genome
     */
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

    /**
     * Goes around the organism, starting in the top left corner and checks for neighbours
     * it returns the first neighbour it finds and which hasn't been marked for deletion;
     * @param organism organism for which the first neighbour is to be found
     * @return the first found neighbour
     */
    private Organism getFirstNeighbour(Organism organism) {
        int positionY = organism.getCurrentPosition().getY();
        int positionX = organism.getCurrentPosition().getX();
        Organism neighbour;
        for (int y = positionY - 1; y <=  positionY + 1; y++) {
            for (int x = positionX - 1; x <= positionX + 1; x++) {
                if ((neighbour = FieldProcessor.field[FieldProcessor.adjustToBounds(y, FieldProcessor.Y_AXIS_SIZE)]
                        [FieldProcessor.adjustToBounds(x, FieldProcessor.X_AXIS_SIZE)]) != null &&
                        !organismsToRemove.contains(neighbour) &&
                        !(neighbour.getCurrentPosition().getX() == positionX && neighbour.getCurrentPosition().getY() == positionY))
                    return neighbour;
            }
        }
        return null;
    }

}
