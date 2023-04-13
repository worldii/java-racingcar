package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String NAME_DELIMITER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String ERROR_MESSAGE_FOR_NAME_LENGTH_LIMIT = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_MINUS_COUNT = "시도할 횟수는 양수여야 합니다.";

    private final List<Car> carList = new ArrayList<>();

    public void preparingGame(String namesOfCars, int count) {
        checkIfCountPositive(count);
        for (String name : getNames(namesOfCars)) {
            checkLengthOfName(name);
            carList.add(new Car(name));
        }
    }

    private void checkIfCountPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_MINUS_COUNT);
        }
    }

    private List<String> getNames(String namesOfCars) {
        return Arrays.asList(namesOfCars.split(NAME_DELIMITER));
    }

    private void checkLengthOfName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NAME_LENGTH_LIMIT);
        }
    }

    public List<String> race() {
        List<String> resultList = new ArrayList<>();
        for (Car car : carList) {
            car.goOrStop();
            resultList.add(car.getNowRacingResult());
        }
        return resultList;
    }

    public List<String> getWinner() {
        return getWinner(carList);
    }

    public List<String> getWinner(List<Car> carList) {
        int maxLength = carList
                .stream()
                .mapToInt(car -> car.getTrace().length())
                .max()
                .orElseThrow();
        return carList
                .stream()
                .filter(car -> car.getTrace().length() == maxLength)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}