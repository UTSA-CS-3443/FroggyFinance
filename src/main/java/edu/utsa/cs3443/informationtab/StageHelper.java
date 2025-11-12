package edu.utsa.cs3443.informationtab;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageHelper {
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


