module lab2apps.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens lab2apps.calculator to javafx.fxml;
    exports lab2apps.calculator;
}