package Controllers;

import Entidades.Recetas;
import UtilidadesEntidades.ImageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PedidosController extends GenericController{

    public Label precioPizza;
    public Label precioHamburguesa;
    public Label precioCola;
    public Label precioCesar;
    public Label precioPollo;
    public Label precioAgua;
    public Label precioCoctel;
    public Label precioBacon;
    public ListView Pedido;
    private double pizzaF;
    private double hamburguesaF;
    private double colaF;
    private double cesarF;
    private double polloF;
    private double aguaF;
    private double coctelF;
    private double baconF;
    @FXML
    private Spinner<Integer> pizza;

    @FXML
    private Spinner<Integer> hamburguesa;

    @FXML
    private Spinner<Integer> cola;

    @FXML
    private Spinner<Integer> cesar;

    @FXML
    private Spinner<Integer> pollo;

    @FXML
    private Spinner<Integer> agua;

    @FXML
    private Spinner<Integer> coctel;

    @FXML
    private Spinner<Integer> bacon;

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
    private void convertirPrecios() {
        if (precioPizza != null) {
            String pizzat = precioPizza.getText();
            pizzaF = Double.parseDouble(pizzat.substring(0, pizzat.length() - 1));
        }
        if (precioHamburguesa != null) {
            String hamburguesat = precioHamburguesa.getText();
            hamburguesaF = Double.parseDouble(hamburguesat.substring(0, hamburguesat.length() - 1));
        }
        if (precioCola != null) {
            String colat = precioCola.getText();
            colaF = Double.parseDouble(colat.substring(0, colat.length() - 1));
        }
        if (precioCesar != null) {
            String cesart = precioCesar.getText();
            cesarF = Double.parseDouble(cesart.substring(0, cesart.length() - 1));
        }
        if (precioPollo != null) {
            String pollot = precioPollo.getText();
            polloF = Double.parseDouble(pollot.substring(0, pollot.length() - 1));
        }
        if (precioAgua != null) {
            String aguat = precioAgua.getText();
            aguaF = Double.parseDouble(aguat.substring(0, aguat.length() - 1));
        }
        if (precioCoctel != null) {
            String coctelt = precioCoctel.getText();
            coctelF = Double.parseDouble(coctelt.substring(0, coctelt.length() - 1));
        }
        if (precioBacon != null) {
            String bacontelt = precioBacon.getText();
            baconF = Double.parseDouble(bacontelt.substring(0, bacontelt.length() - 1));
        }
    }

    public void initialize() {
        List<Spinner<Integer>> spinners = new ArrayList<>();
        spinners.add(pizza);
        spinners.add(hamburguesa);
        spinners.add(cola);
        spinners.add(cesar);
        spinners.add(pollo);
        spinners.add(agua);
        spinners.add(coctel);
        spinners.add(bacon);

        File file = new File("src/main/resources/Fotos/pizza-margarita.jpg");
        Image image1=new Image(file.toURI().toString());
        imageView1.setImage(image1);
        imageView1.setFitHeight(100);
        imageView1.setFitWidth(100);

        File file2 = new File("src/main/resources/Fotos/istockphoto-520215281-612x612.jpg");
        Image image2=new Image(file2.toURI().toString());
        imageView2.setImage(image2);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        File file3 = new File("src/main/resources/Fotos/cocacola.jpeg");
        Image image3=new Image(file3.toURI().toString());
        imageView3.setImage(image3);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(100);

        File file4 = new File("src/main/resources/Fotos/cesar.jpeg");
        Image image4=new Image(file4.toURI().toString());
        imageView4.setImage(image4);
        imageView4.setFitHeight(100);
        imageView4.setFitWidth(100);

        File file5 = new File("src/main/resources/Fotos/pollo.jpeg");
        Image image5=new Image(file5.toURI().toString());
        imageView5.setImage(image5);
        imageView5.setFitHeight(100);
        imageView5.setFitWidth(100);

        File file6 = new File("src/main/resources/Fotos/agua.jpeg");
        Image image6=new Image(file6.toURI().toString());
        imageView6.setImage(image6);
        imageView6.setFitHeight(100);
        imageView6.setFitWidth(100);

        File file7 = new File("src/main/resources/Fotos/aguavalencia.png");
        Image image7=new Image(file7.toURI().toString());
        imageView7.setImage(image7);
        imageView7.setFitHeight(100);
        imageView7.setFitWidth(100);

        File file8 = new File("src/main/resources/Fotos/bacon_cheese_fries.png");
        Image image8=new Image(file8.toURI().toString());
        imageView8.setImage(image8);
        imageView8.setFitHeight(100);
        imageView8.setFitWidth(100);





        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        }
        convertirPrecios();
    }

    public void handleGenerarRecibo(ActionEvent actionEvent) {
        
        
        
    }

    public void onAnhadirProd(ActionEvent actionEvent) {
        List<Recetas> productosSeleccionados = new ArrayList<>();
        productosSeleccionados.add(new Recetas(pizza.getValue(),pizzaF));
        productosSeleccionados.add(new Recetas( hamburguesa.getValue(),hamburguesaF));
        productosSeleccionados.add(new Recetas(cola.getValue(),colaF));
        productosSeleccionados.add(new Recetas(cesar.getValue(),cesarF));
        productosSeleccionados.add(new Recetas(pollo.getValue(),polloF));
        productosSeleccionados.add(new Recetas(agua.getValue(),aguaF));
        productosSeleccionados.add(new Recetas(coctel.getValue(),coctelF));
        productosSeleccionados.add(new Recetas(bacon.getValue(),baconF));


        List<Recetas> productosFiltrados = new ArrayList<>();
        for (Recetas producto : productosSeleccionados) {
            if (producto.getCantidad() > 0) {
                productosFiltrados.add(producto);
            }
        }
        System.out.println(productosFiltrados);

    }
}