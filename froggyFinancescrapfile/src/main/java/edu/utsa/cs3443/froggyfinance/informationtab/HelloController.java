package edu.utsa.cs3443.informationtab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * A simple JavaFX controller used for FXML-based UI testing or demos.
 * <p>
 * This controller responds to a button click by updating a label’s text.
 * It serves primarily as a template or placeholder controller.
 */
public class HelloController {

    /** Reference to the label defined in the FXML file. */
    @FXML
    private Label welcomeText;

    /**
     * Handles the "Hello" button click event.
     * <p>
     * When triggered, the method updates the {@code welcomeText} label
     * with a greeting message.
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

