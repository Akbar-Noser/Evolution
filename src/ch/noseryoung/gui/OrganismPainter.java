package ch.noseryoung.gui;

import ch.noseryoung.Organism;

import java.awt.*;
import java.util.ArrayList;

public class OrganismPainter {
    private final Panel gridPanel;

    public OrganismPainter(Panel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public void paintGeneration(Graphics g, ArrayList<Organism> organisms) {
        organisms.forEach(organism -> paintOrganism(g, organism));
    }

    private void paintOrganism(Graphics g, Organism organism) {
        g.setColor(organism.getColor());
        g.fillRect(organism.getCurrentPosition().getX() * gridPanel.getScaleFactor(),
                organism.getCurrentPosition().getY() * gridPanel.getScaleFactor(),
                gridPanel.getScaleFactor(), gridPanel.getScaleFactor()
        );
    }
}
