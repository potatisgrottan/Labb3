package se.kth.olof.beyar.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{
    private double width, height;

    public Rectangle(double x, double y, double width, double height, Color color, boolean filled) {
        super(x, y, color);
        this.width = width;
        this.height = height;
        setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillRect(getX() - width / 2, getY() - height / 2, width, height);
        } else {
            gc.setStroke(getColor());
            gc.strokeRect(getX() - width / 2, getY() - height / 2, width, height);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        final double edgeWidth = width / 2;
        final double edgeHeight = height / 2;

        // if rectangles edge is outside the border on the right / left side, change direction
        if (getX() - edgeWidth < boxX || getX() + edgeWidth > boxX + boxWidth) {
            setVelocity(-getDx(), getDy());
        }

        // if rectangles edge is outside the border on the top / bottom side, change direction
        if (getY() - edgeHeight < boxY || getY() + edgeHeight > boxY + boxHeight) {
            setVelocity(getDx(), -getDy());
        }
    }

    @Override
    public String toString(){
        return "widht: " + width + " height: " + height;
    }
}
