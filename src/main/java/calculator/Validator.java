package calculator;

import java.math.BigDecimal;
import java.util.List;

public class Validator {

    // 띄어쓰기가 포함된 숫자, 공백은 생성자를 통해 검증 (NumberFormatException)
    // 0과 음수는 조건문으로 검증
    public boolean validate(List<String> tokens) {
        try {
            for (String token : tokens) {
                BigDecimal number = new BigDecimal(token);
                if (number.equals(BigDecimal.ZERO)) {
                    return false;
                } else if (number.compareTo(BigDecimal.ZERO) < 0) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}