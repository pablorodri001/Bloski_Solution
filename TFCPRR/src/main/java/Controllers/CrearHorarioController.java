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
import java.util.Date;

public class CrearHorarioController {

    @FXML
    private TextField campoUsuario;
    @FXML
    private DatePicker campoFecha;
    @FXML
    private TextField campoTurno;
    @FXML
    private TextField campoDescripcion;

    @FXML
    private void guardarNuevoHorario() {
        Usuarios usuario = obtenerUsuarioDesdeCampo(campoUsuario.getText());
        Date fecha = localDateToDate(campoFecha.getValue());
        String turno = campoTurno.getText();
        String descripcion = campoDescripcion.getText();

        Turnos nuevoTurno = new Turnos(usuario, fecha, turno, descripcion);
        HibernateUtil.guardarTurno(nuevoTurno);

        Stage stage = (Stage) campoUsuario.getScene().getWindow();
        stage.close();
    }

    private Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Usuarios obtenerUsuarioDesdeCampo(String nombreUsuario) {
        Usuarios usuario = HibernateUtil.buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            usuario = new Usuarios();
            usuario.setNombreUsuario(nombreUsuario);

        }
        return usuario;
    }
}
