package ch.noseryoung;

import ch.noseryoung.processor.GenomeProcessor;

/**
 * An interface which is used to define different kinds of genomes
 */
public interface Genome {
    void genomeEffect(GenomeProcessor processor);
}
