package com.example.MainPackage;

import Controllers.*;
import com.example.MainPackage.SceneHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.FloatMap;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Restaurantes_bloski extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader mainLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("MainScene.fxml"));
        FXMLLoader menuLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("Menu.fxml"));
        FXMLLoader recetasLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("Recetas.fxml"));
        FXMLLoader turnosLoader = new FXMLLoader(Restaurantes_bloski.class.getResource("Turnos.fxml"));
        FXMLLoader pedidosLoader=new FXMLLoader(Restaurantes_bloski.class.getResource("Pedidos.fxml"));

        Parent main = mainLoader.load();
        Parent menu = menuLoader.load();
        Parent recetas = recetasLoader.load();
        Parent turnos = turnosLoader.load();
        Parent pedidos=pedidosLoader.load();

        Scene mainScene = new Scene(main, 450, 265);
        Scene menuScene = new Scene(menu, 450, 265);
        Scene recetasScene = new Scene(recetas, 450, 265);
        Scene turnosScene = new Scene(turnos, 450, 265);
        Scene pedidosScene=new Scene(pedidos ,450,265);

        SceneHandler sceneHandler = new SceneHandler(stage);
        sceneHandler.addScene(SceneHandler.Main_Scene, mainScene);
        sceneHandler.addScene(SceneHandler.Menu_Scene, menuScene);
        sceneHandler.addScene(SceneHandler.Recetas_Scene, recetasScene);
        sceneHandler.addScene(SceneHandler.Turnos_Scene, turnosScene);
        sceneHandler.addScene(SceneHandler.Pedidos_Scene,pedidosScene);

        HashMap<String, GenericController> controllers = new HashMap<>();
        controllers.put(SceneHandler.Main_Scene, mainLoader.getController());
        GenericController menuController = menuLoader.getController();
        controllers.put(SceneHandler.Menu_Scene, menuController);
        GenericController recetasController = recetasLoader.getController();
        controllers.put(SceneHandler.Recetas_Scene, recetasController);
        GenericController turnosController = turnosLoader.getController();
        controllers.put(SceneHandler.Turnos_Scene, turnosController);
        GenericController pedidosController=pedidosLoader.getController();
        controllers.put(SceneHandler.Pedidos_Scene,pedidosController);


        controllers.values().forEach(genericController -> {
            genericController.setSceneHandler(sceneHandler);
        });

        ((MenuController) menuController).setRecetasController((RecetasController) recetasController);
        ((MenuController) menuController).setTurnosController((TurnosController) turnosController);
        ((MenuController) menuController).setPedidosController((PedidosController)pedidosController);

        stage.setTitle("Restaurante Bloski's");
        stage.setScene(mainScene);


        stage.setFullScreen(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
