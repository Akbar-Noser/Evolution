package ch.noseryoung.gui;

import ch.noseryoung.processor.Starter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerationAdvancer extends JPanel {
    private final Button button;
    private final GenerationAdvancerInputField inputField;
    private final Starter starter;

    public GenerationAdvancer(Starter starter) {
        add(button = new Button("Advance"));
        add(inputField = new GenerationAdvancerInputField());
        this.starter = starter;
        setAlignmentX(LEFT_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                starter.completeGenerationCycle(Integer.parseInt(inputField.getText()));
            }
        });
        setVisible(true);
    }
}
