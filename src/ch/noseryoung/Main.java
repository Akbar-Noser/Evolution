package ch.noseryoung;

import ch.noseryoung.gui.MainFrame;
import ch.noseryoung.gui.OrganismPainter;
import ch.noseryoung.processor.Starter;

public class Main {

    public static void main(String[] args) {
        new MainFrame(new Starter());
    }
}
