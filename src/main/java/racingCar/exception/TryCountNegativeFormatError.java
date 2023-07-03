package racingCar.exception;

public class TryCountNegativeFormatError extends RuntimeException{
    public TryCountNegativeFormatError () {
        super("시도 횟수는 음수면 안된다.");
    }
}
