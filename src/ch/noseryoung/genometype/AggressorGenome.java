package ch.noseryoung.genometype;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

/**
 * increments the aggression value of an organism
 */
public class AggressorGenome implements Genome {
    @Override
    public void genomeEffect(GenomeProcessor processor) {
        OrganismStatsUtils.incrementAggression(processor.getOrganism());
    }
}
