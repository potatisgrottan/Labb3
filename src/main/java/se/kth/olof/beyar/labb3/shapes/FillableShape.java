package se.kth.olof.beyar.labb3.shapes;

public  abstract class FillableShape extends Shape {
        private boolean filled;

        protected  FillableShape()
        {
            this.filled = false;
        }

        public boolean isFilled(){
            return filled;
        }

        public void setFilled(boolean filled)
        {
            this.filled = filled;
        }
}
