package edu.kaa.romancalc.line.impl;

import edu.kaa.romancalc.constants.CalcType;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.VariousNumberSystemsException;
import edu.kaa.romancalc.line.LineCheck;
import edu.kaa.romancalc.util.NumberUtils;

public class LineCheckImpl implements LineCheck {

    @Override
    public void checkExpression(String line) {
        String mathOperators = line.startsWith("-") ?
                line.substring(1).replaceAll("[0-9]", "") :
                line.replaceAll("[0-9]", "");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mathOperators.length(); i++) {
            stringBuilder.append(mathOperators.charAt(i)).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);

        if (mathOperators.length() > 1) {
            throw new IncorrectExpressionException("формат математической операции не удовлетворяет заданию, обнаружено несколько операторов: " + stringBuilder);
        }
    }

    @Override
    public CalcType findOutType(String[] array) {
        if (NumberUtils.isArabianNumber(array[0]) && NumberUtils.isArabianNumber(array[1])) {
            return CalcType.ARABIAN;
        } else if (NumberUtils.isRomanNumber(array[0]) && NumberUtils.isRomanNumber(array[1])) {
            return CalcType.ROMAN;
        } else if (array[0].startsWith("-") || array[1].startsWith("-")) {
            throw new VariousNumberSystemsException("римские числа не могут быть отрицательными");
        }
        throw new VariousNumberSystemsException();
    }
}
