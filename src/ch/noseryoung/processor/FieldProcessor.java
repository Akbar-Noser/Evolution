package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Responsible for managing the field and the functionalities
 * directly associated with it
 */
public class FieldProcessor {
    public final static int Y_AXIS_SIZE = 50;
    public final static int X_AXIS_SIZE = 50;
    public final static Organism[][] field = new Organism[Y_AXIS_SIZE][X_AXIS_SIZE];

    /**
     * clears the field
     */
    private void clearField() {
        for (int y = 0; y < Y_AXIS_SIZE; y++) {
            for (int x = 0; x < X_AXIS_SIZE; x++) {
                field[y][x] = null;
            }
        }
    }

    /**
     * Clears the field and randomly spreads the organisms across the field.
     * Will infinite loop if amount of organisms exceed the space on the field.
     * @param organisms Organisms which should be spread acorss the field
     */
    public void spreadAcrossField(ArrayList<Organism> organisms) {
        clearField();
        int listSize = organisms.size();
        for (int i = 0; i < listSize; i++) {
            int x = ThreadLocalRandom.current().nextInt(X_AXIS_SIZE);
            int y = ThreadLocalRandom.current().nextInt(Y_AXIS_SIZE);
            if (field[y][x] != null) {
                --i;
                continue;
            }
            Organism o = organisms.get(i);
            field[y][x] = o;
            o.setCurrentPosition(new Position(x,y));
        }
    }

    /**
     *
     * Moves all the organisms, if a target field is taken, it will look for an empty slot along its path
     * (Example: It moves to the right with the speed of 4, the target field is occupied, it moves back one slot and
     * checks if it is empty until it finds an empty slot or ends at its starting position.)
     * @param organisms list of the organisms which should get moved and displayed on the field
     */
    public void moveAll(ArrayList<Organism> organisms) {
        Position targetedPosition;
        for (Organism o :
                organisms) {
            field[o.getCurrentPosition().getY()][o.getCurrentPosition().getX()] = null;
            targetedPosition = o.move();
            if (field[targetedPosition.getY()][targetedPosition.getX()] != null) {
                targetedPosition = adjustPosition(o.getCurrentPosition(), targetedPosition);
            }
            o.setCurrentPosition(targetedPosition);
            field[targetedPosition.getY()][targetedPosition.getX()] = o;
        }
    }

    /**
     * Determines in which direction the Organism is going and moves back until it finds an empty field
     * If no empty field is found, it won't move.
     * @param oldPosition The position the organism is currently on
     * @param targetedPosition The position which the organism is aiming to move to
     * @return A position which is empty
     */
    private Position adjustPosition(Position oldPosition, Position targetedPosition) {
        int x = targetedPosition.getX() - oldPosition.getX();
        if (x != 0) {
            // stepper is 1 if target direction is left and -1 if it's right
            int stepper = x < 0 ? 1 : -1;
            for (int i = x + stepper; i != 0 ; i += stepper) {
                if (field[targetedPosition.getY()][oldPosition.getX() + i] == null)
                    return new Position(oldPosition.getX() + i, targetedPosition.getY());
            }
        }
        int y = targetedPosition.getY() - oldPosition.getY();
        if (y != 0) {
            // stepper is 1 if target direction is left and -1 if it's right
            int stepper = y < 0 ? 1 : -1;
            for (int i = y + stepper; i != 0 ; i += stepper) {
                if (field[oldPosition.getY() + i][targetedPosition.getX()] == null)
                    return new Position(targetedPosition.getX(), oldPosition.getY() + i);
            }
        }
        return oldPosition;
    }

    /**
     * checks if the axis position is in bounds
     * @param targetPosition the axis position
     * @param axisSize the size of the axis
     * @return boolean value if the position on the axis is in bounds
     */
    public static boolean isNotInBounds(int targetPosition, int axisSize) {
        return targetPosition >= axisSize || targetPosition < 0;
    }

    /**
     * adjusts the axis position to be in bounds
     * @param targetPosition the axis position
     * @param axisSize the size of the axis
     * @return the edge axis position which is in bounds
     */
    public static int adjustToBounds(int targetPosition, int axisSize) {
        return isNotInBounds(targetPosition,axisSize) ?
                targetPosition < 0 ? 0 : axisSize - 1 : targetPosition;
    }

}