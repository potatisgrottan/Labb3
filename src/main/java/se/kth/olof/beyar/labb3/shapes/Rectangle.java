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

    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillRect(getX() - width/2, getY() - height/2, width, height);
        } else {
            gc.setStroke(getColor());
            gc.strokeRect(getX() - width/2, getY() - height/2, width, height);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        if (getX() - width/2 < boxX || getX() + width/2 > boxX + boxWidth) {
            setVelocity(-getDx(), getDy());
        }

        if (getY() - height/2 < boxY || getY() + height/2 > boxY + boxHeight) {
            setVelocity(getDx(), -getDy());
        }

        /*
        if (x2 < boxX) {
            dx = Math.abs(dx);
        } else if (x2 > boxWidth) {
            dx = -Math.abs(dx);
        }
        if (y2 < boxY) {
            dy = Math.abs(dy);
        } else if (y2 > boxHeight) {
            dy = -Math.abs(dy);
        }
        */
    }

    @Override
    public String toString(){
        return "widht: " + width + " height: " + height;
    }
}
