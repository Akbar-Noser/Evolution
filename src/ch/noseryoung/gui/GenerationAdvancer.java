package ch.noseryoung.gui;

import ch.noseryoung.processor.Starter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerationAdvancer extends Box {

    public GenerationAdvancer(Starter starter) {
        super(BoxLayout.Y_AXIS);
        add(createVerticalGlue());
        add(new InputPanel(starter));
        add(createVerticalGlue());
        setVisible(true);
    }
}

class InputPanel extends JPanel {
    private final GenerationAdvancerButton button;
    private final GenerationAdvancerInputField inputField;
    private final Starter starter;

    public InputPanel(Starter starter) {
        add(button = new GenerationAdvancerButton());
        add(inputField = new GenerationAdvancerInputField());
        this.starter = starter;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 starter.completeGenerationCycle(Integer.parseInt(inputField.getText()));
            }
        });
        setVisible(true);
    }


}
