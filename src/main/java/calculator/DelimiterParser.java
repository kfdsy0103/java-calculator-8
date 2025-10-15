package calculator;

public class DelimiterParser {

    public String getCustomDelimiter(String input) {
        int index = input.indexOf("\\n");
        if (index == -1) {
            throw new IllegalArgumentException();
        } else {
            return input.substring(2, index - 1);
        }
    }

    public String getRegex(String input) {
        return "[" + input + "]+";
    }
}
