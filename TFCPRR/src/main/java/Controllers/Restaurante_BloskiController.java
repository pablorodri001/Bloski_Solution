package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Restaurante_BloskiController extends GenericController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}