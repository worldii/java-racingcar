package racingCar.domain;

import racingCar.Utils.StringUtils;
import racingCar.exception.TryCountNumberFormatError;
import racingCar.exception.TryCountZeroException;

public class TryCount {
    private Positive count;

    public TryCount(String num) {
        validateNum(num);
        this.count = new Positive(StringUtils.toInt(num));
    }


    private void validateNum(String str) {
        try {
            int num = Integer.parseInt(str);
            if (num ==0) throw new TryCountZeroException();
        } catch (NumberFormatException e) {
            throw new TryCountNumberFormatError();
        }
    }


}
