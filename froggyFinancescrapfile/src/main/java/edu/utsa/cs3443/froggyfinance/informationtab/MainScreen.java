package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import edu.utsa.cs3443.froggyfinance.FloatingMenu;

/**
 * Represents the main menu screen of the FroggyFinance application.
 * <p>
 * This screen provides navigation to the Information section or allows
 * the user to return to the {@link FloatingMenu}.
 */
public class MainScreen {

    /**
     * Displays the main menu in the provided {@link Stage}.
     * <p>
     * The menu contains:
     * <ul>
     *     <li>A header label showing "Main Menu"</li>
     *     <li>A button to navigate to the {@link InformationMenu}</li>
     *     <li>A button to return to the {@link FloatingMenu}</li>
     * </ul>
     *
     * @param stage the primary JavaFX window where the main menu is displayed
     */
    public void start(Stage stage) {
        stage.setTitle("Main Menu");

        Label title = new Label("Main Menu");
        title.setFont(Font.font("Arial", 28));
        title.setStyle("-fx-font-weight: bold;");

        Button infoButton = new Button("Information");
        infoButton.setPrefSize(260, 40);
        infoButton.setFont(Font.font(16));

        Button exitButton = new Button("Back to Menu");
        exitButton.setPrefSize(260, 36);
        exitButton.setFont(Font.font(14));

        // Navigate to the InformationMenu
        infoButton.setOnAction(e -> new InformationMenu().show(stage));

        // Return to the FloatingMenu
        exitButton.setOnAction(e -> FloatingMenu.open(stage));

        VBox root = new VBox(20, title, infoButton, exitButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle(
            "-fx-padding: 30; " +
            "-fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); " +
            "-fx-border-radius: 15; " +
            "-fx-background-radius: 15;"
        );

        stage.setScene(new Scene(root, 420, 300));
        stage.show();
    }
}

