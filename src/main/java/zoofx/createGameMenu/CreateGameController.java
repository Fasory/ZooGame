package zoofx.createGameMenu;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;

import java.io.IOException;

public class CreateGameController extends AbstractController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgBackgroundOption;

    @FXML
    private ImageView imgBack;

    @FXML
    private VBox boxBack;

    @FXML
    private VBox mainBox;

    public void initialize() {
        try {
            imgBackground.setImage(ZooGame.BACKGROUND);
            imgBackground.setEffect(new GaussianBlur(15));
            imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
            imgBackgroundOption.setRotate(180);
            imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,33,220,91));
            ((StackPane)boxBack.getParent()).setAlignment(boxBack, Pos.BOTTOM_CENTER);
            ((StackPane)mainBox.getParent()).setAlignment(mainBox, Pos.CENTER);
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
