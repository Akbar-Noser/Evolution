package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.datacontainer.DirectionEvaluator;
import ch.noseryoung.genometype.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenomeProcessor {
    public final static int AMOUNT_OF_GENOMES = 10;
    private final Organism organism;
    private final DirectionEvaluator directionEvaluator;

    public GenomeProcessor(Organism organism) {
        this.organism = organism;
        directionEvaluator = new DirectionEvaluator(organism);
    }

    public ArrayList<Genome> generateGenomes() {
        ArrayList<Genome> genomes = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_GENOMES; i++) {
            genomes.add(getRandomGenome());
        }
        return genomes;
    }

    public static Genome getRandomGenome () {
        Genome genomeToReturn = null;
        switch (ThreadLocalRandom.current().nextInt(5)) {
            case 0 -> genomeToReturn = new AggressorGenome();
            case 1 -> genomeToReturn = new CharmGenome();
            case 2 -> genomeToReturn = new DefenseGenome();
            case 3 -> genomeToReturn = new SpeedGenome();
            case 4 -> {
                switch (ThreadLocalRandom.current().nextInt(4)) {
                    case 0 -> genomeToReturn =new DirectionGenome(Direction.DOWN);
                    case 1 -> genomeToReturn =new DirectionGenome(Direction.LEFT);
                    case 2 -> genomeToReturn =new DirectionGenome(Direction.UP);
                    case 3 -> genomeToReturn =new DirectionGenome(Direction.RIGHT);
                }
            }
        }
        return genomeToReturn;
    }

    public void processGenomes() {
        organism.getGenomes().forEach(genome -> genome.genomeEffect(this));
        directionEvaluator.evaluateDirection();
    }

    public Organism getOrganism() {
        return organism;
    }

    public DirectionEvaluator getDirectionEvaluator() {
        return directionEvaluator;
    }
}
