package racingCar.domain;

import racingCar.exception.CarNameException;

import java.util.Arrays;

public class Car {
    private String name;
    private int curPosition;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.curPosition = 0;
    }

    private void validateName(String name) {
        long count = Arrays.stream(name.split(","))
                .filter(s -> s.length() > 5 || s.length() <= 0)
                .count();
        if (count > 0) throw new CarNameException();
    }

    public void move(int number) {
        if (number >= 4) curPosition++;
    }

    public int getCurPosition() {
        return curPosition;
    }

    public String getCarName() {
        return name;
    }
}
