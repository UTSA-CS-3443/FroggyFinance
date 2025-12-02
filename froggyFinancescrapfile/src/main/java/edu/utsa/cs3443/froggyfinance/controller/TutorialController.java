package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TutorialController
 *
 * Manages the tutorial screen for the FroggyFinance application.
 * This controller displays step-by-step instructions to guide the
 * user through the game's features. Users can navigate through
 * tutorial steps or return to the previous screen when finished.
 *
 * author: Sofia Flores
 */
public class TutorialController {

    /** Label that displays the current tutorial step text. */
    @FXML
    private Label tutorialText;

    /** The stage where the tutorial is being displayed. */
    private Stage stage;

    /** Scene that was displayed before opening the tutorial. */
    private Scene previousScene;

    /** Tracks the current step number in the tutorial. */
    private int step = 0;

    /** Array of tutorial steps to display sequentially to the user. */
    private final String[] tutorialSteps = new String[] {
            "Step 1: Explore the hub. You'll see Review, Test, and Calculate options.",
            "Step 2: Review topics to learn about Banking and Loans in Toads hut!.",
            "Step 3: Take quizzes with Toad and track your progress.",
            "Step 4: Navigate the open-world map and test your knowledge at the bark bank.",
            "Step 5: Use the Calculator to see how loans and interest will apply to your answers.",
            "Tutorial complete! Good luck player! Press Done to return."
    };

    /**
     * Sets the stage and the previous scene so the tutorial can return
     * to it when done.
     *
     * This method should be called when opening the tutorial from
     * another screen (e.g., FloatingMenu).
     *
     * @param stage the stage where the tutorial is displayed
     * @param previousScene the scene to return to after the tutorial
     */
    public void setPreviousScene(Stage stage, Scene previousScene) {
        this.stage = stage;
        this.previousScene = previousScene;
    }

    /**
     * Advances to the next tutorial step.
     *
     * Updates the tutorial text to the next step in the tutorialSteps
     * array. If the user is on the last step, calling this method
     * has no effect.
     */
    @FXML
    private void handleNextStep() {
        step++;
        if (step < tutorialSteps.length) {
            tutorialText.setText(tutorialSteps[step]);
        }
    }

    /**
     * Completes the tutorial and returns to the previous scene.
     *
     * If a previous scene was set via {@link #setPreviousScene(Stage, Scene)},
     * the stage will switch back to that scene.
     */
    @FXML
    private void handleDone() {
        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
}
