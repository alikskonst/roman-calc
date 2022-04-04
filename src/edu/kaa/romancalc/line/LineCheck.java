package edu.kaa.romancalc.line;

import edu.kaa.romancalc.constants.CalcType;

public interface LineCheck {

    void checkExpression(String line);

    CalcType findOutType(String[] array);
}
