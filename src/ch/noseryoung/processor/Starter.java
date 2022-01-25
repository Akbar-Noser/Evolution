package ch.noseryoung.processor;

import ch.noseryoung.cos.SafetyOnLeftQuarterCOS;
import ch.noseryoung.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The starter class
 */
public class Starter {
    private final int INTIAL_ORGANISM_AMOUNT = 500;
    private final OrganismProcessor organismProcessor;
    private final FieldProcessor fieldProcessor;
    private final InteractionProcessor interactionProcessor;
    private final ReplicationProcessor replicationProcessor;
    private final MainFrame mainFrame;
    private final Timer animationTimer;
    private int amountOfRepeats;

    public Starter() {
        organismProcessor = new OrganismProcessor();
        fieldProcessor = new FieldProcessor();
        interactionProcessor = new InteractionProcessor(organismProcessor, fieldProcessor);
        replicationProcessor = new ReplicationProcessor(organismProcessor, new COSProcessor(new SafetyOnLeftQuarterCOS()));
        organismProcessor.generateInitialOrganisms(INTIAL_ORGANISM_AMOUNT);
        fieldProcessor.spreadAcrossField(organismProcessor.getOrganisms());
        mainFrame = new MainFrame(this);
        mainFrame.getGridPanel().getPanel().repaint();
        animationTimer = new Timer(200, new ActionListener() {
            private int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldProcessor.moveAll(organismProcessor.getOrganisms());
                mainFrame.getGridPanel().getPanel().setOrganisms(organismProcessor.getOrganisms());
                mainFrame.getGridPanel().getPanel().validate();
                mainFrame.getGridPanel().getPanel().repaint();
                if (++counter >= amountOfRepeats) {
                    ((Timer) e.getSource()).stop();
                    counter = 0;
                    organismProcessor.setOrganisms(
                            replicationProcessor.calcNextGeneration(interactionProcessor.startInteraction()));
                    fieldProcessor.spreadAcrossField(organismProcessor.getOrganisms());
                    mainFrame.getGridPanel().getPanel().setOrganisms(organismProcessor.getOrganisms());
                    mainFrame.getGridPanel().getPanel().validate();
                    mainFrame.getGridPanel().getPanel().repaint();
                }
            }
        }
        );
    }

    /**
     * Completes a cycle of a generation
     * @param amount amount of movement cycles.
     */
    public void completeGenerationCycle(int amount) {
        amountOfRepeats = amount;
        animationTimer.start();
    }

    public int getINTIAL_ORGANISM_AMOUNT() {
        return INTIAL_ORGANISM_AMOUNT;
    }

    public FieldProcessor getFieldProcessor() {
        return fieldProcessor;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public OrganismProcessor getOrganismProcessor() {
        return organismProcessor;
    }
}