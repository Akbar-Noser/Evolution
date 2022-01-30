package ch.noseryoung.gui;

import ch.noseryoung.Organism;

import java.awt.*;
import java.util.ArrayList;

/**
 * Responsible for painting the organisms in the grid
 */
public class OrganismPainter {
    private final Panel gridPanel;

    public OrganismPainter(Panel gridPanel) {
        this.gridPanel = gridPanel;
    }

    /**
     * Paints a whole generation of organisms
     * @param g Graphics context used for drawing the GUI
     * @param organisms Organisms which should be drawn
     */
    public void paintGeneration(Graphics g, ArrayList<Organism> organisms) {
        organisms.forEach(organism -> paintOrganism(g, organism));
    }

    /**
     * Methode to paint a single organism
     * @param g Graphics context used for drawing the GUI
     * @param organism Organism which should be drawn
     */
    private void paintOrganism(Graphics g, Organism organism) {
        g.setColor(organism.getColor());
        g.fillRect(organism.getCurrentPosition().getX() * gridPanel.getScaleFactor(),
                organism.getCurrentPosition().getY() * gridPanel.getScaleFactor(),
                gridPanel.getScaleFactor(), gridPanel.getScaleFactor()
        );
    }
}
