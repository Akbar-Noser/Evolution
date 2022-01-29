package ch.noseryoung.test;

import ch.noseryoung.Genome;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.genometype.AggressorGenome;
import ch.noseryoung.genometype.SpeedGenome;
import ch.noseryoung.processor.GenomeProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenomeProcessorTest {
    Organism o;
    GenomeProcessor genomeProcessor;

    @BeforeEach
    void setUp() {
        o = new Organism(0,0);
        genomeProcessor = new GenomeProcessor(o);

    }

    @Test
    void generateGenomes() {
        genomeProcessor.generateGenomes();
        assertEquals(GenomeProcessor.AMOUNT_OF_GENOMES, o.getGenomes().size());
    }

    @Test
    void processGenomes() {
        ArrayList<Genome> genomes = new ArrayList<Genome>(Set.of(new AggressorGenome()));
        o.setGenomes(genomes);
        o.setOrganismStats(new OrganismStats());
        genomeProcessor.processGenomes();
        assertEquals(1, o.getOrganismStats().getAggression());
    }
}