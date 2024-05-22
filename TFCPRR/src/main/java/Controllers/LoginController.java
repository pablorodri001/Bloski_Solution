package Controllers;

import UtilidadesEntidades.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
            onMenuScene(actionEvent);
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
            mostrarAlerta("Registro Exitoso", "El usuario ha sido registrado exitosamente.", AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error de Registro", "Ya existe un usuario con ese nombre.", AlertType.ERROR);
        }

        // Limpiar los campos de texto después de intentar registrar
        txtNuevoNombreUsuario.clear();
        txtNuevaContrasena.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje, AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
