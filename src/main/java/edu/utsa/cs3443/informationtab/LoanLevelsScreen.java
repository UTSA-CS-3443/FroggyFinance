package edu.utsa.cs3443.informationtab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Displays paged "Loans" content with next/back buttons.
 */
public class LoanLevelsScreen {

    private final ContentManager contentManager = new ContentManager();
    private int currentLevel = 1; // 1-based
    private final String topic = "Loans";

    public void show(Stage stage) {
        stage.setTitle(topic);

        // Header label
        Label header = new Label(topic);
        header.setFont(Font.font("Arial", 28));
        header.setStyle("-fx-font-weight: bold;");

        // Level title and paragraph
        Label levelTitle = new Label(contentManager.getTitle(topic, currentLevel));
        levelTitle.setFont(Font.font("Arial", 20));
        levelTitle.setStyle("-fx-padding: 10 0 5 0; -fx-font-weight: bold;");

        Label paragraph = new Label(contentManager.getParagraph(topic, currentLevel));
        paragraph.setWrapText(true);
        paragraph.setFont(Font.font(15));
        paragraph.setStyle("-fx-padding: 0 15 0 15;");

        VBox contentBox = new VBox(10, header, levelTitle, paragraph);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle("-fx-background-color: #f7f7fb;");

        // Buttons
        Button backMain = new Button("Back");
        Button prevBtn = new Button("<");
        Button nextBtn = new Button(">");

        // Main back
        backMain.setOnAction(e -> new InformationMenu().show(stage));

        // Navigation
        prevBtn.setOnAction(e -> {
            if (currentLevel > 1) {
                currentLevel--;
                levelTitle.setText(contentManager.getTitle(topic, currentLevel));
                paragraph.setText(contentManager.getParagraph(topic, currentLevel));
            }
        });
        nextBtn.setOnAction(e -> {
            if (currentLevel < contentManager.getParagraphCount(topic)) {
                currentLevel++;
                levelTitle.setText(contentManager.getTitle(topic, currentLevel));
                paragraph.setText(contentManager.getParagraph(topic, currentLevel));
            }
        });

        prevBtn.setPrefWidth(100);
        nextBtn.setPrefWidth(100);

        HBox navBox = new HBox(20, prevBtn, nextBtn);
        navBox.setAlignment(Pos.CENTER);
        navBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setTop(backMain);
        BorderPane.setAlignment(backMain, Pos.TOP_LEFT);
        BorderPane.setMargin(backMain, new Insets(10));
        root.setCenter(contentBox);
        root.setBottom(navBox);

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
}






