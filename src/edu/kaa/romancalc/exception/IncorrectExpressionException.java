package edu.kaa.romancalc.exception;

public class IncorrectExpressionException extends RuntimeException {

    public IncorrectExpressionException() {
        this("Incorrect expression");
    }

    public IncorrectExpressionException(String message) {
        super(message);
    }
}
