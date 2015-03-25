package com.tw.NumberInWords.converters;

import com.tw.NumberInWords.NumberSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class TwoDigitConverter implements Converter {

    private final char WORD_SEPARATOR = ' ';
    private Map<Long, String> numberMap = newHashMap();

    public TwoDigitConverter() throws IOException {
        loadInitialNumberMap();
    }

    // TODO: See if you can restructure the interface to avoid passing number system here
    public String convert(long number, NumberSystem numberSystem) {
        StringBuilder numberInWords = new StringBuilder();

        if (number > 20) {
            numberInWords.append(numberMap.get((number / 10) * 10));
            if (number % 10 > 0) {
                numberInWords.append(WORD_SEPARATOR + numberMap.get(number % 10));
            }
        } else {
            numberInWords.append(numberMap.get(number));
        }

        return numberInWords.toString().trim();
    }

    private void loadInitialNumberMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/numberToWordsMapForTwoDigits.txt")));

        String input = reader.readLine();
        while (input != null) {
            numberMap.put(Long.parseLong(input.split(",")[0]), input.split(",")[1]);
            input = reader.readLine();
        }
    }
}
