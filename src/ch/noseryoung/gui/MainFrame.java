package ch.noseryoung.gui;

import javax.swing.*;
import java.awt.*;

public class GridFrame extends JFrame {
    private final GridPanel gridPanel;

    public GridFrame() throws HeadlessException {
        gridPanel = new GridPanel();
        add(gridPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }
}
