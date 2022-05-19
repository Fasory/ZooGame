package com.ihm.zoofx;

import com.ihm.tools.ImageTools;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ZooGameController {

    @FXML
    private ImageView titleScreen;

    @FXML
    private ImageView newGame;

    @FXML
    private ImageView loadGame;

    public void initialize() {
        try {
            titleScreen.setImage(new Image(String.valueOf(ZooGameController.class.getResource("img/title-screen.png"))));
            Image sign = new Image(String.valueOf(ZooGameController.class.getResource("img/background-sign.png")));
            newGame.setImage(ImageTools.getSubImage(sign, 41,33,220,91));
            loadGame.setImage(ImageTools.getSubImage(sign, 41,142,219,85));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}