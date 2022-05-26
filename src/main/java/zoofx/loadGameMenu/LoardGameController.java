package zoofx.loadGameMenu;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;

import java.io.IOException;

public class LoardGameController extends AbstractController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgBackgroundOption;

    @FXML
    private ImageView imgBack;

    @FXML
    private VBox boxBack;

    @FXML
    private Button save1;

    @FXML
    private Button save2;

    @FXML
    private Button save3;

    @FXML
    private Button save4;

    public void initialize() {
        try {
            imgBackground.setImage(ZooGame.BACKGROUND);
            imgBackground.setEffect(new GaussianBlur(15));
            imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
            imgBackgroundOption.setRotate(180);
            imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            ((StackPane)boxBack.getParent()).setAlignment(boxBack, Pos.BOTTOM_CENTER);
            if (ZooGame.getSave(0) == null) save1.setDisable(true);
            if (ZooGame.getSave(1) == null) save2.setDisable(true);
            if (ZooGame.getSave(2) == null) save3.setDisable(true);
            if (ZooGame.getSave(3) == null) save4.setDisable(true);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @FXML
    public void onOptionClick() throws IOException {
        ZooGame.loadView("layouts/option-view.fxml", stage);
    }

    @FXML
    public void onBackClick() {
        ZooGame.loadLastView(stage);
    }
}
