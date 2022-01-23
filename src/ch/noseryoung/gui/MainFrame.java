package ch.noseryoung.gui;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;
import ch.noseryoung.processor.Starter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class MainFrame extends JFrame {
    private final GridPanel gridPanel;

    public MainFrame(Starter starter) throws HeadlessException {
        gridPanel = new GridPanel(new GenerationAdvancer(starter));
        add(gridPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }
}
