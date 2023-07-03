package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.TryCount;
import racingCar.exception.NegativeFormatError;
import racingCar.exception.TryCountNegativeFormatError;
import racingCar.exception.TryCountNumberFormatError;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TryCountTest {

    @Test
    @DisplayName("시도 횟수는 숫자여야 한다")
    void 시도_횟수가_숫자가_아님() {
        // given
        String num = "a";
        assertThatThrownBy((() -> new TryCount(num))).isInstanceOf(TryCountNumberFormatError.class);
    }

    @Test
    @DisplayName("시도 횟수는 음수이면 안된다.")
    void 시도_횟수가_음수() {
        // given
        String num = "-1";
        assertThatThrownBy(() -> new TryCount(num)).isInstanceOf(NegativeFormatError.class);
    }

}
