package Controllers;

import com.example.MainPackage.SceneHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends GenericController implements Initializable {

    @FXML
    private ListView<ImageView> carouselListView;

    private ObservableList<ImageView> images;
    private int currentIndex = 0;

    private RecetasController recetasController;
    private TurnosController turnosController;
    private PedidosController pedidosController;

    double imageWidth = 450.0; // Ancho deseado para las imágenes
    double imageHeight = 400.0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCarouselImages();
        showCurrentImage();
    }

    private void loadCarouselImages() {
        images = FXCollections.observableArrayList();
        File file = new File("src/main/resources/Fotos/restaurante1.jpeg");
        Image image1 = new Image(file.toURI().toString());
        ImageView imagen1=new ImageView(image1);
        File file2 = new File("src/main/resources/Fotos/restaurante2.jpeg");
        Image image2 = new Image(file2.toURI().toString());
        ImageView imagen2 = new ImageView(image2);
        File file3 = new File("src/main/resources/Fotos/restaurante3.jpeg");
        Image image3 = new Image(file3.toURI().toString());
        ImageView imagen3 = new ImageView(image3);
        File file4 = new File("src/main/resources/Fotos/restaurante4.jpeg");
        Image image4 = new Image(file4.toURI().toString());
        ImageView imagen4 = new ImageView(image4);
        File file5 = new File("src/main/resources/Fotos/restaurante5.jpeg");
        Image image5 = new Image(file5.toURI().toString());
        ImageView imagen5 = new ImageView(image5);
        File file6 = new File("src/main/resources/Fotos/restaurante6.jpeg");
        Image image6 = new Image(file6.toURI().toString());
        ImageView imagen6 = new ImageView(image6);





        images.add(imagen1);
        images.add(imagen2);
        images.add(imagen3);
        images.add(imagen4);
        images.add(imagen5);
        images.add(imagen6);



        for (ImageView imageView : images) {
            imageView.setFitHeight(imageHeight);
            imageView.setFitWidth(imageWidth);
            imageView.setPreserveRatio(true);
        }
    }

    private void showCurrentImage() {
        if (!images.isEmpty()) {
            carouselListView.setItems(FXCollections.observableArrayList(images.get(currentIndex)));
        }
    }

    @FXML
    private void onNextImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex + 1) % images.size();
            showCurrentImage();
        }
    }

    @FXML
    private void onPreviousImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex - 1 + images.size()) % images.size();
            showCurrentImage();
        }
    }

    public void setRecetasController(RecetasController recetasController) {
        this.recetasController = recetasController;
    }
    public void setPedidosController(PedidosController pedidosController){
        this.pedidosController=pedidosController;
    }

    public void onRecetas(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Recetas_Scene);
        if (recetasController != null) {
            recetasController.verDatos();
        } else {
            System.out.println("RecetasController no ha sido inicializado");
        }
    }

    public void setTurnosController(TurnosController turnosController) {
        this.turnosController = turnosController;
    }

    public void onTurnos(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Turnos_Scene);
        if (turnosController != null) {
            turnosController.verDatos();
        }
    }

    public void onPedidos(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Pedidos_Scene);
    }

    public void onSalir(ActionEvent actionEvent) {
        System.exit(0);
    }
}
