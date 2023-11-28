package bridge.view.input;

import java.util.Objects;

import static bridge.exception.ExceptionMessage.*;
import static bridge.model.BridgeConstant.MAX_BRIDGE_SIZE;
import static bridge.model.BridgeConstant.MIN_BRIDGE_SIZE;
import static bridge.model.BridgeSymbol.*;
import static bridge.model.BridgeSymbol.QUIT;
import static bridge.utils.StringConvertor.convertStringToInteger;

public class InputValidator {
    private InputValidator() {}
    public static void validateBridgeSize(String input) {
        validateInput(input);
        validateIsDigit(input);
        int size = convertStringToInteger(input);
        validateBridgeSizeInRange(size);
    }

    public static void validateMoving(String input) {
        validateInput(input);
        validateMovingCommand(input);
    }

    public static void validateGameCommand(String input) {
        validateInput(input);
        validateRestartOrQuitCommand(input);
    }

    private static void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateIsDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(DIGIT_ONLY.getMessage());
        }
    }

    private static void validateBridgeSizeInRange(int size) {
        if (size < MIN_BRIDGE_SIZE.getValue() || size > MAX_BRIDGE_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private static void validateMovingCommand(String input) {
        if (!Objects.equals(input, UP.getSymbol()) && !Objects.equals(input, DOWN.getSymbol())) {
            throw new IllegalArgumentException(INVALID_MOVING.getMessage());
        }
    }

    private static void validateRestartOrQuitCommand(String input) {
        if (!Objects.equals(input, RESTART.getSymbol()) && !Objects.equals(input, QUIT.getSymbol())) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_QUIT.getMessage());
        }
    }
}
