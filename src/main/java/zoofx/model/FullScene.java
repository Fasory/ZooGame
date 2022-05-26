package zoofx.model;

import javafx.scene.Scene;
import zoofx.AbstractController;

public class FullScene {
    private final Scene scene;

    public Scene getScene() {
        return scene;
    }

    public AbstractController getController() {
        return controller;
    }

    private final AbstractController controller;

    public FullScene(Scene scene, AbstractController controller) {
        this.scene = scene;
        this.controller = controller;
    }


}
