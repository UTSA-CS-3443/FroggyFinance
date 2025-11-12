package edu.utsa.cs3443.informationtab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Shows a single information level (loans or credit) with Back navigation.
 */
public class LevelContentScreen {

    public void show(Stage stage, String title, String content, Object parentScreen) {
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", 22));
        titleLabel.setStyle("-fx-font-weight: bold;");

        Label textLabel = new Label(content);
        textLabel.setWrapText(true);
        textLabel.setFont(Font.font(15));

        VBox contentBox = new VBox(12, titleLabel, textLabel);
        contentBox.setStyle("-fx-padding: 16;");

        ScrollPane scroll = new ScrollPane(contentBox);
        scroll.setFitToWidth(true);

        Button back = new Button("Back");
        back.setPrefWidth(120);
        back.setOnAction(e -> {
            // Navigate back to parent screen
            if (parentScreen instanceof LoanLevelsScreen) {
                ((LoanLevelsScreen) parentScreen).show(stage);
            } else if (parentScreen instanceof CreditLevelsScreen) {
                ((CreditLevelsScreen) parentScreen).show(stage);
            }
        });

        VBox root = new VBox(16, scroll, back);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 16; -fx-background-color: #ffffff;");

        stage.setScene(new Scene(root, 440, 300));
        stage.show();
    }
}






