package edu.kaa.romancalc.exception;

public class NotFoundMathOperatorException extends RuntimeException {

    public NotFoundMathOperatorException() {
        this("Not found math operator");
    }

    public NotFoundMathOperatorException(String message) {
        super(message);
    }
}
