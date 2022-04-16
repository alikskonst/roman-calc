package edu.kaa.romancalc.validation.impl;

import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.VariousNumberSystemsException;
import edu.kaa.romancalc.util.NumberUtils;
import edu.kaa.romancalc.util.StringUtils;
import edu.kaa.romancalc.validation.MathExpressionValidator;

public class MathExpressionValidatorImpl implements MathExpressionValidator {

    @Override
    public void validation(String[] array) {
        // проверка размерности массива
        if (array.length != 2) {
            throw new IncorrectExpressionException("Некорректное выражение");
        }
        // проверка ячеек на пустоту
        if (StringUtils.isEmpty(array[0]) || StringUtils.isEmpty(array[1])) {
            throw new IncorrectExpressionException("Некорректное выражение");
        }
        // проверка на принадлежность к разным системам
        if (NumberUtils.isArabianNumber(array[0]) && NumberUtils.isRomanNumber(array[1])) {
            throw new VariousNumberSystemsException("Разные системы счисления");
        } else if (NumberUtils.isArabianNumber(array[1]) && NumberUtils.isRomanNumber(array[0])) {
            throw new VariousNumberSystemsException("Разные системы счисления");
        } else if (NumberUtils.isArabianNumber(array[0]) && NumberUtils.isArabianNumber(array[1])) {
            // проверка на размерность (1 - 10)
            if (inRange(array[0]) || inRange(array[1])) {
                throw new IncorrectExpressionException("Выход за пределы возможностей системы (1 - 10)");
            }
        }
    }

    private boolean inRange(String source) {
        int number = Integer.parseInt(source);
        return number < 0 || number > 10;
    }
}
