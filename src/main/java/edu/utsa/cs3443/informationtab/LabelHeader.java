package edu.utsa.cs3443.informationtab;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Small utility to produce consistently styled section headers.
 */
public class LabelHeader {
    private final Label label;
    public LabelHeader(String text) {
        label = new Label(text);
        label.setFont(Font.font("Arial", 20));
        label.setStyle("-fx-font-weight: bold; -fx-padding: 6 0 10 0;");
    }
    public Label getLabel() { return label; }
}

