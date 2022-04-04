package edu.kaa.romancalc.converter.impl;

import edu.kaa.romancalc.converter.Converter;
import edu.kaa.romancalc.exception.IncorrectExpressionException;
import edu.kaa.romancalc.exception.NegativeResultException;

import java.util.Map;
import java.util.Optional;

import static edu.kaa.romancalc.constants.Constants.ROME_MAP_10;
import static edu.kaa.romancalc.constants.Constants.ROME_MAP_100;

public class ConverterImpl implements Converter {

    @Override
    public int convert(String number) {
        Optional<Integer> result = ROME_MAP_10.entrySet()
                .stream()
                .filter(entry -> number.equalsIgnoreCase(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        return result.orElseThrow(() -> new IncorrectExpressionException("Not more X (10)"));
    }

    @Override
    public String convert(int number) {
        if (number <= 0) {
            throw new NegativeResultException("Римское число не может быть меньше или равно нулю");
        }
        if (number <= 10) {
            return ROME_MAP_10.get(number);
        }
        int tail = number % 10;
        return ROME_MAP_100.get(number - tail) + ROME_MAP_10.getOrDefault(tail, "");
    }
}
