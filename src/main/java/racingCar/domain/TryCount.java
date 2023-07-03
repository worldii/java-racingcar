package racingCar.domain;

import racingCar.Utils.StringUtils;
import racingCar.exception.TryCountNumberFormatError;

public class TryCount {
    private Positive count;

    public TryCount(String num) {
        validateNum(num);
        this.count = new Positive(StringUtils.toInt(num));
    }
    

    private void validateNum(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new TryCountNumberFormatError();
        }
    }


}
