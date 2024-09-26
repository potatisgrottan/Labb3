package se.kth.olof.beyar.labb3.shapes;

import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2021-09-15
 */
public class World {
    private double width, height; // this worlds width and height
    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this world
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;
        shapes = new Shape[6];

        shapes[0] = new Line(0,0,100,80,Color.RED);
        shapes[0].setVelocity(20,40);

        shapes[1] = new Line(width, height, width-100, height-80, Color.ORANGE);
        shapes[1].setVelocity(-25, -35);

        shapes[2] = new Circle(width/2, height/2, 30, Color.BLUE, true);
        shapes[2].setVelocity(-30, 50);

        shapes[3] = new Circle(width/4, height/4, 30, Color.BLUE, false);
        shapes[3].setVelocity(-30, 50);

        shapes[4] = new Rectangle(width/4, height/4, 40, 60, Color.GREEN, false);
        shapes[4].setVelocity(40, -20);

        shapes[5] = new Rectangle(width/8, height/8, 40, 60, Color.BEIGE, true);
        shapes[5].setVelocity(-40, -20);
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds
     */
    public void moveAndConstrain(long elapsedTimeNs) {
        for (Shape s : shapes) {
            s.moveAndConstrain(elapsedTimeNs, 0, 0, width, height);
        }
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}
