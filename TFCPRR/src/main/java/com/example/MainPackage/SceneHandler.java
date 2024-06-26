package com.example.MainPackage;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneHandler {
    public static final String Main_Scene = "mainScene";
    public static final String Menu_Scene = "MenuScene";
    public static final String Recetas_Scene = "RecetasScene";
    public static final String Turnos_Scene = "Turnos_Scene";
    public static final String Pedidos_Scene = "Pedidos_Scene";

    private HashMap<String, Scene> scenes;
    private Stage stage;

    public SceneHandler(Stage stage) {
        this.scenes = new HashMap<>();
        this.stage = stage;
    }

    public void addScene(String sceneName, Scene scene) {
        this.scenes.put(sceneName, scene);
    }

    public void changeToScene(String sceneName) {
        this.stage.setScene(this.scenes.get(sceneName));
    }
}
