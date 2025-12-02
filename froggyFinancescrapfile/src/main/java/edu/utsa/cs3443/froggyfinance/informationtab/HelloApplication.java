package edu.utsa.cs3443.froggyfinance.informationtab;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main entry point for the JavaFX application.
 * <p>
 * This class initializes the program by launching JavaFX and delegating
 * the startup UI logic to {@link MainScreen}. It acts as the root
 * bootstrapper for the entire application.
 */
public class HelloApplication extends Application {

    /**
     * Called automatically by the JavaFX runtime after the application
     * has been launched. This method sets up the initial window by
     * displaying the {@link MainScreen}.
     *
     * @param stage the primary application window
     */
    @Override
    public void start(Stage stage) {
        new MainScreen().start(stage);
    }

    /**
     * Standard Java entry point that launches the JavaFX application.
     *
     * @param args optional command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}





