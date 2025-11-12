package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class ConceptArtController {


    @FXML
    private void goBackToMainMenu(ActionEvent event) {
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
