package racingCar.exception;

public class CarsNameDuplicateException extends RuntimeException {
    public CarsNameDuplicateException() {
        super("자동차 이름은 중복될 수 없습니다.");
    }
}
