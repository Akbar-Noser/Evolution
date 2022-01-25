package ch.noseryoung.gui;

import ch.noseryoung.processor.FieldProcessor;

import java.awt.*;

/**
 * Contains all the functions to draw the grid
 */
public class GridGenerator {
    private final Panel gridPanel;

    public GridGenerator(Panel gridPanel) {
        this.gridPanel = gridPanel;
    }

    /**
     * Draws all the rows in the grid
     * @param g Graphics context used to draw in the GUI
     */
    private void generateRows(Graphics g) {
        for (int i = 0; i <= gridPanel.getRows(); i++) {
            g.drawLine(0, i * gridPanel.getScaleFactor() ,
                    (FieldProcessor.X_AXIS_SIZE) * gridPanel.getScaleFactor(),i * gridPanel.getScaleFactor());
        }
    }

    /**
     * Draws all the columns in the grid
     * @param g Graphics context used to draw in the GUI
     */
    private void generateCols(Graphics g) {
        for (int i = 0; i <= gridPanel.getCols(); i++) {
            g.drawLine(i * gridPanel.getScaleFactor() , 0,
                    i * gridPanel.getScaleFactor(), (FieldProcessor.Y_AXIS_SIZE) * gridPanel.getScaleFactor());
        }
    }

    /**
     * Generates the columns and rows in the GUI
     * @param g Graphics context used to draw in the GUI
     */
    public void generateGrid(Graphics g) {
        generateCols(g);
        generateRows(g);
    }
}