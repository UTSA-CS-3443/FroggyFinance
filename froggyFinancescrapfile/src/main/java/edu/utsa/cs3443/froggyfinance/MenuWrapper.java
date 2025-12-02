package edu.utsa.cs3443.froggyfinance;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Wraps an existing Scene with a global menu bar for navigation.
 */
public class MenuWrapper {

    /**
     * Wraps a game Scene with a MenuBar that has Main Menu, Calculator, and Notepad options.
     *
     * @param stage     the primary stage
     * @param gameScene the existing game Scene to wrap
     * @return a new Scene containing the menu bar and the game scene
     */
    public static Scene wrapWithMenu(Stage stage, Scene gameScene) {
        VBox wrapper = new VBox();

        // Create the menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Navigate");

        MenuItem mainMenu = new MenuItem("🏠 Main Menu");
        mainMenu.setOnAction(e -> {
            // TODO: load your main menu FXML or scene
            System.out.println("Main Menu clicked");
        });

        MenuItem calculator = new MenuItem("🧮 Calculator");
        calculator.setOnAction(e -> {
            // TODO: load your calculator FXML or scene
            System.out.println("Calculator clicked");
        });

        MenuItem notepad = new MenuItem("📝 Notepad");
        notepad.setOnAction(e -> {
            // TODO: load your notepad FXML or scene
            System.out.println("Notepad clicked");
        });

        menu.getItems().addAll(mainMenu, calculator, notepad);
        menuBar.getMenus().add(menu);

        // Add the menu bar first, then the original game scene root
        wrapper.getChildren().addAll(menuBar, gameScene.getRoot());

        // Create and return a new scene
        return new Scene(wrapper, gameScene.getWidth(), gameScene.getHeight() + 25); // extra height for menu
    }
}
