package Platform;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.image.*;
import javafx.util.Duration;

public class Platform {

    private static final double platformSpaceY = 1000, platformSpaceX = 800;
    private Image platformImage = new Image("Pictures/Platform.png");
    public Node platformNode;
    private boolean goEast, goWest;

    public Platform() {
        platformNode = new ImageView(platformImage);
        platformNode.relocate(550,platformSpaceX);
    }

    public void movePlatformBy(int dx, int dy) {
        if (dx == 200 && dy == 0) return;

        final double cx = platformNode.getBoundsInLocal().getWidth() / 2;
        double x = cx + platformNode.getLayoutX() + dx;

        movePlatformTo(x);
    }

    public void movePlatformTo(double x) {
        final double cx = platformNode.getBoundsInLocal().getWidth() / 2;

        if (x - cx >= 200 && x + cx <= platformSpaceY) {
            platformNode.relocate(x - cx, platformSpaceX);
        }
    }

    public void startMove() {
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
    }

    private Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<>() {
        @Override
        public void handle(ActionEvent t) {
            int dx = 0, dy = 0;
            if (goEast) dx += 4;
            if (goWest) dx -= 4;
            movePlatformBy(dx, dy);
        }
    }));

    public void prepareScene(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {

                case LEFT:
                    goWest = true;
                    break;
                case RIGHT:
                    goEast = true;
                    break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:
                    goWest = false;
                    break;
                case RIGHT:
                    goEast = false;
                    break;
            }
        });
    }

    public Node getPlatformNode() {
        return platformNode;
    }
}

