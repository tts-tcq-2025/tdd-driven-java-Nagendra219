package caluculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterExtractor implements DelimiterExtractor {
    @Override
    public String extractDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        String delimiterSection = input.substring(2, delimiterEndIndex);

        if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
            List<String> delimiters = new ArrayList<>();
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }
            return String.join("|", delimiters);
        } else {
            return Pattern.quote(delimiterSection);
        }
    }

    @Override
    public String extractNumberSection(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }
}
