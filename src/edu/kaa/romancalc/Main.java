package edu.kaa.romancalc;

import edu.kaa.romancalc.calc.Calc;
import edu.kaa.romancalc.converter.impl.ConverterImpl;
import edu.kaa.romancalc.validation.impl.MathExpressionValidationImpl;

public class Main {

    public static void main(String[] args) {

        new Calc(new MathExpressionValidationImpl(), new ConverterImpl()).result();
    }
}
