package se.kth.olof.beyar.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {
    private double diameter;

    public Circle(double x, double y, double diameter, Color color, boolean filled) {
        super(x, y, color);
        this.diameter = diameter;
        setFilled(filled);
    }

    public double getDiameter(){
        return diameter;
    }

    public void setDiameter(double diameter){
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillOval(getX() - diameter / 2, getY() - diameter / 2, diameter, diameter);
        } else {
            gc.setStroke(getColor());
            gc.strokeOval(getX() - diameter / 2, getY() - diameter / 2, diameter, diameter);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Radius
        final double r = diameter / 2;

        // If the circles left side is outside the boxes left side OR vice-versa (right-side), change direction
        if (getX() - r < boxX || getX() + r > boxX + boxWidth) {
            setVelocity(-getDx(), getDy());
        }

        // If circles bottom is outside the boxes bottom OR vice-versa (top-side), change direction
        if (getY() - r < boxY || getY() + r > boxY + boxHeight) {
            setVelocity(getDx(), -getDy());
        }
    }

    @Override
    public String toString() {
        return "diameter: " + diameter;
    }
}
