package calculator;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        
        ConsoleIO consoleIO = new ConsoleIO();
        String input = consoleIO.getInput();

        StringCalculator stringCalculator = new StringCalculator();
        BigInteger result = stringCalculator.calculateString(input);

        consoleIO.displayOutput(result);
    }
}
