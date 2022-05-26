package zoofx.gameUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;
import zoofx.optionMenu.OptionController;

import java.io.IOException;

public class GameUIController extends AbstractController {

    @FXML
    private ImageView imgBackgroundOption;

    @FXML
    private ImageView imgTopInfo;

    @FXML
    private StackPane boxTopInfo;

    @FXML
    private ImageView imgBottomButton;

    @FXML
    private StackPane boxBottomButton;

    @FXML
    private HBox infoBox;


    public void initialize() {
        imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
        imgBackgroundOption.setRotate(180);
        imgTopInfo.setImage(ImageTools.getSubImage(ZooGame.LONGSIGN, 3,3,696,72));
        imgTopInfo.setRotate(180);
        ((StackPane)boxTopInfo.getParent()).setAlignment(boxTopInfo, Pos.TOP_LEFT);
        imgBottomButton.setImage(ImageTools.getSubImage(ZooGame.LONGSIGN, 3,3,696,72));
        imgBottomButton.setScaleX(1.5);
        ((StackPane)boxBottomButton.getParent()).setAlignment(boxBottomButton, Pos.BOTTOM_RIGHT);
        ((StackPane)infoBox.getParent()).setAlignment(infoBox, Pos.CENTER_LEFT);
    }

    @FXML
    public void onOptionClick() throws IOException {
        ZooGame.loadView("layouts/option-view.fxml", stage);
        ((OptionController)ZooGame.getLastFullScenne().getController()).modeInGame();
    }
}
