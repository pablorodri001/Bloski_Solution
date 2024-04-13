package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Restaurante_BloskiController extends GenericController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onConsultarHorariosClick(ActionEvent actionEvent) {
    }

    public void onConsultarInventarioClick(ActionEvent actionEvent) {
    }
}