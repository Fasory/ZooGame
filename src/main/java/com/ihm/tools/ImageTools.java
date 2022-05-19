package com.ihm.tools;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public abstract class ImageTools {

    public static Image getSubImage(Image img, int x, int y, int w, int h) {
        PixelReader reader = img.getPixelReader();
        WritableImage image = new WritableImage(reader, x, y, w, h);
        return image;
    }
}
