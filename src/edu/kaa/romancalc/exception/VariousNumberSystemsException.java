package edu.kaa.romancalc.exception;

public class VariousNumberSystemsException extends RuntimeException {

    //todo: kaa: тут надо норально не забыть написать, а то опять говно получится
    public VariousNumberSystemsException() {
        this("несовпадающие системы счисления");
    }

    public VariousNumberSystemsException(String message) {
        super(message);
    }
}
