module com.ihm.zoofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens zoofx to javafx.fxml;
    exports zoofx;
    exports zoofx.mainMenu;
    exports zoofx.optionMenu;
    exports zoofx.loadGameMenu;
    exports zoofx.createGameMenu;
    opens zoofx.mainMenu to javafx.fxml;
    opens zoofx.optionMenu to javafx.fxml;
    opens zoofx.loadGameMenu to javafx.fxml;
    opens zoofx.createGameMenu to javafx.fxml;
}