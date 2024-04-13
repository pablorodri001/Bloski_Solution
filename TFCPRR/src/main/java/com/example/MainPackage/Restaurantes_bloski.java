package com.example.MainPackage;

import Controllers.GenericController;
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
        FXMLLoader fxmlLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("MainScene.fxml"));
        Parent mainLoader=fxmlLoader.load();


        Scene mainscene = new Scene(mainLoader, 600, 600);
        SceneHandler sceneHandler=new SceneHandler(stage);
        sceneHandler.addScene(SceneHandler.Main_Scene,mainscene);

        HashMap<String, GenericController> controllers=new HashMap<>();

        controllers.put(sceneHandler.Main_Scene,fxmlLoader.getController());
        controllers.values().forEach(genericController->genericController.setSceneHandler(sceneHandler));

        stage.setTitle("Restaurante Bloski's");
        stage.setScene(mainscene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}