package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.exception.CarsNameDuplicateException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("car 간 이름이 중복되면 안된다.")
    void 중복된_이름() {
        // given
        Stream<String> stream = List.of("pobi", "pobi", "pobi").stream();
        List<Car> collect = stream.map((s) -> new Car(s)).collect(Collectors.toList());

        // when & then
        assertThatThrownBy((() -> new Cars(collect))).isInstanceOf(CarsNameDuplicateException.class);
    }

    @Test
    @DisplayName("이름이 중복이 되지 않으면 올바르게 Cars 객체 생성")
    void 올바른_Cars_객체_생성() {
        // given
        Stream<String> stream = List.of("pobi", "pobi2", "pobi3").stream();
        List<Car> collect = stream.map((s) -> new Car(s)).collect(Collectors.toList());

        // when & then
        assertThatCode(() -> new Cars(collect)).doesNotThrowAnyException();
    }
}
