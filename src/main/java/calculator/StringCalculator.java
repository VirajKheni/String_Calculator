package calculator;

public class StringCalculator {

    public static int add(String text) {
        if (checkStringIsEmpty(text)) {
            return 0;
        }
        return 1;
    }

    private static boolean checkStringIsEmpty(String text) {
        return text.isEmpty();
    }

}
