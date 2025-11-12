package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class SettingsController {

    // Handler for the Save button
    @FXML
    private Slider volumeSlider;


    @FXML
    private void handleSave(ActionEvent event) {
        System.out.println("Settings saved!");
        switchToMainMenu(event);  // Go back to Main Menu after saving
    }

    // Handler for the Go Back / Cancel button
    @FXML
    private void handleCancel(ActionEvent event) {
        switchToMainMenu(event);
    }

    // Common method to switch back to Main Menu
    @FXML
    private void switchToMainMenu(ActionEvent event) {
        try {
            // Load the Main Menu FXML
            Parent root = FXMLLoader.load(getClass().getResource("/edu/utsa/cs3443/froggyfinance/view/main_menu.fxml"));

            // Get the current stage from the button that was clicked
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene to Main Menu
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
