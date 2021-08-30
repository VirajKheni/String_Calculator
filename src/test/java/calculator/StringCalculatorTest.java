package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    @DisplayName("When string is Empty")
    void stringIsEmptyTest() {
        int actual = StringCalculator.add("");
        int expected = 0;
        assertEquals(expected, actual , () -> "Should return "+ expected + " but returned " + actual);
    }

    @Test
    @DisplayName("When string is One Number")
    void stringIsOneNumberTest() {
        int actual = StringCalculator.add("1");
        int expected = 1;
        assertEquals(expected, actual , () -> "Should return "+ expected + " but returned " + actual);
    }

    @Nested
    @DisplayName("When string is Comma or NewLine Delimiter")
    @Tag("CustomDelimiter")
    class CommaNewLineDelimiter {
        @Test
        @DisplayName("When string is Two Number Delimiter by Comma")
        void stringIsTwoNumberSepByCommaTest() {
            int actual = StringCalculator.add("1,2");
            int expected = 3;
            assertEquals(expected, actual, () -> "Should return the sum of two number which delimited by a comma is " + expected + " but returned " + actual);
        }
        @Test
        @DisplayName("When string is Multiple Numbers Delimiter by Comma")
        void stringIsMultipleNumbersSepByCommaTest() {
            int actual = StringCalculator.add("1,2,3");
            int expected = 6;
            assertEquals(expected, actual , () -> "Should return the sum of multiple numbers which delimited by a comma is "+ expected + " but returned " + actual);
        }

        @Test
        @DisplayName("When string is Delimiter by Comma and NewLine character")
        void stringIsDelimiterByNewLineTest() {
            int actual = StringCalculator.add("1,2\n3,4\n5");
            int expected = 15;
            assertEquals(expected, actual , () -> "Should return the sum of multiple numbers which delimited by a comma and new line is "+ expected + " but returned " + actual);
        }
    }

    @Nested
    @DisplayName("When string is Custom Delimiter")
    @Tag("CustomDelimiter")
    class CustomDelimiter {
        @Test
        @DisplayName("When string is Single Custom Delimiter")
        void stringIsSingleCustomDelimiterTest() {
            int actual = StringCalculator.add("//;\n1;2;3");
            int expected = 6;
            assertEquals(expected, actual, () -> "Should return the sum of numbers which splited by single custom delimiter is " + expected + " but returned " + actual);
        }

        @Test
        @DisplayName("When string is Single Custom Delimiters with Longer Length")
        void stringIsSingleCustomDelimiterWithLongerLengthTest() {
            int actual = StringCalculator.add("//[***]\n1***2***3");
            int expected = 6;
            assertEquals(expected, actual , () -> "Should return the sum of numbers which splited by single custom delimiter with longer length is "+ expected + " but returned " + actual);
        }

        @Test
        @DisplayName("When string is Multiple Custom Delimiter")
        void stringIsMultipleCustomDelimiterTest() {
            int actual = StringCalculator.add("//[*][%]\n1*2%3");
            int expected = 6;
            assertEquals(expected, actual , () -> "Should return the sum of numbers which splited by multiple custom delimiter is "+ expected + " but returned " + actual);
        }

        @Test
        @DisplayName("When string is Multiple Custom Delimiters with Longer Length")
        void stringIsMultipleCustomDelimiterWithLongerLengthTest() {
            int actual = StringCalculator.add("//[**][%%]\n1**2%%3");
            int expected = 6;
            assertEquals(expected, actual , () -> "Should return sum of numbers which splited by multiple custom delimiter with longer length is "+ expected + " but returned " + actual);
        }
    }

    @Nested
    @DisplayName("When string is Negatives Number")
    @Tag("NegativesNumber")
    class NegativesNumber {
        @Test
        @DisplayName("When string is Negatives Number")
        void stringIsNegativesNumberTest() {
            assertThrows(RuntimeException.class, () -> StringCalculator.add("-1,2,3"), "negatives not allowed");
        }
    }
}
