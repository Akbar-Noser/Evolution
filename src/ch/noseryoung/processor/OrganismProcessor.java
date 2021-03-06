package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;

import java.util.ArrayList;

/**
 * The manager of generating and managing the organisms
 */
public class OrganismProcessor {
    public final static Position DEFAULT_POSITION = new Position(0,0);
    private ArrayList<Organism> organisms;

    public OrganismProcessor() {
        this.organisms = new ArrayList<>();
    }

    /**
     * generates the initial generation of organisms
     * @param amount the amount of organisms which should be generated
     */
    public void generateInitialOrganisms(int amount) {
        for (int i = 0; i < amount; i++) {
            organisms.add(new Organism(DEFAULT_POSITION.getX(), DEFAULT_POSITION.getY()));
        }
    }

    public void setOrganisms(ArrayList<Organism> organisms) {
        this.organisms = organisms;
    }

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }
}
