package ch.noseryoung.gui;

import ch.noseryoung.Organism;
import ch.noseryoung.datacontainer.Position;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class MainFrame extends JFrame {
    private final GridPanel gridPanel;

    public MainFrame() throws HeadlessException {
        gridPanel = new GridPanel();
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
