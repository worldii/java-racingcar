package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarGameTest {
    private Cars car ;

    @BeforeEach
    void init () {
        Stream<String> stream = List.of("pobi", "pobi2", "pobi3").stream();
        List<Car> collect = stream.map(s -> new Car(s)).collect(Collectors.toList());
        car = new Cars(collect);
    }



}
