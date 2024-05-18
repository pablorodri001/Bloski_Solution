package UtilidadesEntidades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class ImageLoader {

    public static ImageView loadImage(String imagePath, double width, double height) {
        Image image = new Image(new File(imagePath).toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }
}
