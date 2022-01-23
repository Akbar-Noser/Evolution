package ch.noseryoung;

import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.processor.FieldProcessor;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

import java.util.ArrayList;

public class Organism {
    private ArrayList<Genome> genomes;
    private OrganismStats organismStats;
    private Position currentPosition;

    public Organism(int x, int y) {
        organismStats = new OrganismStats();
        GenomeProcessor processor = new GenomeProcessor(this);
        genomes = processor.generateGenomes();
        currentPosition = new Position(x,y);
    }

    public Organism(int x, int y, ArrayList<Genome> genomes) {
        organismStats = new OrganismStats();
        this.genomes = genomes;
        currentPosition = new Position(x,y);
    }

    public Position move() {
        Direction direction = organismStats.getDirection() != null ? organismStats.getDirection() :
                OrganismStatsUtils.getRandomDirection();
        currentPosition = new Position(adjustToBounds(calcMovement(currentPosition.getX(),
                        direction.getXDirectionFactor()), FieldProcessor.X_AXIS_SIZE),
                adjustToBounds(calcMovement(currentPosition.getY(),
                        direction.getYDirectionFactor()), FieldProcessor.Y_AXIS_SIZE));
        return currentPosition;
    }

    private int adjustToBounds(int targetPosition, int axisSize) {
        return targetPosition >= axisSize || targetPosition < 0 ?
                targetPosition < 0 ? 0 : axisSize - 1 : targetPosition;
    }

    private int calcMovement(int currentPosition, int directionFactor) {
        return currentPosition + directionFactor * organismStats.getSpeed();
    }

    public ArrayList<Genome> getGenomes() {
        return genomes;
    }

    public void setGenomes(ArrayList<Genome> genomes) {
        this.genomes = genomes;
    }

    public OrganismStats getOrganismStats() {
        return organismStats;
    }

    public void setOrganismStats(OrganismStats organismStats) {
        this.organismStats = organismStats;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}