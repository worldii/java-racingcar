package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator("2 + 3 * 4 / 2");

    @Test
    void plus() {
        assertThat(calculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(calculator.minus(2, 1)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiplied(2, 3)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    void calculation() {
        Calculator calculator = new Calculator("2 + 3 * 4 / 2");
        assertThat(calculator.calculation()).isEqualTo(10);
    }

    @Test
    void operatorIllegalArgumentException() {
        Calculator calculator = new Calculator("2 + 3 * 4 ^ 2");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(calculator::calculation);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
        });
    }
}