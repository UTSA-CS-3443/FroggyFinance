package edu.utsa.cs3443.informationtab;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application entry point.
 */
public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        new MainScreen().start(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}





