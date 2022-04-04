package edu.kaa.romancalc.line.impl;

import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.NotFoundMathOperatorException;
import edu.kaa.romancalc.line.LineCheck;
import edu.kaa.romancalc.line.LinePreparing;
import edu.kaa.romancalc.util.StringUtils;

public class LinePreparingImpl implements LinePreparing {

    private final LineCheck lineCheck;

    public LinePreparingImpl(LineCheck lineCheck) {
        this.lineCheck = lineCheck;
    }

    @Override
    public String[] getPreparedLine(String line) {
        line = line.replace(" ", "");
        if (line.contains("*") || line.contains("/") || line.contains("+") || line.contains("-")) {
            return getPreparedArray(line);
        } else {
            throw new NotFoundMathOperatorException("строка не является математической операцией");
        }
    }

    private String[] getPreparedArray(String line) {
        // форматируем выражения вида -1--1
        line = line.replace("--", "+");
        // проверка на короткое выражение
        lineCheck.checkExpression(line);
        return getArray(line);
    }

    private String[] getArray(String line) {

        // позволим проводить операции типа "-1 - 1"
        boolean prefixMinus = false;
        if (line.startsWith("-")) {
            line = line.substring(1);
            prefixMinus = true;
        }

        String[] array = new String[0];
        if (line.contains("*")) {
            array = getArray(line.split("\\*"), "*");
        } else if (line.contains("/")) {
            array = getArray(line.split("/"), "/");
        } else if (line.contains("+")) {
            array = getArray(line.split("\\+"), "+");
        } else if (line.contains("-")) {
            array = getArray(line.split("-"), "-");
        }
        // вернем минус на место
        if (prefixMinus) {
            array[0] = "-" + array[0];
        }
        return array;
    }

    private String[] getArray(String[] array, String mathOperator) {
        if (StringUtils.isEmpty(array[0])) {
            throw new IncorrectExpressionException("строка не является математической операцией");
        } else if (array.length == 2) {
            return new String[]{array[0], array[1], mathOperator};
        }
        throw new IncorrectExpressionException("строка не является математической операцией");
    }
}
