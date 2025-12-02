package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * A simple content screen that displays a title and a content message.
 * Used as a placeholder or example for other screens.
 */
public class ContentScreen {

    private final String title;
    private final String content;

    public ContentScreen(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Displays the content screen in a new JavaFX Stage.
     */
    public void show() {
        Stage stage = new Stage();
        stage.setTitle(title);

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        Label contentLabel = new Label(content);
        contentLabel.setWrapText(true);
        contentLabel.setStyle("-fx-font-size: 14;");

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(15, titleLabel, contentLabel, closeBtn);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Static helper for quick message display (replaces old Swing dialogs).
     */
    public static void showInfo(String title, String message) {
        new ContentScreen(title, message).show();
    }
}




