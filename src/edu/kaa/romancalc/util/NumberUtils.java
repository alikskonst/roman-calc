package edu.kaa.romancalc.util;

import static edu.kaa.romancalc.constants.Constants.ROME_MAP_10;

public class NumberUtils {

    /**
     * проверка только целочисленных значений, дробные не проходят проверку
     */
    public static boolean isNumber(String line) {
        if (StringUtils.isEmpty(line)) {
            return false;
        }
        int start = line.startsWith("-") ? 1 : 0;
        for (int i = start; i < line.length(); ++i) {
            if (!Character.isDigit(line.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * несет в себе существенный недостаток - проверка от 1 до 10
     */
    public static boolean isRomanNumber(String line) {
        return ROME_MAP_10.containsValue(line.toUpperCase());
    }
}
