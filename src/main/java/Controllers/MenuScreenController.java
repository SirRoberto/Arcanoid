package Controllers;

import Ball.Ball;
import Blocks.Block;
import Game.Game;
import Main.Main;
import Platform.Platform;
import Score.ScoreBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;


public class MenuScreenController {

    private MainScreenController mainScreenController;
    private Game game;
    private Pane pane;

    void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    @FXML
    public void startNewGame() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/GameScreen.fxml"));

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene gameScene = new Scene(pane, 1200, 850);

        Main.sceneLoader.setSceneForApp(gameScene);

        game = new Game();

        addBall(game.getBall());
        addPlatform(game.getPlatform());
        addBlocks(game.getBlocks());
        addScoreBoard(game.getScoreBoard());

        game.startCheckingConditionOfWin();
        game.getPlatform().prepareScene(gameScene);
        game.getBall().bounce();
        game.getPlatform().startMove();
    }

    @FXML
    public void nextLvlClick() {
        startNewGame();
    }

    @FXML
    public void quitGame() {
        javafx.application.Platform.exit();
    }

    private void addBall (Ball ball) {
        pane.getChildren().add(ball.getBallShape());
    }

    private void addPlatform( Platform platform) {
        pane.getChildren().add(platform.getPlatformNode());
    }

    private void addBlocks(List<Block> blocks) {
        for(Block bb : blocks ) {
            pane.getChildren().add(bb.getRectangle());
        }
    }

    private void addScoreBoard(ScoreBoard board) {
        pane.getChildren().add(board.getYourScore());
        pane.getChildren().add(board.getHighScore());
    }
}
