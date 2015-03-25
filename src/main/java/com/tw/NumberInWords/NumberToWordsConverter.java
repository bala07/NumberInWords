package com.tw.NumberInWords;

import com.google.common.annotations.VisibleForTesting;
import com.tw.NumberInWords.converters.Converter;
import com.tw.NumberInWords.converters.MultiDigitConverter;

import java.io.IOException;

public class NumberToWordsConverter {

    private Converter multiDigitConverter;

    public NumberToWordsConverter() throws IOException {
        multiDigitConverter = new MultiDigitConverter();
    }

    @VisibleForTesting
    NumberToWordsConverter(Converter multiDigitConverter) {
        this.multiDigitConverter = multiDigitConverter;
    }

    public String convert(long number, NumberSystem numberSystem) {
        return multiDigitConverter.convert(number, numberSystem);
    }

    public static void main(String[] args) throws IOException {
        Long number = Long.parseLong(args[0]);
        String numberSystem = args.length == 2 ? args[1] : null;

        if(numberSystem == null || numberSystem.equalsIgnoreCase("indian")) {
            System.out.println(new NumberToWordsConverter().convert(number, NumberSystem.INDIAN));
        }
        else {
            System.out.println(new NumberToWordsConverter().convert(number, NumberSystem.WESTERN));
        }
    }
}
