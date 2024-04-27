package Controllers;

import com.example.MainPackage.SceneHandler;
import javafx.event.ActionEvent;

public class MenuController extends GenericController {

    private RecetasController recetasController;


    public void setRecetasController(RecetasController recetasController) {
        this.recetasController = recetasController;
    }

    public void onRecetas(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Recetas_Scene);
        if (recetasController != null) {
            recetasController.verDatos();
        } else {
            System.out.println("RecetasController no ha sido inicializado");
        }

    }
}
