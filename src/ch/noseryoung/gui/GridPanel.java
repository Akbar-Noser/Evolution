package ch.noseryoung.gui;

import ch.noseryoung.processor.FieldProcessor;

import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {
    private final int rows, cols;
    private final int scaleFactor = 13;
    private final GridGenerator gridGenerator;

    public Panel() {
        Dimension gridSize = new Dimension((FieldProcessor.X_AXIS_SIZE - 1) * scaleFactor + 1,
                (FieldProcessor.Y_AXIS_SIZE - 1) * scaleFactor + 1);
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}