package Ball;

import Blocks.Block;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import Game.GameArea;

import java.util.LinkedList;

class BallBounceCondition {
    private Circle ball;
    private Node platform;
    private LinkedList<Block> blocks;

    BallBounceCondition(Circle ball, Node platform, LinkedList<Block> board) {
        this.ball = ball;
        this.platform = platform;
        blocks = board;
    }

    boolean whenHitPlatform() {
        return ball.getLayoutX()+ball.getRadius() > platform.getLayoutX()
                && ball.getLayoutX()-ball.getRadius() < platform.getLayoutX() + platform.getBoundsInLocal().getWidth()
                && ball.getLayoutY()+ball.getRadius() > platform.getLayoutY()
                && ball.getLayoutY()-ball.getRadius() < platform.getLayoutY() + platform.getBoundsInLocal().getHeight();
    }

    boolean whenHitWall() {
        return ball.getLayoutX() <= GameArea.getMinX() + ball.getRadius() || ball.getLayoutX() >= GameArea.getMaxX() - ball.getRadius();
    }

    boolean whenHitCelling() {
        return  ball.getLayoutY() <= GameArea.getMinY() + ball.getRadius() ;
    }

    boolean whenHitGround() {
        return ball.getLayoutY() >= GameArea.getMaxY() - ball.getRadius();
    }

    boolean whenHitLeftSideBlock() {
        for (Block block : blocks) {
            if (ball.getLayoutY() + ball.getRadius() > block.getLayoutY() && ball.getLayoutY() - ball.getRadius() < block.getLayoutY() + block.getHeight()
                    && ball.getLayoutX() + ball.getRadius() < block.getLayoutX() + 4
                    && ball.getLayoutX() + ball.getRadius() > block.getLayoutX()
                    && block.isExist()) {
                block.getHit();
                block.changeRectangle();
                return true;
            }
        }
        return false;
    }

    boolean whenHitRightSideBlock() {
        for(Block block : blocks) {
            if (ball.getLayoutY() + ball.getRadius() > block.getLayoutY() && ball.getLayoutY() - ball.getRadius() < block.getLayoutY() + block.getHeight()
                    && ball.getLayoutX() - ball.getRadius() < block.getLayoutX() + block.getWidth()
                    && ball.getLayoutX() - ball.getRadius() > block.getLayoutX() + block.getWidth() - 4
                    && block.isExist()) {
                block.getHit();
                block.changeRectangle();
                return true;
            }
        }
        return false;
    }

    boolean whenHitUpSideBlock() {
        for(Block block : blocks) {
            if (ball.getLayoutX() + ball.getRadius() > block.getLayoutX() && ball.getLayoutX() - ball.getRadius() < block.getLayoutX() + block.getWidth()
                    && ball.getLayoutY() + ball.getRadius() > block.getLayoutY()
                    && ball.getLayoutY() + ball.getRadius() < block.getLayoutY() + 4
                    && block.isExist()) {
                block.getHit();
                block.changeRectangle();
                return true;
            }
        }
        return false;
    }

    boolean whenHitDownSideBlock() {
        for(Block block : blocks) {
            if (ball.getLayoutX() + ball.getRadius() > block.getLayoutX() && ball.getLayoutX() - ball.getRadius() < block.getLayoutX() + block.getWidth()
                    && ball.getLayoutY() - ball.getRadius() > block.getLayoutY() + block.getHeight() - 4
                    && ball.getLayoutY() - ball.getRadius() < block.getLayoutY() + block.getHeight()
                    && block.isExist()) {
                block.getHit();
                block.changeRectangle();
                return true;
            }
        }
        return false;
    }
}
