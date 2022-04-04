package edu.kaa.romancalc.calc.impl;

import edu.kaa.romancalc.calc.MathOperation;

public class Subtraction implements MathOperation {

    @Override
    public int result(int a, int b) {
        return a - b;
    }
}
