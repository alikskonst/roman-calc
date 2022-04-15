package edu.kaa.romancalc.calc;

import edu.kaa.romancalc.calc.impl.Addition;
import edu.kaa.romancalc.calc.impl.Division;
import edu.kaa.romancalc.calc.impl.Multiplication;
import edu.kaa.romancalc.calc.impl.Subtraction;
import edu.kaa.romancalc.converter.Converter;
import edu.kaa.romancalc.exception.EmptySourceException;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.NotFoundMathOperatorException;
import edu.kaa.romancalc.util.NumberUtils;
import edu.kaa.romancalc.util.StringUtils;
import edu.kaa.romancalc.validation.MathExpressionValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

    private final MathExpressionValidation mathExpressionValidation;
    private final Converter converter;

    public Calc(MathExpressionValidation mathExpressionValidation,
                Converter converter) {
        this.mathExpressionValidation = mathExpressionValidation;
        this.converter = converter;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void result() {

        String line = readLine();
        String mathOperator = line.replaceAll("[0-9a-zA-Z]", "");
        if (mathOperator.length() != 1) {
            throw new IncorrectExpressionException();
        }
        String[] array = line.split(mathOperator.contains("*") ? "\\*" : mathOperator.contains("+") ? "\\+" : mathOperator);
        mathExpressionValidation.validation(array);
        boolean isRomanExpression = NumberUtils.isRomanNumber("" + line.charAt(0));
        int result;
        switch (mathOperator) {
            case "*":
                Calculation calculation = new Multiplication();
                result = calculation.calculate(getNumber(array[0]), getNumber(array[1]));
                break;
            case "/":
                calculation = new Division();
                result = calculation.calculate(getNumber(array[0]), getNumber(array[1]));
                break;
            case "+":
                calculation = new Addition();
                result = calculation.calculate(getNumber(array[0]), getNumber(array[1]));
                break;
            case "-":
                calculation = new Subtraction();
                result = calculation.calculate(getNumber(array[0]), getNumber(array[1]));
                break;
            default:
                throw new NotFoundMathOperatorException();
        }
        System.out.print("Result: ");
        System.out.print(isRomanExpression ? converter.convert(result) : result);
    }

    private String readLine() {
        System.out.print("Please enter mathematical expression: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (StringUtils.isNotEmpty(line)) {
            return line;
        } else {
            throw new EmptySourceException("Empty line for math operation");
        }
    }

    private int getNumber(String number) {
        if (NumberUtils.isArabianNumber(number)) {
            int num = Integer.parseInt(number);
            if (num == 0) {
                throw new IncorrectExpressionException("You mustn't use 0 (zero)");
            }
            if (num > 10) {
                throw new IncorrectExpressionException("Not more 10");
            }
            return num;
        } else if (NumberUtils.isRomanNumber(number)) {
            return converter.convert(number);
        }
        throw new IncorrectExpressionException();
    }
}
