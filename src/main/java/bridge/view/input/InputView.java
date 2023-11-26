package bridge.view.input;

import bridge.view.output.Printer;

import java.util.Objects;

import static bridge.exception.ExceptionMessage.*;
import static bridge.model.BridgeConstant.MAX_BRIDGE_SIZE;
import static bridge.model.BridgeConstant.MIN_BRIDGE_SIZE;
import static bridge.model.BridgeSymbol.*;
import static bridge.utils.StringConvertor.convertStringToInteger;
import static bridge.view.IOMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    // todo while 문을 사용하지 않고 리팩토링을 진행

    private final Reader reader;
    private final Printer printer;

    public InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean flag = true;
        int size = 0;
        while (flag) {
            flag = false;
            try {
                printer.print(INPUT_BRIDGE_SIZE.getMessage());
                String input = reader.inputOneLine();
                validateInput(input);
                validateIsDigit(input);
                size = convertStringToInteger(input);
                validateBridgeSizeInRange(size);
            } catch (IllegalArgumentException e) {
                printer.print(e.getMessage());
                flag = true;
            }
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean flag = true;
        String input = "";

        while (flag) {
            flag = false;
            try {
                printer.print(INPUT_MOVING.getMessage());
                input = reader.inputOneLine();
                validateInput(input);
                validateMovingCommand(input);
            } catch (IllegalArgumentException e) {
                printer.print(e.getMessage());
                flag = true;
            }
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean flag = true;
        String input = "";
        while (flag) {
            flag = false;
            try {
                printer.print(INPUT_RESTART_OR_QUIT.getMessage());
                input = reader.inputOneLine();
                validateInput(input);
                validateRestartOrQuitCommand(input);
            } catch (IllegalArgumentException e) {
                printer.print(e.getMessage());
                flag = true;
            }
        }
        return input;
    }

    private void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private void validateIsDigit(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(DIGIT_ONLY.getMessage());
        }
    }

    private void validateBridgeSizeInRange(int size) {
        if (size < MIN_BRIDGE_SIZE.getValue() || size > MAX_BRIDGE_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    private void validateMovingCommand(String input) {
        if (!Objects.equals(input, UP.getSymbol()) && !Objects.equals(input, DOWN.getSymbol())) {
            throw new IllegalArgumentException(INVALID_MOVING.getMessage());
        }
    }

    private void validateRestartOrQuitCommand(String input) {
        if (!Objects.equals(input, RESTART.getSymbol()) && !Objects.equals(input, QUIT.getSymbol())) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_QUIT.getMessage());
        }
    }
}
