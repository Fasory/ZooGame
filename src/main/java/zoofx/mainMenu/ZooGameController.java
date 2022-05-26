package zoofx.mainMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import tools.ImageTools;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import zoofx.AbstractController;
import zoofx.ZooGame;

import java.io.FileInputStream;
import java.io.IOException;

public class ZooGameController extends AbstractController {

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
    private ImageView imgBackgroundOption;

    public void initialize() {
        imgBackground.setImage(ZooGame.BACKGROUND);
        imgBackground.setEffect(new GaussianBlur(15));
        imgTitleScreen.setImage(ZooGame.TITLE);
        imgNewGame.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,33,220,91));
        imgLoadGame.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
        imgQuitGame.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
        imgQuitGame.setRotate(180);
        imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
        imgBackgroundOption.setRotate(180);
    }

    @FXML
    protected void onQuitClick() {
        closeApp();
    }

    @FXML
    protected void onNewGameClick() throws IOException {
        ZooGame.loadView("layouts/create-game-view.fxml", stage);
    }

    @FXML
    protected void onLoadGameClick() throws IOException {
        ZooGame.loadView("layouts/load-game-view.fxml", stage);
    }

    @FXML
    protected void onOptionClick() throws IOException {
        ZooGame.loadView("layouts/option-view.fxml", stage);
    }
}