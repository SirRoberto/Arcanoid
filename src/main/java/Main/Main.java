package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static SceneLoader sceneLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        sceneLoader = new SceneLoader(primaryStage);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/MainScreen.fxml"));

        Pane pane = loader.load();
        Scene scene = new Scene(pane, 1200, 870);

        primaryStage.setFullScreen(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Arkanoid");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


