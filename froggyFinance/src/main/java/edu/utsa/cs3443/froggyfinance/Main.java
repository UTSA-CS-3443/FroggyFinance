package edu.utsa.cs3443.froggyfinance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3443/froggyfinance/view/main_menu.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Froggy Finance - Main Menu");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
