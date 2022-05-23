package com.ihm.zoofx;

import com.ihm.tools.ImageTools;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ZooGameController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgTitleScreen;

    @FXML
    private ImageView imgNewGame;

    @FXML
    private ImageView imgLoadGame;

    @FXML
    private ImageView imgQuitGame;

    @FXML
    private Button btnNewGame;

    @FXML
    private Button btnLoadGame;

    public void initialize() {
        try {
            Font.loadFont(new FileInputStream("src/main/resources/com/ihm/zoofx/fonts/Tytoon_Mist.ttf"), 10);
            imgBackground.setImage(new Image(String.valueOf(ZooGameController.class.getResource("img/background.jpg"))));
            imgBackground.setEffect(new GaussianBlur(15));
            imgTitleScreen.setImage(new Image(String.valueOf(ZooGameController.class.getResource("img/title-screen.png"))));
            Image sign = new Image(String.valueOf(ZooGameController.class.getResource("img/background-sign.png")));
            imgNewGame.setImage(ImageTools.getSubImage(sign, 41,33,220,91));
            imgLoadGame.setImage(ImageTools.getSubImage(sign, 41,142,219,85));
            imgQuitGame.setImage(ImageTools.getSubImage(sign, 41,142,219,85));
            imgQuitGame.setRotate(180);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @FXML
    protected void onQuitClick() {
        System.exit(0);
    }
}