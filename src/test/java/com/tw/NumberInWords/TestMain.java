package com.tw.NumberInWords;

import com.tw.NumberInWords.converters.MultiDigitConverter;
import org.junit.Test;

import java.io.IOException;

public class TestMain {
    @Test
    public void convertsNumberToWords() throws IOException {
        System.out.println(new MultiDigitConverter().convert(230001l, NumberSystem.WESTERN));
    }
}
