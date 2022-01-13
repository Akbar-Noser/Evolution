package ch.noseryoung.genometype;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.processor.GenomeProcessor;

public class DirectionGenome implements Genome {
    private Direction direction;

    public DirectionGenome(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void genomeEffect(GenomeProcessor processor) {
        processor.getDirectionEvaluator().incrementVote(direction);
    }
}
