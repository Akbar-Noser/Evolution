package ch.noseryoung.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Implementation of JButton
 */
public class Button extends JButton {
    public Button(String text) {
        setText(text);
        setAlignmentX(LEFT_ALIGNMENT);
        setPreferredSize(new Dimension(100, 25));
        setVisible(true);
    }
}
