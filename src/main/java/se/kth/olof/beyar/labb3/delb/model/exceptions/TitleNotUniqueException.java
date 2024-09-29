package se.kth.olof.beyar.labb3.delb.model.exceptions;

public class TitleNotUniqueException extends RuntimeException {

    public TitleNotUniqueException() {
        super();
    }

    public TitleNotUniqueException(String message) {
        super(message);
    }
}