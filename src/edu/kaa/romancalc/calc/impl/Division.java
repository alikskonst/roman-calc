package edu.kaa.romancalc.calc.impl;

import edu.kaa.romancalc.calc.MathOperation;
import edu.kaa.romancalc.exception.DivisionByZeroException;

public class Division implements MathOperation {

    @Override
    public int result(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }
}
