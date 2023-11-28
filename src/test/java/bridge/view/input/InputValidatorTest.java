package bridge.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("다리 사이즈가 올바르지 않은 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1", "21", "a", "안녕"})
    void testInvalidBridgeSize(String value) {
        assertThatThrownBy(
                () -> InputValidator.validateBridgeSize(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 이동 명령이 올바르지 않은 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "A", "B", "P", "히히", "R", "Q"})
    void testInvalidMoving(String value) {
        assertThatThrownBy(
                () -> InputValidator.validateMoving(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 또는 종료 명령이 올바르지 않은 경우 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "A", "B", "P", "히히", "U", "D"})
    void testInvalidGameCommand(String value) {
        assertThatThrownBy(
                () -> InputValidator.validateGameCommand(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}