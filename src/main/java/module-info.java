module com.ihm.zoofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.ihm.zoofx to javafx.fxml;
    exports com.ihm.zoofx;
}