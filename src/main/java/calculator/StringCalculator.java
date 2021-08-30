package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String text) {
        if (checkStringIsEmpty(text)) {
            return 0;
        }else {
            ArrayList<Integer> numbers = stringSplitByDelimiter(text);
            stringHaveNegativesNumber(numbers);
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
        customDelimiter = multipleCustomDelimiter(customDelimiter);
        return text.split(customDelimiter);
    }

    private static String getCustomDelimiters(String text) {
        return "\\"+text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
    }

    private static String getCustomNumbersString(String text) {
        return text.substring(text.indexOf("\n")+1);
    }

    private static String multipleCustomDelimiter(String customDelimiter) {
        if(customDelimiter.contains("[")) {
            ArrayList<String> customDelimiters = new ArrayList<>();
            String regex = "\\[(.*?)]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(customDelimiter);
            while (m.find())
                customDelimiters.add(m.group(1));

            customDelimiter = getCustomDelimitedRegexString(customDelimiters);
        }
        return customDelimiter;
    }

    private static String getCustomDelimitedRegexString(ArrayList<String> customDelimiters) {
        return "[\\"+ String.join("|\\", customDelimiters) +"]+";
    }

    private static void stringHaveNegativesNumber(ArrayList<Integer> numbers) {
        ArrayList<Integer> negativeNumber = getNegativesNumbers(numbers);
        if(negativeNumber.size() > 0) {
            throw new RuntimeException("negatives not allowed " + negativeNumber.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    private static ArrayList<Integer> getNegativesNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for(int number: numbers)
            if(number<0)
                negativeNumbers.add(number);
        return negativeNumbers;
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
            if(number > 1000) continue; // Numbers bigger than 1000 then it should be ignored
            sum +=number;
        }
        return sum;
    }
}
