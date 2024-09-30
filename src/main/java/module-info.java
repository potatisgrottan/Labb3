module se.kth.olof.beyar.labb3.dela {
    requires javafx.controls;
    requires javafx.fxml;

    opens se.kth.olof.beyar.labb3.dela to javafx.fxml;
    exports se.kth.olof.beyar.labb3.dela;
}