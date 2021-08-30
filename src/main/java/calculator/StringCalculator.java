package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int add(String text) {
        if (checkStringIsEmpty(text)) {
            return 0;
        }else {
            ArrayList<Integer> numbers = stringSplitByDelimiter(text);
            return sumOfAllNumbers(numbers);
        }
    }

    private static boolean checkStringIsEmpty(String text) {
        return text.isEmpty();
    }

    private static ArrayList<Integer> stringSplitByDelimiter(String text) {
        List<String> elements;
        if(checkStringStartWithSpecificDelimiter(text)) {
            elements = Arrays.asList(stringSplitByCustomDelimiter(text));
        }else {
            elements = Arrays.asList(stringSplitByCommaOrNewLineDelimiter(text));
        }
        return toInteger(elements);
    }

    private static boolean checkStringStartWithSpecificDelimiter(String text) {
        return text.startsWith("//");
    }

    private static String[] stringSplitByCommaOrNewLineDelimiter(String text) {
        return text.split("[,\n]");
    }

    private static String[] stringSplitByCustomDelimiter(String text) {
        String customDelimiter = getCustomDelimiters(text);
        text=getCustomNumbersString(text);
        return text.split(customDelimiter);
    }

    private static String getCustomDelimiters(String text) {
        return "\\"+text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
    }

    private static String getCustomNumbersString(String text) {
        return text.substring(text.indexOf("\n")+1);
    }

    private static int toInteger(String text) throws NumberFormatException {
        return Integer.parseInt(text);
    }

    private static ArrayList<Integer> toInteger(List<String> elements) throws NumberFormatException {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(String s: elements)
            numbers.add(StringCalculator.toInteger(s));
        return numbers;
    }

    private static int sumOfAllNumbers(ArrayList<Integer> numbers) {
        int sum=0;
        for(int number : numbers) {
            if(number > 1000) continue;
            sum +=number;
        }
        return sum;
    }

}
