package ch.noseryoung.gui;

import ch.noseryoung.processor.FieldProcessor;

import java.awt.*;

public class GridGenerator {
    private final Panel gridPanel;

    public GridGenerator(Panel gridPanel) {
        this.gridPanel = gridPanel;
    }

    private void generateRows(Graphics g) {
        for (int i = 0; i <= gridPanel.getRows(); i++) {
            g.drawLine(0, i * gridPanel.getScaleFactor() ,
                    (FieldProcessor.X_AXIS_SIZE) * gridPanel.getScaleFactor(),i * gridPanel.getScaleFactor());
        }
    }

    private void generateCols(Graphics g) {
        for (int i = 0; i <= gridPanel.getCols(); i++) {
            g.drawLine(i * gridPanel.getScaleFactor() , 0,
                    i * gridPanel.getScaleFactor(), (FieldProcessor.Y_AXIS_SIZE) * gridPanel.getScaleFactor());
        }
    }

    public void generateGrid(Graphics g) {
        generateCols(g);
        generateRows(g);
    }
}