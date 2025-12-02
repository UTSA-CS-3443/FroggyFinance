package edu.utsa.cs3443.froggyfinance;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Open the floating menu first
        FloatingMenu.open(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

