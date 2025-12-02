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
 * The {@code LevelContentScreen} class displays a scrollable text page
 * for a single information level, such as a loan explanation or
 * credit/debit topic.
 * <p>
 * This screen is intended to show detailed content passed in at runtime,
 * along with a Back button that returns the user to the originating
 * parent screen (either {@link LoanLevelsScreen} or {@link CreditLevelsScreen}).
 */
public class LevelContentScreen {

    /**
     * Displays the level content screen within the provided {@link Stage}.
     *
     * @param stage        the JavaFX window where the screen is shown
     * @param title        the title/header for this information page
     * @param content      the detailed text content to be displayed
     * @param parentScreen the originating screen instance; used to navigate back
     */
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







