package Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarTest {
    @DisplayName("경주할 자동차 이름")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,cron,honx"})
    void 올바른_자동차_이름으로_차_생성(String string) {
        assertThatCode(()->new Car(string)).doesNotThrowAnyException();
    }


    @DisplayName("경주할 자동차 잟못된 이름")
    @ParameterizedTest
    @ValueSource(strings = {"honux,crongdsd"})
    void 잘못된_자동차_이름으로_차_생성(String string) {
        assertThatCode(()->new Car(string)).isInstanceOf(CarNameException.class);
    }
}
