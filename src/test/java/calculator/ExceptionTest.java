package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {
    @Test
    @DisplayName("숫자 이외의 값 전달 시 RuntimeException")
    void numberFormatException() {
        assertThrows(RuntimeException.class, () -> Calculator.sum("//;\n1;2;a"));
    }

    @Test
    @DisplayName("음수 값 전달 시 RuntimeException")
    void negativeNumberException() {
        assertThrows(RuntimeException.class, () -> Calculator.sum("//;\n1;-2"));
    }

}