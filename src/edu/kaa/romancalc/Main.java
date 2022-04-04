package edu.kaa.romancalc;

import edu.kaa.romancalc.calc.Calc;
import edu.kaa.romancalc.converter.Converter;
import edu.kaa.romancalc.converter.impl.ConverterImpl;
import edu.kaa.romancalc.line.LineCheck;
import edu.kaa.romancalc.line.LinePreparing;
import edu.kaa.romancalc.line.impl.LineCheckImpl;
import edu.kaa.romancalc.line.impl.LinePreparingImpl;

public class Main {

    public static void main(String[] args) {

        LineCheck lineCheck = new LineCheckImpl();
        LinePreparing linePreparing = new LinePreparingImpl(lineCheck);
        Converter converter = new ConverterImpl();

        new Calc(linePreparing, lineCheck, converter).result();

//        String str = "1+1+1";
//        System.out.println(str.replaceAll("[0-9]", "").length());
    }
}
