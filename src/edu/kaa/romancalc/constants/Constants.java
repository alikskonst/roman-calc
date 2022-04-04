package edu.kaa.romancalc.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * создан с целью избежать попыток постоянно дергать память на постоянные создания карт
 */
public class Constants {

    public static final Map<Integer, String> ROME_MAP_10;
    public static final Map<Integer, String> ROME_MAP_100;

    static {
        ROME_MAP_10 = new HashMap<>();
        ROME_MAP_10.put(1, "I");
        ROME_MAP_10.put(2, "II");
        ROME_MAP_10.put(3, "III");
        ROME_MAP_10.put(4, "IV");
        ROME_MAP_10.put(5, "V");
        ROME_MAP_10.put(6, "VI");
        ROME_MAP_10.put(7, "VII");
        ROME_MAP_10.put(8, "VIII");
        ROME_MAP_10.put(9, "IX");
        ROME_MAP_10.put(10, "X");
    }

    static {
        ROME_MAP_100 = new HashMap<>();
        ROME_MAP_100.putAll(ROME_MAP_10);
        ROME_MAP_100.put(20, "XX");
        ROME_MAP_100.put(30, "XXX");
        ROME_MAP_100.put(40, "XL");
        ROME_MAP_100.put(50, "L");
        ROME_MAP_100.put(60, "LX");
        ROME_MAP_100.put(70, "LXX");
        ROME_MAP_100.put(80, "LXXX");
        ROME_MAP_100.put(90, "XC");
        ROME_MAP_100.put(100, "C");
    }
}
