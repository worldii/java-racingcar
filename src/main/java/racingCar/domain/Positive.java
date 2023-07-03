package racingCar.domain;


import racingCar.exception.NegativeFormatError;
import racingCar.exception.TryCountNegativeFormatError;

public class Positive {
    private int num;
    public Positive(int num) {
        validatePositiveNum(num);
        this.num = num;
    }
    private void validatePositiveNum (int num) {
        if (num <0) throw new NegativeFormatError();
    }
}
