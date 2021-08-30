package calculator;

import org.junit.jupiter.api.DisplayName;
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


}