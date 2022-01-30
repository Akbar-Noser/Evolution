package ch.noseryoung.genometype;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

/**
 * increments the defense genome of an organism
 */
public class DefenseGenome implements Genome {
    @Override
    public void genomeEffect(GenomeProcessor processor) {
        OrganismStatsUtils.incrementDefense(processor.getOrganism());
    }
}
