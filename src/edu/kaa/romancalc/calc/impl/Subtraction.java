package edu.kaa.romancalc.calc.impl;

import edu.kaa.romancalc.calc.Calculation;

public class Subtraction implements Calculation {

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
