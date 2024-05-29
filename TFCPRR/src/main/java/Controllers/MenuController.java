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

        String[] imagePaths = {
                "Fotos/restaurante1.jpeg",
                "Fotos/restaurante2.jpeg",
                "Fotos/restaurante3.jpeg",
                "Fotos/restaurante4.jpeg",
                "Fotos/restaurante5.jpeg",
                "Fotos/restaurante6.jpeg"
        };

        for (String relativePath : imagePaths) {
            try {
                String normalizedPath = getClass().getResource("/" + relativePath).toExternalForm();
                Image image = new Image(normalizedPath);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(imageHeight);
                imageView.setFitWidth(imageWidth);
                imageView.setPreserveRatio(true);
                images.add(imageView);
            } catch (Exception e) {
                System.err.println("No se pudo cargar la imagen en la ruta: " + relativePath);
                e.printStackTrace();
            }
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
