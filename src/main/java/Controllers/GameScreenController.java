package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GameScreenController {

    @FXML
    public void backToMenu() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/MenuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace(); }
        Scene scene = new Scene(pane, 1200, 870);
        Main.sceneLoader.setSceneForApp(scene);

    }

    @FXML
    public void gameOverScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/GameOverScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(pane, 1200, 870);
        Main.sceneLoader.setSceneForApp(scene);
    }

    @FXML
    public void nextLevelScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/NextLevelScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(pane, 1200, 870);
        Main.sceneLoader.setSceneForApp(scene);
    }
}
