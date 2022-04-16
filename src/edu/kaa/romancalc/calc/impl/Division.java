package edu.kaa.romancalc.calc.impl;

import edu.kaa.romancalc.calc.Calculation;
import edu.kaa.romancalc.exception.DivisionByZeroException;

public class Division implements Calculation {

    @Override
    public int calculate(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("Попытка деления на ноль");
        }
        return a / b;
    }
}
