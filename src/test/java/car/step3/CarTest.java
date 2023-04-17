package car.step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    HandleCar handleCar = new HandleCar();
    @Test
    public void 차가_전진하는지_테스트() {
        Car car = new Car();
        car.go();
        assertThat(car.location()).isEqualTo(1);
    }

    @Test
    public void 랜덤값이_4이상일때_전지하는지_테스트() {
        Car car = new Car();
        Car goCar = handleCar.isOverFour(car);
        assertThat(goCar.location()).isGreaterThanOrEqualTo(car.location());
    }

    @Test
    public void 차리스트를_조회하여_전진한다() {
        List<Car> carList = Arrays.asList(new Car(), new Car());
        List<Car> newCarList = handleCar.iteratorCar(carList);
        assertThat(newCarList.size()).isEqualTo(carList.size());
        assertThat(newCarList.get(0).location()).isGreaterThanOrEqualTo(carList.get(0).location());
    }

}