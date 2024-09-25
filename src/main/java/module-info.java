module se.kth.olof.beyar.labb3.labb3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.kth.olof.beyar.labb3 to javafx.fxml;
    exports se.kth.olof.beyar.labb3;
}