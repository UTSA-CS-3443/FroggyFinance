package edu.utsa.cs3443.froggyfinance.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CreditsController {

    @FXML
    private void goBackToMainMenu(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        MainMenuController.show(stage);
    }
}
