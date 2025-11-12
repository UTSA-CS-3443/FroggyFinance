package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;


public class MainMenuController {
    @FXML
    private AnchorPane Anchorpane;

    @FXML
    private Button startGameButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button conceptArtButton;

    // Handle Start Game button (you can implement actual game later)
    @FXML
    private void handleStartGame() {
        System.out.println("Start Game clicked!");

    }
    // Handle Settings button
    @FXML
    private void handleSettings() {
        loadScene("/edu/utsa/cs3443/froggyfinance/view/Settings.fxml");
    }

    // Handle Concept Art button
    @FXML
    private void handleConceptArt() {
        loadScene("/edu/utsa/cs3443/froggyfinance/view/concept_art.fxml");
    }

    // Utility method to load new scenes
    private void loadScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) startGameButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
