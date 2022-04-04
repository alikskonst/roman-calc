package edu.kaa.romancalc.line.impl;

import edu.kaa.romancalc.constants.CalcType;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.VariousNumberSystemsException;
import edu.kaa.romancalc.line.LineCheck;
import edu.kaa.romancalc.util.NumberUtils;

public class LineCheckImpl implements LineCheck {

    @Override
    public void checkExpression(String line) {
        int count = 0;
        int start = line.startsWith("-") ? 1 : 0;
        for (int i = start; i < line.length(); i++) {
            count = line.charAt(i) == '*' || line.charAt(i) == '/' || line.charAt(i) == '+' || line.charAt(i) == '-' ? ++count : count;
        }
        if (count > 1) {
            throw new IncorrectExpressionException();
        }
    }

    @Override
    public CalcType findOutType(String[] array) {
        if (NumberUtils.isNumber(array[0]) && NumberUtils.isNumber(array[2])) {
            return CalcType.ARABIAN;
        } else if (NumberUtils.isRomanNumber(array[0]) && NumberUtils.isRomanNumber(array[2])) {
            return CalcType.ROMAN;
        } else if (array[0].startsWith("-") || array[2].startsWith("-")) {
            throw new VariousNumberSystemsException("римские числа не могут быть отрицательными");
        }
        throw new VariousNumberSystemsException();
    }
}
