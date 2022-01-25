package ch.noseryoung.gui;

import ch.noseryoung.Organism;
import ch.noseryoung.processor.FieldProcessor;
import ch.noseryoung.processor.Starter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class GridPanel extends Box {
    private final Panel gridPanel;

    public GridPanel(ArrayList<Organism> organisms) {
        super(BoxLayout.Y_AXIS);
        gridPanel = new Panel(organisms);
        add(Box.createVerticalGlue());
        add(gridPanel);
        add(Box.createVerticalGlue());
        gridPanel.setVisible(true);
        setVisible(true);
    }

    public GridPanel(Starter starter) {
        super(BoxLayout.X_AXIS);
        gridPanel = new Panel(starter.getOrganismProcessor().getOrganisms());
        add(new InputInterface(starter));
        add(Box.createHorizontalGlue());
        add(gridPanel);
        add(Box.createHorizontalGlue());
        gridPanel.setVisible(true);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public Panel getPanel() {
        return gridPanel;
    }
}