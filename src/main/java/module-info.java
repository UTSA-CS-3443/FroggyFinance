/**
 * Module configuration for the InformationTab application.
 *
 * Declares required JavaFX modules and opens/exports the base package.
 */
module edu.utsa.cs3443.informationtab {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.utsa.cs3443.informationtab to javafx.fxml;
    exports edu.utsa.cs3443.informationtab;
}
