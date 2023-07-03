package racingCar;

import racingCar.exception.CarNameException;
import racingCar.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @DisplayName("경주할 자동차 이름")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,cron,honx"})
    void 올바른_자동차_이름으로_차_생성(String string) {
        assertThatCode(() -> new Car(string)).doesNotThrowAnyException();
    }

    @DisplayName("경주할 자동차 잟못된 이름")
    @ParameterizedTest
    @ValueSource(strings = {"honux,crongdsd"})
    void 긴_자동차_이름으로_차_생성(String string) {
        assertThatCode(() -> new Car(string)).isInstanceOf(CarNameException.class);

    }

    @DisplayName("경주할 자동차 너무 짧은 이름")
    @Test
    void 짧은_자동차_이름으로_차_생성() {
        // given
        final String SHORT_NAME = "";
        // when & then
        assertThatCode(() -> new Car(SHORT_NAME)).isInstanceOf(CarNameException.class);
    }

    @DisplayName("random 값이 4이상 일 경우, 전진한다")
    @Test
    void 자동차_전진() {
        // given
        Car car = new Car("pobi");
        int randomNum = 4;
        int carPosition = car.getCurPosition();
        // when
        car.move(randomNum);
        // then
        assertThat(carPosition + 1).isEqualTo(car.getCurPosition());
    }

    @DisplayName("random 값이 4이하일 경우, 이동하지 않는다.")
    @Test
    void 자동차_이동_X() {
        // given
        Car car = new Car("pobi");
        int randomNum = 3;
        int carPosition = car.getCurPosition();
        // when
        car.move(randomNum);
        // then
        assertThat(carPosition).isEqualTo(car.getCurPosition());
    }

}
