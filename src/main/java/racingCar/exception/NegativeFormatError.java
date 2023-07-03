package racingCar.exception;

public class NegativeFormatError extends RuntimeException {
    public NegativeFormatError () {
        super("Positive 숫자는  음수면 안된다.");
    }
}
