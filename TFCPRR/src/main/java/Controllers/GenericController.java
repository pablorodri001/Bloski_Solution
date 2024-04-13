package Controllers;

import com.example.MainPackage.SceneHandler;

public class GenericController {
    protected SceneHandler sceneHandler;

    public void setSceneHandler(SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
        System.out.println(this);
    }
}
