package ch.noseryoung.genometype;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

/**
 * increments the value for the speed stat of an organism
 */
public class SpeedGenome implements Genome {
    @Override
    public void genomeEffect(GenomeProcessor processor) {
        OrganismStatsUtils.incrementSpeed(processor.getOrganism());
    }
}
