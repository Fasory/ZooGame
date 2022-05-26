package zoofx.optionMenu;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;

import java.io.FileInputStream;
import java.io.IOException;

public class OptionController extends AbstractController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgBackToMenu;

    @FXML
    private ImageView imgSave;

    @FXML
    private ChoiceBox cbResolution;

    @FXML
    private HBox boxCompile;

    @FXML
    private VBox mainBox;

    @FXML
    private StackPane paneSave;

    @FXML
    private StackPane paneBackToMenu;

    public void initialize() {
        try {
            imgBackground.setImage(ZooGame.BACKGROUND);
            imgBackground.setEffect(new GaussianBlur(15));
            imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            imgSave.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            imgSave.setRotate(180);
            imgBackToMenu.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            imgBackToMenu.setScaleX(-1);
            ((StackPane)boxCompile.getParent()).setAlignment(boxCompile, Pos.BOTTOM_CENTER);
            ((StackPane)mainBox.getParent()).setAlignment(mainBox, Pos.CENTER);
            cbResolution.setBackground(new Background(new BackgroundImage(ImageTools.getSubImage(ZooGame.SIGN, 41,33,220,91), BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(100,50,true,false,false, false))));
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @FXML
    public void onBackClick() {
        ZooGame.loadLastView(stage);
    }

    @FXML
    public void onBackToMenuClick() {
        ZooGame.loadOldView(2, stage);
    }

    @FXML
    public void onSaveClick() throws IOException {
        ZooGame.loadView("layouts/save-view.fxml", stage);
    }

    @FXML
    public void modeInGame() {
        paneSave.setManaged(true);
        paneBackToMenu.setManaged(true);
        paneSave.setVisible(true);
        paneBackToMenu.setVisible(true);
    }
}
