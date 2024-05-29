package Controllers;

import Entidades.Turnos;
import Entidades.Usuarios;
import UtilidadesEntidades.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.ZoneId;

public class ModificarTurnoController {
    @FXML
    private TextField campoUsuario;
    @FXML
    private DatePicker campoFecha;
    @FXML
    private TextField campoTurno;
    @FXML
    private TextField campoDescripcion;
    int idTurno;
    Usuarios usuario;
    private Turnos turno;

    public void initData(Turnos turno) {
        this.turno = turno;
        campoUsuario.setText(turno.getUsuario().getNombreUsuario());
        campoFecha.setValue(dateToLocalDate(turno.getFecha()));
        campoTurno.setText(turno.getTurno());
        campoDescripcion.setText(turno.getDescripcion());
        idTurno = turno.getIdTurno();
        usuario = turno.getUsuario();
    }

    @FXML
    private void guardarCambios() {
        HibernateUtil.modificarTurno(idTurno, usuario, localDateToDate(campoFecha.getValue()), campoTurno.getText(), campoDescripcion.getText());

        Stage stage = (Stage) campoUsuario.getScene().getWindow();
        stage.close();
    }

    private LocalDate dateToLocalDate(java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private java.util.Date localDateToDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
