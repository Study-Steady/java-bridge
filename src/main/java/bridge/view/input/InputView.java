package bridge.view.input;

import bridge.view.output.Printer;

import static bridge.utils.StringConvertor.convertStringToInteger;
import static bridge.view.IOMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

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
        printer.print(INPUT_BRIDGE_SIZE.getMessage());
        String input = reader.inputOneLine();
        return convertStringToInteger(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printer.print(INPUT_MOVING.getMessage());
        String input = reader.inputOneLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printer.print(INPUT_RESTART_OR_QUIT.getMessage());
        String input = reader.inputOneLine();
        return input;
    }
}
