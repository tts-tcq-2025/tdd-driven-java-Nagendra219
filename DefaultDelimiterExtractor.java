package caluculator;


public class DefaultDelimiterExtractor implements DelimiterExtractor {
    @Override
    public String extractDelimiter(String input) {
        return ",|\n"; // default delimiters
    }

    @Override
    public String extractNumberSection(String input) {
        return input;
    }
}
