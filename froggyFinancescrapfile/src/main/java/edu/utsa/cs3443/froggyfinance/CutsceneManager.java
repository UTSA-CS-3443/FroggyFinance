package edu.utsa.cs3443.froggyfinance;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class CutsceneManager {

    private boolean isPlaying = false;

    public void playTutorial(Scene gameScene, Runnable onFinish) {
        if (isPlaying) return;
        isPlaying = true;

        // Create overlay
        Label message = new Label("Welcome to Froggy Finance! 🐸\n\nUse arrow keys to move.\nAvoid obstacles and collect coins!");
        message.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-wrap-text: true;");

        Button nextButton = new Button("Got it!");
        nextButton.setOnAction(e -> {
            // End cutscene
            StackPane root = (StackPane) gameScene.getRoot();
            root.getChildren().removeIf(node -> node.getId() != null && node.getId().equals("tutorialOverlay"));
            isPlaying = false;
            onFinish.run(); // resume game
        });

        VBox tutorialBox = new VBox(20, message, nextButton);
        tutorialBox.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7); -fx-padding: 50px; -fx-alignment: center;");

        StackPane overlay = new StackPane(tutorialBox);
        overlay.setId("tutorialOverlay");

        // Pause game and overlay it
        ((StackPane) gameScene.getRoot()).getChildren().add(overlay);

        // Optionally fade in
        PauseTransition fadeIn = new PauseTransition(Duration.seconds(0.5));
        fadeIn.setOnFinished(event -> tutorialBox.setOpacity(1));
        fadeIn.play();
    }
}
