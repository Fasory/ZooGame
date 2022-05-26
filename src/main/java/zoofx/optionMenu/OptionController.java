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

public class OptionController extends AbstractController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgBack;

    @FXML
    private ChoiceBox cbResolution;

    @FXML
    private VBox boxBack;

    public void initialize() {
        try {
            imgBackground.setImage(ZooGame.BACKGROUND);
            imgBackground.setEffect(new GaussianBlur(15));
            imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            ((StackPane)boxBack.getParent()).setAlignment(boxBack, Pos.BOTTOM_CENTER);
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
}
