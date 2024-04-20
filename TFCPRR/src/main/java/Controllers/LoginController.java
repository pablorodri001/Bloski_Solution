package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Entidades.Usuarios;
import UtilidadesEntidades.UsuarioDAO;

public class LoginController extends GenericController {

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtNuevoNombreUsuario;

    @FXML
    private PasswordField txtNuevaContrasena;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML
    public void onIniciarSesionClick(ActionEvent actionEvent) {
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasena = txtContrasena.getText();

        Usuarios usuario = usuarioDAO.obtenerUsuarioPorNombreYContrasena(nombreUsuario, contrasena);

        if (usuario != null) {
            // Si el usuario existe, no hacemos nada
            System.out.println("¡Inicio de sesión exitoso!");
            // Puedes agregar aquí cualquier otra acción que desees
        } else {
            System.out.println("Credenciales incorrectas");
            // Puedes mostrar una alerta o mensaje al usuario aquí
        }
    }

    @FXML
    public void onRegistrarseClick(ActionEvent actionEvent) {
        String nuevoNombreUsuario = txtNuevoNombreUsuario.getText();
        String nuevaContrasena = txtNuevaContrasena.getText();

        Usuarios nuevoUsuario = new Usuarios(nuevoNombreUsuario, nuevaContrasena);

        boolean registroExitoso = usuarioDAO.insertarUsuario(nuevoUsuario);

        if (registroExitoso) {
            System.out.println("¡Registro exitoso!");
            // Puedes agregar aquí cualquier otra acción que desees
        } else {
            System.out.println("Error al registrar usuario");
            // Puedes mostrar una alerta o mensaje al usuario aquí
        }
    }
}
