package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수기호_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//-\\n-1-2-3-4-5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 소수_처리_테스트() {
        assertSimpleTest(() -> {
            run("1.2:1.3,2.5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 구분자_시작_테스트() {
        assertSimpleTest(() -> {
            run(":1,2,3,4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 구분자_끝_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5:");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 매우_큰수_테스트() {
        assertSimpleTest(() -> {
            String bigNumber = "1".repeat(100);
            run(bigNumber);
            assertThat(output()).contains("결과 : " + bigNumber);
        });
    }

    @Test
    void 구분자_연속사용_테스트() {
        assertSimpleTest(() -> {
            run("1::2,,3:,4:,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 구분자만_사용_테스트() {
        assertSimpleTest(() -> {
            run("::,,:,:,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
