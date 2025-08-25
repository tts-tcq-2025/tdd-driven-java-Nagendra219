package caluculator;

import java.util.List;


public class NumberValidator {
    public void validate(List<Integer> numbers) {
        List<Integer> negatives = numbers.stream()
                                         .filter(n -> n < 0)
                                         .toList();
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }
}
