package zoofx.gameUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;
import zoofx.optionMenu.OptionController;

import java.io.IOException;

public class GameUIController extends AbstractController {

    @FXML
    private ImageView imgBackgroundOption;

    public void initialize() {
        imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
        imgBackgroundOption.setRotate(180);
    }

    @FXML
    public void onOptionClick() throws IOException {
        ZooGame.loadView("layouts/option-view.fxml", stage);
        ((OptionController)ZooGame.getLastFullScenne().getController()).modeInGame();
    }
}
