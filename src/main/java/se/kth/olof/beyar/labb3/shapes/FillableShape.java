package se.kth.olof.beyar.labb3.shapes;

public  abstract class FillableShape extends Shape {
        private boolean filled;

        protected  FillableShape(){
        }

        public boolean isFilled(){
            return false;
        }

        public void setFilled(boolean filled){

        }


}
