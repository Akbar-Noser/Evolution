package ch.noseryoung.gui;

import ch.noseryoung.Organism;
import ch.noseryoung.processor.FieldProcessor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel which contains and displays the field and its organisms
 */
public class Panel extends JPanel {
    private final int rows, cols;
    private final int scaleFactor = 13;
    private final GridGenerator gridGenerator;
    private ArrayList<Organism> organisms;
    private final OrganismPainter painter;

    public Panel(ArrayList<Organism> organisms) {
        this.organisms = organisms;
        Dimension gridSize = new Dimension((FieldProcessor.X_AXIS_SIZE ) * scaleFactor + 1,
                (FieldProcessor.Y_AXIS_SIZE ) * scaleFactor + 1);
        setMaximumSize(gridSize);
        setMinimumSize(gridSize);
        setPreferredSize(gridSize);
        rows = FieldProcessor.X_AXIS_SIZE;
        cols = FieldProcessor.Y_AXIS_SIZE;
        gridGenerator = new GridGenerator(this);
        painter = new OrganismPainter(this);
    }

    /**
     * overridden method which paints the grid and the organisms within
     * @param g Graphics context which is used for drawing the GUI
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        painter.paintGeneration(g, organisms);
        g.setColor(Color.BLACK);
        gridGenerator.generateGrid(g);
    }

    public void setOrganisms(ArrayList<Organism> organisms) {
        this.organisms = organisms;
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
