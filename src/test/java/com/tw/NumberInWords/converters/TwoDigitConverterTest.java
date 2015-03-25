package com.tw.NumberInWords.converters;

import com.tw.NumberInWords.NumberSystem;
import com.tw.NumberInWords.converters.TwoDigitConverter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TwoDigitConverterTest {
    @Test
    public void convertsNumbersLessThanHundredForIndianSystem() throws IOException {
        Map<Integer, String> numberMap = prepareMap();
        TwoDigitConverter converter = new TwoDigitConverter();

        for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
            assertThat(converter.convert(entry.getKey(), NumberSystem.INDIAN), is(entry.getValue()));
        }
    }

    @Test
    public void convertsNumbersLessThanHundredForWesternSystem() throws IOException {
        Map<Integer, String> numberMap = prepareMap();
        TwoDigitConverter converter = new TwoDigitConverter();

        for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
            assertThat(converter.convert(entry.getKey(), NumberSystem.WESTERN), is(entry.getValue()));
        }
    }

    private Map<Integer, String> prepareMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/testDataForNumbersLessThanHundred.txt")));
        Map<Integer, String> numberMap = newHashMap();

        String input = reader.readLine();
        while (input != null) {
            numberMap.put(Integer.parseInt(input.split(",")[0]), input.split(",")[1]);
            input = reader.readLine();
        }

        return numberMap;
    }
}