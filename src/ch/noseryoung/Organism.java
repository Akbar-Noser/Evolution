package ch.noseryoung;

import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.processor.FieldProcessor;
import ch.noseryoung.processor.GenomeProcessor;
import ch.noseryoung.utils.OrganismStatsUtils;

import java.awt.*;
import java.util.ArrayList;

public class Organism {
    private ArrayList<Genome> genomes;
    private OrganismStats organismStats;
    private Position currentPosition;
    private Color color;

    public Organism(int x, int y) {
        organismStats = new OrganismStats();
        GenomeProcessor processor = new GenomeProcessor(this);
        genomes = processor.generateGenomes();
        processor.processGenomes();
        color = new Color(organismStats.getAggression() * 25 + organismStats.getCharm() * 25,
                organismStats.getSpeed() * 23 + organismStats.getCharm() * 23,
                organismStats.getDefense() * 25 + organismStats.getCharm() * 25);
        currentPosition = new Position(x, y);
    }

    public Organism(Organism o) {
        organismStats = o.getOrganismStats();
        genomes = (ArrayList<Genome>) o.getGenomes().clone();
        currentPosition = new Position(o.getCurrentPosition());
        color = o.getColor();
    }

    public Organism(int x, int y, ArrayList<Genome> genomes) {
        organismStats = new OrganismStats();
        this.genomes = genomes;
        GenomeProcessor processor = new GenomeProcessor(this);
        processor.processGenomes();
        color = new Color(organismStats.getAggression() * 25 + organismStats.getCharm() * 25,
                organismStats.getSpeed() * 23 + organismStats.getCharm() * 23,
                organismStats.getDefense() * 25 + organismStats.getCharm() * 25);
        currentPosition = new Position(x, y);
    }

    public Position move() {
        Direction direction = organismStats.getDirection() != null ? organismStats.getDirection() :
                OrganismStatsUtils.getRandomDirection();
        return new Position(FieldProcessor.adjustToBounds(calcMovement(currentPosition.getX(),
                direction.getXDirectionFactor()), FieldProcessor.X_AXIS_SIZE),
                FieldProcessor.adjustToBounds(calcMovement(currentPosition.getY(),
                        direction.getYDirectionFactor()), FieldProcessor.Y_AXIS_SIZE));

    }


    private int calcMovement(int currentPosition, int directionFactor) {
        return currentPosition + directionFactor * organismStats.getSpeed();
    }

    public Color getColor() {
        return color;
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