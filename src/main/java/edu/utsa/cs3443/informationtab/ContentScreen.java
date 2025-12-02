package edu.utsa.cs3443.informationtab;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The {@code ContentScreen} class represents a simple JavaFX window used to
 * display a title and a block of text content. It can function as a standalone
 * message window or as a reusable screen template within the application.
 */
public class ContentScreen {

    /** The title displayed at the top of the content window. */
    private final String title;

    /** The main content text to be shown in the window. */
    private final String content;

    /**
     * Constructs a new {@code ContentScreen} with the given title and content.
     *
     * @param title   the title text to be displayed at the top of the window
     * @param content the body text to be displayed in the window
     */
    public ContentScreen(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Displays the content screen in a new JavaFX {@link Stage}. This method
     * constructs UI elements such as labels and a close button, arranges them
     * in a vertical layout, and shows the window to the user.
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
     * Convenience method that quickly displays a simple informational message
     * in a {@code ContentScreen}. This serves as a JavaFX-based alternative to
     * older Swing-based dialogs such as {@code JOptionPane.showMessageDialog}.
     *
     * @param title   the title to display on the window
     * @param message the content message to show
     */
    public static void showInfo(String title, String message) {
        new ContentScreen(title, message).show();
    }
}





