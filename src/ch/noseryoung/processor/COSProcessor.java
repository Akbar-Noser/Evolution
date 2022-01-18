package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;

/**
 * Processor to configure the condition of survival
 */
public class COSProcessor {
    private static int activeCOS;

    public static boolean evaluateCOS(Organism organism) {
        boolean condition = false;
        switch (activeCOS) {
            case 1 -> condition = safetyOnLeftHalf(organism);
            case 2 -> {/*TODO: safety by eating food*/}
        }
        return condition;
    }

    private static boolean safetyOnLeftHalf (Organism organism) {

    }

    public void setActiveCOS(int activeCOS) {
        this.activeCOS = activeCOS;
    }
}
