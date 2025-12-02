package edu.utsa.cs3443.froggyfinance.controller;

import edu.utsa.cs3443.froggyfinance.BackgroundMusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SettingsController {

    @FXML
    private Slider volumeSlider;

    @FXML
    public void initialize() {
        // Set initial slider value from current volume
        volumeSlider.setValue(BackgroundMusicPlayer.getVolume() * 100);

        // Update volume when slider moves
        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            float vol = newVal.floatValue() / 100f; // map 0-100 to 0-1
            BackgroundMusicPlayer.setVolume(vol);
        });
    }

    @FXML
    private void handleSave(ActionEvent event) {
        switchToMainMenu(event);
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        switchToMainMenu(event);
    }

    @FXML
    private void switchToMainMenu(ActionEvent event) {
        Stage stage = (Stage) volumeSlider.getScene().getWindow();
        MainMenuController.show(stage);
    }
}
