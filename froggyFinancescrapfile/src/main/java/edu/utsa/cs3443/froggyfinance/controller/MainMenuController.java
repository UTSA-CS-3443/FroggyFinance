package edu.utsa.cs3443.froggyfinance.controller;

import edu.utsa.cs3443.froggyfinance.FloatingMenu;
import edu.utsa.cs3443.froggyfinance.GamePanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController {

    private static Stage stage;

    /** Show MainMenuController on the given stage */
    public static void show(Stage ownerStage) {
        stage = ownerStage;

        VBox root = new VBox(15);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); -fx-padding: 30; -fx-alignment: center;");

        // Buttons
        Button startGame = new Button("Continue Game");
        Button settings = new Button("Settings");
        Button credits = new Button("Credits");
        Button back = new Button("Back");

        String style = "-fx-font-size:16px; -fx-pref-width:200px; -fx-background-radius:10; -fx-background-color:#ffffff;";
        startGame.setStyle(style);
        settings.setStyle(style);
        credits.setStyle(style);
        back.setStyle(style);

        // Button actions
        startGame.setOnAction(e -> {
            Scene gameScene = GamePanel.createGameScene(stage, false);
            stage.setScene(gameScene);
            stage.setTitle("Froggy Finance");
        });

        settings.setOnAction(e -> loadScene("/edu/utsa/cs3443/froggyfinance/view/Settings.fxml"));
        credits.setOnAction(e -> loadScene("/edu/utsa/cs3443/froggyfinance/view/Credits_Controller.fxml"));

        // BACK button now returns to Floating Menu
        back.setOnAction(e -> FloatingMenu.reopen(stage));

        root.getChildren().addAll(startGame, settings, credits, back);

        stage.setScene(new Scene(root, 400, 350));
        stage.setTitle("Main Menu");
        stage.show();
    }

    /** Load a scene from FXML file */
    private static void loadScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(MainMenuController.class.getResource(fxmlPath));
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
