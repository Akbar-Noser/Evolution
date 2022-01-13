package ch.noseryoung.genometype;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

public class CharmGenome implements Genome {
    @Override
    public void genomeEffect(GenomeProcessor processor) {
        OrganismStatsUtils.incrementCharm(processor.getOrganism());
    }
}
