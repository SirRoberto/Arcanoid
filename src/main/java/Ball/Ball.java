package Ball;

import Blocks.Block;
import Controllers.GameScreenController;
import Score.PointCounter;
import Score.ScoreBoard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Ball {
    private BallVelocity ballVelocity = new BallVelocity(4);
    private BallBounceCondition condition;
    private Circle ballShape;
    private Node platform;
    private ScoreBoard scoreBoard;
    private GameScreenController gameScreenController = new GameScreenController();


    public Ball(Node platform, LinkedList<Block> blocks, ScoreBoard board ) {
        ballShape = new Circle(10, Color.WHITESMOKE);
        ballShape.relocate(590, 770);
        this.platform = platform;
        this.condition = new BallBounceCondition(ballShape, platform, blocks);
        this.scoreBoard = board;
    }

    private Timeline timeline = new Timeline(new KeyFrame(Duration.millis(6), new EventHandler<>() {
        @Override
        public void handle(ActionEvent t) {

            ballShape.setLayoutX(ballShape.getLayoutX() + ballVelocity.getVelocityX());
            ballShape.setLayoutY(ballShape.getLayoutY() + ballVelocity.getVelocityY());
            double platformCenterX = platform.getLayoutX()+platform.getBoundsInLocal().getWidth()/2;


            if (condition.whenHitDownSideBlock()||condition.whenHitUpSideBlock()) {
                ballVelocity.setVelocityY(-ballVelocity.getVelocityY());
                PointCounter.addPoints();
                scoreBoard.setYourScore();
            }
            if(condition.whenHitRightSideBlock()||condition.whenHitLeftSideBlock()) {
                ballVelocity.setVelocityX(-ballVelocity.getVelocityX());
                PointCounter.addPoints();
                scoreBoard.setYourScore();
            }
            if (condition.whenHitWall()) {
                ballVelocity.setVelocityX(-ballVelocity.getVelocityX());
            }
            if (condition.whenHitCelling()) {
                ballVelocity.setVelocityY(-ballVelocity.getVelocityY());
            }
            if (condition.whenHitGround()) {
                timeline.stop();
                try {
                    PointCounter.writeTheHighestScore();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                gameScreenController.gameOverScreen();
                PointCounter.setScore(0);
            }
            if(condition.whenHitPlatform()) {
                ballVelocity.designateAlfa(ballShape.getLayoutX()-platformCenterX,platform.getBoundsInLocal().getWidth());
                ballVelocity.designateVelocityX(ballVelocity.getAlfa());
                ballVelocity.designateVelocityY(ballVelocity.getAlfa());
                ballVelocity.setVelocityY(-ballVelocity.getVelocityY());
            }
        }
    }));

    public void bounce() {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        timeline.stop();
        ballVelocity.setVelocityX(0);
        ballVelocity.setVelocityY(0);
        ballShape.relocate(590,770);
    }

    public Circle getBallShape() {
        return ballShape;
    }

    public BallVelocity getbVelocity() {
        return ballVelocity;
    }
}
