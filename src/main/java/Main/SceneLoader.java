package Main;

import javafx.scene.Scene;
import javafx.stage.Stage;

public  class SceneLoader {

        private Stage primaryStage;

        SceneLoader(Stage primaryStage) {
            this.primaryStage = primaryStage;
        }

        public void setSceneForApp(Scene gameScene) {
            primaryStage.setScene(gameScene);
        }
    }
