package edu.utsa.cs3443.froggyfinance.informationtab;

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
 * The {@code CreditLevelsScreen} class displays paginated educational content
 * related to the "Credit/Debit" topic. Users can navigate through chapters
 * using previous and next buttons, while the screen dynamically updates the
 * displayed title and paragraph.
 */
public class CreditLevelsScreen {

    /** Manager responsible for retrieving chapter titles and paragraphs. */
    private final ContentManager contentManager = new ContentManager();

    /** Tracks the currently displayed chapter (1-based index). */
    private int currentLevel = 1;

    /** The topic associated with this screen's content. */
    private final String topic = "Credit/Debit";

    /**
     * Displays the Credit/Debit levels screen within the given JavaFX {@link Stage}.
     * <p>
     * The method builds a complete user interface containing:
     * <ul>
     *     <li>A header showing the topic name</li>
     *     <li>The title and text of the current chapter</li>
     *     <li>Navigation buttons for switching between levels</li>
     *     <li>A back button returning to the main information menu</li>
     * </ul>
     *
     * @param stage the main application window in which the screen is displayed
     */
    public void show(Stage stage) {
        stage.setTitle(topic);

        Label header = new Label(topic);
        header.setFont(Font.font("Arial", 28));
        header.setStyle("-fx-font-weight: bold;");

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

        Button backMain = new Button("Back");
        Button prevBtn = new Button("<");
        Button nextBtn = new Button(">");

        // Returns to the main information menu
        backMain.setOnAction(e -> new InformationMenu().show(stage));

        // Navigate to previous level
        prevBtn.setOnAction(e -> {
            if (currentLevel > 1) {
                currentLevel--;
                levelTitle.setText(contentManager.getTitle(topic, currentLevel));
                paragraph.setText(contentManager.getParagraph(topic, currentLevel));
            }
        });

        // Navigate to next level
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

        Scene scene = new Scene(root, 500, 610);
        stage.setScene(scene);
        stage.show();
    }
}









