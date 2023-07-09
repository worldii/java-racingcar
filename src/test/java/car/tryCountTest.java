package car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class tryCountTest {

    @Test
    @DisplayName("시도 횟수 음수면 예외 처리")
    void 사용자_입력_시도_횟수_예외() {
        int count = -1;
        assertThrows(IllegalArgumentException.class, () -> new TryCount(count));
    }

    @Test
    @DisplayName("시도 횟수 정상 동작")
    void 사용자_입력_시도_횟수() {
        int count = 5;
        assertThatCode(() -> new TryCount(count)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수 숫자가 같으면 TryCount 의 횟수도 같다.")
    void 시도_횟수_같으면_같은_객체 () {
        // given
        int count = 5;
        TryCount c1 = new TryCount(count);
        TryCount c2 = new TryCount(count);

        // when & then
        assertEquals(c1, c2);
    }

    @Test
    @DisplayName("isPositive 메소드 정상 동작 확인")
    void isPositive_정상_동작_확인() {
        assertEquals(new TryCount(1).isPositive(), true);
    }


    @Test
    @DisplayName("decrease 메소드 정상 동작 확인")
    void decreseNumber_메소드_정상_동작_확인() {
        int countNum = 2;
        int decreseNum = countNum-1;
        TryCount count = new TryCount(countNum);
        TryCount anotherCount = new TryCount(decreseNum);

        count = count.decreaseCount();

        assertEquals(count, anotherCount);
    }

}
