package ch.noseryoung.gui;

import ch.noseryoung.Organism;
import ch.noseryoung.processor.FieldProcessor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

class Panel extends JPanel {
    private final int rows, cols;
    private final int scaleFactor = 13;
    private final GridGenerator gridGenerator;

    public Panel() {
        Dimension gridSize = new Dimension((FieldProcessor.X_AXIS_SIZE ) * scaleFactor + 1,
                (FieldProcessor.Y_AXIS_SIZE ) * scaleFactor + 1);
        setMaximumSize(gridSize);
        setMinimumSize(gridSize);
        setPreferredSize(gridSize);
        rows = FieldProcessor.X_AXIS_SIZE;
        cols = FieldProcessor.Y_AXIS_SIZE;
        gridGenerator = new GridGenerator(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        new OrganismPainter(this).paintGeneration(g, new ArrayList<>(Set.of(new Organism(0,0),
                new Organism(5,7), new Organism(33,23), new Organism(49, 49))));
        g.setColor(Color.BLACK);
        gridGenerator.generateGrid(g);
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }
}

public class GridPanel extends Box {
    private final Panel gridPanel;

    public GridPanel() {
        super(BoxLayout.Y_AXIS);
        gridPanel = new Panel();
        add(Box.createVerticalGlue());
        add(gridPanel);
        add(Box.createVerticalGlue());
        gridPanel.setVisible(true);
        setVisible(true);
    }

    public GridPanel(GenerationAdvancer advancer) {
        super(BoxLayout.X_AXIS);
        gridPanel = new Panel();
        add(advancer);
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