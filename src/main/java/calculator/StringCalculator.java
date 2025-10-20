package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final String defaultDelimiters = ",:";

    public BigDecimal calculateString(String input) {
        DelimiterParser delimiterParser = new DelimiterParser();
        Validator validator = new Validator();

        try {
            String targetString;
            String customDelimiter;

            // 1. 커스텀 구분자가 있는 경우, 커스텀 구분자 파싱 및 입력 문자열 갱신
            if (input.startsWith("//")) {
                customDelimiter = delimiterParser.getCustomDelimiter(input);
                targetString = input.substring(4 + customDelimiter.length());
            } else {
                customDelimiter = "";
                targetString = input;
            }

            // 2. 정규 표현식을 통해 토큰 리스트 획득
            String regex = delimiterParser.getRegex(defaultDelimiters + customDelimiter);
            List<String> tokens = Arrays.stream(targetString.split(regex))
                    .filter(token -> !token.isEmpty())
                    .toList();

            // 3. 모든 토큰이 수로 변환이 가능한지, 양수인지 검증
            boolean isValidNumber = validator.validate(tokens);

            // 4. 유효하다면 sum 반환, 아니라면 예외 처리
            if (isValidNumber) {
                return getSum(tokens);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 문자열 숫자 리스트를 입력받아 합계를 반환합니다.
     *
     * @param : 숫자 문자열 리스트
     * @return : 합계
     */
    private BigDecimal getSum(List<String> tokens) {
        BigDecimal result = BigDecimal.valueOf(0);
        for (String number : tokens) {
            result = result.add(new BigDecimal(number));
        }
        return result;
    }
}
