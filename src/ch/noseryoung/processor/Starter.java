package ch.noseryoung.processor;

import ch.noseryoung.Organism;
import ch.noseryoung.cos.SafetyOnLeftHalfCOS;
import ch.noseryoung.gui.MainFrame;

import java.util.ArrayList;

public class Starter {
    private final int INTIAL_ORGANISM_AMOUNT = 500;
    private final OrganismProcessor organismProcessor;
    private final FieldProcessor fieldProcessor;
    private final InteractionProcessor interactionProcessor;
    private final ReplicationProcessor replicationProcessor;
    private final MainFrame mainFrame;

    public Starter() {
        organismProcessor = new OrganismProcessor();
        fieldProcessor = new FieldProcessor();
        interactionProcessor = new InteractionProcessor(organismProcessor);
        replicationProcessor = new ReplicationProcessor(organismProcessor, new COSProcessor(new SafetyOnLeftHalfCOS()));
        organismProcessor.generateInitialOrganisms(INTIAL_ORGANISM_AMOUNT);
        mainFrame = new MainFrame(this);
    }

    public void completeGenerationCycle(int amount) {
        for (int i = 0; i < amount; i++) {
            fieldProcessor.spreadAcrossField(organismProcessor.getOrganisms());
            fieldProcessor.moveAll(organismProcessor.getOrganisms());
            organismProcessor.setOrganisms(replicationProcessor.calcNextGeneration(
                    interactionProcessor.startInteraction()));
        }
        mainFrame.getGridPanel().getPanel().setOrganisms(organismProcessor.getOrganisms());
        mainFrame.getGridPanel().getPanel().validate();
        mainFrame.getGridPanel().getPanel().repaint();
    }

    public OrganismProcessor getOrganismProcessor() {
        return organismProcessor;
    }
}
