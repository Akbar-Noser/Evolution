package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.DirectionEvaluator;

public class GenomeProcessor {
    private Organism self;
    private DirectionEvaluator directionEvaluator;

    public GenomeProcessor(Organism self) {
        this.self = self;
        directionEvaluator = new DirectionEvaluator(self);
    }

    public void processGenomes() {
        self.getGenomes().forEach(genome -> genome.genomeEffect(self));
    }

    public Organism getSelf() {
        return self;
    }

    public DirectionEvaluator getDirectionEvaluator() {
        return directionEvaluator;
    }
}
