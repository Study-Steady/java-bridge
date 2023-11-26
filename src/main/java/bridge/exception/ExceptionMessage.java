package bridge.exception;

import static bridge.model.BridgeConstant.MAX_BRIDGE_SIZE;
import static bridge.model.BridgeConstant.MIN_BRIDGE_SIZE;
import static bridge.model.BridgeSymbol.*;

public enum ExceptionMessage {

    INVALID_BRIDGE_SIZE(String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", MIN_BRIDGE_SIZE.getValue(), MAX_BRIDGE_SIZE.getValue())),
    DIGIT_ONLY("다리의 길이는 숫자만 입력해주세요"),
    INVALID_MOVING(String.format("이동의 경우 %s, %s 중 하나만 입력해야 합니다.", UP.getSymbol(), DOWN.getSymbol())),
    INVALID_RESTART_OR_QUIT(String.format("재시도의 경우 %s, 종료의 경우 %s만 입력해야 합니다.", RESTART.getSymbol(), QUIT.getSymbol())),
    INVALID_INPUT("올바른 입력을 해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ExceptionSymbol.PREFIX.getValue() + message;
    }
}
