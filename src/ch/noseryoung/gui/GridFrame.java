package ch.noseryoung.gui;

import javax.swing.*;
import java.awt.*;

public class GridFrame extends JFrame {
    public GridFrame() throws HeadlessException {
        add(new GridPanel());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
