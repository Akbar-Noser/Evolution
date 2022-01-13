package ch.noseryoung.processor;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.datacontainer.DirectionEvaluator;
import ch.noseryoung.genometype.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenomeProcessor {
    private Organism organism;
    private DirectionEvaluator directionEvaluator;

    public GenomeProcessor(Organism organism) {
        this.organism = organism;
        directionEvaluator = new DirectionEvaluator(organism);
    }

    public ArrayList<Genome> generateGenomes() {
        ArrayList<Genome> genomes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (ThreadLocalRandom.current().nextInt(5)) {
                case 0 -> genomes.add(new AggressorGenome());
                case 1 -> genomes.add(new CharmGenome());
                case 2 -> genomes.add(new DefenseGenome());
                case 3 -> genomes.add(new SpeedGenome());
                case 4 -> {
                    switch (ThreadLocalRandom.current().nextInt(4)) {
                        case 0 -> genomes.add(new DirectionGenome(Direction.DOWN));
                        case 1 -> genomes.add(new DirectionGenome(Direction.LEFT));
                        case 2 -> genomes.add(new DirectionGenome(Direction.UP));
                        case 3 -> genomes.add(new DirectionGenome(Direction.RIGHT));
                    }
                }
            }
        }
        return genomes;
    }

    public void processGenomes() {
        organism.getGenomes().forEach(genome -> genome.genomeEffect(this));
    }

    public Organism getOrganism() {
        return organism;
    }

    public DirectionEvaluator getDirectionEvaluator() {
        return directionEvaluator;
    }
}
