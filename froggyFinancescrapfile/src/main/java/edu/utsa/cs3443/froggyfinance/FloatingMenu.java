package edu.utsa.cs3443.froggyfinance;

import edu.utsa.cs3443.froggyfinance.controller.MainMenuController;
import edu.utsa.cs3443.froggyfinance.informationtab.InformationMenu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class FloatingMenu {

    private static Stage menuStage;

    /**
     * Opens the floating menu on the given stage.
     * Reuses the stage if already open.
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
     * Loads a new scene and passes the current scene to the controller if applicable.
     * This allows the "Done"/Back button to return to the previous scene.
     */
    private static void loadSceneWithBack(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(FloatingMenu.class.getResource(fxmlPath));
            Scene currentScene = stage.getScene(); // save current scene
            Scene newScene = new Scene(loader.load());

            // If controller has setPreviousScene, pass stage and previous scene
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
    public static Stage getMenuStage() {
        return menuStage;
    }
    public static Scene getMenuScene() {
        return menuStage.getScene();
    }

    public static void reopen(Stage stage) {
        // If the menuStage already exists, force it to reload its scene
        if (menuStage == null) {
            menuStage = stage;
        }
        // Clear any previous scene (optional, avoids visual glitches)
        menuStage.setScene(null);

        // Set up the Floating Menu scene again
        setupScene(menuStage);
    }

    /** Extracted from open() for reuse */
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

        // Calculator button
        calculator.setOnAction(e -> loadSceneWithBack(stage, "/edu/utsa/cs3443/froggyfinance/hello-viewCalc.fxml", "Calculator"));

        // Notepad button
        notepad.setOnAction(e -> new InformationMenu().show(stage));

        // Main Menu button
        mainMenu.setOnAction(e -> MainMenuController.show(stage));

        // Tutorial button
        tutorial.setOnAction(e -> loadSceneWithBack(stage, "/edu/utsa/cs3443/froggyfinance/view/tutorial.fxml", "Tutorial"));

        VBox root = new VBox(15, calculator, notepad, mainMenu, tutorial);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-alignment: center; -fx-background-color: linear-gradient(to bottom, #a0e3f0, #60c4d8); -fx-background-radius: 15;");

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

}
