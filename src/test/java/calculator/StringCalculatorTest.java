package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}
