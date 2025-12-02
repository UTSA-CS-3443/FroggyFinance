package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Utility class that provides simple helper methods for displaying
 * small modal message windows.
 * <p>
 * This is typically used in place of traditional dialog boxes to show short
 * alerts, notifications, or informational messages within the JavaFX
 * application.
 * @author Victoria Baladez
 */
public class StageHelper {

    /**
     * Displays a small modal pop-up window containing a message.
     * <p>
     * The window is created with {@link Modality#APPLICATION_MODAL}, meaning it
     * blocks interaction with other application windows until closed.
     *
     * @param title   the title of the message window
     * @param message the text content displayed inside the window
     */
    public static void showMessage(String title, String message) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);

        Label lbl = new Label(message);
        VBox root = new VBox(10, lbl);
        root.setStyle("-fx-padding:12; -fx-alignment:center;");

        stage.setScene(new Scene(root, 320, 120));
        stage.show();
    }
}


