package Game;

import java.util.*;
import Blocks.Block;
import Blocks.BlocksGenerator;
import Controllers.GameScreenController;
import Platform.Platform;
import Ball.Ball;
import Score.PointCounter;
import Score.ScoreBoard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Game {
    private Platform platform;
    private Ball ball;
    private LinkedList<Block> blocks;
    private static int level;
    private GameScreenController gameScreenController = new GameScreenController();
    private ScoreBoard scoreBoard;

    static {
        level = 1;
    }

    public Game() {
        this.platform = new Platform();
        blocks = BlocksGenerator.createBoardOfBlocks(1,1,1,5, level);
        scoreBoard = new ScoreBoard();
        this.ball = new Ball(platform.getPlatformNode(), blocks, scoreBoard);
    }


    private Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.millis(6), new EventHandler<>() {
        @Override
        public void handle(ActionEvent t) {
            if(isWin()) {
                timeline.stop();
                level++;
                startNewGame();
            }
        }
    }));

    private boolean isWin() {
        for( Block block : blocks) {
            if(block.getDurability() > 0)
                return false;
        }
        return true;
    }

    private void startNewGame() {
        PointCounter.setLevel(level);
        ball.stop();
        platform.getPlatformNode().relocate(550,800);
        blocks = BlocksGenerator.createBoardOfBlocks(1,1,0,5, level);
        gameScreenController.nextLevelScreen();
        ball.getbVelocity().setVelocityY(ball.getbVelocity().getVelocity());
    }

    public void startCheckingConditionOfWin() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Platform getPlatform() {
        return platform;
    }

    public Ball getBall() {
        return ball;
    }

    public LinkedList<Block> getBlocks() {
        return blocks;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
}
