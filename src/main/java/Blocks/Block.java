package Blocks;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
    private Rectangle rectangle;
    private int durability;
    private double width;
    private double height;
    private double layoutX;
    private double layoutY;
    private static Appearance appearance = new Appearance();

    public Block() {
        width = 0;
        height = 0;
        layoutX = 0;
        layoutY = 0;
    }

    public Block(double x, double y, double width, double height, int durability) {
        layoutX = x;
        layoutY = y;
        this.width = width;
        this.height = height;
        this.durability = 0;
        this.durability = durability;
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setStrokeWidth(1);
        rectangle.setStroke(Color.ANTIQUEWHITE);
        rectangle.setArcHeight(10);
        rectangle.setArcWidth(10);
        changeRectangle();
    }

    public void getHit() {
        if(durability > 0)
            durability--;
    }

    public void changeRectangle() {
        if(durability == 0)
            disappear();
        else if(durability == 1)
            rectangle.setFill(appearance.linearGradient1);
        else if(durability == 2)
            rectangle.setFill(appearance.linearGradient2);
        else if(durability == 3)
            rectangle.setFill(appearance.linearGradient3);
        else if(durability == 4)
            rectangle.setFill(appearance.linearGradient4);
        else if(durability == 5)
            rectangle.setFill(appearance.linearGradient5);
        else
            rectangle.setFill(appearance.linearGradient6);
    }

    public boolean isExist() {
        return durability > 0;
    }

    private void disappear() {
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.TRANSPARENT);
    }

    @Override
    public String toString() {
        return "[ d:" + durability + " w:" + width + " h:" + height + " x:" + layoutX + " y:" + layoutY  + " ]";
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public double getLayoutY() {
        return layoutY;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
