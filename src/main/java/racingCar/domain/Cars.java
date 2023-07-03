package racingCar.domain;

import racingCar.exception.CarsNameDuplicateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 일급 컬렉션
public class Cars {

    private List<Car> cars = new ArrayList<>();

    // 불변성 보장
    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        // unmodified list
        return Collections.unmodifiableList(cars);
    }

    private void validateDuplicateName(List<Car> cars) {
        long uniqueCarCount = cars.stream().map(Car::getCarName).distinct().count();
        long notUniqueCarCount = cars.stream().map(Car::getCarName).count();
        if (uniqueCarCount!= notUniqueCarCount) throw new CarsNameDuplicateException();
    }

}
