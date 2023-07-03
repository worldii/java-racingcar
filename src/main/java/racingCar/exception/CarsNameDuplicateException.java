package racingCar.exception;

public class CarsNameDuplicateException extends RuntimeException {
    public CarsNameDuplicateException() {
        super();
    }

    public CarsNameDuplicateException(String message) {
        super("자동차 이름은 중복될 수 없습니다.");
    }

    public CarsNameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarsNameDuplicateException(Throwable cause) {
        super(cause);
    }

    protected CarsNameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
