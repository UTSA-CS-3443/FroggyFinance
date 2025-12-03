package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * The {@code LabelHeader} class is a small UI utility used to create
 * consistently styled header labels throughout the application.
 * <p>
 * It automatically applies a predefined font, weight, and padding to ensure
 * uniform visual appearance across different screens.
 * @author Victoria Baladez
 */
public class LabelHeader {

    /** The styled label instance created by this utility. */
    private final Label label;

    /**
     * Constructs a new {@code LabelHeader} with the specified text, applying
     * consistent header styling such as font size, weight, and spacing.
     *
     * @param text the header text to display in the label
     */
    public LabelHeader(String text) {
        label = new Label(text);
        label.setFont(Font.font("Arial", 20));
        label.setStyle("-fx-font-weight: bold; -fx-padding: 6 0 10 0;");
    }

    /**
     * Returns the styled {@link Label} object created by this class.
     *
     * @return the configured label instance
     */
    public Label getLabel() {
        return label;
    }
}

