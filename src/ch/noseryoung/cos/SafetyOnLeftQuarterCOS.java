package ch.noseryoung.cos;

import ch.noseryoung.COS;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.processor.FieldProcessor;

/**
 * Condition which states that every organism in the left quarter of the field survives and replicates
 */
public class SafetyOnLeftQuarterCOS implements COS {
    private static final int SAVE_COORDINATE_RIGHT = FieldProcessor.X_AXIS_SIZE / 4;
    private static final int SAVE_COORDINATE_LEFT = 0;
    private static final int SAVE_COORDINATE_UP = 0;
    private static final int SAVE_COORDINATE_DOWN = FieldProcessor.Y_AXIS_SIZE - 1;

    /**
     * Implementation of COS interface, used to check the COS in an organism
     *
     * @param organism on which the COS should be checked
     * @return boolean value if the organism fulfills the criteria to survive
     */
    @Override
    public boolean conditionForSurvival(Organism organism) {
        Position currentPosition = organism.getCurrentPosition();
        return currentPosition.getX() >= SAVE_COORDINATE_LEFT && currentPosition.getX() <= SAVE_COORDINATE_RIGHT
                && currentPosition.getY() >= SAVE_COORDINATE_UP && currentPosition.getY() <= SAVE_COORDINATE_DOWN;
    }
}
