package Controllers;

import Entidades.Recetas;
import UtilidadesEntidades.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecetasController extends GenericController implements Initializable {
    @FXML
    private TableView<Recetas> inventarioTable;

    @FXML
    private TableColumn<Recetas, Integer> idProductoColumn;

    @FXML
    private TableColumn<Recetas, Integer> restauranteColumn;

    @FXML
    private TableColumn<Recetas, String> nombreColumn;
    @FXML
    private TableColumn<Recetas,String> descripcionColumn;

    @FXML
    private TableColumn<Recetas, Integer> cantidadColumn;

    @FXML
    private TableColumn<Recetas, Double> precioUnitarioColumn;


    ObservableList<Recetas> listaRecetas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idProductoColumn.setCellValueFactory(new PropertyValueFactory<Recetas,Integer>("idProducto"));
        restauranteColumn.setCellValueFactory(new PropertyValueFactory<Recetas,Integer>("restaurante"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Recetas,String>("nombre"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<Recetas,String>("Descripcion"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<Recetas,Integer>("cantidad"));
        precioUnitarioColumn.setCellValueFactory(new PropertyValueFactory<Recetas,Double>("precioUnitario"));
        listaRecetas = FXCollections.observableArrayList();

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
    }

    @FXML
    public void verDatos(){
        listaRecetas.clear();
        List<Recetas> lista2Recetas = HibernateUtil.rellenarInventario();
        for(Recetas i: lista2Recetas){
            listaRecetas.add(i);
            inventarioTable.setItems(listaRecetas);
        }
    }
    private void mostrarDescripcion(String descripcion) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descripción del Producto");
        alert.setHeaderText(null);
        alert.setContentText(descripcion);
        alert.showAndWait();
    }



}

