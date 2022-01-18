package ch.noseryoung.cos;

import ch.noseryoung.COS;
import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.processor.FieldProcessor;

public class SafetyOnLeftHalfCOS implements COS {
    private static final int SAVE_COORDINATE_RIGHT = FieldProcessor.X_AXIS_SIZE / 2;
    private static final int SAVE_COORDINATE_LEFT = 0;
    private static final int SAVE_COORDINATE_UP = 0;
    private static final int SAVE_COORDINATE_DOWN = FieldProcessor.Y_AXIS_SIZE - 1;
    
    @Override
    public boolean conditionForSurvival(Organism organism) {
        Position currentPosition = organism.getCurrentPosition();
        return currentPosition.getX() >= SAVE_COORDINATE_LEFT && currentPosition.getX() <= SAVE_COORDINATE_RIGHT
                && currentPosition.getY() >= SAVE_COORDINATE_UP && currentPosition.getY() <= SAVE_COORDINATE_DOWN;
    }
}
