package se.kth.olof.beyar.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends FillableShape{
    private double width,height;

    public Rectangle(){

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

    }

    @Override
    protected void constrain(double boxX, double boxY,
                             double boxWidth, double boxHeight){
        super.constrain(boxX,boxY,boxWidth,boxHeight);

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
    }

    @Override
    public String toString(){
        return "widht: " + width + " height: " + height;
    }
}
