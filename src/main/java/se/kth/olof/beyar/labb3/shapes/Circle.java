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

    public void setDiameter(double newDiameter){
        diameter = newDiameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if (isFilled()) {
            gc.setFill(getColor());
            gc.fillOval(getX() - diameter/2, getY() - diameter/2, diameter, diameter);
        } else {
            gc.setStroke(getColor());
            gc.strokeOval(getX() - diameter/2, getY() - diameter/2, diameter, diameter);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        if (getX() - diameter/2 < boxX || getX() + diameter/2 > boxX + boxWidth) {
            setVelocity(-getDx(), getDy());
        }

        if (getY() - diameter/2 < boxY || getY() + diameter/2 > boxY + boxHeight) {
            setVelocity(getDx(), -getDy());
        }

    }

    @Override
    public String toString(){
        return "diameter: " + diameter;
    }
}
