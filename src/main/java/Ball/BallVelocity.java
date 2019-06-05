package Ball;

import static java.lang.Math.*;

public class BallVelocity {
    private double alfa;
    private double velocity;
    private double velocityX;
    private double velocityY;

     BallVelocity(double velocity) {
        this.velocity = velocity;
        velocityX = 0;
        velocityY = velocity;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocityY(double y) {
        velocityY = y;
    }

    void designateAlfa(double x, double platformWidth) {
        alfa = -100/platformWidth * x + 90;
    }

    void designateVelocityX(double alfa) {
        velocityX = cos(toRadians(alfa)) * velocity;
    }

    void designateVelocityY(double alfa) {
        velocityY = sin(toRadians(alfa)) * velocity;
    }

    double getAlfa () {
        return alfa;
    }

    double getVelocityY() {
        return velocityY;
    }

    double getVelocityX() {
        return velocityX;
    }

    void setVelocityX(double x) {
        velocityX = x;
    }
}
