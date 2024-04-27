package Controllers;

import Entidades.Inventario;
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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecetasController extends GenericController implements Initializable {
    @FXML
    private TableView<Inventario> inventarioTable;

    @FXML
    private TableColumn<Inventario, Integer> idProductoColumn;

    @FXML
    private TableColumn<Inventario, Integer> restauranteColumn;

    @FXML
    private TableColumn<Inventario, String> nombreColumn;
    @FXML
    private TableColumn<Inventario,String> descripcionColumn;

    @FXML
    private TableColumn<Inventario, Integer> cantidadColumn;

    @FXML
    private TableColumn<Inventario, Double> precioUnitarioColumn;


    ObservableList<Inventario> listaInventario= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idProductoColumn.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("idProducto"));
        restauranteColumn.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("restaurante"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Inventario,String>("nombre"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<Inventario,String>("Descripcion"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<Inventario,Integer>("cantidad"));
        precioUnitarioColumn.setCellValueFactory(new PropertyValueFactory<Inventario,Double>("precioUnitario"));
        listaInventario = FXCollections.observableArrayList();

        inventarioTable.setRowFactory(tv -> {
            TableRow<Inventario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    Inventario inventario = row.getItem();
                    if (inventario != null) {
                        mostrarDescripcion(inventario.getDescripcion());
                    }
                }
            });
            return row;
        });
    }

    @FXML
    public void verDatos(){
        listaInventario.clear();
        List<Inventario> lista2Inventario= HibernateUtil.rellenarInventario();
        for(Inventario i:lista2Inventario){
            listaInventario.add(i);
            inventarioTable.setItems(listaInventario);
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

