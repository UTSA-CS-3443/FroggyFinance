package edu.utsa.cs3443.froggyfinance.controller;

import edu.utsa.cs3443.froggyfinance.FloatingMenu;
import edu.utsa.cs3443.froggyfinance.GamePanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MainMenuController
 *
 * Manages the FroggyFinance application's Main Menu UI. This class
 * handles the creation of the main menu layout, button initialization,
 * and navigation to other parts of the application such as the game screen,
 * settings, credits, or back to the floating in-game menu.
 *
 * The class uses static behavior to allow any part of the program to
 * display the Main Menu on a given {@link Stage}.
 *
 * Responsibilities:
 * - Build and display the main menu layout programmatically.
 * - Handle navigation to Settings, Credits, and GamePanel.
 * - Return users to the Floating Menu via the Back button.
 *
 * author: Sofia Flores
 */
public class MainMenuController {

    /** The stage on which the Main Menu is displayed. */
    private static Stage stage;

    /**
     * Displays the Main Menu on the provided stage.
     *
     * This method constructs the menu UI, applies styling, sets up
     * button actions, and updates the stage with the resulting scene.
     *
     * @param ownerStage the stage on which the menu should be shown
     */
    public static void show(Stage ownerStage) {
        stage = ownerStage;

        VBox root = new VBox(15);
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); "
                + "-fx-padding: 30; -fx-alignment: center;");

        // Buttons
        Button startGame = new Button("Continue Game");
        Button settings = new Button("Settings");
        Button credits = new Button("Credits");
        Button back = new Button("Back");

        String style = "-fx-font-size:16px; -fx-pref-width:200px; "
                + "-fx-background-radius:10; -fx-background-color:#ffffff;";
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

        // BACK button returns to the Floating Menu
        back.setOnAction(e -> FloatingMenu.reopen(stage));

        root.getChildren().addAll(startGame, settings, credits, back);

        stage.setScene(new Scene(root, 400, 350));
        stage.setTitle("Main Menu");
        stage.show();
    }

    /**
     * Loads and displays a new scene from an FXML file.
     *
     * This method attempts to read and load the provided FXML resource
     * path using a {@link javafx.fxml.FXMLLoader}. If the file is found
     * and loads successfully, the scene is applied to the stage.
     *
     * @param fxmlPath the classpath location of the FXML file to load
     */
    private static void loadScene(String fxmlPath) {
        try {
            javafx.fxml.FXMLLoader loader =
                    new javafx.fxml.FXMLLoader(MainMenuController.class.getResource(fxmlPath));
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
