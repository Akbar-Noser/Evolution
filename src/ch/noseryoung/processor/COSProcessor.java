package ch.noseryoung.processor;

import ch.noseryoung.COS;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;

/**
 * Processor to configure the condition of survival
 */
public class COSProcessor {
    private COS cos;

    public COSProcessor(COS cos) {
        this.cos = cos;
    }

    public boolean evaluateCOS(Organism organism) {
        return cos.conditionForSurvival(organism);
    }

    public void setCos(COS cos) {
        this.cos = cos;
    }
}
