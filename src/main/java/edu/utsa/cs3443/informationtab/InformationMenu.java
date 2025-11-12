package edu.utsa.cs3443.informationtab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Displays the main information tab with options for Loans and Credit/Debit.
 */
public class InformationMenu {

    public void show(Stage stage) {
        stage.setTitle("Information Menu");

        Label title = new Label("Information Tab");
        title.setFont(Font.font("Arial", 28));
        title.setStyle("-fx-font-weight: bold;");

        Button loansButton = new Button("Loans");
        loansButton.setPrefSize(260, 40);
        loansButton.setFont(Font.font(16));

        Button creditButton = new Button("Credit/Debit");
        creditButton.setPrefSize(260, 40);
        creditButton.setFont(Font.font(16));

        Button backButton = new Button("Back");
        backButton.setPrefSize(260, 36);
        backButton.setFont(Font.font(14));

        loansButton.setOnAction(e -> new LoanLevelsScreen().show(stage));
        creditButton.setOnAction(e -> new CreditLevelsScreen().show(stage));
        backButton.setOnAction(e -> new MainScreen().start(stage));

        VBox root = new VBox(20, title, loansButton, creditButton, backButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f7f7fb;");

        Scene scene = new Scene(root, 420, 350);
        stage.setScene(scene);
        stage.show();
    }
}




