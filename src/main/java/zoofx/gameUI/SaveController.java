package zoofx.gameUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;

public class SaveController extends AbstractController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private ImageView imgBack;

    @FXML
    private HBox boxBack;

    @FXML
    private ImageView imgConfirm;

    @FXML
    private ToggleGroup groupSave;

    @FXML
    private Button btnConfirm;

    public void initialize() {
        imgBackground.setImage(ZooGame.BACKGROUND);
        imgBackground.setEffect(new GaussianBlur(15));
        imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
        imgConfirm.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
        imgConfirm.setRotate(180);
        ((StackPane)boxBack.getParent()).setAlignment(boxBack, Pos.BOTTOM_CENTER);
        groupSave.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (groupSave.getSelectedToggle() != null) {
                    btnConfirm.setDisable(false);
                } else {
                    btnConfirm.setDisable(true);
                }
            }
        });
    }

    @FXML
    public void onBackClick() {
        ZooGame.loadLastView(stage);
    }

    @FXML
    public void onConfirmClick() {
        // TO DO to save...
        ZooGame.loadOldView(2, stage);
    }
}
