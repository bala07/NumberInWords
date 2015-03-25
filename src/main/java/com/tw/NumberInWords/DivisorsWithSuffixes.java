package com.tw.NumberInWords;

public class DivisorsWithSuffixes {
    public long[] divisors;
    public String[] singularSuffixes;
    public String[] pluralSuffixes;

    public DivisorsWithSuffixes(long[] divisors, String[] singularSuffixes, String[] pluralSuffixes) {
        this.divisors = divisors;
        this.singularSuffixes = singularSuffixes;
        this.pluralSuffixes = pluralSuffixes;
    }
}
