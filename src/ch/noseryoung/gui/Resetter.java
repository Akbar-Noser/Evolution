package ch.noseryoung.gui;

import ch.noseryoung.processor.Starter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Resetter extends JPanel {
    private Button resetButton;
    private Starter starter;

    public Resetter(Starter starter) {
        this.starter = starter;
        resetButton = new Button("Reset");
        add(resetButton);
        add(Box.createRigidArea(new Dimension(100, 20)));
        resetButton.addActionListener(e -> {
            starter.getOrganismProcessor().setOrganisms(new ArrayList<>());
            starter.getOrganismProcessor().generateInitialOrganisms(starter.getINTIAL_ORGANISM_AMOUNT());
            starter.getFieldProcessor().spreadAcrossField(starter.getOrganismProcessor().getOrganisms());
            starter.getMainFrame().getGridPanel().getPanel().setOrganisms(starter.getOrganismProcessor().getOrganisms());
            starter.getMainFrame().getGridPanel().getPanel().revalidate();
            starter.getMainFrame().getGridPanel().getPanel().repaint();
        });
        setVisible(true);
    }
}
