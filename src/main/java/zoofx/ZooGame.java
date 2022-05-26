package zoofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import zoofx.model.FullScene;
import zoofx.model.Save;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class ZooGame extends Application {

    public final static Image BACKGROUND = new Image(String.valueOf(ZooGame.class.getResource("img/background.jpg")));
    public final static Image TITLE = new Image(String.valueOf(ZooGame.class.getResource("img/title-screen.png")));
    public final static Image SIGN = new Image(String.valueOf(ZooGame.class.getResource("img/background-sign.png")));
    private static Stack<FullScene> stackScene = new Stack<>();
    public final static int MAX_SAVE = 4;
    private static ArrayList<Save> list_save = new ArrayList<>(MAX_SAVE);

    @Override
    public void start(Stage stage) throws IOException {
        // load save
        for (int i = 0; i < MAX_SAVE; i++) {
            list_save.add(null);
        }
        // load interface
        Font.loadFont(new FileInputStream("src/main/resources/zoofx/fonts/Tytoon_Mist.ttf"), 10);
        stage.getIcons().add(new Image(String.valueOf(ZooGame.class.getResource("img/icone.png"))));
        stage.setTitle("ZooGame");
        loadView("layouts/main-view.fxml", stage);
        stage.setWidth(1600);
        stage.setHeight(900);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadView(String path, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooGame.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load());                                              // résolution 16:9
        AbstractController controller = ((AbstractController)fxmlLoader.getController());
        controller.setStage(stage);
        stage.setScene(scene);
        stackScene.push(new FullScene(scene, controller));
    }

    public static void loadLastView(Stage stage) {
        stackScene.pop();
        stage.setScene(stackScene.peek().getScene());
    }

    public static void loadOldView(int back, Stage stage) {
        for (int i = 0; i < back; i++)
            stackScene.pop();
        stage.setScene(stackScene.peek().getScene());
    }

    public static void loadViewWithRollback(int rollback, String path, Stage stage) throws IOException {
        for (int i = 0; i < rollback; i++)
            stackScene.pop();
        loadView(path, stage);
    }

    public static Save getSave(int n) {
        return list_save.get(n);
    }

    public static void replaceSave(int n, Save save) {
        list_save.set(n, save);
    }

    public static FullScene getLastFullScenne() {
        return stackScene.peek();
    }
}