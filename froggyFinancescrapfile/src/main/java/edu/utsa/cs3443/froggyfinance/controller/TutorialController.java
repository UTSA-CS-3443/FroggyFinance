package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TutorialController {

    @FXML
    private Label tutorialText;

    private Stage stage;
    private Scene previousScene;
    private int step = 0;

    private final String[] tutorialSteps = new String[] {
            "Step 1: Explore the hub. You'll see Review, Test, and Calculate options.",
            "Step 2: Review topics to learn about Banking and Loans in Toads hut!.",
            "Step 3: Take quizzes with Toad and track your progress.",
            "Step 4: Navigate the open-world map and test your knowledge at the bark bank.",
            "Step 5: Use the Calculator to see how loans and interest will apply to your answers.",
            "Tutorial complete Good luck player! Press Done to return."
    };

    // Called from FloatingMenu
    public void setPreviousScene(Stage stage, Scene previousScene) {
        this.stage = stage;
        this.previousScene = previousScene;
    }

    @FXML
    private void handleNextStep() {
        step++;
        if (step < tutorialSteps.length) {
            tutorialText.setText(tutorialSteps[step]);
        }
    }

    @FXML
    private void handleDone() {
        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
}
