package racingCar.exception;

public class TryCountZeroException extends RuntimeException {
    public TryCountZeroException () {
        super("시도 횟수는 0이면 안된다.");
    }
}
