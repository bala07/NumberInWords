package com.tw.NumberInWords.converters;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.tw.NumberInWords.DivisorsWithSuffixes;
import com.tw.NumberInWords.DivisorsWithSuffixesFactory;
import com.tw.NumberInWords.NumberSystem;

import java.io.IOException;

public class MultiDigitConverter implements Converter {

    private final char WORD_SEPARATOR = ' ';

    private long[] divisors;
    private String[] singularSuffixes;
    private String[] pluralSuffixes;
    private RangeMap<Long, Converter> converterMap;
    private DivisorsWithSuffixesFactory divisorsWithSuffixesFactory;

    public MultiDigitConverter() throws IOException {
        converterMap = TreeRangeMap.create();
        converterMap.put(Range.closed(0l, 99l), new TwoDigitConverter());
        converterMap.put(Range.atLeast(100l), this);

        divisorsWithSuffixesFactory = new DivisorsWithSuffixesFactory();
    }

    public String convert(long number, NumberSystem numberSystem) {
        if(number == 0) {
            return "zero";
        }

        updateDivisorsAndSuffixesForTheNumberSystem(numberSystem);

        StringBuilder numberInWords = new StringBuilder();
        int divisorIdx = getStartingDivisorIdx(number);

        while (number >= 100) {
            numberInWords.append(converterMap.get(number).convert(number / divisors[divisorIdx], numberSystem));
            numberInWords.append(WORD_SEPARATOR);
            numberInWords.append(getPlaceValue(number, divisorIdx));
            numberInWords.append(WORD_SEPARATOR);

            number %= divisors[divisorIdx];
            divisorIdx++;
        }

        if (number > 0) {
            numberInWords.append(converterMap.get(number).convert(number, numberSystem));
        }

        return numberInWords.toString().trim();
    }

    private void updateDivisorsAndSuffixesForTheNumberSystem(NumberSystem numberSystem) {
        DivisorsWithSuffixes divisorsWithSuffixes = divisorsWithSuffixesFactory.getFor(numberSystem);
        this.divisors = divisorsWithSuffixes.divisors;
        this.singularSuffixes = divisorsWithSuffixes.singularSuffixes;
        this.pluralSuffixes = divisorsWithSuffixes.pluralSuffixes;
    }

    private String getPlaceValue(long number, int divisorIdx) {
        return (number / divisors[divisorIdx] <= 1 ? singularSuffixes[divisorIdx] : pluralSuffixes[divisorIdx]);
    }

    private int getStartingDivisorIdx(long number) {
        for (int idx = 0; idx < divisors.length; ++idx) {
            if (number / divisors[idx] >= 1) {
                return idx;
            }
        }

        return 0;
    }
}
