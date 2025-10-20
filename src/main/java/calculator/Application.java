package calculator;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        String input = consoleIO.getInput();

        StringCalculator stringCalculator = new StringCalculator();
        BigDecimal result = stringCalculator.calculateString(input);

        consoleIO.displayOutput(result);
    }
}
