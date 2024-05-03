package Controllers;

import Entidades.Inventario;
import Entidades.Turnos;
import UtilidadesEntidades.HibernateUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TurnosController extends GenericController implements Initializable {
    @FXML
    private TableView<Turnos> turnosTable;
    @FXML
    private TableColumn<Turnos, Integer> idTurnoColumn;
    @FXML
    private TableColumn<Turnos, Integer> restauranteColumn;
    @FXML
    private TableColumn<Turnos, Date> fechaColumn;
    @FXML
    private TableColumn<Turnos, Integer> idEmpleadoColumn;
    @FXML
    private TableColumn<Turnos, String> turnoColumn;
    @FXML
    private TableColumn<Turnos, String> descripcionColumn;

    ObservableList<Turnos> listaTurnos= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idTurnoColumn.setCellValueFactory(new PropertyValueFactory<Turnos,Integer>("idTurno"));
        restauranteColumn.setCellValueFactory(new PropertyValueFactory<Turnos,Integer>("restaurante"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<Turnos,Date>("fecha"));
        idEmpleadoColumn.setCellValueFactory(new PropertyValueFactory<Turnos,Integer>("idEmpleado"));
        turnoColumn.setCellValueFactory(new PropertyValueFactory<Turnos,String>("turno"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<Turnos,String>("descripcion"));
    }
    @FXML
    public void verDatos(){
        listaTurnos.clear();
        List<Turnos> lista2Turnos= HibernateUtil.rellenarTurno();
        for(Turnos i:lista2Turnos){
            listaTurnos.add(i);
            turnosTable.setItems(listaTurnos);
        }
    }
}

