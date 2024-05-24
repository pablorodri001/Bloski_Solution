package Controllers;

import Entidades.Recetas;
import UtilidadesEntidades.HibernateUtil;
import com.example.MainPackage.Restaurantes_bloski;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecetasController extends GenericController implements Initializable {

    @FXML
    private TableView<Recetas> inventarioTable;

    @FXML
    private TableColumn<Recetas, Integer> idProductoColumn;

    @FXML
    private TableColumn<Recetas, String> restauranteColumn;

    @FXML
    private TableColumn<Recetas, String> nombreColumn;

    @FXML
    private TableColumn<Recetas, String> descripcionColumn;

    @FXML
    private TableColumn<Recetas, Integer> cantidadColumn;

    @FXML
    private TableColumn<Recetas, Double> precioUnitarioColumn;

    private ObservableList<Recetas> listaRecetas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idProductoColumn.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        restauranteColumn.setCellValueFactory(new PropertyValueFactory<>("restaurante"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        precioUnitarioColumn.setCellValueFactory(new PropertyValueFactory<>("precioUnitario"));

        inventarioTable.setItems(listaRecetas);

        inventarioTable.setRowFactory(tv -> {
            TableRow<Recetas> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Recetas recetas = row.getItem();
                    if (recetas != null) {
                        mostrarDescripcion(recetas.getDescripcion());
                    }
                }
            });
            return row;
        });

        verDatos();
    }

    @FXML
    public void verDatos() {
        listaRecetas.clear();
        List<Recetas> lista2Recetas = HibernateUtil.rellenarInventario();
        listaRecetas.addAll(lista2Recetas);
    }

    private void mostrarDescripcion(String descripcion) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descripción del Producto");
        alert.setHeaderText(null);
        alert.setContentText(descripcion);
        alert.showAndWait();
    }

    @FXML
    public void onAñadirReceta(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(Restaurantes_bloski.class.getResource("AñadirReceta.fxml"));
            Parent root = loader.load();
            AnhadirRecetaController controller = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Añadir Receta");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            verDatos();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
