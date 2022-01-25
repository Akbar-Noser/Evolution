package ch.noseryoung.gui;

import ch.noseryoung.processor.Starter;

import javax.swing.*;

/**
 * Contains all the user input possibility through
 * GUI components
 */
public class InputInterface extends Box {
    private final JPanel panel;

    public InputInterface(Starter starter) {
        super(BoxLayout.Y_AXIS);
        add(createVerticalGlue());
        add(panel = new JPanel());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(createVerticalGlue());
        panel.setAlignmentX(LEFT_ALIGNMENT);
        GenerationAdvancer generationAdvancer = new GenerationAdvancer(starter);
        generationAdvancer.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(generationAdvancer);
        Resetter resetter = new Resetter(starter);
        resetter.setAlignmentX(LEFT_ALIGNMENT);
        panel.add(resetter);

    }
}