package bridge.view.input;

import bridge.view.input.validator.BridgeSelectValidator;
import bridge.view.input.validator.BridgeSizeValidator;
import bridge.view.input.validator.GameEndValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return new BridgeSizeValidator().validate(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return new BridgeSelectValidator().validate(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return new GameEndValidator().validate(Console.readLine());
    }
}
