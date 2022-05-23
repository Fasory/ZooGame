package com.ihm.zoofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class ZooGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooGame.class.getResource("layouts/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 900);                                              // résolution 16:9
        stage.getIcons().add(new Image(String.valueOf(ZooGame.class.getResource("img/icone.png"))));
        stage.setTitle("ZooGame");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}