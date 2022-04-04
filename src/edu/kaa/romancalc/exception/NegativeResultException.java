package edu.kaa.romancalc.exception;

public class NegativeResultException extends RuntimeException {

    public NegativeResultException() {
        this("Negative result");
    }

    public NegativeResultException(String message) {
        super(message);
    }
}
