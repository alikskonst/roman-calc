package edu.kaa.romancalc.calc;

import edu.kaa.romancalc.calc.impl.Addition;
import edu.kaa.romancalc.calc.impl.Division;
import edu.kaa.romancalc.calc.impl.Multiplication;
import edu.kaa.romancalc.calc.impl.Subtraction;
import edu.kaa.romancalc.constants.CalcType;
import edu.kaa.romancalc.converter.Converter;
import edu.kaa.romancalc.exception.EmptySourceException;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.NotFoundMathOperatorException;
import edu.kaa.romancalc.exception.VariousNumberSystemsException;
import edu.kaa.romancalc.line.LineCheck;
import edu.kaa.romancalc.line.LinePreparing;
import edu.kaa.romancalc.util.NumberUtils;
import edu.kaa.romancalc.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

    private final LinePreparing linePreparing;
    private final LineCheck lineCheck;
    private final Converter converter;

    public Calc(LinePreparing linePreparing, LineCheck lineCheck, Converter converter) {
        this.linePreparing = linePreparing;
        this.lineCheck = lineCheck;
        this.converter = converter;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void result() {
        System.out.print("Please enter mathematical expression: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        if (StringUtils.isNotEmpty(line)) {
            String[] array = linePreparing.getPreparedLine(line);
            CalcType calcType = lineCheck.findOutType(array);
            int result;
            switch (array[2]) {
                case "*":
                    MathOperation mathOperation = new Multiplication();
                    result = mathOperation.result(getNumber(array[0]), getNumber(array[1]));
                    break;
                case "/":
                    mathOperation = new Division();
                    result = mathOperation.result(getNumber(array[0]), getNumber(array[1]));
                    break;
                case "+":
                    mathOperation = new Addition();
                    result = mathOperation.result(getNumber(array[0]), getNumber(array[1]));
                    break;
                case "-":
                    mathOperation = new Subtraction();
                    result = mathOperation.result(getNumber(array[0]), getNumber(array[1]));
                    break;
                default:
                    throw new NotFoundMathOperatorException();
            }
            printResult(calcType, result);
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
        throw new VariousNumberSystemsException();
    }

    private void printResult(CalcType calcType, int result) {
        if (calcType.equals(CalcType.ARABIAN)) {
            System.out.println("Result: " + result);
        } else if (calcType.equals(CalcType.ROMAN)) {
            System.out.println("Result: " + converter.convert(result));
        }
    }
}
