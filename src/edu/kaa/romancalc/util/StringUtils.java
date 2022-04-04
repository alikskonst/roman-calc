package edu.kaa.romancalc.util;

public class StringUtils {

    public static boolean isEmpty(String line) {
        return line == null || line.length() == 0;
    }

    public static boolean isNotEmpty(String line) {
        return !isEmpty(line);
    }
}
