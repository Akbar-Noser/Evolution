package ch.noseryoung;

import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.datacontainer.OrganismStats;
import ch.noseryoung.customenum.Direction;
import ch.noseryoung.utils.OrganismStatsUtils;

import java.util.ArrayList;

public class Organism {
    private ArrayList<Genome> genomes;
    private OrganismStats organismStats;


    public Position move(Position currentPosition) {
        Direction direction = organismStats.getDirection() != null ? organismStats.getDirection() :
                OrganismStatsUtils.getRandomDirection();
        return new Position(calcMovement(currentPosition.getX(), direction.getXDirectionFactor()),
                calcMovement(currentPosition.getY(), direction.getYDirectionFactor()));
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
}