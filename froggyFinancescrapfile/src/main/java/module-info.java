module edu.utsa.cs3443.froggyfinance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    requires java.scripting;


    opens edu.utsa.cs3443.froggyfinance to javafx.fxml;
    opens edu.utsa.cs3443.froggyfinance.controller to javafx.fxml;

    // Export packages if other modules need to access them
    exports edu.utsa.cs3443.froggyfinance;
    exports edu.utsa.cs3443.froggyfinance.controller;
}
