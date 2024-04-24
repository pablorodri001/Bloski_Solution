package com.example.MainPackage;

import Controllers.GenericController;
import com.example.MainPackage.SceneHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Restaurantes_bloski extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("MainScene.fxml"));
        FXMLLoader menuLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("Menu.fxml"));
        FXMLLoader recetasLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("Recetas.fxml"));

        Parent main = mainLoader.load();
        Parent menu = menuLoader.load();
        Parent recetas = recetasLoader.load();

        Scene mainScene = new Scene(main, 450, 265);
        Scene menuScene = new Scene(menu, 450, 265);
        Scene recetasScene = new Scene(recetas, 450, 265);

        SceneHandler sceneHandler = new SceneHandler(stage);
        sceneHandler.addScene(SceneHandler.Main_Scene, mainScene);
        sceneHandler.addScene(SceneHandler.Menu_Scene, menuScene);
        sceneHandler.addScene(SceneHandler.Recetas_Scene, recetasScene);

        HashMap<String, GenericController> controllers = new HashMap<>();
        controllers.put(SceneHandler.Main_Scene, mainLoader.getController());
        controllers.put(SceneHandler.Menu_Scene, menuLoader.getController());
        controllers.put(SceneHandler.Recetas_Scene, recetasLoader.getController());

        controllers.values().forEach(genericController -> genericController.setSceneHandler(sceneHandler));

        stage.setTitle("Restaurante Bloski's");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
