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
        Usuarios usuario = obtenerUsuarioDesdeCampo(campoUsuario.getText()); // Método para obtener el usuario desde el nombre
        Date fecha = localDateToDate(campoFecha.getValue());
        String turno = campoTurno.getText();
        String descripcion = campoDescripcion.getText();

        Turnos nuevoTurno = new Turnos(usuario, fecha, turno, descripcion);
        HibernateUtil.guardarTurno(nuevoTurno); // Método para guardar el nuevo turno en la base de datos

        // Cerrar la ventana
        Stage stage = (Stage) campoUsuario.getScene().getWindow();
        stage.close();
    }

    private Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Usuarios obtenerUsuarioDesdeCampo(String nombreUsuario) {
        // Aquí debes implementar la lógica para obtener el objeto Usuarios desde el nombre de usuario
        // Podrías hacer una consulta a la base de datos para buscar el usuario por su nombre
        // Si no existe, deberías crear y guardar el nuevo usuario.
        Usuarios usuario = HibernateUtil.buscarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            usuario = new Usuarios();
            usuario.setNombreUsuario(nombreUsuario);

        }
        return usuario;
    }
}
