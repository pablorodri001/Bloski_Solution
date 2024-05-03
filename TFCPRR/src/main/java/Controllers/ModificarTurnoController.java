package Controllers;
import Entidades.Restaurante;
import Entidades.Turnos;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class ModificarTurnoController {
    @FXML
    private TextField campoRestaurante;
    @FXML
    private DatePicker campoFecha;
    @FXML
    private TextField campoIdEmpleado;
    @FXML
    private TextField campoTurno;
    @FXML
    private TextField campoDescripcion;

    private Turnos turno;

    public void initData(Turnos turno) {
        this.turno = turno;
        campoRestaurante.setText(turno.getRestaurante().getNombre());

        campoFecha.setValue(dateToLocalDate(turno.getFecha()));
        campoIdEmpleado.setText(String.valueOf(turno.getIdEmpleado()));
        campoTurno.setText(turno.getTurno());
        campoDescripcion.setText(turno.getDescripcion());
    }

    // Método para guardar los cambios y cerrar la ventana
    @FXML
    private void guardarCambios() {

        turno.setRestaurante(new Restaurante(campoRestaurante.getText()));
        // Convertir LocalDate a Date
        turno.setFecha(localDateToDate(campoFecha.getValue()));
        turno.setIdEmpleado(Integer.parseInt(campoIdEmpleado.getText()));
        turno.setTurno(campoTurno.getText());
        turno.setDescripcion(campoDescripcion.getText());

        // Cerrar la ventana
        Stage stage = (Stage) campoRestaurante.getScene().getWindow();
        stage.close();
    }


    private LocalDate dateToLocalDate(java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    private java.util.Date localDateToDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}

