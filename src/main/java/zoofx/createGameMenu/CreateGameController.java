package zoofx.createGameMenu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    private ImageView imgStart;

    @FXML
    private HBox compileBox;

    @FXML
    private VBox mainBox;

    @FXML
    private TextField txtfName;

    @FXML
    private Button btnStart;

    private final static int LENGTH_MAX = 15;

    public void initialize() {
        try {
            imgBackground.setImage(ZooGame.BACKGROUND);
            imgBackground.setEffect(new GaussianBlur(15));
            imgBackgroundOption.setImage(ImageTools.getSubImage(ZooGame.SIGN, 310,288,100,70));
            imgBackgroundOption.setRotate(180);
            imgBack.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            imgStart.setImage(ImageTools.getSubImage(ZooGame.SIGN, 41,142,219,85));
            imgStart.setRotate(180);
            ((StackPane)compileBox.getParent()).setAlignment(compileBox, Pos.BOTTOM_CENTER);
            ((StackPane)mainBox.getParent()).setAlignment(mainBox, Pos.CENTER);
            txtfName.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                    if (txtfName.getText().equals(" ")) {
                        txtfName.setText("");
                    } else if (txtfName.getText().length() > LENGTH_MAX) {
                        String s = txtfName.getText().substring(0, LENGTH_MAX);
                        txtfName.setText(s);
                    }
                    if (txtfName.getText().length() > 0 && btnStart.isDisable()) btnStart.setDisable(false);
                    else if (txtfName.getText().length() == 0 && !btnStart.isDisable()) btnStart.setDisable(true);
                }
            });
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

    @FXML
    public void onStartClick() throws IOException {
        ZooGame.loadViewWithRollback(1, "layouts/game-view.fxml", stage);
    }
}
