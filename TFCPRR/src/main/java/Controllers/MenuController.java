package Controllers;

import com.example.MainPackage.SceneHandler;
import javafx.event.ActionEvent;

public class MenuController extends GenericController {

    private RecetasController recetasController;
    private TurnosController turnosController;


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

    public void setTurnosController(TurnosController turnosController) {
        this.turnosController=turnosController;
    }

    public void onTurnos(ActionEvent actionEvent) {
        this.sceneHandler.changeToScene(SceneHandler.Turnos_Scene);
    }
}
