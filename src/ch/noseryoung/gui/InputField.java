package ch.noseryoung.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Implementation of JTextField
 */
public class InputField extends JTextField {

    public InputField() {
        setMinimumSize(new Dimension(100,20));
        setMaximumSize(new Dimension(100,20));
        setPreferredSize(new Dimension(100,20));
    }
}
