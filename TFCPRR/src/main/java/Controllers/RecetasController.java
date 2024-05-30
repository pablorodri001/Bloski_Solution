package Controllers;

import Entidades.Productos;
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
    private TableView<Productos> inventarioTable;

    @FXML
    private TableColumn<Productos, Integer> idProductoColumn;

    @FXML
    private TableColumn<Productos, String> restauranteColumn;

    @FXML
    private TableColumn<Productos, String> nombreColumn;

    @FXML
    private TableColumn<Productos, String> descripcionColumn;

    @FXML
    private TableColumn<Productos, Integer> cantidadColumn;

    @FXML
    private TableColumn<Productos, Double> precioUnitarioColumn;

    private ObservableList<Productos> listaRecetas = FXCollections.observableArrayList();

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
            TableRow<Productos> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Productos productos = row.getItem();
                    if (productos != null) {
                        mostrarDescripcion(productos.getDescripcion());
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
        List<Productos> lista2Recetas = HibernateUtil.rellenarInventario();
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
            FXMLLoader loader = new FXMLLoader(Restaurantes_bloski.class.getResource("Anhadir.fxml"));
            Parent root = loader.load();
            AnhadirRecetaController controller = loader.getController();

            int nextId = listaRecetas.isEmpty() ? 1 : listaRecetas.get(listaRecetas.size() - 1).getIdProducto() + 1;
            controller.setInitialId(nextId);
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
