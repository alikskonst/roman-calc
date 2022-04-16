package edu.kaa.romancalc.exception;

public class VariousNumberSystemsException extends RuntimeException {

    public VariousNumberSystemsException() {
        this("Несовпадающие системы счисления");
    }

    public VariousNumberSystemsException(String message) {
        super(message);
    }
}
