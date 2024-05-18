package Controllers;

import UtilidadesEntidades.ImageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;

public class PedidosController extends GenericController{

    @FXML
    private Spinner<Integer> spinner1;

    @FXML
    private Spinner<Integer> spinner2;

    @FXML
    private Spinner<Integer> spinner3;

    @FXML
    private Spinner<Integer> spinner4;

    @FXML
    private Spinner<Integer> spinner5;

    @FXML
    private Spinner<Integer> spinner6;

    @FXML
    private Spinner<Integer> spinner7;

    @FXML
    private Spinner<Integer> spinner8;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView5;

    @FXML
    private ImageView imageView6;

    @FXML
    private ImageView imageView7;

    @FXML
    private ImageView imageView8;

    public void initialize() {
        List<Spinner<Integer>> spinners = new ArrayList<>();
        spinners.add(spinner1);
        spinners.add(spinner2);
        spinners.add(spinner3);
        spinners.add(spinner4);
        spinners.add(spinner5);
        spinners.add(spinner6);
        spinners.add(spinner7);
        spinners.add(spinner8);

        // Inicializar las imágenes
        imageView1.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/agua.jpeg", 100, 100).getImage());
        imageView2.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/agua valencia.png", 100, 100).getImage());
        imageView3.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/bacon_cheese_fries.png", 100, 100).getImage());
        imageView4.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/cesar.jpeg", 100, 100).getImage());
        imageView5.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/cocacola.jpeg", 100, 100).getImage());
        imageView6.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/espaguetis-con-tomate.jpg", 100, 100).getImage());
        imageView7.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/istockphoto-520215281-612x612.jpg", 100, 100).getImage());
        imageView8.setImage(ImageLoader.loadImage("/Users/pablorodriguezrodriguez/Desktop/TFCPRR-main 2/TFCPRR/src/main/resources/Fotos/pollo.jpeg", 100, 100).getImage());

        // Inicializar los spinners
        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
    }
}