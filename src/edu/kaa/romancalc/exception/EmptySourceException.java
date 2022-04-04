package edu.kaa.romancalc.exception;

public class EmptySourceException extends RuntimeException {

    public EmptySourceException() {
        this("Empty source");
    }

    public EmptySourceException(String message) {
        super(message);
    }
}
