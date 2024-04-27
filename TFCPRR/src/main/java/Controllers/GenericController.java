package Controllers;

import com.example.MainPackage.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GenericController {
    protected SceneHandler sceneHandler;



    public void setSceneHandler(SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
        System.out.println(this);
    }

    @FXML
    public void onMenuScene(ActionEvent actionEvent){

        this.sceneHandler.changeToScene(SceneHandler.Menu_Scene);

    }
}
