package edu.utsa.cs3443.informationtab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main menu of the application.
 */
public class MainScreen {

    public void start(Stage stage) {
        stage.setTitle("Main Menu");

        Label title = new Label("Main Menu");
        title.setFont(Font.font("Arial", 28));
        title.setStyle("-fx-font-weight: bold;");

        Button infoButton = new Button("Information");
        infoButton.setPrefSize(260, 40);
        infoButton.setFont(Font.font(16));

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(260, 36);
        exitButton.setFont(Font.font(14));

        infoButton.setOnAction(e -> new InformationMenu().show(stage));
        exitButton.setOnAction(e -> stage.close());

        VBox root = new VBox(20, title, infoButton, exitButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30; -fx-background-color: #f2f2f2;");

        stage.setScene(new Scene(root, 420, 300));
        stage.show();
    }
}






