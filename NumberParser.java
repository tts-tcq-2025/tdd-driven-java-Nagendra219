package caluculator;

import java.util.Arrays;
import java.util.List;

public class NumberParser {
    public List<Integer> parse(String numbers, String delimiter, StringCalculatorConfig config) {
        return Arrays.stream(numbers.split(delimiter))
                     .filter(this::isNotEmpty)
                     .map(Integer::parseInt)
                     .filter(n -> isValid(n, config))
                     .toList();
    }

    private boolean isNotEmpty(String s) {
        return !s.isEmpty();
    }

    private boolean isValid(int n, StringCalculatorConfig config) {
        return !config.isIgnoreNumbersGreaterThan1000() || n <= 1000;
    }
}
