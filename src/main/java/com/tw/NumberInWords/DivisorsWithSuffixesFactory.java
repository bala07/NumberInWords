package com.tw.NumberInWords;

public class DivisorsWithSuffixesFactory {

    private final long[] divisorsIndian = {10000000, 100000, 1000, 100, 10, 1};
    private final String[] singularSuffixesIndian = {"crore", "lakh", "thousand", "hundred", "invalid", "invalid"};
    private final String[] pluralSuffixesIndian = {"crores", "lakhs", "thousand", "hundred", "invalid", "invalid"};

    private final long[] divisorsWestern = {1000000000000l, 1000000000, 1000000, 1000, 100, 10, 1};
    private final String[] singularSuffixesWestern = {"trillion", "billion", "million", "thousand", "hundred", "invalid", "invalid"};
    private final String[] pluralSuffixesWestern = {"trillion", "billion", "million", "thousand", "hundred", "invalid", "invalid"};

    public DivisorsWithSuffixes getFor(NumberSystem numberSystem) {
        if(numberSystem == NumberSystem.INDIAN) {
            return new DivisorsWithSuffixes(divisorsIndian, singularSuffixesIndian, pluralSuffixesIndian);
        }
        else {
            return new DivisorsWithSuffixes(divisorsWestern, singularSuffixesWestern, pluralSuffixesWestern);
        }
    }
}
