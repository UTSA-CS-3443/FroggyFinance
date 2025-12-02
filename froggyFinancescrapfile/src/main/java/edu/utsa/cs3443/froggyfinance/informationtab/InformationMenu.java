package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import edu.utsa.cs3443.froggyfinance.FloatingMenu;

/**
 * The {@code InformationMenu} class represents the main information tab
 * in the FroggyFinance application.
 * <p>
 * This screen provides navigation options for viewing content related to
 * Loans or Credit/Debit. The back button returns the user to the
 * {@link FloatingMenu}.
 * @author Victoria Baladez
 */
public class InformationMenu {

    /**
     * Displays the Information Menu screen in the provided {@link Stage}.
     * <p>
     * The screen includes:
     * <ul>
     *     <li>A header label showing "Information Tab"</li>
     *     <li>A button to navigate to {@link LoanLevelsScreen}</li>
     *     <li>A button to navigate to {@link CreditLevelsScreen}</li>
     *     <li>A back button to return to {@link FloatingMenu}</li>
     * </ul>
     *
     * @param stage the JavaFX window where this menu is displayed
     */
    public void show(Stage stage) {
        stage.setTitle("Information Menu");

        Label title = new Label("Information Tab");
        title.setFont(Font.font("Arial", 28));
        title.setStyle("-fx-font-weight: bold;");

        // Buttons
        Button loansButton = new Button("Loans");
        loansButton.setPrefSize(260, 40);
        loansButton.setFont(Font.font(16));

        Button creditButton = new Button("Credit/Debit");
        creditButton.setPrefSize(260, 40);
        creditButton.setFont(Font.font(16));

        Button backButton = new Button("Back");
        backButton.setPrefSize(260, 36);
        backButton.setFont(Font.font(14));

        // Navigate to other screens
        loansButton.setOnAction(e -> new LoanLevelsScreen().show(stage));
        creditButton.setOnAction(e -> new CreditLevelsScreen().show(stage));

        // Back button returns to existing Floating Menu
        backButton.setOnAction(e -> FloatingMenu.reopen(stage));

        VBox root = new VBox(20, title, loansButton, creditButton, backButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #f7f7fb;");

        Scene scene = new Scene(root, 420, 350);
        stage.setScene(scene);
        stage.show();
    }
}

