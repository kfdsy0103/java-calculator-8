package calculator;

import java.math.BigInteger;
import java.util.List;

public class StringCalculator {

    // 문자열 숫자 리스트를 입력받아 합계를 반환하는 private 메서드
    private BigInteger getSum(List<String> tokens) {
        BigInteger result = BigInteger.valueOf(0);
        for (String number : tokens) {
            result = result.add(new BigInteger(number));
        }
        return result;
    }
}
