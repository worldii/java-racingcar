package racingCar.exception;

public class TryCountNumberFormatError extends RuntimeException {
    public TryCountNumberFormatError() {
        super("시도 회수는 숫자가 아닙니다");
    }
}
