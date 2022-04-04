package edu.kaa.romancalc.calc.impl;

import edu.kaa.romancalc.calc.MathOperation;

public class Multiplication implements MathOperation {

    @Override
    public int result(int a, int b) {
        return a * b;
    }
}
