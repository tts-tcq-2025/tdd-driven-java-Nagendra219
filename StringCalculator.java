package caluculator;

import java.util.List;
public class StringCalculator {
    private final StringCalculatorConfig config;
    private final NumberParser parser;
    private final NumberValidator validator;

    public StringCalculator(StringCalculatorConfig config) {
        this.config = config;
        this.parser = new NumberParser();
        this.validator = new NumberValidator();
    }

    public CalculationResult add(String input) {
        if (input == null || input.isEmpty()) {
            return new CalculationResult(0, List.of());
        }

        DelimiterExtractor extractor = getExtractor(input);
        List<Integer> numbers = parseNumbers(input, extractor);
        validator.validate(numbers);

        return new CalculationResult(numbers.stream().mapToInt(i -> i).sum(), numbers);
    }

    private DelimiterExtractor getExtractor(String input) {
        return input.startsWith("//") ? new CustomDelimiterExtractor()
                                      : new DefaultDelimiterExtractor();
    }

    private List<Integer> parseNumbers(String input, DelimiterExtractor extractor) {
        String delimiter = extractor.extractDelimiter(input);
        String numbersSection = extractor.extractNumberSection(input);
        return parser.parse(numbersSection, delimiter, config);
    }
}
