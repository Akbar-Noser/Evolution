package ch.noseryoung.processor;

import ch.noseryoung.Organism;

import java.util.ArrayList;

public class OrganismProcessor {
    private ArrayList<Organism> organisms;

    public OrganismProcessor() {
        this.organisms = new ArrayList<>();
    }

    public void generateInitialOrganisms(int amount) {
        for (int i = 0; i < amount; i++) {
            organisms.add(new Organism(0,0));
        }
    }

 

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }
}
