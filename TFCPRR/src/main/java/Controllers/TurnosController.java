package Controllers;

import Entidades.Turnos;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class TurnosController extends GenericController{
    @FXML
    private TableView<Turnos> turnosTable;
    @FXML
    private TableColumn<Turnos, Integer> idTurnoColumn;
    @FXML
    private TableColumn<Turnos, String> restauranteColumn;
    @FXML
    private TableColumn<Turnos, Date> fechaColumn;
    @FXML
    private TableColumn<Turnos, Integer> idEmpleadoColumn;
    @FXML
    private TableColumn<Turnos, String> turnoColumn;
    @FXML
    private TableColumn<Turnos, String> descripcionColumn;

}
