package edu.kaa.romancalc.calc;

import edu.kaa.romancalc.converter.Converter;
import edu.kaa.romancalc.exception.EmptySourceException;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.NotFoundMathOperatorException;
import edu.kaa.romancalc.util.NumberUtils;
import edu.kaa.romancalc.util.StringUtils;
import edu.kaa.romancalc.validation.MathExpressionValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static edu.kaa.romancalc.constants.Constants.CALCULATION_MAP;

public class Calc {

    private final MathExpressionValidator mathExpressionValidator;
    private final Converter converter;

    public Calc(MathExpressionValidator mathExpressionValidator, Converter converter) {
        this.mathExpressionValidator = mathExpressionValidator;
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
        mathExpressionValidator.validation(array);
        boolean isRomanExpression = NumberUtils.isRomanNumber(Character.toString(line.charAt(0)));
        Calculation calculation = Optional.ofNullable(CALCULATION_MAP.get(mathOperator)).orElseThrow(NotFoundMathOperatorException::new);
        int result = calculation.calculate(getNumber(array[0]), getNumber(array[1]));
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

    private int getNumber(String source) {
        if (NumberUtils.isArabianNumber(source)) {
            int number = Integer.parseInt(source);
            if (number == 0) {
                throw new IncorrectExpressionException("You mustn't use 0 (zero)");
            } else if (number > 10) {
                throw new IncorrectExpressionException("Not more 10");
            }
            return number;
        } else if (NumberUtils.isRomanNumber(source)) {
            return converter.convert(source);
        }
        throw new IncorrectExpressionException();
    }
}
