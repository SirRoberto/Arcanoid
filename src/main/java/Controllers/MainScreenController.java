package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class MainScreenController {
    @FXML
    private Pane MainScreen;

    @FXML
    public void initialize() {
        loadMenuScreen();
    }

    public void setScreen(Pane pane) {
        MainScreen.getChildren().clear();
        MainScreen.getChildren().add(pane);
    }

    public void loadMenuScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/MenuScreen.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuScreenController menuScreenController = loader.getController();
        menuScreenController.setMainScreenController(this);

        setScreen(pane);
    }
}
