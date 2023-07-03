package racingCar.exception;

public class CarNameException extends RuntimeException {
    public CarNameException() {
        super("자동차 이름은 5자 이하만 가능합니다.");
    }
}