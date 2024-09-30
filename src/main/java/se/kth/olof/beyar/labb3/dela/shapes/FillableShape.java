package se.kth.olof.beyar.labb3.dela.shapes;

import javafx.scene.paint.Color;

public  abstract class FillableShape extends Shape {
        private boolean filled;

        protected FillableShape(double x, double y, Color color, boolean filled) {
            super(x, y, color);
            this.filled = filled;
        }

        protected FillableShape(double x, double y, Color color) {
            this(x, y, color, false);
        }

        public boolean isFilled(){
            return filled;
        }

        public void setFilled(boolean filled)
        {
            this.filled = filled;
        }
}
