package Controllers;

import UtilidadesEntidades.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Entidades.Usuarios;

public class LoginController extends GenericController {

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtNuevoNombreUsuario;

    @FXML
    private PasswordField txtNuevaContrasena;



    @FXML
    public void onIniciarSesionClick(ActionEvent actionEvent) {
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasena = txtContrasena.getText();

        Usuarios usuario = HibernateUtil.obtenerUsuarioPorNombreYContrasena(nombreUsuario, contrasena);

        if (usuario != null) {

            System.out.println("¡Inicio de sesión exitoso!");

        } else {
            System.out.println("Credenciales incorrectas");

        }
    }

    @FXML
    public void onRegistrarseClick(ActionEvent actionEvent) {
        String nuevoNombreUsuario = txtNuevoNombreUsuario.getText();
        String nuevaContrasena = txtNuevaContrasena.getText();

        Usuarios nuevoUsuario = new Usuarios(nuevoNombreUsuario, nuevaContrasena);

        boolean registroExitoso = HibernateUtil.insertarUsuario(nuevoUsuario);

        if (registroExitoso) {
            System.out.println("¡Registro exitoso!");

        } else {
            System.out.println("Error al registrar usuario");

        }
    }
}
