package Controllers;

import com.example.MainPackage.SceneHandler;
import javafx.event.ActionEvent;

public class MenuController extends GenericController {

    public void onRecetas(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Recetas_Scene);
    }
}
