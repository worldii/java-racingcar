package racingCar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarGame {
    private Cars car;

    CarGame(Cars car) {
        this.car = car;
    }

    private int findMaxLocation() {
        return car.getCars().stream().max(Comparator.comparing(car -> car.getCurPosition())).get().getCurPosition();
    }

    public List<Car> selectWinner() {
        int maxPosition = findMaxLocation();
        List<Car> collect = car.getCars().stream().filter(s -> s.getCurPosition() == maxPosition).collect(Collectors.toList());
        return collect;
    }

}
