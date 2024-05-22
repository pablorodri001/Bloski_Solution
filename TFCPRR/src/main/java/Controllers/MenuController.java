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

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends GenericController implements Initializable {

    @FXML
    private ListView<ImageView> carouselListView;

    private ObservableList<ImageView> images;
    private int currentIndex = 0;

    private RecetasController recetasController;
    private TurnosController turnosController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCarouselImages();
        showCurrentImage();
    }

    private void loadCarouselImages() {
        images = FXCollections.observableArrayList();

        // Load images
       /* images.add(new ImageView(new Image("/path/to/your/image1.jpg")));
        images.add(new ImageView(new Image("/path/to/your/image2.jpg")));
        images.add(new ImageView(new Image("/path/to/your/image3.jpg")));*/

        // Set image properties if needed
        for (ImageView imageView : images) {
            imageView.setFitHeight(400);
            imageView.setFitWidth(450);
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
