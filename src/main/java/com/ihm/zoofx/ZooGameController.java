package com.ihm.zoofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ZooGameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}