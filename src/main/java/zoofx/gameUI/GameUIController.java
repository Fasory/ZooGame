package zoofx.gameUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tools.ImageTools;
import zoofx.AbstractController;
import zoofx.ZooGame;
import zoofx.model.Build;
import zoofx.model.Section;
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
    private VBox boxBottomButton;

    @FXML
    private HBox infoBox;

    @FXML
    private BorderPane boxSelectBuild;

    @FXML
    private Button btnLeftSelectBuild;

    @FXML
    private Button btnRightSelectBuild;

    @FXML
    private HBox menuSelectBuild;

    private Section current = null;

    private int cursor;

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

    private void hideBox(boolean hide) {
        boxSelectBuild.setVisible(!hide);
    }

    private void hideArrow(boolean hide) {
        btnLeftSelectBuild.setVisible(!hide);
        btnRightSelectBuild.setVisible(!hide);
    }

    private void loadSelectBuild(Section section) {
        loadSelectBuild(section, 0);
    }

    private void loadSelectBuild(Section section, int target) {
        menuSelectBuild.getChildren().clear();
        cursor = target;
        int max = Math.min(section.getBuilds().length, cursor*4+4);
        if (section.getBuilds().length > 4) {
            hideArrow(false);
            if (cursor == 0) {
                btnLeftSelectBuild.setDisable(true);
                btnRightSelectBuild.setDisable(false);
            } else if (cursor*4+4 >= section.getBuilds().length) {
                btnLeftSelectBuild.setDisable(false);
                btnRightSelectBuild.setDisable(true);
            } else {
                btnLeftSelectBuild.setDisable(false);
                btnRightSelectBuild.setDisable(false);
            }
        } else {
            hideArrow(true);
        }
        ToggleGroup buildGroup = new ToggleGroup();
        for (int i = cursor*4; i < max; i++) {
            Build build = section.getBuilds()[i];
            BorderPane content = new BorderPane();
            VBox top = new VBox(new Label(build.getName()), new Separator());
            top.setAlignment(Pos.CENTER);
            content.setTop(top);
            BorderPane.setAlignment(top, Pos.TOP_CENTER);
            VBox center = new VBox(new Label("[img]"));
            center.setAlignment(Pos.CENTER);
            content.setCenter(center);
            BorderPane.setAlignment(center, Pos.CENTER);
            VBox bottom = new VBox(new Separator(), new Label(build.getCost() + " $"));
            bottom.setAlignment(Pos.CENTER);
            content.setBottom(bottom);
            BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
            ToggleButton btn = new ToggleButton();
            btn.setPadding(new Insets(0));
            btn.setGraphic(content);
            btn.setPrefSize((boxSelectBuild.getWidth()-300)/4, boxSelectBuild.getHeight()-50);
            buildGroup.getToggles().add(btn);
            menuSelectBuild.getChildren().add(btn);
        }
    }

    @FXML
    public void onSwitchLeftClick() {
        loadSelectBuild(current, cursor-1);
    }

    @FXML
    public void onSwitchRightClick() {
        loadSelectBuild(current, cursor+1);
    }

    @FXML
    public void onEscavatorClick() {
        if (current != null) {
            hideBox(true);
            current = null;
        }
    }

    @FXML
    public void onWayClick() {
        if (current == Section.WAY && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.WAY;
            loadSelectBuild(current);
        }
    }

    @FXML
    public void onAnimalsClick() {
        if (current == Section.ANIMALS && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.ANIMALS;
            loadSelectBuild(current);
        }
    }

    @FXML
    public void onBuildClick() {
        if (current == Section.BUILD && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.BUILD;
            loadSelectBuild(current);
        }
    }

    @FXML
    public void onFlashClick() {
        if (current == Section.FLASH && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.FLASH;
            loadSelectBuild(current);
        }
    }

    @FXML
    public void onWaterClick() {
        if (current == Section.WATER && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.WATER;
            loadSelectBuild(current);
        }
    }

    @FXML
    public void onTreeClick() {
        if (current == Section.TREE && boxSelectBuild.isVisible()) {
            hideBox(true);
            current = null;
        }
        else{
            if (!boxSelectBuild.isVisible()) hideBox(false);
            current = Section.TREE;
            loadSelectBuild(current);
        }
    }
}
