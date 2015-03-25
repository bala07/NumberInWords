package com.tw.NumberInWords.converters;

import com.tw.NumberInWords.NumberSystem;

public interface Converter {
    String convert(long number, NumberSystem numberSystem);
}
