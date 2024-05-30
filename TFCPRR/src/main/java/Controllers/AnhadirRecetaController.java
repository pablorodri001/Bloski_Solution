package Controllers;

import Entidades.Productos;
import Entidades.Restaurante;
import UtilidadesEntidades.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnhadirRecetaController {
    @FXML
    private TextField campoIdProducto;
    @FXML
    private TextField campoRestaurante;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoDescripcion;
    @FXML
    private TextField campoCantidad;
    @FXML
    private TextField campoPrecioUnitario;

    public void setInitialId(int id) {
        campoIdProducto.setText(String.valueOf(id));
    }

    @FXML
    private void añadirReceta() {
        int idProducto = Integer.parseInt(campoIdProducto.getText());
        Restaurante restaurante = new Restaurante(campoRestaurante.getText());
        String nombre = campoNombre.getText();
        String descripcion = campoDescripcion.getText();
        int cantidad = Integer.parseInt(campoCantidad.getText());
        double precioUnitario = Double.parseDouble(campoPrecioUnitario.getText());

        Productos receta = new Productos(restaurante, nombre, descripcion, cantidad, precioUnitario);

        HibernateUtil.guardarReceta(receta);

        Stage stage = (Stage) campoIdProducto.getScene().getWindow();
        stage.close();
    }
}
