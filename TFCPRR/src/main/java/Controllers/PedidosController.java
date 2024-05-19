package Controllers;

import UtilidadesEntidades.ImageLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
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
        File file = new File("/Users/pablorodriguezrodriguez/Desktop/aguavalencia.png");
        Image image1=new Image(file.toURI().toString());
        imageView1.setImage(image1);
        imageView1.setFitHeight(50);
        imageView1.setFitWidth(50);

        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
    }
}