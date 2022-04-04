package edu.kaa.romancalc.exception;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException() {
        this("Division by zero");
    }

    public DivisionByZeroException(String message) {
        super(message);
    }
}
