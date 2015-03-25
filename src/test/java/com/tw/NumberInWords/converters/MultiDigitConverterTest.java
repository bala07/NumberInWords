package com.tw.NumberInWords.converters;

import com.tw.NumberInWords.NumberSystem;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MultiDigitConverterTest {
    @Test
    public void convertsNumbersToWordsInIndianSystem() throws IOException {
        Map<Long, String> numberMap = prepareMap("/testDataForNumbersMoreThanHundredForIndianSystem.txt");
        MultiDigitConverter converter = new MultiDigitConverter();

        for (Map.Entry<Long, String> entry : numberMap.entrySet()) {
            assertThat(converter.convert(entry.getKey(), NumberSystem.INDIAN), is(entry.getValue()));
        }
    }

    @Test
    public void convertsNumbersToWordsInWesternSystem() throws IOException {
        Map<Long, String> numberMap = prepareMap("/testDataForNumbersMoreThanHundredForWesternSystem.txt");
        MultiDigitConverter converter = new MultiDigitConverter();

        for (Map.Entry<Long, String> entry : numberMap.entrySet()) {
            assertThat(converter.convert(entry.getKey(), NumberSystem.WESTERN), is(entry.getValue()));
        }
    }

    private Map<Long, String> prepareMap(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName)));
        Map<Long, String> numberMap = newHashMap();

        String input = reader.readLine();
        while (input != null) {
            numberMap.put(Long.parseLong(input.split(",")[0]), input.split(",")[1]);
            input = reader.readLine();
        }

        return numberMap;
    }
}