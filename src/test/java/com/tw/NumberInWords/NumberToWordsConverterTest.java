package com.tw.NumberInWords;

import com.tw.NumberInWords.converters.Converter;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class NumberToWordsConverterTest {
    @Test
    public void callsMultiDigitConverterToConvertNumberToWords() {
        Converter multiDigitConverter = mock(Converter.class);
        NumberToWordsConverter converter = new NumberToWordsConverter(multiDigitConverter);

        when(multiDigitConverter.convert(123L, NumberSystem.WESTERN)).thenReturn("number");

        String numberInWords = converter.convert(123L, NumberSystem.WESTERN);

        verify(multiDigitConverter).convert(123L, NumberSystem.WESTERN);
        assertThat(numberInWords, is("number"));
    }
}