package edu.utsa.cs3443.froggyfinance;

import edu.utsa.cs3443.froggyfinance.controller.MainMenuController;
import edu.utsa.cs3443.froggyfinance.informationtab.InformationMenu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * FloatingMenu
 *
 * Manages the floating in-game menu for the FroggyFinance application.
 * Provides quick access to tools and features such as Calculator,
 * Notepad, Tutorial, and Game Menu from anywhere in the game.
 * 
 * The menu is designed to be reusable and can reopen on the same
 * stage, maintaining smooth navigation between screens.
 *
 * author: Sofia Flores
 */
public class FloatingMenu {

    /** The Stage on which the Floating Menu is displayed. */
    private static Stage menuStage;

    /**
     * Opens the Floating Menu on the provided stage.
     * Reuses the stage if already open.
     *
     * @param owner the stage to display the menu on
     */
    public static void open(Stage owner) {
        if (menuStage != null) {
            menuStage.toFront();
            return;
        }

        menuStage = owner;
        menuStage.setTitle("MENU");

        // Buttons
        Button calculator = new Button("Calculator");
        Button notepad = new Button("Notepad");
        Button mainMenu = new Button("Game Menu");
        Button tutorial = new Button("Tutorial");

        String buttonStyle = "-fx-font-size: 16px; -fx-pref-width: 200px; "
                + "-fx-background-radius: 10; -fx-background-color: #ffffff;";
        calculator.setStyle(buttonStyle);
        notepad.setStyle(buttonStyle);
        mainMenu.setStyle(buttonStyle);
        tutorial.setStyle(buttonStyle);

        // Calculator button
        calculator.setOnAction(e -> {
            loadSceneWithBack(menuStage, "/edu/utsa/cs3443/froggyfinance/hello-viewCalc.fxml", "Calculator");
        });

        // Notepad button -> open InformationMenu
        notepad.setOnAction(e -> {
            InformationMenu infoMenu = new InformationMenu();
            infoMenu.show(menuStage);
        });

        // Main Menu button
        mainMenu.setOnAction(e -> {
            MainMenuController.show(menuStage);
        });

        // Tutorial button
        tutorial.setOnAction(e -> {
            loadSceneWithBack(menuStage, "/edu/utsa/cs3443/froggyfinance/view/tutorial.fxml", "Tutorial");
        });

        VBox root = new VBox(15, calculator, notepad, mainMenu, tutorial);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center; "
                + "-fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); "
                + "-fx-background-radius: 15;");

        Scene scene = new Scene(root, 300, 300);
        menuStage.setScene(scene);
        menuStage.show();
    }

    /**
     * Loads a new scene from FXML and passes the current scene to the controller.
     * This allows controllers with a setPreviousScene method to return to the previous screen.
     *
     * @param stage the stage to display the new scene on
     * @param fxmlPath the classpath location of the FXML file to load
     * @param title the window title for the new scene
     */
    private static void loadSceneWithBack(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(FloatingMenu.class.getResource(fxmlPath));
            Scene currentScene = stage.getScene(); // save current scene
            Scene newScene = new Scene(loader.load());

            // Pass previous scene to controller if applicable
            Object controller = loader.getController();
            try {
                controller.getClass()
                        .getMethod("setPreviousScene", Stage.class, Scene.class)
                        .invoke(controller, stage, currentScene);
            } catch (NoSuchMethodException ignored) {
                // Controller doesn't have setPreviousScene, no problem
            }

            stage.setScene(newScene);
            stage.setTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the stage used by the Floating Menu.
     *
     * @return the Floating Menu stage
     */
    public static Stage getMenuStage() {
        return menuStage;
    }

    /**
     * Returns the scene currently displayed by the Floating Menu.
     *
     * @return the current Floating Menu scene
     */
    public static Scene getMenuScene() {
        return menuStage.getScene();
    }

    /**
     * Reopens the Floating Menu, rebuilding its scene if necessary.
     *
     * @param stage the stage to display the Floating Menu on
     */
    public static void reopen(Stage stage) {
        if (menuStage == null) {
            menuStage = stage;
        }
        menuStage.setScene(null); // Clear previous scene
        setupScene(menuStage);
    }

    /**
     * Helper method to set up the Floating Menu scene.
     *
     * Extracted from open() to allow scene rebuilding when reopening the menu.
     *
     * @param stage the stage to display the menu on
     */
    private static void setupScene(Stage stage) {
        stage.setTitle("MENU");

        Button calculator = new Button("Calculator");
        Button notepad = new Button("Notepad");
        Button mainMenu = new Button("Game Menu");
        Button tutorial = new Button("Tutorial");

        String buttonStyle = "-fx-font-size: 16px; -fx-pref-width: 200px; "
                + "-fx-background-radius: 10; -fx-background-color: #ffffff;";
        calculator.setStyle(buttonStyle);
        notepad.setStyle(buttonStyle);
        mainMenu.setStyle(buttonStyle);
        tutorial.setStyle(buttonStyle);

        // Button actions
        calculator.setOnAction(e -> loadSceneWithBack(stage, "/edu/utsa/cs3443/froggyfinance/hello-viewCalc.fxml", "Calculator"));
        notepad.setOnAction(e -> new InformationMenu().show(stage));
        mainMenu.setOnAction(e -> MainMenuController.show(stage));
        tutorial.setOnAction(e -> loadSceneWithBack(stage, "/edu/utsa/cs3443/froggyfinance/view/tutorial.fxml", "Tutorial"));

        VBox root = new VBox(15, calculator, notepad, mainMenu, tutorial);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); -fx-background-radius: 15;");

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
